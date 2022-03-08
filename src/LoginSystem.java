import java.util.*;
import java.io.*;
import java.nio.file.*;



public class LoginSystem {
    private static Scanner sc;
    public static void main(String[] args)throws IOException{
        ArrayList<Credentials> credentials = readCredsFromFile();      
        createNewUsers();
        

   }

   private static ArrayList<Credentials> readCredsFromFile() throws IOException {
       ArrayList<Credentials> credentials = new ArrayList<>();

       List<String> lines = Files.readAllLines(Paths.get("src/credentials.csv"));
       for (int i = 0; i< lines.size();i++) {
           String[] items = lines.get(i).split(",");
           String username = items[0];
           credentials.add (new Credentials(username,Integer.parseInt(items[1])));

       }
       return credentials;
   }

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
       int  temppassword;
       ArrayList<Credentials> credentials=readCredsFromFile();
       sc = new Scanner(System.in);
       System.out.println("Please Enter your new Username: ");
       String username = sc.nextLine();
       System.out.println("Please Enter your new password");
       int password = sc.nextInt();
       System.out.println("Please Enter your password again: ");
       temppassword=sc.nextInt();
       if (temppassword!=password){
        do {
            System.out.println("Passwords don't match. Please Enter your password again");
            temppassword=sc.nextInt();

        } while(temppassword!=password);
       }
    
        System.out.println("Entry successful!, Your info has been saved in our system");
        
       credentials.add(new Credentials(username,password));
       saveCredsToFile(credentials);
   }


}
