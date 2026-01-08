package Boletin1.Ejercicio6;

import Boletin1.Ejercicio3.Clerigo;
import Boletin1.Ejercicio3.Exception.PersonajeException;
import Boletin1.Ejercicio3.Mago;
import Boletin1.Ejercicio3.Raza;

public class Main {
    public static void main(String[] args) throws PersonajeException {

        ArrayPersonaje lista = new ArrayPersonaje();

        lista.add(new Mago("Yeray", Raza.ORCO, 12, 19, 80, 55));
        lista.add(new Clerigo("Bermudo", Raza.ELFO, 18, 15, 80, 30, "JesuCristo"));
        lista.add(new Mago("Manuel", Raza.HUMANO, 8, 18, 90, 40));

        System.out.println("Personajes: " + lista);

        System.out.println(" ");
        System.out.println("Puntos mínimos: " + lista.minimo());
        System.out.println("Puntos máximos: " + lista.maximo());
        System.out.println("Media de puntos: " + lista.media());
    }
}
