import java.util.*;
import java.io.*;
import java.nio.file.*;

public class LoginSystem {
    private static Scanner sc;
    //------------------------Read Credentials file------------------------------------
    private static ArrayList<String> readCredsFromFile(int flag) throws IOException {
        ArrayList<String> credentials = new ArrayList<>();
        if(flag==1){
            List<String> lines = Files.readAllLines(Paths.get("src/credentials.csv"));
            for (int i = 0; i< lines.size();i++) {
                String[] items = lines.get(i).split(",");
                String username = items[0];
                credentials.add(username+" "+items[1]);
            }
        }
        else if(flag==2){
            List<String> lines = Files.readAllLines(Paths.get("src/NgoCredentials.csv"));
            for (int i = 0; i< lines.size();i++) {
                String[] items = lines.get(i).split(",");
                String username = items[0];
                credentials.add(username+" "+items[1]);
            }
        } 
        return credentials;
    }
    //------------------------------------------------------------------------------------

    //-----------------------Checks Input username/password with credentials--------------

    public static void authenticateUser(int flag) throws IOException{
        sc = new Scanner(System.in);
    
        ArrayList<String> credentials = readCredsFromFile(flag);
    
        System.out.println("Enter Name:");
        String tempname=sc.nextLine();
        System.out.println("Enter Password:");
        String temppassword=sc.nextLine();

        for (int i =0; i<credentials.size();i++){
            System.out.println(credentials.get(i));
            if(credentials.get(i).equals(tempname+" "+temppassword)) {
                while(credentials.get(i)!=" ")
            }
        }
        
        if(flag==1){
                  //directs to donor menu      
        }
        else if(flag==2){
                  //directs to ngo menu
        }
                    
    }
    //------------------------------------------------------------------------------------


    //This method saves input into credentials.csv and should be used for signing up method
    private static void saveCredsToFile(ArrayList<Credentials> credentials) throws IOException {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < credentials.size(); i++){
        sb.append(credentials.get(i).toCSVString()+"\n");
    }
    Files.write(Paths.get("src/credentials.csv"), sb.toString().getBytes());
    }

   
    //This method creates a new username and sign them up in the system and will be saved to credentials .csv
    private static void createNewUsers() throws IOException {
    String  temppassword;
    //    ArrayList<String> credentials=readCredsFromFile();
    sc = new Scanner(System.in);
    System.out.println("Please Enter your new Username: ");
    //    String username = sc.nextLine();
    System.out.println("Please Enter your new password");
    String password = sc.nextLine();
    System.out.println("Please Enter your password again: ");
    temppassword=sc.nextLine();
    if (temppassword!=password){
    do {
        System.out.println("Passwords don't match. Please Enter your password again");
        temppassword=sc.nextLine();

    } while(temppassword!=password);
    }

    System.out.println("Entry successful!, Your info has been saved in our system");

    //    credentials.add(new Credentials(username,password));
    //    saveCredsToFile(credentials);
    }

}
