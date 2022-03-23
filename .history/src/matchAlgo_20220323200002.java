import java.util.ArrayList;
import java.util.Collections;
public class matchAlgo extends matching {
    public static void runAlgo(String name, ArrayList<String> dName, 
                                ArrayList<String> dAids ,ArrayList<Integer> dQty, 
                                ArrayList<String> nName, ArrayList<String> nAids, 
                                ArrayList<Integer> nQty, ArrayList<String> nStatus){
        
                                
        for(int i =0; i< nName.size();i++){
            if(name==nName.get(i)){
                
            }
            
        }
        //writeBack.updateDonor(dName, dAids, dQty);
        writeBack.updateNgo(nName, nAids, nQty, nStatus);
        writeBack.store();

    }
    public static void sortArray(ArrayList<String> dName,ArrayList<String> dAids,
    ArrayList<Integer> dQty){
        for(int i=0;i<dQty.size()-1;i++){
            for(int j=i+1;j<dQty.size();j++){
                if(dQty.get(i)<dQty.get(j)){
                Collections.swap(dQty,i,j);
                Collections.swap(dName,i,j);
                Collections.swap(dAids,i,j);
                }       
            }
        }
    }
}
