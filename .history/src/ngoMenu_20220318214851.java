import java.util.*;
import java.util.stream.Stream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.*;

public class ngoMenu {
    //--------------------------------------------------------Shows Ngo Menu---------------------------------------------------------------------------------------------------------//
    public static void welcomeNgo(String name) throws IOException {
        Scanner sc = new Scanner(System.in);
        
        System.out.println
        ("\n|------------------------------------------------------------|"
        +"\n           Welcome NGO "+name+ "                             "
        +"\n|------------------------------------------------------------|"
        +"\n|      Enter 1: To Enter the aids required                   |"
        +"\n|      Enter 2: To view if requested aids are satisfied      |" // i think option 2 belongs in DC
        +"\n|      Enter 3: To view history of aids received             |" // done this and ngo is ready for improvements 
        +"\n|------------------------------------------------------------|");

        
        int choice = sc.nextInt();
        switch (choice) {
            case (1):  enterRequiredAids(name);
                        break;
            case(2):   showStatus(name);
                        break;

            case (3):   viewAidsHistory(name);
                        break;
        }
        
        sc.close();

    }
    //-------------------------------------------------------------------------------------------//

    //----------------------------------------Allows the User to input required aids-------------------------------------------------------------------------------------------------//
    public static void enterRequiredAids(String name){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name of the aid");
        String amount=sc.nextLine();
        System.out.println("Enter the number of quantity");
        int qty=sc.nextInt();

        Ngo set = new Ngo(name,amount, qty, "unsatisfied");
        set.saveNgoDemands();
        sc.close();
        check();
    }
    //-------------------------------------------------------------------------------------------//

    //-------------------------------------------------------------------------------------------//
    public static void showStatus(String name){
        File file =  new File("src/Documentation/ngoDemands.csv");
        try{
            Scanner input = new Scanner(file); 
            do{
                String data = input.nextLine(); //reads data from csv file
                List<String> source = Arrays.asList(data.split(",")); //put data in a list and saves it
                String list = Arrays.toString(source.toArray()).replace("[", "  ").replace("]", "  ").replace(",", "    "); //return to string without brackets or commas
                
                if (list.contains(name)){
                    System.out.printf(list);
                }
                System.out.println();
                
            } while(input.hasNextLine());
           input.close();  
        } catch (Exception e){
            System.out.println("x");
        }
    }
    //-------------------------------------------------------------------------------------------//

    //--------------------------------------Allows the ngo to view all aids donated to them=----------------------------------------------------------------------------------------//
    public static void viewAidsHistory(String name){
        File file =  new File("src/Documentation/DonatedItems.csv");
        try{
            Scanner input = new Scanner(file);  
            System.out.format("%-5s%15s%6s%10s%5s","Name","PhoneNumber","Aid","Quantity","Ngo"+"\n"); //template for the table.
            do{
                String data = input.nextLine(); //reads data from csv file
                List<String> source = Arrays.asList(data.split(",")); //put data in a list and saves it
                String list = Arrays.toString(source.toArray()).replace("[", "  ").replace("]", "  ").replace(",", "    "); //return to string without brackets or commas
                
                if (list.contains(name)){
                    System.out.printf(list);
                }
                System.out.println();
                
            } while(input.hasNextLine());
           input.close();  
        }
           catch (Exception e){
                System.out.println("x");
            }
            
    }
    //-------------------------------------------------------------------------------------------//

    //-------------------------------------------------------------------------------------------//

        //-------------------------------------------------------------------------------------------//


}
//------------------------------------------------------------------------------------------------//

