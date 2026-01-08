package BoletinMatrices;

public class Ejercicio10 {
    public static boolean matrizEsSimetricaAlEjeY(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length / 2; j++) {
                if (matriz[i][j] != matriz[i][matriz[0].length - 1 - j]) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[][] matriz1 = {{1, 2, 1}, {4, 5, 4}, {7, 8, 7}};
        int[][] matriz2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        System.out.println("¿Matriz 1 es Simetrico?: " + matrizEsSimetricaAlEjeY(matriz1));
        System.out.println("¿Matriz 2 es Simetrico?: " + matrizEsSimetricaAlEjeY(matriz2));
    }
}