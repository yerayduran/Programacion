package Boletin2Parte1;

public class Ejercicio9 {
    public static void main(String[] args) {

        for (int tabla = 0; tabla <= 10; tabla++) {
            System.out.println("Tabla del " + tabla);

            for (int i = 0; i <= 10; i++) {
                System.out.println(tabla + " x " + i + " = " + (tabla * i));
            }
            System.out.println();
        }
    }
}