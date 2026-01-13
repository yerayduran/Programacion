package BoletinExtra.Ejercicio2;

public class Lampara implements Encendible{

    @Override
    public void apagar() {
        System.out.println("La lámpara esta apagada");
    }

    @Override
    public void encender() {
        System.out.println("La lámpara esta encendida");
    }
}
