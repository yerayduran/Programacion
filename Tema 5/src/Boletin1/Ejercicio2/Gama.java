package Boletin1.Ejercicio2;

public enum Gama {
    ALTA(50), MEDIA(40), BAJA(30);

    private final double PRECIO_BASE;

    Gama(double PRECIO_BASE) {
        this.PRECIO_BASE = PRECIO_BASE;
    }

    public double getPrecioBase() {
        return PRECIO_BASE;
    }
}
