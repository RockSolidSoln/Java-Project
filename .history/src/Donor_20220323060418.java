import java.io.FileWriter;
import java.io.IOException;

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
            String path  = "src/Documentation/DonatedItems.csv";
            FileWriter fw = new FileWriter(path,true);
            fw.write("\n"+ name +"," + itemName + "," + quantity);
            fw.close();
        }catch(IOException e){
            System.err.println("IOException" + e.getMessage());
        }      
    }
    public static void getDonorInfo(){
        
    }
}