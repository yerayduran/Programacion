package Boletin1.ejercicio8.vehiculo;

import Boletin1.ejercicio8.vehiculo.Exception.CocheException;

import java.util.Objects;

public abstract class Vehiculo implements Comparable<Vehiculo> {

    private String matricula;
    private Gama gama;

    public static final double PRECIO_ALTA = 50;
    public static final double PRECIO_MEDIA = 40;
    public static final double PRECIO_BAJA = 30;

    public Vehiculo(String matricula, Gama gama) {
        this.matricula = matricula;
        this.gama = gama;
    }

    public String getMatricula() {
        return matricula;
    }

    public Gama getGama() {
        return gama;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setGama(Gama gama) {
        this.gama = gama;
    }

    public abstract double calcularAlquiler(int dias) throws CocheException;

    protected double calcularAlquilerBase(int dias) {
        double precio ;

        precio = dias * gama.getPrecioBasePorGama();
        return precio;

    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "matricula='" + matricula + '\'' +
                ", gama=" + gama +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return Objects.equals(matricula, vehiculo.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula);
    }

    @Override
    public int compareTo(Vehiculo o) {
        return this.getMatricula().compareTo(o.getMatricula());
    }
}
