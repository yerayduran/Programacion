package Interfaces;

public class FicheroAudio extends FicheroBinario implements IReproducible {

    private int duracion;

    public FicheroAudio(String nombre, Byte[] bytes, int duracion) {
        super(nombre, bytes);
        this.duracion = duracion;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    @Override
    public void reproducir() {
        System.out.println("Reproduciendo " + super.getNombre());
    }

    @Override
    public String leer() {
        return "";
    }
}
