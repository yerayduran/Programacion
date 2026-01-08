package Interfaces;

public class FicheroEjecutable extends FicheroBinario implements IAnalizable{

    private int permisos;

    public FicheroEjecutable(String nombre, Byte[] bytes, int permisos) {
        super(nombre, bytes);
        this.permisos = permisos;
    }

    public int getPermisos() {
        return permisos;
    }

    public void setPermisos(int permisos) {
        this.permisos = permisos;
    }

    @Override
    public void analizar() {
        System.out.println("Analizando el fichero " + this.getNombre());
    }

    @Override
    public String leer() {
        return "";
    }
}
