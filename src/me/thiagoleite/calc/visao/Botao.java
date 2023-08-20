package me.thiagoleite.calc.visao;

import javax.swing.JButton;
import javax.swing.BorderFactory;
import java.awt.Font;
import java.awt.Color;

public class Botao extends JButton {
    public Botao(String texto, Color cor) {
        setText(texto);
        setOpaque(true);
        setBackground(cor);
        setFont(new Font("courier", Font.PLAIN, 30));
        setForeground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));


    }
}
