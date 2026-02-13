package BoletinArrays1;

public class Ejercicio2 {

    public static int contarNegativos(int[] a) {
        int contador = 0;
        for (int x : a) {
            if (x < 0) contador++;
        }
        return contador;
    }


    public static void main(String[] args) {
        int[] negativos = {-5, 3, -2, -1, 7, -10};
        System.out.println("Negativos: " + contarNegativos(negativos));
    }
}