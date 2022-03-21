import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.io.*;
public class matching {
    private static void matchingAlgorithm()throws IOException{
        List<String> lines = Files.readAllLines(Paths.get("src/Documentation/ngoDemands.csv"));
        for (int i=0;i<lines.size();i++){
            String[] items = lines.get(i).split(",");
            String aidRequired = items[1];
            int quantityDemanded = Integer.parseInt(items[2]);
            String status = items[3];
        }

        List<String> lines2 = Files.readAllLines(Paths.get("src/Documentation/DonatedItems.csv"));
        for (int i=0;i<lines.size();i++){
            String[] items = lines.get(i).split(",");
            String aidDonated=items[1]
            int quantityDonated = Integer.parseInt(items[2]);
            String status = items[3];
        }
        
    }
    






}
