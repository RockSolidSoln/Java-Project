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
    
    //------------This method will save all the request by the donor---------------------------
    public void saveNgoDemands() throws IOException{
        ArrayList<String> data = requiredaids();        //this takes the previous aids requested currently in the DC

        ArrayList<String> nName = new ArrayList<String>();       //ArrayList stores all the name 
        ArrayList<String> nAids = new ArrayList<String>();       //ArrayList stores all the aids 
        ArrayList<Integer> nQty = new ArrayList<Integer>();      //ArrayList stores all the quantity 
        ArrayList<String> nStatus = new ArrayList<String>();     //ArrayList stores all the status
        int flag=0;
        for(int i = 0; i < data.size();i++){
            String[] temp = data.get(i).split("\\s");

            String nameNgo = temp[0];
            String aidsNgo = temp[1];
            int qty = Integer.parseInt(temp[2]);
            String statusNgo = temp[3];
            //if ngo request already exists
            if(nameNgo.equals(name) && aidsNgo.equals(aids)){
                qty += quantity;                //increase the number of the quantity requested
                flag=1;                         //to mark that ngo request already exists
            }

            nName.add(nameNgo);                 //append the name of the NGO
            nAids.add(aidsNgo);                 //append the name of the aids requested
            nQty.add(qty);                      //append the number of the quantity requested
            nStatus.add(statusNgo);             //append the status of the request
        }
        if(flag==0){                            //if new request is created
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
