package BoletinArrays1;

public class Ejercicio10 {

    public static int[] eliminarDuplicados(int[] arr) {
        if (arr == null || arr.length == 0) return new int[0];
        int[] temp = new int[arr.length];
        int contador = 0;
        for (int i = 0; i < arr.length; i++) {
            boolean repetido = false;
            for (int j = 0; j < contador; j++) {
                if (arr[i] == temp[j]) {
                    repetido = true;
                    break;
                }
            }
            if (!repetido) {
                temp[contador] = arr[i];
                contador++;
            }
        }


        int[] resultado = new int[contador];
        for (int i = 0; i < contador; i++) {
            resultado[i] = temp[i];
        }
        return resultado;
    }

    public static void main(String[] args) {
        int[] original = {-4, 0, -4, 3, 0, 1, 3, 5};
        int[] sinDuplicados = eliminarDuplicados(original);

        System.out.print("Array sin duplicados: [");
        for (int i = 0; i < sinDuplicados.length; i++) {
            System.out.print(sinDuplicados[i]);
            if (i < sinDuplicados.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}