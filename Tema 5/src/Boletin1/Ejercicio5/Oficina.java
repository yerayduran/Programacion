package Boletin1.Ejercicio5;

public class Oficina implements IEdificio {

    private double superficie;
    private int numeroOficinas;

    public Oficina(double superficie, int numeroOficinas) {
        this.superficie = superficie;
        this.numeroOficinas = numeroOficinas;
    }

    @Override
    public double getSuperficieEdificio() {
        return superficie;
    }

    public int getNumeroOficinas() {
        return numeroOficinas;
    }

    @Override
    public String toString() {
        return "EdificioDeOficinas [Superficie = " + superficie + ", Numero de Oficinas = " + numeroOficinas + "]";
    }
}
