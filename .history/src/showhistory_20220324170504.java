import java.util.*;
import java.io.*;

public class showHistory {
    public static void viewAidsHistory(String name,int flag){
        File file =  new File("src/Documentation/donor&NgoMatched.csv");
        try{
            Scanner input = new Scanner(file);  
            System.out.format("%10sDonor %15sPhoneNumber %15s %10s %10s %10s""\n"); //template for the table.
            do{
                String data = input.nextLine(); //reads data from csv file
                List<String> source = Arrays.asList(data.split(",")); //put data in a list and saves it
                String list = Arrays.toString(source.toArray()).replace("[", "  ").replace("]", "  ").replace(",", "    "); //return to string without brackets or commas
                
                if (list.contains(name) && flag==0){
                    String[] temp = list.split("\\s");
                    String name = temp[0];
                    System.out.println("%10s %15s %15s %10s %10s %10s",name,name,name,name,name,name);
                
                    //System.out.printf(list); //to print just the data of named entity
                }
                else if(flag==1){
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
