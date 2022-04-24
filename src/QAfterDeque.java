import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class QAfterDeque {
   
    public static void updatefiledq(String path, ArrayList<NgoClass> arrlist, String ngoname, int flag) throws IOException {
      //ngomatched data1 = new ngomatched(things[0], Integer.parseInt(things[1]), things[2]);

        for (NgoClass ngoClass : arrlist) {
            //  System.out.println(arrlist.get(i).name);
            if (ngoClass.ngoName.equals(ngoname)) {
                ngoClass.setStatus("Collected");
                //System.out.println(arrlist.get(i).type);
            }
        }



        try(FileWriter writer = new FileWriter(path)){
            for (NgoClass ngoClass : arrlist) {
                if (ngoClass.ngoMan != 0){
                    writer.write(ngoClass.dName + "," + ngoClass.dPhone + "," + ngoClass.aidType
                            + "," + ngoClass.aidQty + "," + ngoClass.ngoName + "," +
                            ngoClass.ngoMan + "," + ngoClass.status + "\n");
                }

                else{
                    writer.write(ngoClass.dName + "," + ngoClass.dPhone + "," + ngoClass.aidType
                            + "," + ngoClass.aidQty + "," + "0" + "," +
                            "0" + "," + ngoClass.status + "\n");
                }
            }

        }catch(Exception e){
            System.out.println("Unable to write back");
        }
        ShowHistory.viewAidsHistory("null",flag);
    }
}

