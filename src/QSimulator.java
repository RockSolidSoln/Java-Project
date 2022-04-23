import java.util.*;
import java.io.*;
import java.nio.file.*;
public class QSimulator {
    public static void startQSimulator() throws Exception {
        
        List<String> lines = Files.readAllLines(Paths.get("src/Documentation/Donor&NgoMatched.csv"));
        
        
       // List <ngoqarrlisted> match = new ArrayList<ngomatched>();
       ArrayList<NgoClass> qarrlist = new ArrayList<NgoClass>(); 
       for(int i = 0; i < lines.size();i++) {
            String[] things = lines.get(i).split(",");
            NgoClass data1 = new NgoClass(things[0], things[1], things[2], things[3], things[4], Integer.parseInt(things[5]), things[6]);
            qarrlist.add(data1);
            if(qarrlist.get(i).ngoMan != 0)
                System.out.println (qarrlist.get(i).dName + " " + qarrlist.get(i).dPhone + " " + qarrlist.get(i).aidType 
                                + " " + qarrlist.get(i).aidQty + " " + qarrlist.get(i).ngoName + " " +
                                qarrlist.get(i).ngoMan + " " + qarrlist.get(i).status);  
            else
                System.out.println (qarrlist.get(i).dName + " " + qarrlist.get(i).dPhone + " " + qarrlist.get(i).aidType 
                                + " " + qarrlist.get(i).aidQty + " " + " - "+ " - " + qarrlist.get(i).status);
        }

        //------STORING the NGO NAMES-----------------------------------------
        ArrayList<String> allNgos = new ArrayList<String>(); 
        for(int i = 0; i < qarrlist.size(); i++){
            if(!qarrlist.get(i).ngoName.equals("0"))
                allNgos.add(qarrlist.get(i).ngoName); 
        }
        //---------------------------------------------------------------------
        Queue<String> queue = new LinkedList<String>();
        int choice;
        Scanner scan = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in); 
        
        boolean brktheloop = false; 
        do{
            System.out.println("Press 1 for enqueue, Press 2 for dequeue, Press 3 to exit");
            
            choice = scan.nextInt();
            String ngoname;
            boolean found = false;      //to check if data to print is there in the files
            switch(choice) {
                case (1):
                    
                    System.out.println("Insert the name of the Ngo: "); 
                    
                    ngoname = scan2.nextLine();
                    // Actualq.enquing(ngoname);
                    found = allNgos.contains(ngoname);
                    if(found)
                        queue.add(ngoname);
                    else
                        System.out.println("Invalid NGO NAME"); 
    
                    break;
                case (2):
                    if(queue.size() > 0){
                        String nowname = queue.remove();
                        System.out.println(nowname);
                        QAfterDeque.updatefiledq(qarrlist, nowname);
                    }
                    else 
                        System.out.println("The Queue is already empty. Enqueue any Ngo first.");  
                    break;

                case (3): 
                    brktheloop = true;
                    break; 
                default:
                    throw new IOException();
            }
            if(brktheloop) 
                break; 

        } while(choice != 3);
        scan.close();
        scan2.close(); 
        
        


    }
}
