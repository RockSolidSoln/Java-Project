import java.util.*;
import java.io.*;

public class showHistory {
    public static void viewAidsHistory(String name,int flag){
        File file =  new File("src/Documentation/donor&NgoMatched.csv");
        try{
            Scanner input = new Scanner(file);  
            System.out.format("%-5s%15s%6s%10s%5s","Donor","PhoneNumber","Aid","Quantity","Ngo"+"\n"); //template for the table.
            do{
                String data = input.nextLine(); //reads data from csv file
                List<String> source = Arrays.asList(data.split(",")); //put data in a list and saves it
                String list = Arrays.toString(source.toArray()).replace("[", "  ").replace("]", "  ").replace(",", "    "); //return to string without brackets or commas
                
                if (list.contains(name) && flag==0){
                    System.out.printf(list); //to print just the data of named entity
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
    private static void getHash() throws IOException{
        HashMap<String, HashMap<String, String>> required = new HashMap<String,HashMap<String, Integer>>();
        HashMap<String, HashMap<String, Integer>> inner = new HashMap<String,Integer>();

        List<String>lines = Files.readAllLines(Paths.get("src/Documentation/DonatedItems.csv"));
        for (int i = 0; i< lines.size();i++) {
            String[] items = lines.get(i).split(",");
            String name = items[0];
            String aids = items[1];
            int quantity = Integer.parseInt(items[2]);
            inner.put(aids, quantity);
            require.put(name, inner);

        }
        for(int i = 0; i< lines.size();i++) {
            System.out.println(required.get(i));
        }

    }
}
