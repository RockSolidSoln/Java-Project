import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.Scanner;

public class Gui extends JFrame{
//    private final Scanner sc = new Scanner(System.in);
    public static void runNgo() {
        new Gui();
    }

    private JButton button1;
    private JButton button2;
//    private JButton button3;

    public Gui()
    {

        this.setSize(500,350);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Hello");

        Clicklistener click= new Clicklistener();

        JPanel panel1= new JPanel();
        button1= new JButton ("Enter 1:  First in First out mode ");
        button1.addActionListener(click);
        button2= new JButton("Priority mode      ");
        button2.addActionListener(click);
//        button3= new JButton("Enter 3: To view history of  satisfied aids");
//        button3.addActionListener(click);
        panel1.add(button1);
        panel1.add(button2);
//        panel1.add(button3);
        this.add(panel1);
        this.setVisible(true);
    }

    private class Clicklistener implements ActionListener
    {

        public void actionPerformed(ActionEvent e)
        {

            if (e.getSource() == button1)
            {
                try {
                    QSimulator.startQSimulator();
                    System.exit(0);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            else if (e.getSource() == button2){
                try {
                    PqSimulator.startPqSimulator();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                System.exit(0);
            }
//            else {
//                ShowHistory.viewAidsHistory(name,0);
//                System.exit(0);
//            }
        }
    }
}