import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

//------------This class containes methods to write back in the files---------------------------------
public class WriteBack {
    
    //------------------This method is store the tranactions---------------------------
    public static void store(String dName, String dAids ,int dQty, String nName) throws IOException{ //takes the Donors as well as NGO's info
        String path  = "src/Documentation/donor&NgoMatched.csv";

        List<String> lines = Files.readAllLines(Paths.get("src/credentials/DonorCredentials.csv"));  //read from the file and store in the Strings list
        String phono = new String();
        for (int i = 0; i< lines.size();i++) {
            String[] items = lines.get(i).split(",");       //split according to the comma
            if(dName.equals(items[0])){     //if name of the donor matches in Credentials file
                phono= items[2];            //store the phone number
            }   
        }

        lines = Files.readAllLines(Paths.get("src/credentials/NgoCredentials.csv"));    //read the file and stores in the list
        String manpower = new String();
        for (int i = 0; i< lines.size();i++) {
            String[] items = lines.get(i).split(",");       //split according to the comma
            if(nName.equals(items[0])){     //if name of the NGO matches in Credentials file
                manpower = items[2];        //stores the Manpower
            }
        }

        try (FileWriter fw = new FileWriter(path,true);){       //appending at the end of each data
            fw.write("\n"+dName + "," + phono + "," 
                    + dAids + "," + dQty + "," 
                    + nName + "," + manpower);      //write in the file 
            System.out.println(" The transaction was successful ");
            System.out.println("\n|------------------------------------------------------------------------|");
            System.out.format("|%10s  |%11s |%10s |%10s |%10s |%10s|","Donor ","PhoneNumber","Aid","Quantity","Ngo","Manpower"); //template for the table.
            System.out.println("\n|------------------------------------------------------------------------|");
            System.out.printf("| %10s |%11s |%10s |%10s |%10s |%10s|",dName, phono, dAids, dQty, nName, manpower);              //printinf each transaction
            System.out.println("\n|------------------------------------------------------------------------|");
        } catch(Exception e){       //if unable to write
            System.out.println("Unable to write in donor&NgoMatched.csv");
        }
    }
    //-------------------------------------------------------------------------------------------//
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
