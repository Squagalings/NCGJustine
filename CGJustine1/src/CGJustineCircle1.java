import java.util.*;
import java.util.List;

import javax.swing.*;
import javax.swing.event.MouseInputListener;

import java.awt.*;
import java.awt.event.MouseEvent;

public class CGJustineCircle1 {
    // TODO: in the GUI, create 2 panels i.e. canvas, control
    public static void createAndShowGUI() {
        JFrame frame = new JFrame();
        Container cp = frame.getContentPane();
        JPanel canvas = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.WHITE);

            }
        };
        JPanel control = new JPanel();

        // canvas
        canvas.setPreferredSize(new Dimension(400, 300));
        canvas.setBackground(Color.BLACK);

        cp.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.gridx = 0;
        gc.weighty = 0.5;
        cp.add(canvas, gc);
        cp.add(control, gc);

        // show window
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    // TODO: In the canvas, add a mouse listener object
    // 1. add a function for mouse click. display mouse position at the terminal
    // 2. create label and display the mouse position

    // TODO: In the control, add some buttons
    // Add some functions for the buttons e.g. save to file and open file
    public static void main(String[] args) {
        // todo create and show GUI
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
}
