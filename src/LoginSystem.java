import java.util.*;
import java.io.*;

public class LoginSystem {
    private static Scanner sc;
    

    public static void createuser(String username, String password, String filepath){
        try{
            sc=new Scanner(System.in);
            FileWriter fw = new FileWriter("credentials.dat",true);
            PrintWriter pw = new PrintWriter(fw);
            System.out.println("Please enter the disired username: ");
            username = sc.nextLine();
            System.out.println("Please enter the disired Password: ");
            password = sc.nextLine();
            pw.println(username+","+password);
            pw.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }
    
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
                    System.out.println("correct");
                }
                else
                {
                    System.out.println("file doesnt exist in our system try again");
            }
            sc.close();
            
        }
        }
        catch(Exception e){}        
}
  

    public static void main(String[] args){
     sc= new Scanner(System.in);
     System.out.println("Please Enter your username: ");
     String username=sc.nextLine();
     System.out.println("Please Enter your password: ");
     String password=sc.nextLine();
     String filepath = "credentials.dat";
     createuser(username,password,filepath);
     
    
}
}
