import java.util.*;
import java.io.*;

//------------------This class contains the methods for the Donor menu----------------------------------
public class DonorMenu {
    //-------------------------------------Shows Donor Menu and re-routes to enter aids or view all aids donated.-----------------------------------------------------------------------//
    public static void showDonormenu(String name) throws IOException{ //takes the name of the Donor
    Scanner sc = new Scanner(System.in);
    String menu=
    ("\n|------------------------------------------------------------|"
    +"\n                Welcome Donor "+name+"                        "
    +"\n|------------------------------------------------------------|"
    +"\n|     Enter 1: To Enter the aids to be donated               |"
    +"\n|     Enter 2: To view all the aids donated to DC            |"
    +"\n|     Enter 3: To view all the aids donated delivered to NGO |"
    +"\n|------------------------------------------------------------|");
    
    System.out.println(menu);
    int choice= sc.nextInt();           //takes tthe Donor choice according to the menu
    switch (choice){
        case(1):  enterAids(name);      //re-routes to the enter aids method.
                    break;
        case(2):  showStatus(name,0);   //show the aids still in DC
                    break;    
        case(3):  ShowHistory.viewAidsHistory(name,0); //re-routes to view all aids donated.
                    break;
    }
   sc.close();
   }
    //-------------------------------------------------------------------------------------------//
   
   //-----------------------Allows User to enter aids to donate along with donor info-------------//
    public static void enterAids(String name) throws IOException{  //takes the a
        Scanner sc = new Scanner(System.in);
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Please Enter the item name: ");
        String itemName = sc.nextLine();
        System.out.println("Please Enter How many items you want to donate");
        int quantity = sc.nextInt();
        System.out.println("-------------------------------------------------------------------");
        if(quantity>0){
            Donor set = new Donor(name,itemName,quantity);
            set.saveDonorInfo();
        }
        else{
            System.out.println("Quantity cannot be 0 or less"+"\nPlease try again");
            enterAids(name);
        }
        
        sc.close();
    }
    //-------------------------------------------------------------------------------------------//
    
    //-------------------------------------------------------------------------------------------//
    public static void showStatus(String name,int flag){
        File file =  new File("src/Documentation/DonatedItems.csv");
        try{
            Scanner input = new Scanner(file); 
            System.out.println("\n|------------------------------------|");
            System.out.format("|%10s  |%11s |%10s|","Name ","Aid","Quantity"); //template for the table.
            System.out.println("\n|------------------------------------|");
            do{
                String data = input.nextLine(); //reads data from csv file
                List<String> source = Arrays.asList(data.split(",")); //put data in a list and saves it
                String list = Arrays.toString(source.toArray()).replace("[", "  ").replace("]", "  ").replace(",", "    "); //return to string without brackets or commas
                
                if (list.contains(name) && flag==0){
                    String[] temp = list.split("\\s+");
                    System.out.printf("| %10s |%11s |%10s|",temp[1],temp[2],temp[3]);
                    System.out.print("\n|------------------------------------|");
                }
                else if(flag==1){
                    String[] temp = list.split("\\s+");
                    System.out.printf("| %10s |%11s |%10s|",temp[1],temp[2],temp[3]);
                    System.out.print("\n|------------------------------------|");
                }
                System.out.println();
                
            } while(input.hasNextLine());
           input.close();  
        } catch (Exception e){
            System.out.println("-------------------------------------------------------------------");
            System.out.println("Unable to print DonatedItems.csv");
            System.out.println("-------------------------------------------------------------------");
        }
    }
    //-----------------------------------------------------------------------------------------------//            
}
