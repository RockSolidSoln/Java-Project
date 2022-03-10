import java.util.*;
import java.io.*;
import java.nio.file.*;

public class Ngo {
    private String aids;
    private int quantity;

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

    public void saveNgoDemands(){
        try{
            String filename="src/ngoDemands.csv";
            FileWriter fw = new FileWriter(filename, true);
            fw.write("\n" + aids + " "+ )
        } catch(IOException ioe){
            System.err.println("IOException: " + ioe.getMessage());
        }
        

    }
    
}
