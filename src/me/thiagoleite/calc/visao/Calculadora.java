package me.thiagoleite.calc.visao;

import javax.swing.JFrame;

public class Calculadora extends JFrame {
    public Calculadora() {
        setSize(232, 322); // define as dimensões da calculadora
        setDefaultCloseOperation(EXIT_ON_CLOSE); // mata a calculadora ao fechar
        setLocationRelativeTo(null); // centraliza a tela
        setVisible(true); // torna o JFrame visível
    }

    public static void main(String[] args) {
        new Calculadora();
    }
}
