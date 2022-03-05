import java.util.*;
import java.io.*;

public class LoginSystem {
    private static Scanner sc;
    

    
    
public static void verifyLogin(String username, String password, String filepath){
   
        boolean found = false;
        String tempUsername = "";
        String tempPassword = "";

        try
        {
            sc= new Scanner(new File(filepath));
            sc.useDelimiter("[,\n]");

            while(sc.hasNext() && !found){
                tempUsername = sc.next();
                tempPassword = sc.next();

                if(tempUsername.trim().equals(username.trim())&&tempPassword.trim().equals(password.trim())) {
                    found = true;
                }
            }
            sc.close();
            System.out.println("Correct");

        }
        catch(Exception e){
            System.out.println("Error either the username or password is incorrect");
        }
    
        
}
  

    public static void main(String[] args){
     sc= new Scanner(System.in);
     System.out.println("Please Enter your username: ");
     String username=sc.nextLine();
     System.out.println("Please Enter your password: ");
     String password=sc.nextLine();
     String filepath = "credentials.dat";
     verifyLogin(username,password,filepath);
    
}
}
