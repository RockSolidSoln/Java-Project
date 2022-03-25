import java.util.*;
import java.io.IOException;
import java.io.*;

//------------------This class contains the methods for the NGO menu----------------------------------
public class NgoMenu {
    
    //----------------Shows Ngo Menu and re routes the NG-------------------------------------//
    public static void welcomeNgo(String name) throws IOException {
        Scanner sc = new Scanner(System.in);
        
        System.out.println
        ("\n|------------------------------------------------------------|"
        +"\n           Welcome NGO "+name+ "                             "
        +"\n|------------------------------------------------------------|"
        +"\n|      Enter 1: To Enter the aids required                   |"
        +"\n|      Enter 2: To view unsatisfied aids                     |" // i think option 2 belongs in DC
        +"\n|      Enter 3: To view history of  satisfied aids           |" // i think option                |" // done this and ngo is ready for improvements 
        +"\n|------------------------------------------------------------|");

        int choice = sc.nextInt();           //takes the NGO choice according to the menu
        switch (choice) {
            case (1):  enterRequiredAids(name);     //re-routes to the enter required aids
                        break;
            case(2):   showStatus(name,0);          //show requested aids 
                        break;  
            case (3):   ShowHistory.viewAidsHistory(name,0);  //re-routes to show the history
                        break;
        }
        sc.close();

    }
    //-------------------------------------------------------------------------------------------//

    //----------------Allows the User to input required aids-------------------------------------//
    public static void enterRequiredAids(String name) throws IOException{   //takes the name of the Donor
        Scanner sc = new Scanner(System.in);
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Enter name of the aid");
        String amount=sc.nextLine();                // takes the aid to be requested
        System.out.println("Enter the number of quantity");
        int qty=sc.nextInt();                       // takes the aids quantity
        System.out.println("-------------------------------------------------------------------");

        if(qty>0){                                  // the quantity cannot be 0 or negative
            Ngo set = new Ngo(name,amount, qty, "unsatisfied"); //creates a new object to store the NGO
            set.saveNgoDemands();                   // calls the methods to save NGO aids
            System.out.println("\nThe aids request was successfully sent to DC");
        }
        else{                                       //else ask the NGO to try again
            System.out.println("Quantity cannot be 0 or less"+"\nPlease try again");
            enterRequiredAids(name);                // re-routes the NGO to try again
        }
        
        sc.close();
    }
    //-------------------------------------------------------------------------------------------//

    //-------------------------------------------------------------------------------------------//
    public static void showStatus(String name, int flag){       // takes the name of the NGO and flag
        File file =  new File("src/Documentation/ngoDemands.csv");
        try{
            Scanner input = new Scanner(file); 
            System.out.println("\n|------------------------------------|");
            System.out.format("|%10s  |%11s |%10s|","Name ","Aid","Quantity"); //template for the table.
            System.out.println("\n|------------------------------------|");
            do{
                String data = input.nextLine();                       //reads data from csv file
                List<String> source = Arrays.asList(data.split(",")); //put data in a list and saves it
                String list = Arrays.toString(source.toArray()).replace("[", "  ").replace("]", "  ").replace(",", "    "); //return to string without brackets or commas
                
                if (list.contains(name) && list.contains("unsatsified") && flag==0){    // if the list containes the name of the NGO
                    String[] temp = list.split("\\s+");     //slpit the comma
                    System.out.printf("| %10s |%11s |%10s|",temp[1],temp[2],temp[3]);   //print the data
                    System.out.print("\n|------------------------------------|");
                }       
                else if(flag==1){                       
                    String[] temp = list.split("\\s+");
                    System.out.printf("| %10s |%11s |%10s|",temp[1],temp[2],temp[3]);
                    System.out.print("\n|------------------------------------|");
                }
                
            } while(input.hasNextLine());
           input.close();  
        } catch (Exception e){
            System.out.println("-------------------------------------------------------------------");
            System.out.println("Unable to print ngoDemands.csv");
            System.out.println("-------------------------------------------------------------------");

        }
    }
    //-------------------------------------------------------------------------------------------// 
}
//------------------------------------------------------------------------------------------------//

