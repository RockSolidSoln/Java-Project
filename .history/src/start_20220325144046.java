import java.io.IOException;
import java.util.*;
 //-----------------------------The program start from here--------------------------------------------
public class Start {
    private static Scanner sc = new Scanner(System.in);
    //------------This function takes user input and directs them to next command----------------------
    public static void main(String[] args) throws IOException{ 
        String menu =
         "\n|------------------------------------------------------------|"
        +"\n|           Welcome to our Aid Distribution System           |"
        +"\n|           To procced please choose an option below         |"
        +"\n|------------------------------------------------------------|"
        +"\n|1-Procced to Register a new user                            |"
        +"\n|2-Procced as a Donor:                                       |"
        +"\n|3-Procced as a Non-Goverment Organization:                  |"
        +"\n|4-Procced as a Distribution Center                          |"
        +"\n|0-To Exit                                                   |"
        +"\n|------------------------------------------------------------|";
        System.out.println(menu);
        int  choice = sc.nextInt();             //takes the input from the user according to the menu
        
        switch(choice){
            case(1):
                System.out.println    ("|-------------------------------------------------------------------|"
                                    +"\n|  Enter 1 for new Donor                                            |"                                           
                                    +"\n|  Enter 2 for new Non-Goverment Organization                       |"
                                    +"\n|-------------------------------------------------------------------|");
                int ch = sc.nextInt();          // takes is user wants to create 
                LoginSystem.createNewUsers(ch); //directs user to create new profile
                break;
            case(2):
                LoginSystem.authenticateUser(1); //directs donor to the login menu
                break;
            case(3):
                LoginSystem.authenticateUser(2); //directs Ngo to the login menu
                break;   
            case(4):
                DcMenu.showDcMenu(); //directs user to the DC menu
                break;
            case(0): //exit the program
                System.out.println("|-------------------------------------------------------------------|\n"
                                +  "   Have a nice Day! ^-^");
                break;    
        }
    }
}
