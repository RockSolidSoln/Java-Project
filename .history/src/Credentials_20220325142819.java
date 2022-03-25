import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Credentials {
    private static String password;
    private static String username;
    //------------------------Read Credentials from the file------------------------------------
    public static ArrayList<String> readCredsFromFile(int flag) throws IOException { // flag is to check if user is Donor or Ngo
        ArrayList<String> credentials = new ArrayList<>();
        if(flag==1){ //if Donor
            List<String> lines = Files.readAllLines(Paths.get("src/credentials/DonorCredentials.csv")); //read from DonorCredentials files
        }
        else if(flag==2){
            List<String> lines = Files.readAllLines(Paths.get("src/credentials/NgoCredentials.csv"));
        } 
        return credentials;
    }
    //------------------------------------------------------------------------------------

    //-------------------Saves the info of new user---------------------------------------
    public static void saveCredsToFile(int flag, String name, String password, int num) throws IOException {
        ArrayList<String> credentials = readCredsFromFile(flag);
        int innerFlag=0;
        for(int i=0; i<credentials.size(); i++){ 
            String[] items = credentials.get(i).split(",");
            String[] temp = items[0].split("\\s");
            username = temp[0];
            if(username.equals(name)){
                innerFlag=1;
            }
        }
        if(innerFlag==1){
                System.out.println("---------------------------------------------------------");
                System.out.println("Username "+name+" is already in use!");
                System.out.println("---------------------------------------------------------");
        }
        else{
            if(flag==1){
                try{
                    String filename= "src/credentials/DonorCredentials.csv";
                    FileWriter fw = new FileWriter(filename,true); //the true will append the new data
                    fw.write("\n"+name+","+password+","+num);              //appends the string to the file
                    fw.close();
                    System.out.println("\nEntry successful!, Your info has been saved in our system"+
                        "\n------------------------------------------------------------------------------\n");
                }catch(IOException ioe){
                        System.err.println("IOException: " + ioe.getMessage());
                }
            }
            else if(flag==2){
                try{
                String filename= "src/credentials/NgoCredentials.csv";
                FileWriter fw = new FileWriter(filename,true); //the true will append the new data
                fw.write("\n"+name+","+password+","+num);              //appends the string to the file
                fw.close();
                }catch(IOException ioe){
                    System.err.println("IOException: " + ioe.getMessage());
                }
            }
        }
    }
    //------------------------------------------------------------------------------------  
}
