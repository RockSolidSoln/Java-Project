import java.util.*;
public class QAfterDeque {
   
    public static void updatefiledq(ArrayList<NgoClass> arrlist, String ngoname){
      //ngomatched data1 = new ngomatched(things[0], Integer.parseInt(things[1]), things[2]);
      
        for(int i=0; i<arrlist.size(); i++){
      //  System.out.println(arrlist.get(i).name);   
            if(arrlist.get(i).ngoName.equals(ngoname)){
                arrlist.get(i).setStatus("Collected");
                //System.out.println(arrlist.get(i).type);
            }
        }

        for(int i=0; i<arrlist.size(); i++){
            if(arrlist.get(i).ngoMan != 0)
                System.out.println (arrlist.get(i).dName + " " + arrlist.get(i).dPhone + " " + arrlist.get(i).aidType 
                                + " " + arrlist.get(i).aidQty + " " + arrlist.get(i).ngoName + " " +
                                arrlist.get(i).ngoMan + " " + arrlist.get(i).status);
        
            else
                System.out.println (arrlist.get(i).dName + " " + arrlist.get(i).dPhone + " " + arrlist.get(i).aidType 
                                + " " + arrlist.get(i).aidQty + " - "
                                + " - " + arrlist.get(i).status);

        }   
    }
}

