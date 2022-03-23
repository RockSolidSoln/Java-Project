import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.io.*;
public class matching {
    
    public static void main(String[]args)throws IOException{
        ArrayList<String> requiredaids = requiredaids();
        for (int i =0; i<requiredaids.size();i++){
            System.out.println(requiredaids.get(i));
        }
    }  
    
    
    private static ArrayList<String> requiredaids() throws IOException{
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
        private static HashMap<String, HashMap<String, Integer>> getHash() throws IOException{
            HashMap<String, HashMap<String, String>> required = new HashMap<String,HashMap<String, Integer>>();
            List<String>lines = Files.readAllLines(Paths.get("src/Documentation/ngoDemands.csv"));
            for (int i = 0; i< lines.size();i++) {
                String[] items = lines.get(i).split(",");
                String name = items[0];
                String aids = items[1];
                int 
            }

        }
    }






}
