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
        +"\n|     Enter 3: To view all the aids donated by specific Donor   |"
        +"\n|     Enter 4: To view all the aids recieve by specific NGO     |"
        +"\n|     Enter 5: To show the history of all the aids distributed  |"
        +"\n|     Enter 6:                                                  |"
        +"\n|---------------------------------------------------------------|");
        
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt("Enter here");




        sc.close();
    } 
}
