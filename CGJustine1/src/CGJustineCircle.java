import java.util.*;
import java.util.List;

import javax.swing.*;
import java.awt.*;

public class CGJustineCircle {
    static List<List<Integer>> myLst = new ArrayList<>();
    private final static int CANVASWIDTH = 400, CANVASHEIGHT = 300;

    public static void createAndShowGUI() {
        JFrame frame = new JFrame();
        Container cp = frame.getContentPane();
        JPanel canvas = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.WHITE);
                g.fillOval(0, 0, 20, 20);
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

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static void save() {
        System.out.println("save");
    }

    public static void open() {
        System.out.println("open");
    }

    public static void select() {
        System.out.println("Select");
    }

    private static void draw() {
        System.out.println("Draw");
    }

    public static void main(String[] args) {

        // new method
        String[] names = { "A", "B", "C", "D" };
        int[][] values = {
                { 10, 20, 30 }, { 40, 50, 60 }, { 70, 80, 90 }, { 100, 110, 120 }
        };
        Map<String, List<Integer>> myMap = createMap(names, values);

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
