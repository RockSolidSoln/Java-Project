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
        +"\n|1-Procced to register a new user                            |"
        +"\n|1-Procced as a donor:                                       |"
        +"\n|2-Procced as a Non-Goverment Organization:                  |"
        +"\n|3-Procced as a Distribution Center                          |"
        +"\n|0-To Exit                                                   |"
        +"\n|------------------------------------------------------------|";
        System.out.println(menu);
        int  choice = sc.nextInt();
        switch(choice){
            case(1):
                System.out.println("")
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