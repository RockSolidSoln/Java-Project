import java.util.*;

public class ngoMenu {
    public static void welcomeNgo(String name, String password){

        Scanner sc = new Scanner(System.in);

        System.out.println
        ("\n|------------------------------------------------------------|"
        +"\n|           Welcome NGO "+name+ "                            |"
        +"\n|           Please Enter the aids required                   |"
        +"\n|------------------------------------------------------------|");

        System.out.println("Enter name of the aid");
        String amount=sc.nextLine();
        System.out.println("Enter the number of quantity");
        int qty=sc.nextInt();

        
        sc.close();
    }

}
