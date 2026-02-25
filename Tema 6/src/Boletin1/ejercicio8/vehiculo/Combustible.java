package Boletin1.ejercicio8.vehiculo;

public enum Combustible {
    GASOLINA(Coche.INCREMENTO_GASOLINA),
    DIESEL(Coche.INCREMENTO_DIESEL);

    private double incremento;

    private Combustible(double incremento) {
        this.incremento = incremento;
    }

    public double getIncremento() {
        return incremento;
    }
}