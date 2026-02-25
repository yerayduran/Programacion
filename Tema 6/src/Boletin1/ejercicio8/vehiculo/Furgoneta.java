package Boletin1.ejercicio8.vehiculo;

import Boletin1.ejercicio8.vehiculo.Exception.CocheException;

public class Furgoneta extends Vehiculo{

    private int pma;
    private final double CANTIDAD = 0.5;

    public Furgoneta(String matricula,Gama gama, int pma) throws CocheException {
        super(matricula, gama);
        setPma(pma);
    }

    public void setPma(int pma) throws CocheException {
        if (pma < 0){
            throw new CocheException("El PMA no puede ser negativo");
        }
        this.pma = pma;
    }

    public int getPma() {
        return pma;
    }

    public double calcularAlquiler(int dias) throws CocheException {
        double total = 0;
        if ( dias <= 0)
            throw new CocheException("Dias de alquiler incorrecto");

        total = CANTIDAD*pma*dias;
        return total + calcularAlquilerBase(dias);
    }

    @Override
    public String toString() {
        return "Furgoneta " + super.toString() + " PMA =" + pma;
    }

    public int compareTo(Furgoneta otra) {
        return Integer.compare(this.getPma(), otra.getPma());
    }
}
