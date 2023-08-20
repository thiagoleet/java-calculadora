package me.thiagoleite.calc.visao;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.FlowLayout;


public class Display extends JPanel {
    private final JLabel label;

    public Display() {
        setBackground(new Color(46, 49, 50));
        setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 25));

        label = new JLabel("123456,78");
        label.setForeground(Color.WHITE);
        label.setFont(new Font("courier", Font.PLAIN, 30));
        add(label);
    }
}
