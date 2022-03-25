import java.io.IOException;
import java.util.*;

//------------------This class contains the methods to filter out Donated aids----------------------------------
public class Matching{  

    public static void filter() throws IOException{
        ArrayList<String> donatedaids = Donor.donatedaids();     //this takes the previous aids currently in the DC
        ArrayList<String> requiredaids = Ngo.requestedaids();   //this takes the previous aids requested to the DC
        
        Scanner sc = new Scanner(System.in);

        //these array lists stores donors 
        ArrayList<String> dName = new ArrayList<String>();
        ArrayList<String> dAids = new ArrayList<String>();
        ArrayList<Integer> dQty = new ArrayList<Integer>();

        ArrayList<String> fName = new ArrayList<String>();
        ArrayList<String> fAids = new ArrayList<String>();
        ArrayList<Integer> fQty = new ArrayList<Integer>();

        ArrayList<String> nName = new ArrayList<String>();
        ArrayList<String> nAids = new ArrayList<String>();
        ArrayList<Integer> nQty = new ArrayList<Integer>();
        ArrayList<String> nStatus = new ArrayList<String>();

        for (int i =0; i<requiredaids.size();i++){
             String[] temp = requiredaids.get(i).split("\\s");

             String status = temp[3];
             if (status.contains("unsatisfied")){
                 nName.add(temp[0]);
                 nAids.add(temp[1]);
                 int Qty = Integer.parseInt(temp[2]);
                 nQty.add(Qty);
                 nStatus.add(temp[3]);
             }
        }
        System.out.println("\n|------------------------------------|");
        System.out.format("|%10s  |%11s |%10s|","Name ","Aid","Quantity"); //template for the table.
        System.out.println("\n|------------------------------------|");

        for(int i=0; i< nAids.size();i++){
            String[] temp = requiredaids.get(i).split("\\s+");
            System.out.printf("| %10s |%11s |%10s|",temp[0],temp[1],temp[2]);
            System.out.println("\n|------------------------------------|");
        }
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Enter the name of the aids which you want to satisfy: ");
        System.out.println("-------------------------------------------------------------------");

        String name = sc.nextLine();
        int flag=0;      

        for (int i =0; i<donatedaids.size();i++){
            String[] temp = donatedaids.get(i).split("\\s+");

            String nameDonor = temp[0];
            String aids = temp[1];
            int Qty = Integer.parseInt(temp[2]);

            //System.out.println("aids-"+aids);

            if (aids.contains(name)){
                dName.add(nameDonor);
                dAids.add(aids);
                dQty.add(Qty);
                flag=1;
            }
            else{
                fName.add(nameDonor);
                fAids.add(aids);
                fQty.add(Qty);
            }
        }
        if(flag==0){
            System.out.println("------------------------------------------------------------------------------------------");
            System.out.println("The required aid by the Ngo's is currently unavailable in the distribution center");
            System.out.println("Please, Check back later");
            System.out.println("Sorry for inconvinience");
            System.out.println("------------------------------------------------------------------------------------------");
        }
        else{
            WriteBack.updateDonor(fName, fAids, fQty,0);
            MatchAlgorithm.runAlgo(name, dName, dAids, dQty, nName, nAids, nQty, nStatus);
        }
        sc.close();  
    }  

}
