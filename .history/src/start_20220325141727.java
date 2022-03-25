import java.io.IOException;
import java.util.*;

public class Start { //The program start from here
    private static Scanner sc = new Scanner(System.in);
        //------------This function takes user input and directs ------------------------------------
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
        int  choice = sc.nextInt();
        
        switch(choice){
            case(1):
                System.out.println    ("|-------------------------------------------------------------------|"
                                    +"\n|  Enter 1 for new Donor                                            |"                                           
                                    +"\n|  Enter 2 for new Non-Goverment Organization                       |"
                                    +"\n|-------------------------------------------------------------------|");
                int ch = sc.nextInt();
                LoginSystem.createNewUsers(ch);
                break;
            case(2):
                LoginSystem.authenticateUser(1);
                break;
            case(3):
                LoginSystem.authenticateUser(2);
                break;   
            case(4):
                DcMenu.showDcMenu();
                break;
            case(0):
                System.out.println("|-------------------------------------------------------------------|\n"
                                +  "   Have a nice Day! ^-^");
                break;    
        }
    }
}
