import javax.swing.*;
import java.awt.*; // class for painting graphics and images

// class is JUST for drawing, we'll be drawing on the JPanel NOT the frame
public class gridLayout extends JPanel{
    final int CELL_SIZE = 30;
    final int GRID_SIZE = 10;

    public void drawing(){
        repaint(); // calls paintComponent method
    }

    // creating method, main drawing
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        /* BASIC RECTANGLE
        // we can begin drawing
        g.setColor(Color.BLUE);
        // up, down, width, height
        g.fillRect(100,100,20,100);
         */
        g.setColor(Color.BLACK);

        int length = (GRID_SIZE + 1) * CELL_SIZE;
        // x1 & x2, longer or shorter for end point, y1 & y2 needs to match
        // for the rows, straight lines
        for(int i = 1; i < 12; i++){ // start at 1 so we don't have a line at x =0
            int y = CELL_SIZE * i; // pos that increases (going down)
            g.drawLine(CELL_SIZE,y,length,y);
        }

        // for columns
        for(int i = 1; i < 12; i++){
            int x = CELL_SIZE * i; // pos that increase (going right)
            g.drawLine(x,CELL_SIZE,x,length);
        }




    }

}
