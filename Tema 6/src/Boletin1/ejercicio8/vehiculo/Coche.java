package Boletin1.ejercicio8.vehiculo;

import Boletin1.ejercicio8.vehiculo.Exception.CocheException;

public class Coche extends Vehiculo {

    private Combustible combustible;

    public static final double INCREMENTO_GASOLINA = 3.5;
    public static final double INCREMENTO_DIESEL = 2;

    public Coche(String matricula, Gama gama, Combustible combustible) {
        super(matricula, gama);
        this.combustible = combustible;
    }

    public Combustible getCombustible() {
        return combustible;
    }

    public void setCombustible(Combustible combustible) {
        this.combustible = combustible;
    }

    public double calcularAlquiler(int dias) throws CocheException {
        double totalVariable = 0;
        if (dias <= 0)
            throw new CocheException("Dias de alquiler incorrecto");


        totalVariable = combustible.getIncremento() * dias;


        return totalVariable + calcularAlquilerBase(dias);
    }


    @Override
    public String toString() {
        return "Coche " + super.toString() + " [combustible=" + combustible + "]";
    }
}
