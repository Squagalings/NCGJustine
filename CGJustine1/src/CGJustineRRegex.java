import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import java.io.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.*;

import javax.swing.*;
import javax.swing.event.MouseInputListener;

public class CGJustineRRegex {

    enum Tool {
        NONE, SAVE, OPEN, DRAW, ERASE
    }

    static Tool currentTool = Tool.NONE;
    private static List<Circle2> circleLst = new ArrayList<>();
    private static JPanel canvas;

    public static void main(String[] args) throws FileNotFoundException {
        String regex = "([\\d]+)[\\s\\t]+([\\d]+)[\\s\\t]+([\\d]+)[\\s\\t]+([\\d]+)[\\s\\t]*";
        Pattern p = Pattern.compile(regex);

        Scanner in = new Scanner(new File("circles.txt"));

        while (in.hasNext()) {
            String readLine = in.nextLine();

            // TODO pass the values to the circle

            Matcher m = p.matcher(readLine);
            if (m.matches()) {
                Circle2 c = new Circle2(
                        Integer.parseInt(m.group(1)),
                        Integer.parseInt(m.group(2)),
                        Integer.parseInt(m.group(3)),
                        Integer.parseInt(m.group(4)));
                circleLst.add(c);
            }

        }
        in.close();

        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }
    // TODO create GUI to paint circles

    private static void createAndShowGUI() {
        // testing....

        // circleLst = new ArrayList<>();

        // TODO create frame
        JFrame f = new JFrame();
        // TODO create panel => canvas
        canvas = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                // TODO draw the circles from the circleLst array
                g.setColor(Color.WHITE);
                for (Circle2 c : circleLst) {
                    g.fillOval(c.getX(), c.getY(), c.getW(), c.getH());
                }
            }
        };

        MouseInputListener m = new MouseInputListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                if (currentTool == Tool.NONE) {
                    createCircle(e, canvas);

                }
                switch (currentTool) {
                    case DRAW:
                        createCircle(e, canvas);
                        break;
                    case ERASE:
                        eraseCircleAt(e.getX(), e.getY());
                        canvas.repaint();
                        break;
                    default:
                        break;
                }

            }

            private static void eraseCircleAt(int x, int y) {
                circleLst.removeIf(c -> x >= c.getX() && x <= c.getX() + c.getW() &&
                        y >= c.getY() && y <= c.getY() + c.getH());
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

        // TODO add mouse listeners to canvas
        canvas.addMouseListener(m);
        canvas.addMouseMotionListener(m);

        // TODO add components to canvas
        // TODO add listeners to components
        JToggleButton btnSave = createToolButton("Save", Tool.SAVE);
        JToggleButton btnOpen = createToolButton("Open", Tool.OPEN);
        JToggleButton btnDraw = createToolButton("Draw", Tool.DRAW);
        JToggleButton btnErase = createToolButton("Erase", Tool.ERASE);

        JPanel control = new JPanel();
        control.add(btnSave);
        control.add(btnOpen);
        control.add(btnDraw);
        control.add(btnErase);

        ButtonGroup group = new ButtonGroup();
        group.add(btnSave);
        group.add(btnOpen);
        group.add(btnDraw);
        group.add(btnErase);

        // TODO create button group and add the button components to it

        // TODO use GridBagLayout and GridBagConstraints

        f.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

        // Canvas (big area)
        gc.gridx = 0;
        gc.gridy = 0;
        gc.weightx = 1;
        gc.weighty = 1;
        gc.fill = GridBagConstraints.BOTH;
        canvas.setPreferredSize(new Dimension(600, 400));
        canvas.setBackground(Color.BLACK);
        f.add(canvas, gc);

        // Control panel (buttons)
        gc.gridy = 1;
        gc.weighty = 0;
        gc.fill = GridBagConstraints.HORIZONTAL;
        f.add(control, gc);

        f.pack();
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // TODO set preferred size for canvas and control panels
        // TODO and (i) pack the panels into the frame (ii) set frame visibility to true
        // (iii) set program to exit when you close the GUI window

        // TODO create function selectors (e.g. switch between SELECT, DRAW, ERASE etc.)
        // in mouse events (click, press, release, drag, move)
        // send mouse positions to paint components on canvas
        // TODO print the content of s set

    }

    protected static void createCircle(MouseEvent e, JPanel canvas) {
        System.out.println(e.getX());
        // TODO create an instance of a circle with the x,y,w,h parameters, and add to
        // the circleLst
        // and call canvas repaint method to invoke the paintComponent
        Circle2 c = new Circle2(e.getX(), e.getY(), 20, 20);
        circleLst.add(c);
        canvas.repaint();

        // TODO problem is how to provide access to canvas to this createCircle method
        // ???
        // canvas.repaint();
    }

    static JToggleButton createToolButton(String name, Tool tool) {
        currentTool = tool;
        JToggleButton btn = new JToggleButton(name);
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                switch (tool) {
                    case SAVE:
                        saveFile();
                        break;
                    case OPEN:
                        openFile();
                        break;
                    default:
                        break;
                }
            }

        });

        return btn;
    }

    protected static void openFile() {
        circleLst.clear();
        canvas.repaint();

        try (Scanner in = new Scanner(new File("circles.txt"))) {
            String regex = "([\\d]+)[\\s\\t]+([\\d]+)[\\s\\t]+([\\d]+)[\\s\\t]+([\\d]+)[\\s\\t]*";
            Pattern p = Pattern.compile(regex);

            while (in.hasNextLine()) {
                String str = in.nextLine();
                Matcher m = p.matcher(str);
                if (m.matches()) {
                    int x = Integer.parseInt(m.group(1));
                    int y = Integer.parseInt(m.group(2));
                    int w = Integer.parseInt(m.group(3));
                    int h = Integer.parseInt(m.group(4));
                    Circle2 c = new Circle2(x, y, w, h);
                    circleLst.add(c);
                }
            }

            in.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("opened");
    }

    protected static void saveFile() {
        try (PrintWriter out = new PrintWriter("circles.txt")) {
            for (Circle2 c : circleLst) {
                out.println(c.getX() + " " + c.getY() + " " + c.getW() + " " + c.getH());
            }
            System.out.println("saved");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

class Circle2 {
    private int x, y, w, h;

    Circle2(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setW(int w) {
        this.w = w;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getW() {
        return w;
    }

    public int getH() {
        return h;
    }
}
