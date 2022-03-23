import java.util.ArrayList;
import java.util.Collections;
public class matchAlgo extends matching {
    public static void runAlgo(ArrayList<String> dName,ArrayList<String> dAids,
                               ArrayList<Integer> dQty, ArrayList<String> nName,
                               ArrayList<String> nAids,ArrayList<Integer> nQty,
                               ArrayList<String> nStatus){
        
        for(int i =0; i< nName.size();i++){

            //sorting function in descending order based on Quantitiy According to Donor's list 
            sortArray(dName, dAids, dQty);
            if(dQty.get(0) == 0){
                break; //that means all the elements inside dqty are 0. 
            }
            //for 1-1 matching: since dQty(0) is the largest after sorting,
            //comparing if dQty(0) is enough
            if(nQty.get(i)<=dQty.get(0)){
                dQty.set(0,dQty.get(0)-nQty.get(i));
                //System.out.println(dQty.get(0));    
            }
            else{
                for(int j=0; j< dQty.size();j++){
                    
                    if(nQty.get(i)<=dQty.get(j)){
                        dQty.set(j,dQty.get(j)-nQty.get(i)); 
                        nQty.set(i,0);      //Ngo request satisfied
                        n
                    }
                    else{
                        nQty.set(i,nQty.get(i)-dQty.get(j));
                        dQty.set(j,0);
                        //System.out.println("nqty-"+nQty.get(i));
                        //now we will acknowledge donor name of j;
                    }
                }
            }  
        }
        writeBack.updateDonor(dName, dAids, dQty);
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
