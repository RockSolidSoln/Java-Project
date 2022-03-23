import java.util.ArrayList;
import java.util.Collections;
public class matchAlgo extends matching {
    public static void runAlgo(String name, ArrayList<String> dName, 
                                ArrayList<String> dAids ,ArrayList<Integer> dQty, 
                                ArrayList<String> nName, ArrayList<String> nAids, 
                                ArrayList<Integer> nQty, ArrayList<String> nStatus){
        
                                
        for(int i =0; i< nName.size();i++){
            //checks if name of the aids to satisfy is equals to aids in the ngo demands
            if(name.equals(nAids.get(i))){
                //sorting function in descending order based on Quantitiy According to Donor's list 
                sortArray(dName, dAids, dQty);

                if(dQty.get(0) == 0){
                    break; //that means all the elements inside dqty are 0. 
                }
                //for 1-1 matching: since dQty(0) is the largest after sorting,
                //comparing if dQty(0) is enough
                if(nQty.get(i)<=dQty.get(0)){
                    writeBack.store(dName.get(i), dAids.get(i), nQty(i), nName);
                    dQty.set(0,dQty.get(0)-nQty.get(i));
                    nQty.set(i,0);
                    nStatus.set(i,"satisfied");

                    //System.out.println(dQty.get(0));    
                }
                else{
                    int sum=0;
                    for(int j=0; j< dQty.size();j++){
                        sum+=dQty.get(j);
                        // System.out.println("sum="+sum);

                        if(nQty.get(i)<=sum){
                            dQty.set(j,sum-nQty.get(i)); 
                            nQty.set(i,0);      //Ngo request satisfied
                            nStatus.set(i,"satisfied");
                            break;
                        }
                        else{
                            nQty.set(i,nQty.get(i)-dQty.get(j));
                            dQty.set(j,0);
                            // System.out.println("nqty-"+nQty.get(i));
                            //now we will acknowledge donor name of j;
                        }
                    }
                } 
                // System.out.println(nAids.get(i)+" "+nQty.get(i)+" "+nStatus.get(i)); 
            }
        }
        writeBack.updateDonor(dName, dAids, dQty,1);
        writeBack.updateNgo(nName, nAids, nQty, nStatus);

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
