import java.util.*;
import java.io.IOException;

public class donorMenu {
    
   public static void showDonormenu(String name){
    Scanner sc = new Scanner(System.in);
    String menu=
    ("\n|------------------------------------------------------------|"
    +"\n|                 Welcome Donor " +name+ "                   |"
    +"\n|------------------------------------------------------------|"
    +"\n|      Enter 1: To Enter the aids to be donated              |"
    +"\n|      Enter 2: To View list of all aids donated:            |"
    +"\n|------------------------------------------------------------|");
    
    System.out.println(menu);
    int choice= sc.nextInt();
    switch (choice) {
        case(1):    System.out.println("Please Enter your name: ");
                    String Name = sc.nextLine();
                    System.out.println("Please Enter phone number: ");
                    String phoneNumber = sc.nextLine();
                    System.out.println("Please Enter the item name: ");
                    String itemName = sc.nextLine();
                    System.out.println("Please Enter How many items you want to donate");
                    int quantity = sc.nextInt();
                    
                    Donor set = new Donor(name,phoneNumber,itemName,quantity);
                    set.saveDonorInfo();
            
            
    
        case(2):
            break;
   }
   }
   

}
