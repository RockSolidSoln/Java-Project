import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

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
    
    public void saveNgoDemands(){
        try{
            String filename="src/Documentation/ngoDemands.csv";
            FileWriter fw = new FileWriter(filename, true);
            fw.write("\n" + name + "," + aids + "," + quantity + "," + status);
            fw.close();
        } catch(IOException ioe){
            System.err.println("IOException: " + ioe.getMessage());
        }
    }  

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
}
