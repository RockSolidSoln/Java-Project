import java.util.ArrayList;

public class matchAlgo extends matching {
    public static void runAlgo(ArrayList<String> dName,ArrayList<String> dAids,
                               ArrayList<Integer> dQty, ArrayList<String> nName,
                               ArrayList<String> nAids,ArrayList<Integer> nQty,
                               ArrayList<String> nStatus){

        for(int i =0; i< nName.size();i++){

            //sorting function in des
            sorting.sortArray(dName, dAids, dQty);

            for(int j =0; j< dQty.size();j++){
                if(dQty.get(j)==nQty.get(i)){
                    //this is 1-1

                }
                
            }
        }
    }

    
}
