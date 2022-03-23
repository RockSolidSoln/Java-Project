import java.util.ArrayList;

public class matchAlgo extends matching {
    public static void runAlgo(ArrayList<String> dName,ArrayList<String> dAids,
                               ArrayList<Integer> dQty, ArrayList<String> nName,
                               ArrayList<String> nAids,ArrayList<Integer> nQty,
                               ArrayList<String> nStatus){

        for(int i =0; i< nName.size();i++){

            //sorting function in descending order based on Quantitiy According to Donor's list 
            sorting.sortArray(dName, dAids, dQty);

            if(nQty.get(i)==dQty.get(i)){
                //this is 1-1 matching 
            }
            for(int j =0; j< dQty.size();j++){
                
                
            }
        }
    }

    
}
