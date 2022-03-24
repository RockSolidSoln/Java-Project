// import java.io.File;
import java.io.IOException;
// import java.nio.file.Files;
// import java.nio.file.Paths;
import java.util.*;
// import java.io.*;
public class matching{  

    public static void filter() throws IOException{
        ArrayList<String> donatedaids = Donor.donatedaids();
        ArrayList<String> requiredaids = Ngo.requiredaids();
        
        Scanner sc = new Scanner(System.in);

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
            System.out.printf("| %10s |%11s |%10s|",temp[1],temp[2],temp[3]);
            System.out.print("\n|------------------------------------|");
        }
        System.out.println("-------------------------------------------------------------------");
        System.out.println("Enter the name of the Ngo which requests you want to satisfy: ");
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
            writeBack.updateDonor(fName, fAids, fQty,0);
            matchAlgo.runAlgo(name, dName, dAids, dQty, nName, nAids, nQty, nStatus);
        }
        sc.close();  
    }  

}
