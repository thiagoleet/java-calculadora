package me.thiagoleite.calc.visao;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Color;


public class Teclado extends JPanel {
    private final Color COR_CINZA_ESCURO = new Color(68, 68, 68);
    private final Color COR_CINZA_CLARO = new Color(99, 99, 99);
    private final Color COR_LARANJA = new Color(242, 163, 60);

    public Teclado() {
        setLayout(new GridLayout(5, 4));


    }
}
