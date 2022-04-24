import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.Scanner;

public class Gui extends JFrame{
 private Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        new Gui();
    }

    private JButton button1;
    private JButton button2;
    private JButton button3;

    public Gui()
    {
           
        this.setSize(300,150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Click Event");

        Clicklistener click= new Clicklistener();

        JPanel panel1= new JPanel();
        button1= new JButton ("Enter 1: To Enter the aids to bbe donated");
        button1.addActionListener(click);
        button2= new JButton("Enter 2: To Enter the aids to bbe donated");
        button2.addActionListener(click);
        button3= new JButton("Enter 3: To Enter the aids to bbe donated");
        button3.addActionListener(click);
        panel1.add(button1);
        panel1.add(button2);
        panel1.add(button3);
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
                    DonorMenu.enterAids(sc, "D1");
                    System.exit(0);
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }     
                
            }
            else if (e.getSource() == button2){
                System.out.println("eee");
                System.exit(0);
            }
            else {
                System.out.println("33");
            }

            }
        }
    }