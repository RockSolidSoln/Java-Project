import java.util.*;
import java.io.IOException;

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
        System.out.println("|-----------------------------------------------------------------------|");

        switch (choice) {
            case 1: donorMenu.showStatus("null",1);
                    break;
            case 2: ngoMenu.showStatus("null",1);
                    break;
            case 3: matching.filter();
                    break;
            case 4: System.out.println("Please Enter the name of the Donor-");
                    show(0);
                    break;
            case 5: System.out.println("Please Enter the name of the NGO-");
                    show(0);
                    break;
            case 6: show(1);    
                    break;
        }
        sc.close();
    }
    public static void show(int flag){
        if(flag==0){
                Scanner sc = new Scanner(System.in);
                String str;
                str = sc.nextLine();
                showHistory.viewAidsHistory(str,0);
                sc.close();
        }
        else if(flag==1){
                showHistory.viewAidsHistory("null",1);
        }
        
    }
}
