import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.io.*;
public class matching{  

    public static void main(String[]args) throws IOException{
        ArrayList<String> requiredaids = Donor.requiredaids();
        ArrayList<String> donatedaids = Ngo.donatedaids();
        Scanner sc = new Scanner(System.in);

        ArrayList<String> fName = new ArrayList<String>();
        ArrayList<String> fAids = new ArrayList<String>();
        ArrayList<Integer> fQty = new ArrayList<Integer>();

        ArrayList<String> nName = new ArrayList<String>();
        ArrayList<String> nAids = new ArrayList<String>();
        ArrayList<Integer> nQty = new ArrayList<Integer>();
        ArrayList<String> nStatus = new ArrayList<String>();

        int j=0;

        for (int i =0; i<requiredaids.size();i++){
             String[] temp = requiredaids.get(i).split("\\s");

             String status = temp[3];
             if (status.contains("unsatisfied")){
                 nName.add(temp[0]);
                 nAids.add(temp[1]);
                 int Qty = Integer.parseInt(temp[2]);
                 nQty.add(Qty);
                 nStatus.add(temp[3]);
                 j++;
             }
        }
        for(int i=0; i< nName.size();i++){
            System.out.println(nName.get(i) + " " + nAids.get(i) + " " + nQty.get(i) + " " + nStatus.get(i));
        }

        System.out.println("Enter the name of the Ngo which requests you want to satisfy: ");
        String name = sc.nextLine();

        j=0;
        for (int i =0; i<donatedaids.size();i++){
            //System.out.println(donatedaids.get(i));
            String[] temp = donatedaids.get(i).split("\\s");

            String aids = temp[1];
            if (aids.contains(name)){
                fName.add(temp[0]);
                fAids.add(temp[1]);
                int Qty = Integer.parseInt(temp[2]);
                fQty.add(Qty);
                System.out.println(fName.get(j));
                j++;
            }
        }
        matchAlgo.runAlgo(dName, fAids, fQty, nName, nAids, nQty, nStatus);
        sc.close();  
    }  

}
