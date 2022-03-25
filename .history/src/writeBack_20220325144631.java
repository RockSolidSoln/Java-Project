import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

//------------This class containes methods to write back in the files---------------------------------
public class WriteBack {
    public static void store(String dName, String dAids ,int dQty, String nName) throws IOException{
        String path  = "src/Documentation/donor&NgoMatched.csv";

        List<String> lines = Files.readAllLines(Paths.get("src/credentials/DonorCredentials.csv"));
        String phono = new String();
        for (int i = 0; i< lines.size();i++) {
            String[] items = lines.get(i).split(",");
            if(dName.equals(items[0])){
                phono= items[2];
            }   
        }

        lines = Files.readAllLines(Paths.get("src/credentials/NgoCredentials.csv"));
        String manpower = new String();
        for (int i = 0; i< lines.size();i++) {
            String[] items = lines.get(i).split(",");
            if(nName.equals(items[0])){
                manpower = items[2];
            }
        }

        try (FileWriter fw = new FileWriter(path,true);){
            fw.write("\n"+dName + "," + phono + "," 
                    + dAids + "," + dQty + "," 
                    + nName + "," + manpower);
            System.out.println(" The transaction was successful")
            System.out.println("\n|------------------------------------------------------------------------|");
            System.out.format("|%10s  |%11s |%10s |%10s |%10s |%10s|","Donor ","PhoneNumber","Aid","Quantity","Ngo","Manpower"); //template for the table.
            System.out.println("\n|------------------------------------------------------------------------|");
            System.out.println(dName + "," + phono + "," 
                                + dAids + "," + dQty + "," 
                                + nName + "," + manpower);

        } catch(Exception e){
            System.out.println("Unable to write in donor&NgoMatched.csv");
        }
    }

    public static void updateDonor(ArrayList<String> dName, ArrayList<String> dAids,
                                    ArrayList<Integer> dQty, int flag){
        String path  = "src/Documentation/DonatedItems.csv";
        if(flag==0){
            try( FileWriter fw = new FileWriter(path);){
                fw.write(dName.get(0)+"," + dAids.get(0) + "," + dQty.get(0));
                for(int i=1; i<dQty.size(); i++){
                    fw.write("\n"+ dName.get(i) +"," + dAids.get(i) + "," + dQty.get(i));
                }
    
                fw.close();             
            }catch(Exception e){
                System.out.println("Unable to write in DonatedItems.csv");
            }
        }       
        else{
            try( FileWriter fw = new FileWriter(path,true);){
                for(int i=0; i<dQty.size(); i++){
                    if(dQty.get(i)!=0){
                        fw.write("\n"+ dName.get(i) +"," + dAids.get(i) + "," + dQty.get(i));
                    }
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
                if(nStatus.get(i).equals("unsatisfied")){
                    fw.write("\n"+ nName.get(i) +","+ nAids.get(i)+ "," + nQty.get(i)+","+ nStatus.get(i));
                }
            }
            fw.close();
        }catch(Exception e){
            System.out.println("Unable to write in ngoDemands.csv");
        }  
    }
}
