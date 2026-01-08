package Space;

public class Mina extends Construccion {
    private final String material; // Piedra, Hierro, Boletin5Parte1.Ejercicio2.Combustible, Oro
    private final int produccionPorTurno;

    public Mina(String material, Dado dadoA) {
        super("Class.Space.Mina de " + material, 1, Costes.MINA_PERSONAS); // precio=1 oro
        this.material = material;
        if (material.equalsIgnoreCase("Oro")) {
            this.produccionPorTurno = 2; // oro siempre 2
        } else {
            this.produccionPorTurno = dadoA.lanzar();
        }
    }

    public String getMaterial() { return material; }

    public int getProduccionPorTurno() { return produccionPorTurno; }

    @Override
    public String toString() {
        return super.toString() + " | Material=" + material +
                " | Producción=" + produccionPorTurno + "/turno";
    }
}