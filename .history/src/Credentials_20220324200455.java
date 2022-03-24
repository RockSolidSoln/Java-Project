import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Credentials {
    private static String password;
    private static String username;
    private static int number;
    public Credentials() {}
    public Credentials(String username , String password, int number) {
        Credentials.password = password;
        Credentials.username = username;
        Credentials.number = number;
    }
    //------------------------Read Credentials file------------------------------------
    public static ArrayList<String> readCredsFromFile(int flag) throws IOException {
        ArrayList<String> credentials = new ArrayList<>();
        if(flag==1){
            List<String> lines = Files.readAllLines(Paths.get("src/credentials/DonorCredentials.csv"));
            for (int i = 0; i< lines.size();i++) {
                String[] items = lines.get(i).split(",");
                username = items[0];
                password = items[1];
                credentials.add(username+" "+password);
            }
        }
        else if(flag==2){
            List<String> lines = Files.readAllLines(Paths.get("src/credentials/NgoCredentials.csv"));
            for (int i = 0; i< lines.size();i++) {
                String[] items = lines.get(i).split(",");
                username = items[0];
                password = items[1];
                credentials.add(username+" "+items[1]);
            }
        } 
        return credentials;
    }
    //------------------------------------------------------------------------------------

    //-------------------Saves the info of new user---------------------------------------
    public static void saveCredsToFile(int flag) throws IOException {
        ArrayList<String> credentials = readCredsFromFile(flag);
        int innerFlag=0;
        for(int i=0; i<credentials.size(); i++){ 
            String[] items = credentials.get(i).split(",");
            String[] temp = items[0].split("\\s");
            String name = temp[0];
            if(name.equals(username)){
                innerFlag=1;
            }
        }
        if(innerFlag==1){
                System.out.println("---------------------------------------------------------");
                System.out.println("Username "+username+" is already in use!");
                System.out.println("---------------------------------------------------------");
        }
        else{
            if(flag==1){
                try{
                    String filename= "src/credentials/DonorCredentials.csv";
                    FileWriter fw = new FileWriter(filename,true); //the true will append the new data
                    fw.write("\n"+username+","+password+","+number);              //appends the string to the file
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
                fw.write("\n"+username+","+password+","+number);              //appends the string to the file
                fw.close();
                }catch(IOException ioe){
                    System.err.println("IOException: " + ioe.getMessage());
                }
            }
        }
    }
    //------------------------------------------------------------------------------------  
}
