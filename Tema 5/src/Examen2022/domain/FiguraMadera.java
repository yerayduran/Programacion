package Examen2022.domain;

import Examen2022.exceptcion.JugueteException;
import Examen2022.interfaces.Apilable;

public class FiguraMadera extends JugueteMadera implements Apilable {

    private String color;
    private int numDeLados;

    public FiguraMadera(String nombre, String marca, String origen, int añoTala, String color, int numDeLados) throws JugueteException {
        super(nombre, marca, origen, añoTala);
        this.color = color;
        setNumDeLados(numDeLados);
    }
    public int getNumDeLados() {
        return numDeLados;
    }

    private void setNumDeLados(int numDeLados) throws JugueteException {
        if (numDeLados < 1) {
            throw new JugueteException("No puedes tener una figura sin lados");
        }
        this.numDeLados = numDeLados;
    }

    public String getColor() {
        return color;
    }

    @Override
    public void apilar(Juguete a) {
        this.apilar(a);
        System.out.println("Se ha apilado " + this.getNombre() + " sobre " + a.getNombre());

    }

    @Override
    public String toString() {
        return getNombre() + " " + color + " de " + getNumDeLados() + " lados";
    }

}
