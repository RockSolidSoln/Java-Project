import java.io.IOException;
import java.util.Scanner;

public class DirectBackMenu{
    
    //------------------This method directs back the user----------------------------------------------
    public static void directBack(Scanner sc,String name,int flag) throws IOException,NoSuch{  //takes the name of the NGO
        System.out.println(      "\n|---------------------------------------------------------------|"
                                +"\n| Please Press 1 to continue back to your menu                  |"
                                +"\n| Please Press 0 or any number to exit the menu                 |"
                                +"\n|---------------------------------------------------------------|");
        int choice = sc.nextInt(); 
        if(choice == 1 && flag==1){        //if choice is 1 and user is Donor
            DonorMenu.welcomeDonor(name);
        }
        else if(choice == 1 && flag==2){        //if choice is 1 and user is NGO
            NgoMenu.welcomeNgo(name);
        }
        else if( choice == 1 && flag==3){       //if choice is 1 and user is DC
            DcMenu.showDcMenu(); 
        }
        else{
                System.exit(0); //if choice not 1
        }        
    }
    //-------------------------------------------------------------------------------------------//  
}
