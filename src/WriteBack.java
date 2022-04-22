import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**This class contains methods to write back in the files*/
public class WriteBack {
    
    /**This method is store the transactions*/
    public static void store(String dName, String dAids ,int dQty, String nName) throws IOException{ //takes the Donors as well as NGO's info

        List<String> lines = Files.readAllLines(Paths.get("src/credentials/DonorCredentials.csv"));  //read from the file and store in the Strings list
        String phono = new String();
        String status = "Reserved";
        for (String line : lines) {
            String[] items = line.split(",");       //split according to the comma
            if (dName.equals(items[0])) {     //if name of the donor matches in Credentials file
                phono = items[2];            //store the phone number
            }
        }

        lines = Files.readAllLines(Paths.get("src/credentials/NgoCredentials.csv"));    //read the file and stores in the list
        String manpower = new String();
        for (String line : lines) {
            String[] items = line.split(",");       //split according to the comma
            if (nName.equals(items[0])) {     //if name of the NGO matches in Credentials file
                manpower = items[2];        //stores the Manpower
            } else if (nName.equals("-")) {
                manpower = nName;
                status = "Available";
            }
        }

        String path  = "src/Documentation/Donor&NgoMatched.csv";    //stores the path of the file
        try (FileWriter fw = new FileWriter(path,true);){       //appending at the end of each data
            fw.write("\n"+dName + "," + phono + "," 
                    + dAids + "," + dQty + "," 
                    + nName + "," + manpower + "," + status);      //write in the file

            System.out.println(" The transaction was successful ");
            System.out.println("\n|------------------------------------------------------------------------------------|");
            System.out.format("|%10s  |%11s |%10s |%10s |%10s |%10s |%10s|","Donor ","PhoneNumber","Aid","Quantity","Ngo","Manpower","Status"); //template for the table.
            System.out.println("\n|------------------------------------------------------------------------------------|");
            System.out.printf("| %10s |%11s |%10s |%10s |%10s |%10s |%10s|",dName, phono, dAids, dQty, nName, manpower, status);              //printinf each transaction
            System.out.println("\n|------------------------------------------------------------------------------------|");
        } catch(Exception e){       //if unable to write
            System.out.println("Unable to write in Donor&NgoMatched.csv");
        }
    }
    //-------------------------------------------------------------------------------------------//
    
    /**This method is update the Donors aids*/
    public static void updateDonor(ArrayList<String> dName, ArrayList<String> dAids,
                                    ArrayList<Integer> dQty, int flag){     //takes the Donor's aids info and a flag
        String path  = "src/Documentation/DonatedItems.csv";                //stores the path of the file
        if(flag==0){    
            //if flag 0 means do not truncate the array and re-write it again
            try( FileWriter fw = new FileWriter(path);){    
                fw.write(dName.get(0)+"," + dAids.get(0) + "," + dQty.get(0));  //stores the first data set in the first line
                for(int i=1; i<dQty.size(); i++){
                    fw.write("\n"+ dName.get(i) +"," + dAids.get(i) + "," + dQty.get(i));   //appends the data in each line
                }
                fw.close();             
            }catch(Exception e){    //if unable to write back
                System.out.println("Unable to write in DonatedItems.csv");
            }
        }       
        else{       
            //if flag not 0 means appending after every set of values
            try( FileWriter fw = new FileWriter(path,true);){
                for(int i=0; i<dQty.size(); i++){
                    if(dQty.get(i)!=0){     //do not append the 0 quantity values in the file
                        fw.write("\n"+ dName.get(i) +"," + dAids.get(i) + "," + dQty.get(i));   //appends data
                    }
                }
                fw.close();
            }catch(Exception e){        //if unable to write back
                System.out.println("Unable to write in DonatedItems.csv");
            } 
        }                      
    }
    //-------------------------------------------------------------------------------------------//

    /**This method is to update NGO requests*/
    public static void updateNgo(ArrayList<String> nName,
                                ArrayList<String> nAids,ArrayList<Integer> nQty,
                                ArrayList<String> nStatus){     //takes the NGO's aids data 
        try{
            String path  = "src/Documentation/NgoDemands.csv";  //stores the path of the file
            FileWriter fw = new FileWriter(path);
            if(nStatus.get(0).equals("unsatisfied")){
                fw.write(nName.get(0) +","+ nAids.get(0)+ "," + nQty.get(0)+","+ nStatus.get(0));   //appends the data
            }      //truncate the file and write in the first line

            for(int i = 1; i < nStatus.size();i++){
                if(nStatus.get(i).equals("unsatisfied")){       //only append the unsatisfied requests
                    fw.write("\n"+ nName.get(i) +","+ nAids.get(i)+ "," + nQty.get(i)+","+ nStatus.get(i)); //appends the data
                }
            }
            fw.close();
        }catch(Exception e){    //if unable to write back
            System.out.println("Unable to write in ngoDemands.csv");
        }  
    }
    //-------------------------------------------------------------------------------------------//
}