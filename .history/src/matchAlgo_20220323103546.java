import java.util.ArrayList;

public class matchAlgo extends matching {
    public static void runAlgo(ArrayList<String> dName,ArrayList<String> dAids,
                               ArrayList<Integer> dQty, ArrayList<String> nName,
                               ArrayList<String> nAids,ArrayList<Integer> nQty,
                               ArrayList<String> nStatus){
        
        System                        
        for(int i=0;i<dQty.size();i++){
            
        }                        
        for(int i =0; i< nName.size();i++){

            //sorting function in descending order based on Quantitiy According to Donor's list 
            sorting.sortArray(dName, dAids, dQty);

            //for 1-1 matching: since dQty(0) is the largest after sorting,
            //comparing if dQty(0) is enough
            if(nQty.get(i)<=dQty.get(0)){
                dQty.set(0,dQty.get(0)-nQty.get(i));
                //System.out.println(dQty.get(0));    
            }
            else{
                int sum=0;
                for(int j=0; j< dQty.size();j++){
                    sum+=dQty.get(j);
                    if(nQty.get(i)<=sum){
                        dQty.set(j,sum-nQty.get(i)); 
                        nQty.set(i,0);      //Ngo request satisfied
                    }
                    else{
                        nQty.set(i,nQty.get(i)-dQty.get(j));
                        dQty.set(j,0);
                        //now we will acknowledge donor name of j;
                    }
                }
            }
            for(int j=0; j<dQty.size(); j++){
                System.out.println("donor "+dQty.get(j));
                System.out.println("ngo "+nQty.get(i));
                System.out.println("------------");
            }
            
        }
    }

    
}
