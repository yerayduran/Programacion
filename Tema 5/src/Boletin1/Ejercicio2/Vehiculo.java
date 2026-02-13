package Boletin1.Ejercicio2;import java.util.Objects;

public abstract class Vehiculo {

    protected final String MATRICULA;
    protected int numDias;
    protected final Gama GAMA;

    public Vehiculo(String MATRICULA,  int numDias, Gama GAMA) {
        this.MATRICULA = MATRICULA;
        this.numDias = numDias;
        this.GAMA = GAMA;
    }

    public String getMatricula() {
        return MATRICULA;
    }

    public int getNumDias() {
        return numDias;
    }

    public Gama getGama() {
        return GAMA;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return Objects.equals(MATRICULA, vehiculo.MATRICULA);
    }

    @Override
    public int hashCode() {
        return Objects.hash(MATRICULA);
    }

    public double precioTotal() {
        return numDias * GAMA.getPrecioBase();
    }
}
