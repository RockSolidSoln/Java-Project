import java.util.*;
import java.io.*;

//------------------This class contains the method to show history----------------------------------
public class ShowHistory {

    //------------------This method is to print the matched aids history----------------------------------
    public static void viewAidsHistory(String name,int flag){   //takes input of history to be shown according to name or not
        File file =  new File("src/Documentation/Donor&NgoMatched.csv");    //open the file according to the path
        int wrongName = 0;          // to keep track if Donor or NGO is in the history file
        boolean found = true;
        try{
            Scanner input = new Scanner(file);  
            System.out.println("\n|------------------------------------------------------------------------|");
            System.out.format("|%10s  |%11s |%10s |%10s |%10s |%10s|","Donor ","PhoneNumber","Aid","Quantity","Ngo","Manpower"); //template for the table.
            System.out.println("\n|------------------------------------------------------------------------|");

            do{
                String data = input.nextLine(); //reads data from csv file
                List<String> source = Arrays.asList(data.split(",")); //put data in a list and saves it
                String list = Arrays.toString(source.toArray()).replace("[", "").replace("]", "").replace(",", " "); //return to string without brackets or commas
                
                if (list.contains(name) && flag==0){
                    String[] temp = list.split("\\s+");     //split according to the spaces
                    System.out.printf("| %10s |%11s |%10s |%10s |%10s |%10s|",temp[0],temp[1],temp[2],temp[3],temp[4],temp[5]);//prints the data
                    System.out.print("\n|------------------------------------------------------------------------|\n");
                    wrongName=0;
                    found
                }
                else if(flag==1){
                    String[] temp = list.split("\\s+");     //split according to the spaces
                    System.out.printf("| %10s |%11s |%10s |%10s |%10s |%10s|",temp[0],temp[1],temp[2],temp[3],temp[4],temp[5]);//prints the data
                    System.out.print("\n|------------------------------------------------------------------------|\n");
                    wrongName=0;
                }
                else{
                   wrongName=1;    //if Donor/NGO not found in the file
                }
            } while(input.hasNextLine());   //while the end of the file
            if(wrongName==1 && found=false){
                System.out.printf("| %10s |%11s |%10s |%10s |%10s |%10s|","X","X","X","X","X","X");//prints the data
                System.out.println("\n|------------------------------------------------------------------------|");
                System.out.println("\n\nPlease enter the correct name");
            }
           input.close();
        }catch (Exception e){               //if unable to print 
                System.out.printf("| %10s |%11s |%10s |%10s |%10s |%10s|","X","X","X","X","X","X");//prints the data
                System.out.println("\nUnable to Print the table");
                System.out.println("|------------------------------------------------------------------------|");
        }  
    }
    //-------------------------------------------------------------------------------------------//
}
