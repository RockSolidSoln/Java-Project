import java.util.Scanner;

public class SimulationMenu {

    public static void Simulation() throws Exception {
        Scanner scanner = new Scanner(System.in);
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
        int choice = scanner.nextInt();
        switch (choice) {
            case (1):   QSimulator.startQSimulator();
                break;
            case (2):   PqSimulator.startPqSimulator();
                break;
        }
        scanner.close();
    }
}
