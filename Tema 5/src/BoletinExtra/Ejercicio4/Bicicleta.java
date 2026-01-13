package BoletinExtra.Ejercicio4;

public class Bicicleta extends Vehiculo implements Movibles{

    public Bicicleta(String nombre) {
        super(nombre);
    }

    @Override
    public void acelerar() {
        System.out.println("Acelerando bicicleta " +  this.getNombre());
    }

    @Override
    public void frenar() {
        System.out.println("Frenando bicicleta " +  this.getNombre());
    }
}
