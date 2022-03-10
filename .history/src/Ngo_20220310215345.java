import java.io.FileWriter;

public class ngo {
    private String aids;
    private int quantity;

    public ngo() {};
    public ngo(String name, int q) {
        this.aids = name;
        this.quantity = q;
    }
    public String getAids(){
        return aids;
    }
    public int getQty(){
        return quantity;
    }

    public void saveNgoDemands(){
        try{
            String filename="src/ngoDemands.csv";
            FileWriter fw = new FileWriter(filename, true);
            fw.write("\n" + aids + " " + quantity );
            fw.close();
        } catch(IOException ioe){
            System.err.println("IOException: " + ioe.getMessage());
        }
        

    }
    
}
