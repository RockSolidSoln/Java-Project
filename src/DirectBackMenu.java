import java.io.IOException;
import java.util.Scanner;

/**This class contains a method to direct back users to their specific menu accordingly*/
public class DirectBackMenu{
    
    /**This method directs back the user to their menus*/
    public static void directBack(String name,int flag) throws IOException{  //takes the name of the NGO
        Scanner sc = new Scanner(System.in);
        System.out.println("""

                |---------------------------------------------------------------|
                | Please Press 1 to continue back to your menu                  |
                | Please Press 0 or any number to exit the menu                 |
                |---------------------------------------------------------------|""");
        String tempChoice = sc.nextLine();
        int choice = Integer.parseInt(tempChoice); 
        if(choice == 1 && flag==1){        //if choice is 1 and user is Donor
            DonorMenu.welcomeDonor(name);  //directs donor back to menu
        }
        else if(choice == 1 && flag==2){        //if choice is 1 and user is NGO
            NgoMenu.welcomeNgo(name);           //directs NGO back to menu
        }
        else if(choice == 1 && flag==3){       //if choice is 1 and user is DC
            DcMenu.showDcMenu();               //directs back to DC menu
        }
        else{
            System.exit(0); //if choice not 1 
        }
        sc.close();                         
    }
    //-------------------------------------------------------------------------------------------//  
}
