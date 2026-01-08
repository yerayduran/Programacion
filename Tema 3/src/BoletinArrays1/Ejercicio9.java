package BoletinArrays1;

public class Ejercicio9 {
    public static int posicionDe(int[] arr, int valor, boolean reverse) {
        if (arr == null || arr.length == 0) return -1; // caso nulo o vacío

        int[] copia = new int[arr.length];  // crear copia del array original
        for (int i = 0; i < arr.length; i++) {
            copia[i] = arr[i];
        }


        for (int i = 0; i < copia.length - 1; i++) {  // ordenar la copia
            for (int j = i + 1; j < copia.length; j++) {
                if ((reverse && copia[i] < copia[j]) || (!reverse && copia[i] > copia[j])) {
                    int temp = copia[i];
                    copia[i] = copia[j];
                    copia[j] = temp;
                }
            }
        }


        for (int i = 0; i < copia.length; i++) {    // buscar el valor en la copia ordenada
            if (copia[i] == valor) return i;
        }


        return -1;
    }

    public static void main(String[] args) {
        int[] datos = {5, -2, -9, 1, 7};
        System.out.println("Posición en orden ascendente: " + posicionDe(datos, 5, false));
        System.out.println("Posición en orden descendente: " + posicionDe(datos, 1, true));
    }
}