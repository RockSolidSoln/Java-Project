import java.io.IOException;
import java.util.*;

public class Main {
   private static Scanner sc = new Scanner(System.in);
  public static void main(String[] args) throws IOException{
    Welcomemenu();
  }

    private static void Welcomemenu() throws IOException{
        String menu =
        "\n|------------------------------------------------------------|"
        +"\n|           Welcome to our Aid Distribution System           |"
        +"\n|           To procced please choose an option below         |"
        +"\n|------------------------------------------------------------|"
        +"\n|1-Procced to Register a new user                            |"
        +"\n|1-Procced as a Donor:                                       |"
        +"\n|2-Procced as a Non-Goverment Organization:                  |"
        +"\n|3-Procced as a Distribution Center                          |"
        +"\n|0-To Exit                                                   |"
        +"\n|------------------------------------------------------------|";
        System.out.println(menu);
        int  choice = sc.nextInt();
        switch(choice){
            case(1):
                System.out.println("Enter 1 for new Donor and 2 for new NGO");
                int ch = sc.nextInt();
                LoginSystem.createNewUsers(ch);
                break;
            case(2):
                LoginSystem.authenticateUser(1);
                System.out.println("here is method for 1");
                break;
            case(3):
                LoginSystem.authenticateUser(2);
                System.out.println("here is method for 2");
                break;   
            case(4):
                System.out.println("here is method for 3");
                break;
            case(0):
                System.out.println("Have a nice Day! ^-^");
                break;    
        }
    }
}