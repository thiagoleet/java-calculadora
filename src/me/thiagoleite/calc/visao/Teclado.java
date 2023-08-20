package me.thiagoleite.calc.visao;

import me.thiagoleite.calc.modelo.Memoria;

import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Teclado extends JPanel implements ActionListener {
    private final Color COR_CINZA_ESCURO = new Color(68, 68, 68);
    private final Color COR_CINZA_CLARO = new Color(99, 99, 99);
    private final Color COR_LARANJA = new Color(242, 163, 60);

    public Teclado() {
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints constraints = new GridBagConstraints();

        setLayout(layout);

        constraints.weightx = 1;
        constraints.weighty = 1;
        constraints.fill = GridBagConstraints.BOTH;

        // Linha 1
        constraints.gridwidth = 3;
        adicionarBotao("AC", COR_CINZA_ESCURO, constraints, 0, 0);
        constraints.gridwidth = 1;
        // TODO: Para ser implementado no futuro
        // adicionarBotao("+/-", COR_CINZA_ESCURO, c, 1, 0);
        // adicionarBotao("%", COR_CINZA_ESCURO, c, 2, 0);

        adicionarBotao("/", COR_LARANJA, constraints, 3, 0);

        // Linha 2
        adicionarBotao("7", COR_CINZA_CLARO, constraints, 0, 1);
        adicionarBotao("8", COR_CINZA_CLARO, constraints, 1, 1);
        adicionarBotao("9", COR_CINZA_CLARO, constraints, 2, 1);
        adicionarBotao("*", COR_LARANJA, constraints, 3, 1);

        // Linha 3
        adicionarBotao("4", COR_CINZA_CLARO, constraints, 0, 2);
        adicionarBotao("5", COR_CINZA_CLARO, constraints, 1, 2);
        adicionarBotao("6", COR_CINZA_CLARO, constraints, 2, 2);
        adicionarBotao("-", COR_LARANJA, constraints, 3, 2);

        // Linha 4
        adicionarBotao("1", COR_CINZA_CLARO, constraints, 0, 3);
        adicionarBotao("2", COR_CINZA_CLARO, constraints, 1, 3);
        adicionarBotao("3", COR_CINZA_CLARO, constraints, 2, 3);
        adicionarBotao("+", COR_LARANJA, constraints, 3, 3);

        // Linha 5
        constraints.gridwidth = 2;
        adicionarBotao("0", COR_CINZA_CLARO, constraints, 0, 4);
        constraints.gridwidth = 1;
        adicionarBotao(",", COR_CINZA_CLARO, constraints, 2, 4);
        adicionarBotao("=", COR_LARANJA, constraints, 3, 4);


    }

    private void adicionarBotao(String texto, Color cor, GridBagConstraints constraints, int x, int y) {
        constraints.gridx = x;
        constraints.gridy = y;
        Botao botao = new Botao(texto, cor);
        botao.addActionListener(this);

        add(botao, constraints);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof JButton) {
            JButton botao = (JButton) e.getSource();
            Memoria.getInstancia().processarComando(botao.getText());
        }

    }
}
