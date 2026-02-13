package BoletinExtra.Ejercicio2;

public class Televisor implements Encendible{

    @Override
    public void encender() {
        System.out.println("El televisor esta encendido");
    }

    @Override
    public void apagar() {
        System.out.println("El televisor esta apagado");
    }
}
