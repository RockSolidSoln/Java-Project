import java.io.IOException;
import java.util.*;

public class Ngo {
    private String name;
    private int q;

    public Ngo() {};
    public Ngo(String NGOname, String NGOpassword) {
        this.NGOname = NGOname;
        this.NGOpassword = NGOpassword;
    }

    // public String getNgoName(){
    //     return NGOname;
    // }
    // public String getNgoPassword(){
    //     return NGOpassword;
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
