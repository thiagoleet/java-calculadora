package me.thiagoleite.calc.visao;

import me.thiagoleite.calc.modelo.Memoria;
import me.thiagoleite.calc.modelo.MemoriaObserver;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.FlowLayout;


public class Display extends JPanel implements MemoriaObserver {
    private final JLabel label;

    public Display() {
        Memoria.getInstancia().adicionarObservador(this);

        setBackground(new Color(46, 49, 50));
        setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 25));

        label = new JLabel(Memoria.getInstancia().getTextoAtual());
        label.setForeground(Color.WHITE);
        label.setFont(new Font("courier", Font.PLAIN, 30));
        add(label);
    }

    @Override
    public void valorAlterado(String novoValor) {
        label.setText(novoValor);
    }
}
