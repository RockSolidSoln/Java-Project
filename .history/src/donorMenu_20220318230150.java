import java.util.*;
import java.io.*;

// import java.util.logging.Logger;
// import java.lang.reflect.Array;
// import javax.swing.JTable;
// import javax.swing.table.DefaultTableModel;
// import javax.swing.*;
// import java.awt.event.*;


public class donorMenu {

    //-------------------------------------Shows Donor Menu and re-routes to enter aids or view all aids donated.-----------------------------------------------------------------------//
    public static void showDonormenu(String name) throws IOException{
    Scanner sc = new Scanner(System.in);
    String menu=
    ("\n|------------------------------------------------------------|"
    +"\n                Welcome Donor "+name+"                        "
    +"\n|------------------------------------------------------------|"
    +"\n|      Enter 1: To Enter the aids to be donated              |"
    +"\n|      Enter 2: To view the aids provided not used           |"
    +"\n|      Enter 3: To View list of all aids donated             |"
    +"\n|------------------------------------------------------------|");
    
    System.out.println(menu);
    int choice= sc.nextInt();
    switch (choice){
        case(1):     
            enterAids(name); //re-routes to the enter aids method.
            break;
        case(2):   showStatus(name);
                    break;    
        case(3):
            viewAidsDonated(); //re-routes to view all aids donated.
            break;
    }
   sc.close();
   }
    //-------------------------------------------------------------------------------------------//
   
   //---------------------------------------------Allows User to enter aids to donate along with donor info-------------------------------------------------------------------------//
    public static void enterAids(String name) throws IOException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter the item name: ");
        String itemName = sc.nextLine();
        System.out.println("Please Enter How many items you want to donate");
        String quantity = sc.nextLine();

        Donor set = new Donor(name,itemName,quantity,"unsatisfied");
        set.saveDonorInfo();
        sc.close();
        directBackDonor(name);
    }
    //-------------------------------------------------------------------------------------------//
    
    //-------------------------------------------------------------------------------------------//
    public static void showStatus(String name){
        File file =  new File("src/Documentation/DonatedItems.csv");
        try{
            Scanner input = new Scanner(file); 
            do{
                String data = input.nextLine(); //reads data from csv file
                List<String> source = Arrays.asList(data.split(",")); //put data in a list and saves it
                String list = Arrays.toString(source.toArray()).replace("[", "  ").replace("]", "  ").replace(",", "    "); //return to string without brackets or commas
                
                if (list.contains(name) && list.contains("unsatisfied")){
                    System.out.printf(list);
                }
                System.out.println();
                
            } while(input.hasNextLine());
           input.close();  
        } catch (Exception e){
            System.out.println("x");
        }
    }
    //-----------------------------------------------------------------------------------------------//

    //--------------------------------------------Allows the user to view all aids donated-------------------------------------------------------------------------------------------//
    private static void  viewAidsDonated() throws IOException {
        File file = new File("src/Documentation/donor&NgoMatched.csv");
        String line = "";
        
        System.out.format("%8s%20s%9s%16s%13s","Name","PhoneNumber","Aid","Quantity","Ngo"+"\n");
        try{
           Scanner input = new Scanner(file);
           BufferedReader br = new BufferedReader(new FileReader(file));
           while((line = br.readLine()) !=null){
               String[] row = line.split(",");

               for (String index : row) {
                   System.out.printf("%-15s","   "+index);
               }
               System.out.println();
               input.close();
               br.close();
           } 
        } catch (Exception e) {
            e.printStackTrace(); 
        }        
    }
    //-------------------------------------------------------------------------------------------//
    
    //-------------------------------------------------------------------------------------------//
    // public static void directBackDonor(String name) throws IOException{
    //     System.out.println
    //     ("\n|------------------------------------------------------------|"
    //     +"\n                    Donor "+name+ "                             "
    //     +"\n|------------------------------------------------------------|"
    //     +"\n|   Enter 1: To go back to donor Menu                        |"
    //     +"\n|   Enter 2: To logout                                       |"
    //     +"\n|------------------------------------------------------------|");

    //     int choice = 1;
    //     if (choice == 1) {
    //         showDonormenu(name);
    //     }
    //     else if (choice == 2) {
    //         System.out.println
    //             ("Thanks for putting your requests,"
    //             +"\n It will be satisfied with in no Time.");
    //     }
    // }
    //-------------------------------------------------------------------------------------------//
    
}

