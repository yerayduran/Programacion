package Interfaces;

public class FicheroImagen extends FicheroBinario{

    private Formato formato;

    public FicheroImagen(String nombre, Byte[] bytes, Formato formato) {
        super(nombre, bytes);
        this.formato = formato;
    }

    public Formato getFormato() {
        return formato;
    }

    public void setFormato(Formato formato) {
        this.formato = formato;
    }

    @Override
    public String leer() {
        return "";
    }
}
