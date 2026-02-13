package BoletinExtra.Ejercicio4;

public class Autobus extends Vehiculo implements Cargable, Movibles{

    public Autobus(String nombre) {
        super(nombre);
    }

    @Override
    public void cargar() {
        System.out.println("Cargando pasajeros en el autobus " + this.getNombre());
    }

    @Override
    public void descargar() {
        System.out.println("Descargar pasajeros en el autobus " + this.getNombre());
    }

    @Override
    public void acelerar() {
        System.out.println("Acelerando el autobus " + this.getNombre());
    }

    @Override
    public void frenar() {
        System.out.println("Frenando el autobus " + this.getNombre());
    }
}
