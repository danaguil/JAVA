

import javax.swing.*;
import java.awt.*;

/*
    Program that opens a window, includes:
        - A title: "My First Swing App"
        - A label that says: "Hello, Swing!"
        - A button that closes the program when clicked
 */

public class Main {
    public static void main(String[] args) {
        // Creating a frame using a constructor, able to set a name to
        // always include a visibility(true)
        // main window, contains panels, other frames or components
        JFrame Frame = new JFrame("My First GUI");

        // Container for lightweight components, with grid..., forces everything to be centered auto,
        // with common attributes (buttons, labels, and text)
        // gridBagLayout best for use of multiple rows and columns with diff sizes
        JPanel Panel = new JPanel(new GridBagLayout());
        // size the frame
        Frame.setSize(400, 800);

        // Need a way to exit out the program
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // prevents resizing
        Frame.setResizable(false);

        // Using Border Layout: very simple layouts but can't handle complex
        Frame.setLayout(new BorderLayout());

        /* Sets a title card in the window
            CENTER,RIGHT,LEFT,LEADING OR TRAILING for the text in the box
         */
        JLabel label1 = new JLabel("Hello, Swing!",SwingConstants.CENTER);

        // customizing text
        label1.setFont(new Font("Verdana", Font.BOLD, 20));
        // need to actually add the label into the frame
        Frame.add(label1, BorderLayout.NORTH);

        // adding button
        JButton button1 = new JButton("Exit");
        button1.setPreferredSize(new Dimension(200,80));

        // adding an event to the button
        button1.addActionListener(_ -> {
            System.out.println("Button is pressed!!");
            System.exit(0);
        });

        // adding button to panel
        Panel.add(button1);

        // adding panel to frame, then centering it
        Frame.add(Panel,BorderLayout.CENTER);
        // Need to show the new window
        Frame.setVisible(true);
    }
}