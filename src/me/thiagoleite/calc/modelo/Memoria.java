package me.thiagoleite.calc.modelo;

import java.util.ArrayList;
import java.util.List;

public class Memoria {
    private static Memoria instancia = new Memoria(); // Singleton
    private String textoAtual = "";
    private final List<MemoriaObserver> observers = new ArrayList<>();

    private Memoria() {

    }

    public static Memoria getInstancia() {
        return instancia;
    }

    public void adicionarObservador(MemoriaObserver observer) {
        observers.add(observer);
    }

    public String getTextoAtual() {
        return textoAtual.isEmpty() ? "0" : textoAtual;
    }

    void limparTextoAtual() {
        textoAtual = "";
    }

    void concatenarValor(String valor) {
        textoAtual += valor;
    }

    public void processarComando(String valor) {
        if ("AC".equalsIgnoreCase(valor)) {
            limparTextoAtual();
        } else {
            concatenarValor(valor);
        }

        observers.forEach(o -> o.valorAlterado(getTextoAtual()));
    }
}
