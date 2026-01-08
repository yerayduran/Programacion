package BoletinMatrices;

public class Ejercicio13 {
    public static boolean matrizCuadradaTranspuestaInversa(int[][] matriz) {
        if (matriz.length != matriz[0].length) {
            return false;
        }

        for (int i = matriz.length - 1; i >= 0; i--) {
            for (int j = matriz[0].length - 1; j >= 0; j--) {
                System.out.print(matriz[j][i] + " ");
            }
            System.out.println();
        }
        return true;
    }
    public static void main(String[] args) {
        int[][] matriz1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matriz2 = {{1, 2, 3}, {4, 5, 6}};

        System.out.println("Matriz 1 transpuesta empezando por el final:");
        if (!matrizCuadradaTranspuestaInversa(matriz1)) {
            System.out.println("La matriz no es cuadrada.");
        }

        System.out.println("Matriz 2 transpuesta empezando por el final:");
        if (!matrizCuadradaTranspuestaInversa(matriz2)) {
            System.out.println("La matriz no es cuadrada.");
        }
    }
}