package Boletin1.Ejercicio5;

public class Polideportivo implements IInstalacionDeportiva, IEdificio {

    private String nombre;
    private double superficie;
    private int tipoInstalacion;

    public Polideportivo(String nombre, double superficie, int tipoInstalacion) {
        this.nombre = nombre;
        this.superficie = superficie;
        this.tipoInstalacion = tipoInstalacion;
    }

    @Override
    public int getTipoDeInstalacion() {
        return tipoInstalacion;
    }

    @Override
    public double getSuperficieEdificio() {
        return superficie;
    }

    @Override
    public String toString() {
        return "Ejercicio5.Boletin5Parte1.Ejercicio5.Polideportivo [Nombre = " + nombre + ", Superficie = " + superficie + ", Tipo de Instalacion = " + tipoInstalacion + "]";
    }
}