import java.io.FileWriter;
import java.util.ArrayList;
// import java.io.File;

public class writeBack {
    public static void store(){

    }
    public static void updateDonor(ArrayList<String> dName, ArrayList<String> dAids,
                                    ArrayList<Integer> dQty, int flag){
        String path  = "src/Documentation/DonatedItems.csv";
       if(flag==0){
           int iter=0;
           if(iter==0){
            try( FileWriter fw = new FileWriter(path,true);){
                    fw.write(dName.get(0) +"," + dAids.get(0) + "," + dQty.get(0));
                }
                fw.close();
            }catch(Exception e){

            } 
           }
           else{
                try( FileWriter fw = new FileWriter(path,true);){
                    for(int i=0; i<dQty.size(); i++){
                        fw.write("\n"+ dName.get(i) +"," + dAids.get(i) + "," + dQty.get(i));
                    }
                    fw.close();
                }catch(Exception e){

                } 
           }  
       }
        else{
            //have to truncate file
            try( FileWriter fw = new FileWriter(path,true);){
                for(int i=0; i<dQty.size(); i++){
                    fw.write("\n"+ dName.get(i) +"," + dAids.get(i) + "," + dQty.get(i));
                }
                fw.close();
            }catch(Exception e){

            } 
        }                      
    }
    public static void updateNgo(ArrayList<String> nName,
                                ArrayList<String> nAids,ArrayList<Integer> nQty,
                                ArrayList<String> nStatus){
        try{
            String path  = "src/Documentation/ngoDemands.csv";
            FileWriter fw = new FileWriter(path);
            fw.write(nName.get(0) +","+ nAids.get(0)+ "," + nQty.get(0)+","+ nStatus.get(0));
            for(int i = 1; i < nStatus.size();i++){
                fw.write("\n"+ nName.get(i) +","+ nAids.get(i)+ "," + nQty.get(i)+","+ nStatus.get(i));
            }
            fw.close();
        }catch(Exception e){
            
        }  
    }
}
