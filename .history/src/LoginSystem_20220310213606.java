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
                String[] temp = credentials.get(i).split("")
            }
        }
        
        if(flag==1){
                  //directs to donor menu      
        }
        else if(flag==2){
                  //directs to ngo menu
            ngoMenu.welcomeNgo(tempname,temppassword);
        }
                    
    }
    //------------------------------------------------------------------------------------
   
    //------------------creates a new usernamein the system------------------------------
    public static void createNewUsers(int flag) throws IOException {
    
    sc = new Scanner(System.in);
    System.out.println("Please Enter your new Username: ");
    String username = sc.nextLine();
    System.out.println("Please Enter your new password");
    String password = sc.nextLine();
    System.out.println("Please Enter your password again: ");
    String temppassword=sc.nextLine();
    do{ 
        System.out.println(password+"---"+temppassword);
        if (temppassword.equals(password)){
            break;
        }
        else{
            System.out.println("Passwords don't match. Please Enter your password again");
            temppassword=sc.nextLine();
        }
    }while(temppassword!=password);
    
    System.out.println("Entry successful!, Your info has been saved in our system");
    saveCredsToFile(flag,username,password);
    }
    //------------------------------------------------------------------------------------

    //-------------------Saves the info of new user---------------------------------------
    private static void saveCredsToFile(int flag, String name, String password) {
        if(flag==1){
            try{
                String filename= "src/credentials.csv";
                FileWriter fw = new FileWriter(filename,true); //the true will append the new data
                fw.write("\n"+name+","+password);//appends the string to the file
                fw.close();
            }catch(IOException ioe){
                    System.err.println("IOException: " + ioe.getMessage());
                }
        }
        else if(flag==2){
            try{
                String filename= "src/NgoCredentials.csv";
                FileWriter fw = new FileWriter(filename,true); //the true will append the new data
                fw.write("\n"+name+","+password);//appends the string to the file
                fw.close();
            }catch(IOException ioe){
                    System.err.println("IOException: " + ioe.getMessage());
                }

        }
    }
    //------------------------------------------------------------------------------------  
}
