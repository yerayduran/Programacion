package examen2022.domain;

public class Escudo extends Cromo {

    private int añoFundado;
    private int numDeJugadores;

    public Escudo(int id, String nombre, int añoFundado, int numDeJugadores) {
        super(id, nombre);
        this.añoFundado = añoFundado;
        this.numDeJugadores = numDeJugadores;
    }

    public int getAñoFundado() {
        return añoFundado;
    }

    public int getNumDeJugadores() {
        return numDeJugadores;
    }
}
