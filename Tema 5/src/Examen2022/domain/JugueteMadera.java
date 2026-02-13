package Examen2022.domain;

public class JugueteMadera extends Juguete{

    private String origen;
    private int añoTala;

    public JugueteMadera(String nombre, String marca, String origen, int añoTala) {
        super(nombre, marca);
        this.origen = origen;
        this.añoTala = añoTala;
    }

    public String getOrigen() {
        return origen;
    }


    public int getAñoTala() {
        return añoTala;
    }
}
