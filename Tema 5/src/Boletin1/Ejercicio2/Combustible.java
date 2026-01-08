package Boletin1.Ejercicio2;

public enum Combustible {
    GASOLINA(3.5), DIESEL(2.0);

    private final double PRECIO_AÑADIDO;

    Combustible(double PRECIO_AÑADIDO) {
        this.PRECIO_AÑADIDO = PRECIO_AÑADIDO;
    }

    public double getPrecioAñadido() {
        return PRECIO_AÑADIDO;
    }
}
