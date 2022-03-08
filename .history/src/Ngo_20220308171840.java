import java.io.IOException;
import java.util.*;

public class Ngo {
    private String name;
    private int q;

    public Ngo() {};
    public Ngo(String name, int q) {
        this.name = name;
        this.q = q;
    }

    // public String getAids(){
    //     return name;
    // }
    // public int getQty(){
    //     return;
    // }

    public static void welcomeNgo(String name, String password){

        Scanner sc = new Scanner(System.in);

        System.out.println
        ("\n|------------------------------------------------------------|"
        +"\n|           Welcome NGO "+name+ "                            |"
        +"\n|           Please Enter the aids required                   |"
        +"\n|------------------------------------------------------------|");

        System.out.println("Enter name of the aid");
        String aids=sc.nextLine();
        System.out.println("Enter the number of quantity");
        int qty=sc.nextInt();

        Ngo n= new Ngo(name,password);

        sc.close();
    }

}
