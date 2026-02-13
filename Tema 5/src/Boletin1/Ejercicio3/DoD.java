package Boletin1.Ejercicio3;

import Boletin1.Ejercicio3.Exception.PersonajeException;

public class DoD {
    static void main(String[] args) {
        try{
            Mago mago1 = new Mago("Yeray", Raza.ORCO, 12, 19, 80, 55);
            mago1.aprendeHechizo("Virgen Supremo");
            mago1.aprendeHechizo("Abadra cadabra");

            Mago mago2 = new Mago("Manuel", Raza.HUMANO, 8, 18, 90, 70);
            mago2.aprendeHechizo("Permatrago");

            System.out.println(" ");
            System.out.println("-------------------------------------------Dungeons of Dragons-------------------------------------------");
            System.out.println(mago1);
            System.out.println("------------------------------------------------------------------------------------------------------- ");
            System.out.println(mago2);
            System.out.println("------------------------------------------------------------------------------------------------------- ");

            Clerigo clerigo = new Clerigo("Bermudo", Raza.ELFO, 18, 15, 80, 30, "JesuCristo");

            mago1.lanzarHechizo(mago2, "Virgen Supremo");
            mago2.lanzarHechizo(mago1, "Permatrago");
            clerigo.curar(mago2);
            mago1.lanzarHechizo(mago2, "Abadra cadabra");

            System.out.println("------------------------------------------------------------------------------------------------------- ");
            System.out.println("----------------------------------------------- 1º Ronda -----------------------------------------------");
            System.out.println(mago1);
            System.out.println("------------------------------------------------------------------------------------------------------- ");
            System.out.println(mago2);
            System.out.println("------------------------------------------------------------------------------------------------------- ");
            System.out.println(clerigo);
            System.out.println("------------------------------------------------------------------------------------------------------- ");

        } catch (PersonajeException e) {
            System.out.println(e.getMessage());
        }
    }
}