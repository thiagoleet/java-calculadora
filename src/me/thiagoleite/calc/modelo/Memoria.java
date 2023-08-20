package me.thiagoleite.calc.modelo;

import java.util.ArrayList;
import java.util.List;

public class Memoria {

    private enum TipoComando {
        ZERAR, NUMERO, DIV, MULT, SUB, SOMA, IGUAL, VIRGULA
    }

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

    public void processarComando(String texto) {
        TipoComando tipoComando = detectarTipoComando(texto);
        System.out.println(tipoComando);

        observers.forEach(o -> o.valorAlterado(getTextoAtual()));
    }

    private TipoComando detectarTipoComando(String texto) {
        if (getTextoAtual().isEmpty() && texto.equals("")) {
            return null;
        }

        try {
            Integer.parseInt(texto);
            return TipoComando.NUMERO;
        } catch (NumberFormatException e) {
            if ("AC".equalsIgnoreCase(texto)) {
                return TipoComando.ZERAR;
            } else if ("/".equals(texto)) {
                return TipoComando.DIV;
            } else if ("*".equals(texto)) {
                return TipoComando.MULT;
            } else if ("+".equals(texto)) {
                return TipoComando.SOMA;
            } else if ("-".equals(texto)) {
                return TipoComando.SUB;
            } else if (",".equals(texto)) {
                return TipoComando.VIRGULA;
            } else if ("=".equals(texto)) {
                return TipoComando.IGUAL;
            }
        }

        return null;
    }
}
