import java.io.IOException;
import java.util.*;

public class start {
   private static Scanner sc = new Scanner(System.in);
  public static void main(String[] args) throws IOException{
    welcomeMenu();
  }

    private static void welcomeMenu() throws IOException{
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
                System.out.println("-----------------------------------------------------------------------
                                    "Enter 1 for new Donor"+"\nEnter 2 for new Non-Goverment Organization");
                System.out.println("------------------------------------------------------------------------------------------");
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
                dcMenu.showDcMenu();
                break;
            case(0):
                System.out.println("Have a nice Day! ^-^");
                break;    
        }
    }
}