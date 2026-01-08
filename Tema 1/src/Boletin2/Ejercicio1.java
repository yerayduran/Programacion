package Boletin2;

public class Ejercicio1 {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; i++) {
            boolean esMultiplo = false;

            if (i % 7 == 0) {
                System.out.println(i + " es múltiplo de 7");
                esMultiplo = true;
            }

            if (i % 13 == 0) {
                System.out.println(i + " es múltiplo de 13");
                esMultiplo = true;
            }

            if (esMultiplo) {
                System.out.println();
            }
        }
    }
}