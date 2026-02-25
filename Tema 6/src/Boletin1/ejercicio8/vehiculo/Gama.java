package Boletin1.ejercicio8.vehiculo;

public enum Gama {
    ALTA(Vehiculo.PRECIO_ALTA),
    MEDIA(Vehiculo.PRECIO_MEDIA),
    BAJA(Vehiculo.PRECIO_BAJA);

    private double precioBasePorGama;

    private Gama ( double precioBasePorGama) {
        this.precioBasePorGama=precioBasePorGama;
    }

    public double getPrecioBasePorGama() {
        return precioBasePorGama;
    }
}
