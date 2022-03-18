import java.util.*;
import java.util.logging.Logger;
import java.io.*;
import java.lang.reflect.Array;

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
    +"\n|      Enter 2: To View list of all aids donated:            |"
    +"\n|------------------------------------------------------------|");
    
    System.out.println(menu);
    int choice= sc.nextInt();
    switch (choice){
        case(1):     
            enterAids(name); //re-routes to the enter aids method.
            break;    
        case(2):
            viewAidsDonated(); //re-routes to view all aids donated.
            break;
    }
   sc.close();
   }
   //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
   //---------------------------------------------Allows User to enter aids to donate along with donor info-------------------------------------------------------------------------//
   public static void enterAids(String name){
    Scanner sc = new Scanner(System.in);
    System.out.println("Please Enter phone number: ");
    String phoneNumber = sc.nextLine();
    System.out.println("Please Enter the item name: ");
    String itemName = sc.nextLine();
    System.out.println("Please Enter How many items you want to donate");
    String quantity = sc.nextLine();
    System.out.println("Please Enter The None Goverment Orginization you would like to donate to:");
    String ngo = sc.nextLine();
    
    Donor set = new Donor(name,phoneNumber,itemName,quantity,ngo);
    set.saveDonorInfo();
    sc.close();
   }
    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
    //--------------------------------------------Allows the user to view all aids donated-------------------------------------------------------------------------------------------//
    private static void  viewAidsDonated() throws IOException {
 
        File file = new File("src/Documentation/DonatedItems.csv");
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
                     
     
    //-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------//
   //-----------------------------------------------This Function Saves HTML Report--------------------------------------------------------------------------------------------------//
   public static void saveHTMLReport(){
       File file = new File("src/Documentation/report.html");
   }
}

