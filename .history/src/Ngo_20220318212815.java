import java.io.FileWriter;
import java.io.IOException;

public class Ngo {
    private String aids;
    private int quantity;
    private String status;

    public Ngo() {};
    public Ngo(String name, int q) {
        this.aids = name;
        this.quantity = q;
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
            fw.write("\n" + aids +","+ quantity+ );
            fw.close();
        } catch(IOException ioe){
            System.err.println("IOException: " + ioe.getMessage());
        }
        

    }
    
}
