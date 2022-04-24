import java.io.IOException;
import java.util.*;

/**
 * Java documentation by Group 4 TT3V
 * The Assignment 1 documentation starts from here.
 */

public class Start {
    /**Initializing scanner*/
    static Scanner sc = new Scanner(System.in);

    /**
     * This function takes user input and directs them to next command
     */
    public static void main(String[] args) throws Exception {
        String menu =
                """

                        |------------------------------------------------------------|
                        |           Welcome to our Aid Distribution System           |
                        |           To proceed please choose an option below         |
                        |------------------------------------------------------------|
                        |1-Proceed to Register a new user                            |
                        |2-Proceed as a Donor:                                       |
                        |3-Proceed as a Non-Government Organization:                 |
                        |4-Proceed as a Distribution Center                          |
                        |0-To Exit                                                   |
                        |------------------------------------------------------------|""";
        System.out.println(menu);
        /*Takes the input from the user according to the menu
         */
        int  choice = sc.nextInt();
        switch(choice){
            case(1):
                System.out.println    ("""
                        |-------------------------------------------------------------------|
                        |  Enter 1 for new Donor                                            |
                        |  Enter 2 for new Non-Government Organization                      |
                        |-------------------------------------------------------------------|""");
                /*
                 * Takes if user wants to create new profile as Donor or Ngo
                 */
                int ch = sc.nextInt();
                /* Directs user to create new profile
                 */
                LoginSystem.createNewUsers(ch);
                main(args);
                break;
            case(2):
                /*Directs donor to the login menu
                 */
                LoginSystem.authenticateUser(sc,1);
                break;
            case(3):
                /* Directs Ngo to the login menu
                 */
                LoginSystem.authenticateUser(sc,2);
                break;
            case(4):
                /* Directs user to the DC menu
                 */
                DcMenu.showDcMenu();
                break;
            case(0):
                /* Exit the program
                 */
                System.out.println("|-------------------------------------------------------------------|\n"
                                +  "   Have a nice Day! ^-^");
                System.exit(0);
                break;
            default:
                /**
                 * throws IOException if any other number is entered
                 */
                throw new IOException();
        }
        sc.close();
    }
}
