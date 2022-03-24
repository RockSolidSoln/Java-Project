import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Donor{
    private String name;
    private String itemName;
    private String quantity;

    public Donor(){};

    public Donor(String name,String itemName, String qty){
        this.name = name;
        this.itemName = itemName;
        this.quantity = qty;    
    }
    // each of the statements below will return a variable we will use on later.
    public String getName(){                    
        return name;
    }
    public String getItemName(){
        return itemName;
    }
    public String getQuantity(){
        return quantity;
    }

    // this method will save all the information about a donor and will be used in a html report later on!
    public void saveDonorInfo(){
        try{
            ArrayList<String> data = donatedaids();

            for(int i=0; i<data.size(); i++){
                String[] temp = data.get(i).split("\\s");

                String nameDonor = temp[0];
                String aids = temp[1];
                int Qty = Integer.parseInt(temp[2]);
                if(nameDonor.equals(name) && aids.equals(itemname)){

                }
            }

            String path  = "src/Documentation/DonatedItems.csv";
            FileWriter fw = new FileWriter(path,true);
            fw.write("\n"+ name +"," + itemName + "," + quantity);
            fw.close();
        }catch(IOException e){
            System.err.println("IOException" + e.getMessage());
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