import java.io.FileWriter;
import java.util.ArrayList;
import java.io.File;

public class writeBack {
    public static void store(){

    }
    public static void updateDonor(ArrayList<String> dName,ArrayList<String> dAids,
                               ArrayList<Integer> dQty){
        String path  = "src/Documentation/DonatedItems.csv";
       
        try( FileWriter fw = new FileWriter(path);){
            for(int i=0; i<dQty.size(); i++){
                fw.write("\n"+ dName.get(i) +"," + dAids.get(i) + "," + dQty.get);
            
            }
            fw.close();
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
