package BoletinArrays1;

public class Ejercicio12 {
    public static void ordenarBurbuja(int[] arr) {
        if (arr == null || arr.length <= 1) return;

        boolean intercambiado;
        int n = arr.length;

        do {
            intercambiado = false;
            for (int i = 0; i < n - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];   // Intercambiar los elementos
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    intercambiado = true;
                }
            }
            n--; // Reducir el rango de comparación
        } while (intercambiado);
    }

    public static void main(String[] args) {
        int[] datos = {5, 2, -9,-1, 7};

        System.out.print("Array original: ");
        mostrarArray(datos);

        ordenarBurbuja(datos);

        System.out.print("Array ordenado: ");
        mostrarArray(datos);
    }

    // Modo auxiliar para mostrar el array
    public static void mostrarArray(int[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
            if (i < arr.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}