import java.util.*;
import java.io.*;
import java.nio.file.*;

/**This class contains the method to start the Priority Queue Simulator*/
public class PqSimulator{
    /**This method works for the Priority Queue mode of simulation */
    public static void startPqSimulator() throws Exception  {
        
        System.out.println("===========PRIORITY Queue Simulator============="); 

        //Reading from Donor&NgoMatched file and storing in the list named 'lines'
        List<String> lines = Files.readAllLines(Paths.get("src/Documentation/Donor&NgoMatched.csv"));
            
        ArrayList<MatchedClass> ngoarr = new ArrayList<MatchedClass>(); // ArrayList stores all the MatchedClass objects
        Map<String, Integer> map = new HashMap<String, Integer>();      // Map stores Name and the manpower of the NGOs

        ShowHistory.viewAidsHistory("null",1);  //prints the list of data in Donor&NgoMatched.csv

        for(int i = 0; i < lines.size();i++) { 
            String[] things = lines.get(i).split(",");    //dissecting each content from the list 'lines' and storing in 'things.' 
            // creating new object of the MatchedClass by calling the parameterized constructor
            MatchedClass data1 = new MatchedClass(things[0], things[1], things[2], things[3], things[4], Integer.parseInt(things[5]), things[6]);
            ngoarr.add(data1);   //adding the object of MatchedClass in ngoarr. 
            map.put(ngoarr.get(i).ngoName, ngoarr.get(i).ngoMan); //adding content in map, which stores the each Ngo's name and the manpower.
        }
       
        //Intializing the Array to store NGO names
        ArrayList<String> allNgos = new ArrayList<String>();  //this arraylist stores all the names of the ngos. 
        
        //Storing NGO name
        for (MatchedClass MatchedClass : ngoarr) {
            if (!MatchedClass.ngoName.equals("0")) // avoiding the Ngonames which is named as "0",  which worked as a flag for the case where NGO is not yet found for any donated items.
                allNgos.add(MatchedClass.ngoName);
        }
        
        //Initializing the Priority queue with NGO class (NgoClass represents the name and the manpower of a NGO)
        PriorityQueue<NgoClass> pq = new PriorityQueue<NgoClass>(5, new NgoComparator());
        int choice;       
        //Initializing the Scanners
        Scanner scan = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);

        boolean brktheloop = false;  //flag for breaking the loop
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
                case (1): //for enqueuing 
                    System.out.println("Insert the name of the Ngo: ");
                    ngoname = scan2.nextLine();   // storing the NGO name that the user enters for enqueue 
                    found = allNgos.contains(ngoname); //to validate the NGO name that being put by the user. 
                    if(found){      //if NGO name entered is valid
                        
                        NgoClass ngo1 = new NgoClass(ngoname, map.get(ngoname)); //creating object for the Ngo Class 
                        pq.add(ngo1); // nicely added in the priority queue
                    }
                    else        //if ngo name is not valid
                        System.out.println("Invalid NGO NAME.");  
                    break;
                case (2): // for dequeuing
                    if(pq.size() > 0){   //deque will be done only if there is any element in the priority queue. 
                        String nowname = pq.poll().ngoName;  //storing the name of the NGO that's in the front of the priority queue and removing that from q.
                        System.out.println(nowname);         // printing the front of the priority queue
                        String path = "src/Documentation/AfterPq.csv";  
                        QAfterDeque.updatefiledq(path, ngoarr, nowname, 3); //calling this method to update the file and arraylist 
                                                                                 // after dequeuing, updating by changing the status to 'Collected' for that NGO. 
                    } 
                    else{           //Nothing is in the priority queue. 
                        System.out.println("The queue is already empty. Make sure to enquue first.");
                    }
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
        //Closing the scanners 
        scan.close();   
        scan2.close();
    }
}
