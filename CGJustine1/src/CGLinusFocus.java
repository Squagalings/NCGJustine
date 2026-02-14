
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import javax.swing.border.Border;

public class CGLinusFocus extends JFrame {

    private int width=400;
    private int height = 300;
    private int xpos = 10;

    CGLinusFocus() {

        JPanel canvas1 = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                // TODO Auto-generated method stub
                super.paintComponent(g);
                g.setColor(Color.WHITE);
                g.fillOval(xpos,10,50,50);
            }
        };

        JPanel canvas2 = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                // TODO Auto-generated method stub
                super.paintComponent(g);
                g.setColor(Color.BLACK);
                g.fillOval(10,10,50,50);
            }
        };

        canvas1.setPreferredSize(new Dimension(width,height));
        canvas1.setBackground(Color.BLACK);

        canvas2.setPreferredSize(new Dimension(width,height));
        canvas2.setBackground(Color.WHITE);

        getContentPane().add(canvas1, BorderLayout.PAGE_START);
        getContentPane().add(canvas2,BorderLayout.PAGE_END);

        addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub
                // System.out.println("keyTyped "+e.getKeyChar());
                
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // TODO Auto-generated method stub
                // System.out.println("keyTyped");
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_A:
                        System.out.println("A");
                        xpos-=10;
                        canvas1.repaint();
                        canvas2.repaint();
                        break;
                    case KeyEvent.VK_D:
                        System.out.println("D");
                        xpos+=10;
                        canvas1.repaint();
                        canvas2.repaint();
                        break;
                    
                
                    default:
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub
                // System.out.println("keyTyped");
            }
            
        });

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    class CGCanvas extends JPanel {
        
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CGLinusFocus());
    }
}
