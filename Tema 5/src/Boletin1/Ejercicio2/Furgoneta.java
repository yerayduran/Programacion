package Boletin1.Ejercicio2;public class Furgoneta extends Vehiculo{

    private final double PESO_MAXIMO_AUTORIZADO;

    public Furgoneta(String MATRICULA, int numDias, Gama GAMA, double PESO_MAXIMO_AUTORIZADO) {
        super(MATRICULA, numDias, GAMA);
        this.PESO_MAXIMO_AUTORIZADO = PESO_MAXIMO_AUTORIZADO;
    }


    public double precioTotal() {
        return (super.GAMA.getPrecioBase() + (PESO_MAXIMO_AUTORIZADO * 0.5)) * numDias;
    }
}
