import java.util.*;
import java.io.*;
import java.nio.file.*;


public class LoginSystem {
    private static Scanner sc;
    public static void main(String[] args)throws IOException{
        
          ArrayList<Credentials> credentials=readCredsFromFile();
          saveCredsToFile(credentials);
          for (int i = 0; i < credentials.size();i++){
            System.out.println(credentials.get(i));
           
          }     
   }

   private static ArrayList<Credentials> readCredsFromFile() throws IOException {
       ArrayList<Credentials> credentials = new ArrayList<>();

       List<String> lines = Files.readAllLines(Paths.get("credentials.csv"));
       for (int i = 0; i< lines.size();i++) {
           String[] items = lines.get(i).split(",");
           int password = Integer.parseInt(items[0]);
           credentials.add (new Credentials(password,items[1]));

       }
       return credentials;
   }
   private static void saveCredsToFile(ArrayList<Credentials> credentials) throws IOException {
       StringBuilder sb = new StringBuilder();
       for (int i = 0; i < credentials.size(); i++){
           sb.append(credentials.get(i).toCSVString()+"\n");
       }
       Files.write(Paths.get("credentials.csv"), sb.toString().getBytes());
   }
  


}
