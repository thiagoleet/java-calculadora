package me.thiagoleite.calc.visao;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class Calculadora extends JFrame {
    public Calculadora() {
        organizarLayout();

        setSize(232, 322); // define as dimensões da calculadora
        // setUndecorated(true); // Remove a barra da aplicação
        setDefaultCloseOperation(EXIT_ON_CLOSE); // mata a calculadora ao fechar
        setLocationRelativeTo(null); // centraliza a tela
        setVisible(true); // torna o JFrame visível
    }

    private void organizarLayout() {
        setLayout(new BorderLayout());

        Display display = new Display();
        display.setPreferredSize(new Dimension(233, 60));
        add(display, BorderLayout.NORTH);

        Teclado teclado = new Teclado();
        add(teclado, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        new Calculadora();
    }
}

