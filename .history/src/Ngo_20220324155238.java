import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Ngo {
    private String name;
    private String aids;
    private int quantity;
    private String status;

    public Ngo() {};
    public Ngo(String name, String aids, int q, String status) {
        this.name = name;
        this.aids = aids;
        quantity = q;
        this.status = status;
    }
    public String getName() {
        return name;
    }
    public String getAids(){
        return aids;
    }
    public int getQty(){
        return quantity;
    }
    public String getStatus(){
        return status;
    }
    
    public void saveNgoDemands() throws IOException{
        ArrayList<String> data = requiredaids();

        ArrayList<String> nName = new ArrayList<String>();
        ArrayList<String> nAids = new ArrayList<String>();
        ArrayList<Integer> nQty = new ArrayList<Integer>();
        ArrayList<String> nStatus = new ArrayList<String>();

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
        writeBack.updateNgo(nName, nAids, nQty, nStatus);
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
