import java.io.*;
import java.util.*;

class MyReader {

    public static void main(String[] args) throws FileNotFoundException {
        // use file, scanner classes to perform and read operation and print the lines
        // on the terminal
        //
        Scanner scanner = new Scanner(new File("circle.txt"));

        List<Circle> circleLst = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            System.out.println(str);

            String[] substr = str.split("[\\s\\t\]+");
            Circle circle = new Circle();
            circle.x = Integer.parseInt(substr[0]);
            circle.y = Integer.parseInt(substr[1]);
            circle.w = Integer.parseInt(substr[2]);
            circle.h = Integer.parseInt(substr[3]);
            circleLst.add(circle);

            System.out.println(circleLst.size());
            System.out.println(circleLst);

            // Todo parse str to data for the circle
            // i.e. o.x=10, o.y=10, o.w-20, o.h=20
            // MyCircle o=new MyCircle()
            // 1. create a class MyCircle
            // 2. you can use regex or String class split method

            // String[] cols = str.split("[,\\.\\s]+");
            // int x = Integer.parseInt(cols[0]);
            // int y = Integer.parseInt(cols[1]);
            // int w = Integer.parseInt(cols[2]);
            // int h = Integer.parseInt(cols[3]);

            // System.out.println(x + "," + y + "," + w + "," + h);
            // }
            // scanner.close();

            // JFrame frame = new JFrame();
            // Container cp = frame.getContentPane();
            // JPanel canvas = new JPanel() {
            // @Override
            // protected void paintComponent(Graphics g) {
            // super.paintComponent(g);
            // g.setColor(Color.WHITE);
            // g.fillOval(10, 10, 20, 20);

        }

        scanner.close();
    }
}

class Circle {
    String str;
    int x, y, w, h;
}
// public class CGJustineCircle1 {
// // TODO: in the GUI, create 2 panels i.e. canvas, control

// public static void createAndShowGUI() {
// JFrame frame = new JFrame();
// Container cp = frame.getContentPane();
// JPanel canvas = new JPanel() {
// @Override
// protected void paintComponent(Graphics g) {
// super.paintComponent(g);
// g.setColor(Color.WHITE);
// g.fillOval(10, 10, 20, 20);
// // TODO: draw circle shapes from a list of data
// // data format x y width height
// // x y w h
// // 10 10 20 20
// // ...
// // 1. create a file boject(file class) and a scanner object

// }
// };
// JPanel control = new JPanel();
// JLabel label = new JLabel();

// // canvas
// canvas.setPreferredSize(new Dimension(600, 400));
// canvas.setBackground(Color.BLACK);

// cp.setLayout(new GridBagLayout());
// GridBagConstraints gc = new GridBagConstraints();

// // control
// control.setPreferredSize(new Dimension(600, 50));

// gc.gridx = 0;
// gc.gridy = 0;
// gc.weightx = 0.5;
// gc.weighty = 0.5;
// gc.fill = (GridBagConstraints.BOTH);
// cp.add(canvas, gc);

// gc.gridy = 1;
// gc.weighty = 0;
// gc.fill = GridBagConstraints.HORIZONTAL;
// cp.add(control, gc);

// // 2. create label and display the mouse position when the mouse is moved
// control.add(label);

// // TODO: In the control, add some buttons
// JButton open = new JButton("Open");
// control.add(open);
// JButton save = new JButton("Save");
// control.add(save);
// JButton showPos = new JButton("Show Position");
// control.add(showPos);

// open.addActionListener(e -> openFile());
// save.addActionListener(e -> saveFile());
// showPos.addActionListener(e -> showMousePos(label));

// // TODO: In the canvas, add a mouse listener object
// MouseInputListener mouselistener = createMouseListener(canvas, label);
// canvas.addMouseListener(mouselistener);
// canvas.addMouseMotionListener(mouselistener);

// // show window
// frame.pack();
// frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
// frame.setVisible(true);

// }

// // 1. add a function for mouse click. display mouse position at the terminal
// public static MouseInputListener createMouseListener(JPanel canvas, JLabel
// label) {
// return new MouseInputListener() {

// @Override
// public void mouseClicked(MouseEvent e) {
// int xcor = e.getX();
// int ycor = e.getY();
// System.out.println("(" + xcor + ", " + ycor + ")");
// // draws circle on click

// }

// @Override
// public void mousePressed(MouseEvent e) {
// }

// @Override
// public void mouseReleased(MouseEvent e) {
// }

// @Override
// public void mouseEntered(MouseEvent e) {
// }

// @Override
// public void mouseExited(MouseEvent e) {
// }

// @Override
// public void mouseDragged(MouseEvent e) {
// }

// @Override
// public void mouseMoved(MouseEvent e) {
// // label displays mouse position when mouse moved
// int xcor = e.getX();
// int ycor = e.getY();
// label.setText("(" + xcor + "," + ycor + ")");
// }
// };

// }

// protected static void drawObject(int xcor, int ycor) {

// }

// // Add some functions for the buttons e.g. save to file and open file
// public static void main(String[] args) {
// // todo create and show GUI
// SwingUtilities.invokeLater(() -> createAndShowGUI());
// }

// public static void openFile() {
// System.out.println("open");
// }

// public static void saveFile() {
// System.out.println("save");
// }

// public static void showMousePos(JLabel label) {
// label.setVisible(!label.isVisible());
// }

// private static class myMap {

// public myMap() {
// }
// }
// }
