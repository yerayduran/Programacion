package BoletinArrays1;

public class Ejercicio11 {
    public static int[] interseccion(int[] arr1, int[] arr2) {
        if (arr1 == null || arr2 == null) return new int[0];


        int[] temp = new int[Math.min(arr1.length, arr2.length)];
        int contador = 0;

        for (int i = 0; i < arr1.length; i++) {  // recorrer arr1
            int valor = arr1[i];
            if (existeEnArray(arr2, valor) && !existeEnArray(temp, valor, contador)) { // si está en arr2 y no en temp
                temp[contador++] = valor;
            }
        }

        int[] resultado = new int[contador];  // tamaño exacto
        for (int i = 0; i < contador; i++) {
            resultado[i] = temp[i];
        }

        return resultado;
    }


    private static boolean existeEnArray(int[] arr, int valor) {  // busca en por el array
        for (int x : arr) {
            if (x == valor) return true;
        }
        return false;
    }


    private static boolean existeEnArray(int[] arr, int valor, int hasta) {  // busca hasta un índice
        for (int i = 0; i < hasta; i++) {
            if (arr[i] == valor) return true;
        }
        return false;
    }

    public static void main(String[] args) { // prueba del función
        int[] a = {1, 2, 3, 4, 5, 5};
        int[] b = {3, 4, 4, 5, 6, 7};

        int[] comunes = interseccion(a, b);

        System.out.print("Elementos comunes: [");
        for (int i = 0; i < comunes.length; i++) {
            System.out.print(comunes[i]);
            if (i < comunes.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}