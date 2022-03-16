import java.io.FileWriter;
import java.io.IOException;

public class Donor{
    private String name;
    private String phoneNumber;
    private String itemName;
    private int quantity;
    public Donor(){};

    public Donor(String name,String phoneNumber,String itemName, int qty){
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.itemName = itemName;
        this.quantity = qty;       
    }
    // each of the statements below will return a variable we will use on later.
    public String getName(){                    
        return name;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public String getItemName(){
        return itemName;
    }
    public int getQuantity(){
        return quantity;
    }

    // this method will save all the information about a donor and will be used in a html report later on!
    public void saveDonorInfo(){
        try{
            String path  = "src/Documentation/Donorinfo.csv";
            FileWriter fw = new FileWriter(path,true);
            fw.write("\n"+ name +","+ phoneNumber+"," +itemName+"," + quantity);
            fw.close();
        }catch(IOException e){
            System.err.println("IOException" + e.getMessage());
        }
        

    }
}