package BoletinMatrices;

public class Ejercicio7 {
    public static boolean sonIguales(int[][] matriz1, int[][] matriz2) {
        if (matriz1.length != matriz2.length) {
            return false;
        }
        for (int i = 0; i < matriz1.length; i++) {
            if (matriz1[i].length != matriz2[i].length) {
                return false;
            }
            for (int j = 0; j < matriz1[i].length; j++) {
                if (matriz1[i][j] != matriz2[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        int[][] matrizA = {{1, 2, 3}, {4, 5, 6}};
        int[][] matrizB = {{1, 2, 3}, {4, 5, 6}};

        boolean resultado1 = sonIguales(matrizA, matrizB);
        System.out.println("¿Matriz A es igual a Matriz B?: " + resultado1);
    }
}