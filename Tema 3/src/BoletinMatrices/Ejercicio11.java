package BoletinMatrices;

public class Ejercicio11 {
    public static boolean comprobarSiTienenMatricesInversas(int[][] matrizA, int[][] matrizB) {
        if (matrizA.length != matrizB.length || matrizA[0].length != matrizB[0].length) {
            return false;
        }

        for (int i = 0; i < matrizA.length; i++) {
            for (int j = 0; j < matrizA[0].length; j++) {
                if (matrizA[i][j] != matrizB[matrizA.length - 1 -i][matrizA[0].length - 1 - j]) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        int[][] matrizA = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] matrizB = {{9, 8, 7}, {6, 5, 4}, {3, 2, 1}};
        int[][] matrizC = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        System.out.println("¿Matriz A y B son inversas?: " + comprobarSiTienenMatricesInversas(matrizA, matrizB));
        System.out.println("¿Matriz A y C son inversas?: " + comprobarSiTienenMatricesInversas(matrizA, matrizC));
    }
}
