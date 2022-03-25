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
        List<String> lines = new ArrayList<>();
        if(flag==1){ //if Donor
            lines = Files.readAllLines(Paths.get("src/credentials/DonorCredentials.csv")); //read from DonorCredentials files
        }
        else if(flag==2){
            lines = Files.readAllLines(Paths.get("src/credentials/NgoCredentials.csv"));
        } 
        for (int i = 0; i< lines.size();i++) {
            String[] items = lines.get(i).split(","); //split the comma, store every word in an array
            username = items[0];    //stores username
            password = items[1];    // stores password
            credentials.add(username+" "+password); //add it in the credentials array with a space
        }
        return credentials; //return credentials to check
    }
    //------------------------------------------------------------------------------------

    //-------------------Saves the info of new user---------------------------------------
    public static void saveCredsToFile(int flag, String name, String password, int num) throws IOException {
        ArrayList<String> credentials = readCredsFromFile(flag); //read credentials from file accordingly
        int innerFlag=0;                        // flag to check is username alread
        for(int i=0; i<credentials.size(); i++){ 
            String[] items = credentials.get(i).split(",");     //split the comma
            String[] temp = items[0].split("\\s");              //split the spaces
            username = temp[0];                  // stores username
            if(username.equals(name)){           // if username already in the user
                innerFlag=1;
            }
        }
        if(innerFlag==1){               //asks the user to try again as username already in the use
                System.out.println("---------------------------------------------------------");
                System.out.println("Username "+name+" is already in use!");
                System.out.println("---------------------------------------------------------");
                LoginSystem.createNewUsers(flag);
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