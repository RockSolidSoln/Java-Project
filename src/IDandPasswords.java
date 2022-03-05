import java.util.*;

public class IDandPasswords {
    private static HashMap<String,String> logininfo = new HashMap<>();  

         class Credentials{
        private String password;
        private String username = "salah";
    
    }
   // This method Prompts the user to Enter his Credentials
    public void getinfo(){
    Scanner input = new Scanner(System.in);
    Credentials creds = new Credentials();
    System.out.println("Enter your ID");
    creds.username = input.nextLine();
    System.out.println("Enter your Password");
    creds.password = input.nextLine();
    logininfo.put(creds.username,creds.password);
    System.out.println(creds.username);
   }
    void authenticateinfo(){
    Credentials creds = new Credentials();
    if(logininfo.containsKey(creds.username)){
      System.out.println("yes");
    }

   }
  

    public static void main(String[] args){
     IDandPasswords d = new IDandPasswords();
     d.getinfo();
     d.authenticateinfo();
    }
}
