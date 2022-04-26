import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**This class contains the method to update the file and the arraylist for the status to be 'Collected' after dequing */
public class QAfterDeque {
   
   /**This method is to update the specific file after dequing is done*/
    public static void updatefiledq(String path, ArrayList<MatchedClass> arrlist, String ngoname, int flag) throws IOException {
                    /** the parameters : path of the file, arrlist which is the array of the objects of the MatchedClass, 
                                        the name of the ngo that has been dequed, and the flag to identify the specific file that needs to be updated.*/ 
                
        for (MatchedClass ngoClass : arrlist) {
            
            if (ngoClass.ngoName.equals(ngoname)) {//if NGO name of the object of NGOclass matches the ngo name that has been asked to be dequed
                ngoClass.setStatus("Collected"); // updating the object's status to be 'Collected' using the setter. 
            }
        }

        //truncating the file to wrtie again
        try(FileWriter writer = new FileWriter(path)){

            for (MatchedClass ngoClass : arrlist) {
                //if the NGO manpower is unempty
                if (ngoClass.ngoMan != 0){
                    //writeback in the file 
                    writer.write(ngoClass.dName + "," + ngoClass.dPhone + "," + ngoClass.aidType
                            + "," + ngoClass.aidQty + "," + ngoClass.ngoName + "," +
                            ngoClass.ngoMan + "," + ngoClass.status + "\n");
                }
                //if NGo manpower is empty
                else{
                    //writeback in the file for name and manpower as 0 with empty data
                    writer.write(ngoClass.dName + "," + ngoClass.dPhone + "," + ngoClass.aidType
                            + "," + ngoClass.aidQty + "," + "0" + "," +
                            "0" + "," + ngoClass.status + "\n");
                }
            }
        }catch(Exception e){
            System.out.println("Unable to write back");
        }
        //printing the file after dequeuing 
        ShowHistory.viewAidsHistory("null",flag);
    }
}