import java.util.*;
import java.io.*;

public class ShowHistory {
    public static void viewAidsHistory(String name,int flag){
        File file =  new File("src/Documentation/donor&NgoMatched.csv");
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
                    String[] temp = list.split("\\s+");
                    System.out.printf("| %10s |%11s |%10s |%10s |%10s |%10s|",temp[0],temp[1],temp[2],temp[3],temp[4],temp[5]);
                    System.out.print("\n|------------------------------------------------------------------------|\n");
                }
                else if(flag==1){
                    String[] temp = list.split("\\s+");
                    System.out.printf("| %10s |%11s |%10s |%10s |%10s |%10s|",temp[0],temp[1],temp[2],temp[3],temp[4],temp[5]);
                    System.out.print("\n|------------------------------------------------------------------------|\n");

                }
                
                System.out.println();
                
            } while(input.hasNextLine());
           input.close();
        }
           catch (Exception e){
                System.out.println("\nUnable to Print the table");
                System.out.println("|------------------------------------------------------------------------|");

            }
            
    }

}
