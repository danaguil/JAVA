import javax.swing.*; // swing library
import java.awt.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static JButton button1, button2, button3, button4;
    static JLabel label1;
    public static void main(String[] args) {
        /*
            JFrame: Helps us create and manage top-level window (main window)
            - There's many parameters/constructors to go with
                - Here we use a simple one with title added
            - Includes with multiple methods
                - Here we use setSize(), setResizable(), setVisible()
                  and setDefaultCloseOperation(), there's 5 extra more too!!
         */
        JFrame frame1 = new JFrame("Border Practice"); // creation of frame
        frame1.setSize(400, 800); // BEST size to mimic a phone
        // CHECK LAST PRACTICE TO SEE LABEL BEING ADDED AND BUTTON

        /*
            JPanel: Container that can store groups of components (buttons, radios, etc)
            - main task: to organize in various layouts
            - multiple constructors, but we'll use simple JPanel
            - common methods include:
                - add(), setLayout(), updateUI(),setUI(),getUI(),paramString(),getUIClassID(),
                  getAccessibleContext()
            ** NOTE: each method has its own constructor detail, best to search them up for specific use **
         */

        // we can also include specific layouts using BorderLayouts()
        /*
            BorderLayout Class: arranges components in 5 regions (N,E,S,W, & CENTER)
            - Here are some of the constructors
                - BorderLayout(int,int), with specific gaps in between
            - methods commonly used:
                - toString(), getLayoutAlignmentX (or Y), removeLayoutComponent etc.8 in total


         */
        JPanel panel1 = new JPanel(new BorderLayout()); // creating panel to add buttons

        panel1.setBackground(Color.red); // setting background for panel

        // creating buttons
        button1 = new JButton("button 1");
        button2 = new JButton("button 2");
        button3 = new JButton("button 3");
        button4 = new JButton("button 4");

        // creating labels
        label1 = new JLabel("label 1");

        // adding buttons to panel, using add() method from JFrame
        panel1.add(button1, BorderLayout.NORTH);
        panel1.add(button2, BorderLayout.EAST);
        panel1.add(button3, BorderLayout.SOUTH);
        panel1.add(button4, BorderLayout.WEST);
        panel1.add(label1, BorderLayout.CENTER);

        frame1.add(panel1); // making sure we add panel(group) to main window

        // set these at the end ALWAYS
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // close operation
        frame1.setResizable(false); // controls weather user can resize frame
        frame1.setVisible(true); // makes frame visible
    }
}