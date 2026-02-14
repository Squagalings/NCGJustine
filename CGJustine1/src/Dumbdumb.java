import java.awt.Dimension;
import java.awt.GridBagConstraints;

import javax.swing.*;

public class Dumbdumb {

    Dumbdumb() {

    }
    // JPanel form = new JPanel();
    // form.setPreferredSize(new Dimension(600,400));

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGUI());
    }

    private static void createAndShowGUI() {

        JFrame frame = new JFrame();

        JPanel form = new JPanel();
        form.setPreferredSize(new Dimension(600, 400));
        GridBagConstraints c = new GridBagConstraints();

        // text box
        JTextField tf1 = new JTextField(30);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 1;
        form.add(tf1);
        // button
        JButton btn1 = new JButton("press here");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 1;
        form.add(btn1);
        // checkbox
        JCheckBox cb1 = new JCheckBox("yes");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 1;
        form.add(cb1);
        // color chooser
        JColorChooser cc1 = new JColorChooser();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 1;
        form.add(cc1);
        // add listener
        btn1.addActionListener(e -> System.out.println("btn1 clicked"));

        frame.add(form);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

}
