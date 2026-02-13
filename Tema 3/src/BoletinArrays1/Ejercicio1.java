package BoletinArrays1;

public class Ejercicio1 {

    public static int posicionesPares(int[] a) {
        int suma = 0;
        for (int i = 0; i < a.length; i += 2) {
            suma += a[i];
        }
        return suma;
    }


    public static void main(String[] args) {
        int[] posiciones = {5, 8, -4, 10, 9, -7};
        System.out.println("Suma posiciones pares: " + posicionesPares(posiciones));
    }
}