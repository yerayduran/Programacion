package Space;

public class CartaMaterial extends Carta {
    private final String tipoMaterial; // Piedra, Oro, Hierro, Boletin5Parte1.Ejercicio2.Combustible

    public CartaMaterial(String tipoMaterial) {
        super("Class.Space.Carta de " + tipoMaterial, 0); // gratuitas
        this.tipoMaterial = tipoMaterial;
    }

    public String getTipoMaterial() {
        return tipoMaterial;
    }

    @Override
    public String toString() {
        return "Space.CartaMaterial{" +
                "material='" + tipoMaterial + '\'' +
                ", precio=" + getPrecio() +
                '}';
    }
}