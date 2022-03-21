import java.util.*;
import java.io.IOException;
import java.io.*;

public class dcMenu {
    public static void showDcMenu() throws IOException {
        System.out.println
        ("\n|---------------------------------------------------------------|"
        +"\n|               Welcome to Distribution Center                  |"
        +"\n|---------------------------------------------------------------|"
        +"\n|     Enter 1: To view all the aids available in DC             |"
        +"\n|     Enter 2: To view all the NGO's demand                     |"
        +"\n|     Enter 3: To match the aids available to NGO               |"
        +"\n|     Enter 4: To view all the aids donated by specific Donor   |"
        +"\n|     Enter 5: To view all the aids recieve by specific NGO     |"
        +"\n|     Enter 6: To show the history of all the aids distributed  |"
        +"\n|---------------------------------------------------------------|");
        
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice) {
            case 1: donorMenu.showStatus("null",1);
                    break;
            case 2: ngoMenu.showStatus("null",1);
                    break;
            case 3: 
                    break;
            case 4: 
                    break;
            case 5: 
                    break;
            case 6:     
                    break;
        }
        sc.close();
    }
    public static void show(int flag){
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter the name-");
        String str = sc.nextLine();
        if(flag==1){
                S
        }
        else if(flag==2){

        }
        sc.close();
    }
}
