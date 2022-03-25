import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

//------------------This class contains the method to match the request ----------------------------------
public class MatchAlgorithm {

    //------------------This method handles the algorithm to match the request --------------------------------
    public static void runAlgo(String name, ArrayList<String> dName,                //takes paramater of aids name, Donor's &
                                ArrayList<String> dAids ,ArrayList<Integer> dQty,   // and NGO's data in different ArrayLists
                                ArrayList<String> nName, ArrayList<String> nAids, 
                                ArrayList<Integer> nQty, ArrayList<String> nStatus) throws IOException{
                                
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
                    //write back the transactions in the file 
                    WriteBack.store(dName.get(i), dAids.get(i), nQty.get(i), nName.get(i));
                    dQty.set(0,dQty.get(0)-nQty.get(i));    //subtracts the difference from donors aids
                    nQty.set(i,0);                          //make requested aids 0 after satisfaction
                    nStatus.set(i,"satisfied");             //set status as "satisfied"
                }   
                else{
                    for(int j=0; j< dQty.size();j++){
                        //checks if every next element is enough to satisfy the requests completely
                        if(nQty.get(i)<=dQty.get(j)){
                            dQty.set(j,dQty.get(j)-nQty.get(i)); //subtracts the difference from the donors aids
                            if(dQty.get(j)!=0){
                                //write back the transactions in the file 
                                WriteBack.store(dName.get(j), dAids.get(j), nQty.get(i), nName.get(i));
                            }
                            nQty.set(i,0);      //Ngo request satisfied
                            nStatus.set(i,"satisfied");     //set status as "satisfied"
                            break;
                        }
                        else{
                            //write back the transactions in the file 
                            WriteBack.store(dName.get(j), dAids.get(j), dQty.get(j), nName.get(i));
                            nQty.set(i,nQty.get(i)-dQty.get(j));    //subtracts the difference from the donors aids
                            dQty.set(j,0);      //set the donors aids zero
                        }
                    }
                } 
                // System.out.println(nAids.get(i)+" "+nQty.get(i)+" "+nStatus.get(i)); 
            }
        }
        WriteBack.updateDonor(dName, dAids, dQty,1);
        WriteBack.updateNgo(nName, nAids, nQty, nStatus);

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