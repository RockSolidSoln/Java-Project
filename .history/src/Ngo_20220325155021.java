import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;

//----------------This class contains the constructors and methods to enter NGO requests in the DC---------------
public class Ngo {
    private String name;        //name of the NGO
    private String aids;        //name of the aids
    private int quantity;       //number of quantity
    private String status;      //status of request

    public Ngo() {};
    public Ngo(String name, String aids, int q, String status) {
        this.name = name;
        this.aids = aids;
        quantity = q;
        this.status = status;
    }
    
    //------------This method will save all the information about a donor---------------------------
    public void saveNgoDemands() throws IOException{
        ArrayList<String> data = requiredaids();

        ArrayList<String> nName = new ArrayList<String>();
        ArrayList<String> nAids = new ArrayList<String>();
        ArrayList<Integer> nQty = new ArrayList<Integer>();
        ArrayList<String> nStatus = new ArrayList<String>();
        int flag=0;
        for(int i = 0; i < data.size();i++){
            String[] temp = data.get(i).split("\\s");

            String nameNgo = temp[0];
            String aidsNgo = temp[1];
            int qty = Integer.parseInt(temp[2]);
            String statusNgo = temp[3];
            if(nameNgo.equals(name) && aidsNgo.equals(aids)){
                qty += quantity;
                flag=1;
            }

            nName.add(nameNgo);
            nAids.add(aidsNgo);
            nQty.add(qty);
            nStatus.add(statusNgo);
        }
        if(flag==0){ 
            nName.add(name);
            nAids.add(aids);
            nQty.add(quantity);
            nStatus.add(status);
        }
        WriteBack.updateNgo(nName, nAids, nQty, nStatus);
    }  

    public static ArrayList<String> requiredaids() throws IOException{
        ArrayList<String> required = new ArrayList<>();
        List<String>lines = Files.readAllLines(Paths.get("src/Documentation/ngoDemands.csv"));
        for(int i =0; i<lines.size();i++){
            String[] items = lines.get(i).split(",");
            String ngoName = items[0];
            String aidRequired = items[1];
            String quantityRequired = items[2];
            String status = items[3];
            required.add(ngoName+" "+aidRequired+" "+quantityRequired+ " "+ status);
        }
        return required;
    }
}
