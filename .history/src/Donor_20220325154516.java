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
        ArrayList<String> data = donatedaids();     //this takes the previous aids currently in the DC

        ArrayList<String> dName = new ArrayList<String>();      //ArrayList stores all the name 
        ArrayList<String> dAids = new ArrayList<String>();      //ArrayList stores all the aids names
        ArrayList<Integer> dQty = new ArrayList<Integer>();     //Arraylist stores all the quantity
        int flag=0;
        for(int i=0; i<data.size(); i++){
            String[] temp = data.get(i).split("\\s");           //split the comma

            String nameDonor = temp[0];                         //stores the name of the donor
            String aids = temp[1];                              //stores the aids donated by the donor
            int qty = Integer.parseInt(temp[2]);                //stores the quantity of aids donated
            
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

    //--------------This method returns the donated aids by all the donors----------------------//
    public static ArrayList<String> donatedaids() throws IOException{
        ArrayList<String> previousAids= new ArrayList<>();     //to store all the donated aids lists
        List<String>lines = Files.readAllLines(Paths.get("src/Documentation/DonatedItems.csv"));

        for(int i =0; i<lines.size();i++){
            String[] items = lines.get(i).split(",");  //splits the comma
            String name = items[0];                    //stores the name
            String aids = items[1];                    //stores the aids name
            String quantity = items[2];                //stores the quantity
            previousAids.add(name+" "+aids+" "+quantity);  //stores every thing in the array
        }
        return previousAids;                                //return the array
    }
    //-------------------------------------------------------------------------------------------//
}