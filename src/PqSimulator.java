import java.util.*;
import java.io.*;
import java.nio.file.*;

public class PqSimulator{
    public static void startPqSimulator() throws Exception  {
        System.out.println("This is the PriorityQ simulator.");

        List<String> lines = Files.readAllLines(Paths.get("src/Documentation/Donor&NgoMatched.csv"));
            
        ArrayList<NgoClass> ngoarr = new ArrayList<NgoClass>();
        Map<String, Integer> map = new HashMap<String, Integer>();

        ShowHistory.viewAidsHistory("null",1);

        for(int i = 0; i < lines.size();i++) {
            String[] things = lines.get(i).split(",");
            NgoClass data1 = new NgoClass(things[0], things[1], things[2], things[3], things[4], Integer.parseInt(things[5]), things[6]);
            ngoarr.add(data1);
            map.put(ngoarr.get(i).ngoName, ngoarr.get(i).ngoMan);
        }
       // System.out.println(map.get("N1"));  // the name of the ngo and the manpower is stored in the map.

        //------STORING the NGO NAMES-----------------------------------------
        ArrayList<String> allNgos = new ArrayList<String>();
        for (NgoClass ngoClass : ngoarr) {
            if (!ngoClass.ngoName.equals("0"))
                allNgos.add(ngoClass.ngoName);
        }
        //---------------------------------------------------------------------

        PriorityQueue<ClassPq> pq = new PriorityQueue<ClassPq>(5, new NgoComparator());
        int choice;
        Scanner scan = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);

        boolean brktheloop = false;
        do{
            // System.out.println ("------------PRINTING THE PRIORITY QUEUE------------");
            // System.out.println(pq);

            // System.out.println ("------------PRINTING THE PRIORITY QUEUE------------");
            
            System.out.println("Press 1 for enqueue, Press 2 for dequeue, Press 3 to exit");

            choice = scan.nextInt();
            String ngoname;
            boolean found = false;
            switch(choice) {
                case (1):
                    System.out.println("Insert the name of the Ngo: ");

                    ngoname = scan2.nextLine();
                    found = allNgos.contains(ngoname);
                    if(found){
                        ClassPq ngo1 = new ClassPq(ngoname, map.get(ngoname));
                        pq.add(ngo1); // nicely added in the priority queue
                    }
                    else       
                        System.out.println("Invalid NGO NAME.");  
                    break;
                case (2):
                    if(pq.size() > 0){
                        String nowname = pq.poll().ngoName;
                    //  pq.remove();
                        System.out.println(nowname);
                        String path = "src/Documentation/AfterPq.csv";
                        QAfterDeque.updatefiledq(path, ngoarr, nowname, 3);
                    } 
                    else{
                        System.out.println("The queue is already empty. Make sure to enquue first.");
                    }
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

