package Boletin2.Ejercicio2;

public class CirculoMovible extends Circulo implements Animable{

    public CirculoMovible(double radio) {
        super(radio);
    }

    @Override
    public void dibujar() {
        System.out.println("Dibujando Circulo");
    }


    @Override
    public void animar() {
        System.out.println("Animando Circulo");
    }
}
