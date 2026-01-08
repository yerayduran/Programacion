package Interfaces;

public abstract class FicheroTexto extends PC implements ILeible{

    private String[] parrafos;

    public FicheroTexto(String nombre, String[] parrafos) {
        super(nombre);
        this.parrafos = parrafos;
    }

    public String[] getParrafos() {
        return parrafos;
    }

    public void setParrafos(String[] parrafos) {
        this.parrafos = parrafos;
    }

    public long getTamaño(){
        long contador = 0;
        for (int i = 0; i < parrafos.length; i++) {
            contador += parrafos[i].length();
        }
        return contador;
    }

    public String leer(){

    }
}
