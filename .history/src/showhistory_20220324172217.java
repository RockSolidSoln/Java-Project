import java.util.*;
import java.io.*;

public class showHistory {
    public static void viewAidsHistory(String name,int flag){
        File file =  new File("src/Documentation/donor&NgoMatched.csv");
        try{
            Scanner input = new Scanner(file);  
            System.out.format("|%10s |%10s |%10s |%10s |%10s |%10s |","Donor","PhoneNumber","Aid","Quantity","Ngo","Manpower"); //template for the table.
            System.out.println("|------------------------------------------------------------------------|");

            do{
                String data = input.nextLine(); //reads data from csv file
                List<String> source = Arrays.asList(data.split(",")); //put data in a list and saves it
                String list = Arrays.toString(source.toArray()).replace(",", "%"); //return to string without brackets or commas
                
                if (list.contains(name) && flag==0){
                    String[] temp = list.split("\\s");
                    System.out.format("\n%10s %10s %10s %10s %10s %10s",temp[0],temp[1],temp[2],temp[3],temp[4],temp[5]);
                
                    //System.out.printf(list); //to print just the data of named entity
                }
                else if(flag==1){
                    String[] temp = list.split("\\s");
                    System.out.println(temp[0]);
                    // System.out.format("\n%10s %10s %10s %10s %10s %10s",temp[0],temp[1],temp[2],temp[3],temp[4],temp[5]);
                    System.out.printf("%10s",list);
                }
                
                System.out.println();
                
            } while(input.hasNextLine());
           input.close();
           System.out.println("|------------------------------------------------------------------------|");
        }
           catch (Exception e){
                System.out.println("\nUnable to Print the table");
                System.out.println("|------------------------------------------------------------------------|");

            }
            
    }

}
