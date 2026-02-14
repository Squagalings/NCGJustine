
import javax.swing.*;
import javax.swing.event.MouseInputListener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputAdapter;

public class CGJustine4 extends JFrame {

    private static final int width = 600, height = 200;

    JPanel panel1, panel2;
    JButton btn1, btn2, btn3, btn4;
    private int xpos, ypos;
    private final JLabel mousePosLbl;

    CGJustine4() {
        setLayout(new BorderLayout());

        panel1 = new JPanel();
        panel1.setPreferredSize(new Dimension(width, height));
        panel1.setBackground(Color.BLACK);
        JButton btn1 = new JButton("btn1");
        panel1.add(btn1);

        panel2 = new JPanel();
        panel2.setPreferredSize(new Dimension(width, height));
        panel2.setBackground(Color.BLUE);
        JButton btn2 = new JButton("btn2");
        panel1.add(btn2);

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("btn1 pressed");
            }

        });

        panel1.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println("Key pressed");
            }

            @Override
            public void keyReleased(KeyEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");
            }

        });

        CGMouseInputAdapter listener1 = new CGMouseInputAdapter();
        CGMouseInputAdapter listener2 = new CGMouseInputAdapter();

        panel1.addMouseMotionListener(listener1);
        panel2.addMouseMotionListener(listener2);

        mousePosLbl = new JLabel(printMousePosition());
        mousePosLbl.setForeground(Color.WHITE);
        panel1.add(mousePosLbl);

        Container cp = getContentPane();
        cp.add(panel1, BorderLayout.NORTH);
        cp.add(panel2, BorderLayout.SOUTH);

        pack();
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    String printMousePosition() {
        return "mouse position x=" + xpos + ", y=" + ypos;
    }

    class CGMouseInputAdapter extends MouseInputAdapter {

        @Override
        public void mouseMoved(MouseEvent e) {
            xpos = e.getX();
            ypos = e.getY();
            System.out.println("mouse moved");
            mousePosLbl.setText(printMousePosition());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                new CGJustine4();
            }
        });
    }
}
