// import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;

//----------------This class contains the constructors and methods to enter Donor aids in the DC---------------
public class Donor{
    private String name;        //name of the Donor
    private String itemName;    //name of the aids
    private int quantity;       //number of items

    public Donor(){};

    public Donor(String name,String itemName, int qty){
        this.name = name;
        this.itemName = itemName;
        this.quantity = qty;    
    }

    //------------This method will save all the information about a donor---------------------------
    public void saveDonorAids() throws IOException{
        ArrayList<String> data = donatedaids();

        ArrayList<String> dName = new ArrayList<String>();
        ArrayList<String> dAids = new ArrayList<String>();
        ArrayList<Integer> dQty = new ArrayList<Integer>();
        int flag=0;
        for(int i=0; i<data.size(); i++){
            String[] temp = data.get(i).split("\\s");

            String nameDonor = temp[0];
            String aids = temp[1];
            int qty = Integer.parseInt(temp[2]);
            if(nameDonor.equals(name) && aids.equals(itemName)){
                qty += quantity;
                flag=1; 
            }

            dName.add(nameDonor);
            dAids.add(aids);
            dQty.add(qty);
        }
        if(flag==0){
            dName.add(name);
            dAids.add(itemName);
            dQty.add(quantity);
        }
        WriteBack.updateDonor(dName, dAids, dQty,0);   
    }
    //-------------------------------------------------------------------------------------------//

    //--------------This method returns the donated aids by all the donors----------//
    public static ArrayList<String> donatedaids() throws IOException{
        ArrayList<String> required = new ArrayList<>();
        List<String>lines = Files.readAllLines(Paths.get("src/Documentation/DonatedItems.csv"));

        for(int i =0; i<lines.size();i++){
            String[] items = lines.get(i).split(",");
            String Name = items[0];
            String aids = items[1];
            String quantity = items[2];
            required.add(Name+" "+aids+" "+quantity);
        }
        return required;
    }
    //-------------------------------------------------------------------------------------------//
}