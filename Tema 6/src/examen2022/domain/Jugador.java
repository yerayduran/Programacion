package examen2022.domain;

public class Jugador extends Cromo {

    private String equipoQueJuega;
    private int altura;

    public Jugador(int id, String nombre, String equipoQueJuega, int altura) {
        super(id, nombre);
        this.equipoQueJuega = equipoQueJuega;
        this.altura = altura;
    }

    public String getEquipoQueJuega() {
        return equipoQueJuega;
    }

    public int getAltura() {
        return altura;
    }
}
