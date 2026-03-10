package examen2022.domain;

public abstract class Cromo {

    private int id;
    private String nombre;

    public Cromo(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Cromo cromo)) return false;

        return id == cromo.id && nombre.equals(cromo.nombre);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + nombre.hashCode();
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cromo{");
        sb.append("id=").append(id);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
