package Examen2022.domain;

import Examen2022.exceptcion.JugueteException;

public class InstrumentoMusical extends JugueteMadera {

    private int edadMinima;

    public InstrumentoMusical(String nombre, String marca, String origen, int anoTala, int edadMinima) throws JugueteException {
        super(nombre, marca, origen, anoTala);
        this.setEdadMinima(edadMinima);
    }

    public int getEdadMinima() {
        return edadMinima;
    }

    private void setEdadMinima(int edadMinima) throws JugueteException {
        if (edadMinima < 0) {
            throw new JugueteException("La edad mínima no puede ser inferior a 0");
        }
        this.edadMinima = edadMinima;
    }

    @Override
    public String toString() {
        return this.getNombre() + ". Edad mínima " + edadMinima + " años";
    }

}
