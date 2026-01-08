package Interfaces;

public class FicheroTextoPlano extends FicheroTexto implements IRepresentable  {

    public FicheroTextoPlano(String nombre, String[] parrafos) {
        super(nombre, parrafos);
    }

    @Override
    public void mostrar() {
        for (int i = 0; i < this.getParrafos().length; i++) {
            System.out.println(this.getParrafos()[i]);
        }
    }
}
