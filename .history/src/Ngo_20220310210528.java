import java.util.*;

public class Ngo {
    private String aids;
    private int quantity;

    public Ngo() {};
    public Ngo(String name, int q) {
        this.aids = name;
        this.quantity = q;
    }

    public String getAids(){
        return ;
    }
    public int getQty(){
        return q;
    }

    public void welcomeNgo(String name, String password){

        Scanner sc = new Scanner(System.in);

        System.out.println
        ("\n|------------------------------------------------------------|"
        +"\n|           Welcome NGO "+name+ "                            |"
        +"\n|           Please Enter the aids required                   |"
        +"\n|------------------------------------------------------------|");

        System.out.println("Enter name of the aid");
        String a=sc.nextLine();
        System.out.println("Enter the number of quantity");
        int qty=sc.nextInt();

        aids=a;
        quantity=qty;

        sc.close();
    }

}
