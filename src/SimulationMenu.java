import java.util.Scanner;

/**This class contains the menu to call the Simulation Methods*/
public class SimulationMenu {

    /**This method asks the user to select from the two Simulation modes*/
    public static void Simulation() throws Exception {
        Scanner scanner = new Scanner(System.in); // Initializing a new scanner for taking input. 
        String menu =
                """
                        |------------------------------------------------------------|
                                        Welcome to the DC Simulation                 
                        |------------------------------------------------------------|
                        |       Select the queue mode from the give choices          |
                        |     Enter 1:  First in First out mode                      |
                        |     Enter 2:  Priority mode                                |
                        |------------------------------------------------------------|""";

        System.out.println(menu);  
        int choice = scanner.nextInt(); //taking input for the choice of the type of the simulation
        switch (choice) {
            case (1):   QSimulator.startQSimulator();   //calls the FIFO queue mode of simulation
                break;
            case (2):   PqSimulator.startPqSimulator(); //calls the Priority queue  mode of simulation
                break;
        }
        scanner.close(); // closing the scanner. 
    }
}
