import java.util.*;
import java.io.*;
import java.nio.file.*;



public class LoginSystem {
    private static Scanner sc;
    public static void main(String[] args)throws IOException{  
        // readCredsFromFile(); 
        authenticateUser();
        
   }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   private static ArrayList<String> readCredsFromFile() throws IOException {
       ArrayList<String> credentials = new ArrayList<>();

       List<String> lines = Files.readAllLines(Paths.get("src/credentials.csv"));
       for (int i = 0; i< lines.size();i++) {
           String[] items = lines.get(i).split(",");
           String username = items[0];
           credentials.add (new Credentials(username,items[1]));
       }
       return credentials;
   }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   //This method saves input into credentials.csv and should be used for signing up method
   private static void saveCredsToFile(ArrayList<Credentials> credentials) throws IOException {
       StringBuilder sb = new StringBuilder();
       for (int i = 0; i < credentials.size(); i++){
           sb.append(credentials.get(i).toCSVString()+"\n");
       }
       Files.write(Paths.get("src/credentials.csv"), sb.toString().getBytes());
   }

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   private static void authenticateUser() throws IOException{
        sc = new Scanner(System.in);
        
        ArrayList<String> credentials = readCredsFromFile();
        // String tempUsername = sc.nextLine();
        // String tempPassword = sc.nextLine();
        // Object obj1=tempUsername;
        // Object obj2=tempPassword;
       
       for (int i =0; i<credentials.size();i++){
           System.out.println(credentials.get(i));
           if(credentials.contains(a)) {
               System.out.println("okkk lesgoo");
           }
       }
            
                   
    }
              
            
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   //This method creates a new username and sign them up in the system and will be saved to credentials .csv
   private static void createNewUsers() throws IOException {
       String  temppassword;
       ArrayList<Credentials> credentials=readCredsFromFile();
       sc = new Scanner(System.in);
       System.out.println("Please Enter your new Username: ");
       String username = sc.nextLine();
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
        
       credentials.add(new Credentials(username,password));
       saveCredsToFile(credentials);
   }


}
