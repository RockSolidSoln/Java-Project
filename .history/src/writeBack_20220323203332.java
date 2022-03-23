import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

public class writeBack {
    public static void store(String dName, int Dqty, String nName){
        String path  = "src/Documentation/donor&NgoMatched.csv";

        ArrayList<String> credentials = new ArrayList<>();
        
        List<String> lines = Files.readAllLines(Paths.get("src/credentials/DonorCredentials.csv"));
            for (int i = 0; i< lines.size();i++) {
                String[] items = lines.get(i).split(",");
                String username = items[0];
                credentials.add(username+" "+items[1]);
            }
        try (FileWriter fw = new FileWriter(path,true);){

        } catch(Exception e){

        }
    }
    public static void updateDonor(ArrayList<String> dName, ArrayList<String> dAids,
                                    ArrayList<Integer> dQty, int flag){
        String path  = "src/Documentation/DonatedItems.csv";
        if(flag==0){
           int iter=0;
           if(iter==0){
            try( FileWriter fw = new FileWriter(path,true);){
                    fw.write(dName.get(0) +"," + dAids.get(0) + "," + dQty.get(0));
                    fw.close();
            }catch(Exception e){
                System.out.println("Unable to write in DonatedItems.csv");
            } 
           }
           else{
                try( FileWriter fw = new FileWriter(path,true);){
                    for(int i=0; i<dQty.size(); i++){
                        fw.write("\n"+ dName.get(i) +"," + dAids.get(i) + "," + dQty.get(i));
                    }
                    fw.close();
                }catch(Exception e){
                    System.out.println("Unable to write in DonatedItems.csv");
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
                System.out.println("Unable to write in DonatedItems.csv");
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
            System.out.println("Unable to write in ngoDemands.csv");
        }  
    }
}
