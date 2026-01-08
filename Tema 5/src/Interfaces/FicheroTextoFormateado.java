package Interfaces;

public class FicheroTextoFormateado extends FicheroTexto implements IAnalizable {

    private Fuente fuente;
    private long tamaño;
    private String color;

    public FicheroTextoFormateado(String nombre, String[] parrafos, Fuente fuente, long tamaño, String color) {
        super(nombre, parrafos);
        this.fuente = fuente;
        this.tamaño = tamaño;
        this.color = color;
    }

    public Fuente getFuente() {
        return fuente;
    }

    public void setFuente(Fuente fuente) {
        this.fuente = fuente;
    }

    public void analizar(){
        System.out.println("Analizando el fichero " + this.getNombre());
    }
}
