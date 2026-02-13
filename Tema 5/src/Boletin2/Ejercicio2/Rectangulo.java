package Boletin2.Ejercicio2;

public class Rectangulo extends Forma implements Dibujable{

    private double alto;
    private double ancho;

    public Rectangulo(double alto, double ancho) {
        this.alto = alto;
        this.ancho = ancho;
    }

    @Override
    public double calcularArea() {
        return (this.alto * this.ancho);
    }

    @Override
    public void dibujar() {
        System.out.println("Dibujando Rectangulo");
    }
}
