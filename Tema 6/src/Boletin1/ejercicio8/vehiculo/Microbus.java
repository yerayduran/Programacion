package Boletin1.ejercicio8.vehiculo;

import Boletin1.ejercicio8.vehiculo.Exception.CocheException;

public class Microbus extends Vehiculo{

    private int numPlazas;
    private final double CANTIDAD_PLAZA=5;

    public Microbus(String matricula, Gama gama, int numPlaza) throws CocheException {
        super(matricula, gama);
        this.setNumPlazas(numPlaza);
    }

    public int getNumPlazas() {
        return numPlazas;
    }

    public void setNumPlazas(int numPlazas)throws CocheException {
        if(numPlazas <= 0){
            throw new CocheException("No puede haber un numero de plazas negativo o cero");
        }
        this.numPlazas = numPlazas;
    }

    public double calcularAlquiler(int dias) throws CocheException {
        double total;
        if ( dias <=0)
            throw new CocheException("Dias de alquiler incorrecto");


        total = CANTIDAD_PLAZA * numPlazas;
        return total + calcularAlquilerBase(dias);
    }

    @Override
    public String toString() {
        return "Microbus  " + super.toString() + " plazas =" + numPlazas;
    }
}
