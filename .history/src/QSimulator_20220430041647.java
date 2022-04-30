import java.util.*;
import java.io.*;
import java.nio.file.*;

/**This class contains the method to start the FIFO Queue Simulator*/
public class QSimulator {

    /**This method works for the FIFO Queue simulation */
    public static void startQSimulator() throws Exception {
        
        System.out.println("===========FIFO Queue Simulator=============");

        //Reading from Donor&NgoMatched file and storing in the list named 'lines'
        List<String> lines = Files.readAllLines(Paths.get("src/Documentation/Donor&NgoMatched.csv"));
        
        // ArrayList stores all the MatchedClass objects
        ArrayList<MatchedClass> qarrlist = new ArrayList<MatchedClass>();  //
        
        ShowHistory.viewAidsHistory("null",1);   //prints the list of data in Donor&NgoMatched.csv

        for(int i = 0; i < lines.size();i++) {
            String[] things = lines.get(i).split(",");  //dissecting each content from the list 'lines' and storing in 'things.' 
            // creating new object of the MatchedClass by calling the parameterized constructor
            MatchedClass data1 = new MatchedClass(things[0], things[1], things[2], things[3], things[4], Integer.parseInt(things[5]), things[6]);
            //adding the object in the arraylist
            qarrlist.add(data1);
        }

        //Intializing the Arraylist to store all the NGO names
        ArrayList<String> allNgos = new ArrayList<String>();  

        //Storing NGO name
        for(int i = 0; i < qarrlist.size(); i++){
            if(!qarrlist.get(i).ngoName.equals("0"))     // avoiding the Ngonames which is named as "0",  which worked as a flag for the case where NGO is not yet found for any donated items.
                allNgos.add(qarrlist.get(i).ngoName);   
        } 
        
        //Initializing the FIFO queue with Strings 
        Queue<String> queue = new LinkedList<String>();
        int choice;
        //Intializing scanner
        Scanner scan = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in); 
        
        boolean brktheloop = false; //flag for breaking the loop
        do{
             String menu =
                """          
                        |-----------------------------------|
                        |    Press 1 for enqueue            |
                        |    Press 2 for dequeue            |
                        |    Press 3 to exit                |
                        |-----------------------------------|""";
            
            //printing the menu for user to select from the available option                    
            System.out.println(menu);
            choice = scan.nextInt();    //taking input form user for their choice of enqueue/ dequeue/exit
            String ngoname;             
            boolean found = false;  
            switch(choice) {
                case (1):    //for enqueuing
                    System.out.println("Insert the name of the Ngo: "); 
                    
                    ngoname = scan2.nextLine();  // storing the name of the Ngo that the user wants to enqueue
                    found = allNgos.contains(ngoname);  //to validate the name of the NGO from the valid NGO names list. 
                    if(found)
                        queue.add(ngoname);  // adding the name of the NGO to the queue if it's falid.
                    else
                        System.out.println("Invalid NGO NAME");  
    
                    break;
                case (2):  // for dequeuing
                    if(queue.size() > 0){
                        String nowname = queue.remove();   // removing the NGO in the front of the queue, and storing the name in nowname. 
                        System.out.println(nowname);       // printing the ngo name out that has been dequed 
                        String path = "src/Documentation/AfterQ.csv";
                        QAfterDeque.updatefiledq(path, qarrlist, nowname, 2); //calling this method to update the file and arraylist 
                                                                                    // after dequeuing, updating by changing the status to 'Collected' for that NGO. 
                    }
                    else 
                        System.out.println("The Queue is already empty. Enqueue any Ngo first.");  
                    break;

                case (3): // if the user wants to exit 
                    brktheloop = true;
                    break; 
                default:
                     System.out.println("Wrong option selected");
                    throw new IOException();    //throws IOException if the choice was not from the specified menu
            }
            if(brktheloop) 
                break; 
        } while(choice != 3);
        //Closing the scanner
        scan.close();
        scan2.close(); 
    }
}
