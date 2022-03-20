import java.util.*;
import java.io.IOException;
import java.io.*;

public class showHistory {
    public static void viewAidsHistory(String name){
        File file =  new File("src/Documentation/donor&NgoMatched.csv");
        try{
            Scanner input = new Scanner(file);  
            System.out.format("%-5s%15s%6s%10s%5s","DOn","PhoneNumber","Aid","Quantity","Ngo"+"\n"); //template for the table.
            do{
                String data = input.nextLine(); //reads data from csv file
                List<String> source = Arrays.asList(data.split(",")); //put data in a list and saves it
                String list = Arrays.toString(source.toArray()).replace("[", "  ").replace("]", "  ").replace(",", "    "); //return to string without brackets or commas
                
                if (list.contains(name) ){
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
}
