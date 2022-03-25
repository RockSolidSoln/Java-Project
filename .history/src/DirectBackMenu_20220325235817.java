import java.io.IOException;
import java.util.Scanner;

public class DirectBackMenu{
    
    //------------------This method directs back the user----------------------------------------------
    public static void directback(String name,int flag) throws IOException{  //takes the name of the NGO
        Scanner sc = new Scanner(System.in);
        System.out.println(      "\n|---------------------------------------------------------------|"
                                +"\n| Please Press 1 to continue back to your menu                  |"
                                +"\n| Please Press 0 or any number to exit the menu                 |"
                                +"\n|---------------------------------------------------------------|");
        int choice = sc.nextInt(); 
        if(choice == 1 && flag==2){        //if choice is 1
            NgoMenu.welcomeNgo(name);
        }
        else{
                System.exit(0); //if choice not 1
        }
        sc.close();          
    }
    //-------------------------------------------------------------------------------------------//  
}
