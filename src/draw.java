import javax.swing.*;
import java.awt.*; // class for painting graphics and images

// class is JUST for drawing, we'll be drawing on the JPanel NOT the frame
public class draw extends JPanel{
    public void drawing(){
        repaint(); // calls paintComponent method
    }

    // creating method, main drawing
    public void paintComponent(Graphics g){
        super.paintComponent(g); //

        // we can begin drawing
        g.setColor(Color.BLUE);
        // up, down, width, height
        g.fillRect(100,100,20,100);
    }

}
