import javax.swing.*;

public class Main {
    static JFrame frame1;

    public static void main(String[] args) {
        frame1 = new JFrame("Shape GUI Practice");
        frame1.setSize(370, 500);

        gridLayout object = new gridLayout();
        object.drawing();
        frame1.add(object);



        frame1.setVisible(true);
        frame1.setResizable(false);
        frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}