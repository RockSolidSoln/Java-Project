import java.io.FileWriter;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.nio.file.Files;

public class writeBack {
    public static void store(){

    }
    public static void updateDonor(ArrayList<String> dName,ArrayList<String> dAids,
                               ArrayList<Integer> dQty){
        String path  = "src/Documentation/DonatedItems.csv";
        FileWriter fw = new FileWriter(path,true);
        try(BufferedWriter bw =fw.newBufferedWriter(path)){
            
        }catch(Exception e){

        }                       
    }
    public static void updateNgo(ArrayList<String> nName,
                                ArrayList<String> nAids,ArrayList<Integer> nQty,
                                ArrayList<String> nStatus){
        try{
            String path  = "src/Documentation/DonatedItems.csv";
            FileWriter fw = new FileWriter(path,true);
        }catch(Exception e){
            
        }  
    }
}
