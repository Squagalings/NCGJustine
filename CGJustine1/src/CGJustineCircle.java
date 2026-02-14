import java.util.*;
import java.util.List;

import javax.swing.*;
import javax.swing.event.MouseInputListener;

import java.awt.*;
import java.awt.event.MouseEvent;

public class CGJustineCircle {
    static List<List<Integer>> myLst = new ArrayList<>();
    private final static int CANVASWIDTH = 400, CANVASHEIGHT = 300;
    private static Map<String, List<Integer>> myMap;

    enum Tool {
        SELECT, DRAW, OPEN, SAVE
    }

    protected static Tool currTool = Tool.SELECT;

    public static void createAndShowGUI() {
        JFrame frame = new JFrame();
        Container cp = frame.getContentPane();
        JPanel canvas = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.WHITE);
                List<Integer> coord = myMap.get("A");
                myMap.forEach((k, v) -> {
                    int x = v.get(0);
                    int y = v.get(1);
                    g.fillOval(x, y, 20, 20);
                });

            }
        };
        JPanel control = new JPanel();

        // canvas
        canvas.setPreferredSize(new Dimension(CANVASWIDTH, CANVASHEIGHT));
        canvas.setBackground(Color.BLACK);

        cp.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        gc.fill = GridBagConstraints.HORIZONTAL;
        gc.gridx = 0;

        gc.weighty = 0.5;
        cp.add(canvas, gc);
        gc.gridy = 1;
        cp.add(control, gc);

        // control

        JToggleButton btnSelect = new JToggleButton("Select");
        JToggleButton btnDraw = new JToggleButton("Draw");
        btnSelect.setSelected(true);

        btnSelect.addActionListener(e -> select());
        btnDraw.addActionListener(e -> draw());

        ButtonGroup group = new ButtonGroup();
        group.add(btnSelect);
        group.add(btnDraw);

        control.add(btnSelect);
        control.add(btnDraw);

        // normal button

        JToggleButton btnSave = new JToggleButton("Save");
        JToggleButton btnOpen = new JToggleButton("Open");

        btnSave.addActionListener(e -> save());
        btnOpen.addActionListener(e -> open());

        control.add(btnSave);
        control.add(btnOpen);

        MouseInputListener mouselistener = createMouseListener(canvas);

        canvas.addMouseListener(mouselistener);
        canvas.addMouseMotionListener(mouselistener);

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static MouseInputListener createMouseListener(JPanel canvas) {
        return new MouseInputListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("mouse clicked");

                int x = e.getX();
                int y = e.getY();

                switch (currTool) {
                    case DRAW:
                        drawObject(x, y);
                        break;

                }

                canvas.repaint();
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

    protected static void drawObject(int x, int y) {
        List<Integer> coord = new ArrayList<>();
        coord.add(x);
        coord.add(y);
        String key = coord.hashCode() + "";
        myMap.put(key, coord);
    }

    public static void save() {
        System.out.println("save");
        currTool = Tool.SAVE;
    }

    public static void open() {
        System.out.println("open");
        currTool = Tool.OPEN;
    }

    public static void select() {
        System.out.println("Select");
        currTool = Tool.SELECT;
    }

    private static void draw() {
        System.out.println("Draw");
        currTool = Tool.DRAW;
    }

    public static void main(String[] args) {

        // new method
        String[] names = { "A", "B", "C", "D" };
        int[][] values = {
                { 10, 20, 30 }, { 40, 50, 60 }, { 70, 80, 90 }, { 100, 110, 120 }
        };
        myMap = createMap(names, values);

        SwingUtilities.invokeLater(() -> createAndShowGUI());

    }

    public static Map<String, List<Integer>> createMap(String[] names, int[][] values) {
        Map<String, List<Integer>> myMap = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            List<Integer> valuesLst = new ArrayList<>();
            for (int j = 0; j < values[i].length; j++) {
                valuesLst.add(values[i][j]);
            }
            myMap.put(names[i], valuesLst);
        }
        return myMap;

    }

    // method vs constructor: constructors have no return type, they just construct
    // something
    static List<Integer> createSubLst(String name, int[] values) {
        List<Integer> subLst = new ArrayList<>();
        for (Integer value : values) {
            subLst.add(value);
        }
        return subLst;

    }
}
