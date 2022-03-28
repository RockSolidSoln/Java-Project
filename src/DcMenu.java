import java.util.*;
import java.io.IOException;

/**This class contains the methods for DcMenu*/
public class DcMenu {

    /**Initializing Scanner*/
    private static final Scanner sc = new Scanner(System.in);

    /**This method directs back the user*/
    public static void showDcMenu() throws IOException {
        System.out.println
        ("""

                |---------------------------------------------------------------|
                |               Welcome to Distribution Center                  |
                |---------------------------------------------------------------|
                |     Enter 1: To view all the aids available in DC             |
                |     Enter 2: To view all the NGO's demand                     |
                |     Enter 3: To match the aids available to NGO               |
                |     Enter 4: To view all the aids donated by specific Donor   |
                |     Enter 5: To view all the aids receive by specific NGO     |
                |     Enter 6: To show the history of all the aids distributed  |
                |---------------------------------------------------------------|""");
        
        int choice = sc.nextInt();      //takes the input from the user

        switch (choice) {
            case 1:     DonorMenu.showAvailableAids("null",1);  //show all the available aids in the list
                        break;
            case 2:     NgoMenu.showStatus("null",1);           //show all the requested aids in the system
                        break;
            case 3:     Matching.filter();                      //run the matching algorithm
                        break;
            case 4:     System.out.println("Please Enter the name of the Donor-");
                        show(sc,0);                                //show the transaction for specific Donors
                        break;
            case 5:     System.out.println("Please Enter the name of the NGO-");
                        show(sc,0);                                //show the transaction for specific NGO
                        break;
            case 6:     show(sc,1);                                //show the transaction 
                        break;
        }
        DirectBackMenu.directBack("null",3);        //Direct back menu for user to continue or exit
        sc.close(); 
    }
    //-------------------------------------------------------------------------------------------//

    /**This method is show the history according to the flag*/
    public static void show(Scanner sc, int flag){          //takes flag and show the history according to the flag
        sc = new Scanner(System.in);
        if(flag==0){                                    //if flag 0 show according to specific Donor/NGO
                String str = sc.nextLine();            //takes the name of NGO/Donor
                ShowHistory.viewAidsHistory(str,0);     //calls show history for method 
        }
        else if(flag==1){//if flag 1 show all the history
                ShowHistory.viewAidsHistory("null",1);  //calls the show history method without any Donor/Ngo name
        } 
    }
    //-------------------------------------------------------------------------------------------//
}
