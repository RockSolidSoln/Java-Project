import java.util.*;
import java.io.*;

//---------------This class have function to create or login user in the system-----------------------------
public class LoginSystem {

    //-----------------------Checks Input username/password with credentials--------------
    public static void authenticateUser(Scanner sc, int flag) throws IOException{// flag is to check if user is Donor or Ngo
        sc = new Scanner(System.in);
        ArrayList<String> credentials = Credentials.readCredsFromFile(flag);
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Enter Name:");
        String tempname=sc.nextLine();                  //takes the name 
        System.out.println("Enter Password:");
        String temppassword=sc.nextLine();              //takes the password
        boolean check=false;

        for (int i = 0; i<credentials.size();i++){
            check = credentials.get(i).equals(tempname+" "+temppassword); //check if name and password matches in the Credentials files

            if(check == true) {             //if name and password match
                System.out.println("---------------------------------------------\n"+
                                   "   Login was Successful\n"+
                                   "---------------------------------------------\n");
                String[] temp = credentials.get(i).split("\\s"); //split at the spaces
                tempname=temp[0];       //stores username
                temppassword=temp[1];   //stores password
                if(flag==1){
                    DonorMenu.welcomeDonor(tempname);   //directs the Donor to Donor menu  
                }
                else if(flag==2){
                    NgoMenu.welcomeNgo(tempname);       //directs the NGO to Ngo menu
                }
                break;               
            }
        }
        if(check==false){               // if name or password doesn't match
            System.out.println("---------------------------------------------\n"+
                               "   Either the Name or the Password was wrong\n"+
                               "   Try again\n"+
                               "---------------------------------------------\n");
            authenticateUser(sc,flag);     // directs user to try again.
        } 
    }
    //------------------------------------------------------------------------------------

    //------------------creates a new usernamein the system------------------------------
    public static void createNewUsers(Scanner sc, int flag) throws IOException {// flag is to check if user is Donor or Ngo
        sc = new Scanner(System.in);
    System.out.println("|-------------------------------------------------------------------|");
    System.out.println("Please Enter your new Username: ");
    String username = sc.nextLine();            //takes the name
    System.out.println("Please Enter your new password");
    String password = sc.nextLine();             //takes the password
    System.out.println("Please Enter your password again: ");
    String temppassword=sc.nextLine();          //takes the password again to confirm the password
    int num;
    if(flag==1){                                //if user is Donor, takes their phone number
        System.out.println("Please Enter your phone number: ");
    }   
    else{                                       //if the user is NGO, takes their manpower
        System.out.println("Enter the Ngo manpower");
    }
    num = sc.nextInt();
    System.out.println("|-------------------------------------------------------------------|");

    do{ 
        if (temppassword.equals(password)){             // if the temppassword matches the password  will  procced to save credentials to the file
            break;
        }
        else{
            System.out.println("Passwords don't match. Please Enter your password again");  // will keep looping until both passwords match 
            temppassword=sc.nextLine();
        }
    }while(temppassword!=password);

    Credentials.saveCredsToFile(flag, username, password, num); //passing the values to save in the file accordingly
    }
    //------------------------------------------------------------------------------------
}
