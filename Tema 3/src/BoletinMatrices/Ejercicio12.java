package BoletinMatrices;

public class Ejercicio12 {
    public static boolean matrizCuadradaTranspuesta(int[][] matriz) {
        if (matriz.length != matriz[0].length) {
            return false;
        }

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[j][i] + " ");
            }
            System.out.println();
        }
        return true;
    }
    public static void main(String[] args) {
        int[][] matriz1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matriz2 = {{1, 2, 3}, {4, 5, 6}};

        System.out.println("Matriz 1 transpuesta:");
        if (!matrizCuadradaTranspuesta(matriz1)) {
            System.out.println("La matriz no es cuadrada.");
        }

        System.out.println("Matriz 2 transpuesta:");
        if (!matrizCuadradaTranspuesta(matriz2)) {
            System.out.println("La matriz no es cuadrada.");
        }
    }
}
