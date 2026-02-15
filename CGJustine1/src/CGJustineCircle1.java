import java.awt.*;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.event.MouseInputListener;

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
        canvas.setPreferredSize(new Dimension(600, 400));
        canvas.setBackground(Color.BLACK);

        cp.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        // control
        control.setPreferredSize(new Dimension(600, 50));

        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.gridx = 0;
        gc.weighty = 0.5;
        cp.add(canvas, gc);
        cp.add(control, gc);

        // TODO: In the canvas, add a mouse listener object
        MouseInputListener mouselistener = createMouseListener(canvas);
        canvas.addMouseListener(mouselistener);
        canvas.addMouseMotionListener(mouselistener);

        // show window
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    // 1. add a function for mouse click. display mouse position at the terminal
    public static MouseInputListener createMouseListener(JPanel canvas) {
        return new MouseInputListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                int xcor = e.getX();
                int ycor = e.getY();
                System.out.println("(" + xcor + ", " + ycor + ")");
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

            @Override
            public void mouseDragged(MouseEvent e) {
            }

            @Override
            public void mouseMoved(MouseEvent e) {
            }
        };

    }
    // 2. create label and display the mouse position when the mouse is moved

    // TODO: In the control, add some buttons
    // Add some functions for the buttons e.g. save to file and open file
    public static void main(String[] args) {
        // todo create and show GUI
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
}
