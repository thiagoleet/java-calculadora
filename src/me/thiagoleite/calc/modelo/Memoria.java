package me.thiagoleite.calc.modelo;

import java.util.ArrayList;
import java.util.List;

public class Memoria {

    private enum TipoComando {
        ZERAR, NUMERO, DIV, MULT, SUB, SOMA, IGUAL, VIRGULA
    }

    private static Memoria instancia = new Memoria(); // Singleton

    private TipoComando ultimaOperacao = null;
    private boolean substituir = false;
    private String textoAtual = "";
    private String textoBuffer = "";
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

    private void limparTextoAtual() {
        textoAtual = "";
        textoBuffer = "";
        substituir = false;
        ultimaOperacao = null;
    }

    private void alteraTextoAtual(String valor) {
        textoAtual = substituir ? valor : textoAtual + valor;
        substituir = false;
    }

    private String obterResultadoOperacao() {
        if (ultimaOperacao == null) {
            return textoAtual;
        }

        double numeroBuffer = Double.parseDouble(textoBuffer.replace(",", "."));
        double numeroAtual = Double.parseDouble(textoAtual.replace(",", "."));
        double resultado = 0;

        if (ultimaOperacao == TipoComando.SOMA) {
            resultado = numeroBuffer + numeroAtual;
        } else if (ultimaOperacao == TipoComando.SUB) {
            resultado = numeroBuffer - numeroAtual;
        } else if (ultimaOperacao == TipoComando.MULT) {
            resultado = numeroBuffer * numeroAtual;
        } else if (ultimaOperacao == TipoComando.DIV) {
            resultado = numeroBuffer / numeroAtual;
        }

        String resultadoTexto = Double.toString(resultado).replace(".", ",");
        boolean isInteiro = resultadoTexto.endsWith(",0");

        return isInteiro ? resultadoTexto.replace(",0", "") : resultadoTexto;
    }

    private void prepararOperacao(String texto, TipoComando tipoComando) {
        substituir = true;
        textoAtual = obterResultadoOperacao();
        textoBuffer = textoAtual;
        ultimaOperacao = tipoComando;
    }

    public void processarComando(String texto) {
        TipoComando tipoComando = detectarTipoComando(texto);

        if (tipoComando == null) {
            return;
        } else if (tipoComando == TipoComando.ZERAR) {
            limparTextoAtual();
        } else if (tipoComando == TipoComando.NUMERO || tipoComando == TipoComando.VIRGULA) {
            alteraTextoAtual(texto);
        } else {
            prepararOperacao(texto, tipoComando);
        }

        // notifica os observadores
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
            } else if (",".equals(texto) && !getTextoAtual().contains(",")) {
                return TipoComando.VIRGULA;
            } else if ("=".equals(texto)) {
                return TipoComando.IGUAL;
            }
        }

        return null;
    }
}
