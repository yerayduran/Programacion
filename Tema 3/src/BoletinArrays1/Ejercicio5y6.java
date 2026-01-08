package BoletinArrays1;

import java.util.Scanner;

public class Ejercicio5y6 {
    public static boolean contiene(int[] arr, int valor) {  // comprueba si el array contiene el valor
        for (int x : arr) {
            if (x == valor) return true;
        }
        return false;

    }
    public static void main(String[] args) {  // pide el tamaño del array
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca las posiciones que tendrá el array: ");
        while (!sc.hasNextInt()) {
            System.out.println("Entrada no válida. Introduzca un entero positivo.");
            sc.next();
            System.out.print("Introduzca las posiciones que tendrá el array: ");
        }
        int i = sc.nextInt();
        if (i <= 0) {
            System.out.println("El array debe tener al menos una posición.");
            return;
        }
        generaYmuestraArray(i);
        sc.close();
    }


    public static void generaYmuestraArray(int tamaño) {  // genera y muestra el array
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[tamaño];
        for (int i = 0; i < tamaño; i++) {

            arr[i] = (int) (Math.random() * 1001);

        }


        System.out.print("[");
        for (int i = 0; i < arr.length; i++) {

            System.out.print(arr[i]);

            if (i < arr.length - 1) {

                System.out.print(", ");
            }

        }
        System.out.println("]");

        System.out.print("Introduce el valor a buscar: ");  // pide el valor a buscar
        int valor = sc.nextInt();
        sc.close();

        if (contiene(arr, valor)) {
            System.out.println("El array SÍ contiene el numero " + valor);
        } else {
            System.out.println("El array NO contiene el numero " + valor);
        }
    }
}
