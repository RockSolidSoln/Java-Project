import java.util.*;
import java.util.logging.Logger;
import java.io.*;
import java.lang.reflect.Array;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.event.*;


public class donorMenu {
    public static void main(String[] args) throws IOException{
        viewAidsDonated();
    }
    
   public static void showDonormenu(String name) throws IOException{
    Scanner sc = new Scanner(System.in);
    String menu=
    ("\n|------------------------------------------------------------|"
    +"\n|                 Welcome Donor " +name+ "                   |"
    +"\n|------------------------------------------------------------|"
    +"\n|      Enter 1: To Enter the aids to be donated              |"
    +"\n|      Enter 2: To View list of all aids donated:            |"
    +"\n|------------------------------------------------------------|");
    
    System.out.println(menu);
    int choice= sc.nextInt();
    switch (choice) {
        case(1):     
            enterAids(name); //re-routes to the enter aids method 
            
            
    
        case(2):
            viewAidsDonated();
            break;
   }
   }

   public static void enterAids(String name){
    Scanner sc = new Scanner(System.in);
    System.out.println("Please Enter phone number: ");
    String phoneNumber = sc.nextLine();
    System.out.println("Please Enter the item name: ");
    String itemName = sc.nextLine();
    System.out.println("Please Enter How many items you want to donate");
    String quantity = sc.nextLine();
    
    Donor set = new Donor(name,phoneNumber,itemName,quantity);
    set.saveDonorInfo();
   }
    private static void viewAidsDonated() throws IOException {

     
        File file = new File("src/Documentation/Donorinfo.csv");
        String line = "";
        
        System.out.format("%8s%20s%9s%16s","Name","PhoneNumber","aid","quantity"+"\n");
        try{
           Scanner input = new Scanner(file);
           BufferedReader br = new BufferedReader(new FileReader(file));
           while((line = br.readLine()) !=null){
               String[] row = line.split(",");

               for (String index : row) {
                   System.out.printf("%-15s","   "+index);
               }
               System.out.println();
               
           }
                
           } catch (Exception e) {
                e.printStackTrace();
           
        }
            
        }
    

        
         

    } 
    
   
   


