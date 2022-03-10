import java.util.*;

public class ngoMenu {
    public static void welcomeNgo(String name){

        Scanner sc = new Scanner(System.in);

        System.out.println
        ("\n|------------------------------------------------------------|"
        +"\n           Welcome NGO "+name+ "                             "
        +"\n|      Enter 1: To Enter the aids required                    "
        +"\n      Enter 2 "
        +"\n|------------------------------------------------------------|");

        System.out.println("Enter name of the aid");
        String amount=sc.nextLine();
        System.out.println("Enter the number of quantity");
        int qty=sc.nextInt();

        ngo set = new ngo(amount, qty);

        set.saveNgoDemands();
        sc.close();

    }

}
