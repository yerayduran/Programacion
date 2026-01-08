package Boletin1.Ejercicio2;public class Microbus extends Vehiculo{

    private int numPlazas;
    private final int PRECIO_POR_PLAZA = 5;

    public Microbus(String MATRICULA, int numDias, Gama GAMA, int numPlazas) {
        super(MATRICULA, numDias, GAMA);
        this.numPlazas = numPlazas;
    }


    public double precioTotal() {
        return (super.GAMA.getPrecioBase() + (numPlazas * PRECIO_POR_PLAZA)) * numDias;
    }
}
