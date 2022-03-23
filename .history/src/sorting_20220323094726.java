import java.util.ArrayList;
import java.util.Collections;

public class sorting {
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
        for(int i=0;i<dQty.size();i++){
            System.out.println("--------");
            System.out.println(dName.get[i] + " ")
        }                            
    }
}
