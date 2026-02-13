package Boletin1.Ejercicio2;public class Coche extends Vehiculo {

    private final Combustible combustible;

    public Coche(String MATRICULA, int numDias, Gama GAMA, Combustible combustible) {
        super(MATRICULA, numDias, GAMA);
        this.combustible = combustible;
    }

    public double calcularTotal() {
        return (super.GAMA.getPrecioBase() + combustible.getPrecioAñadido()) * numDias;
    }
}
