package Space;

public abstract class Carta {
    private final String nombre;
    private final int precio; // en puntos de oro

    public Carta(String nombre, int precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public final String getNombre() {
        return nombre;
    }

    public final int getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Space.Carta{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                '}';
    }
}