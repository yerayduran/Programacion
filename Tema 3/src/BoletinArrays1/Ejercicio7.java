package BoletinArrays1;

public class Ejercicio7 {
    public static boolean contieneElemento(int[] arr, int valor) {
        if (arr == null) return false;
        for (int x : arr) {
            if (x == valor) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] a = {7, 5, -3, 0, 2, 99, 21};
        System.out.println(contieneElemento(a, 7));
        System.out.println(contieneElemento(a, 100));

        int[] vacio = {-9, 0, 7, 1};
        System.out.println(contieneElemento(vacio, 0));

        System.out.println(contieneElemento(null, 1));
    }
}