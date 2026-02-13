package BoletinMatrices;

public class Ejercicio8 {

    public static int sumaResultante(int[][] matriz1, int[][] matriz2) {
        int[][] matrizResultado = new int[matriz1.length][matriz1[0].length];
        int sumaTotal = 0;

        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz1[0].length; j++) {
                matrizResultado[i][j] = matriz1[i][j] + matriz2[i][j];
                sumaTotal += matrizResultado[i][j];
            }
        }

        System.out.println("Matriz Resultante de la Suma:");
        for (int i = 0; i < matriz1.length; i++) {
            for (int j = 0; j < matriz1[0].length; j++) {
                System.out.print(matrizResultado[i][j] + " ");
            }
            System.out.println();
        }

        return sumaTotal;
    }
    public static void main(String[] args) {
        int[][] matrizA = {{1, 2, 3}, {4, 5, 6}};
        int[][] matrizB = {{7, 8, 9}, {10, 11, 12}};
        int suma = sumaResultante(matrizA, matrizB);
        System.out.println("Suma Total de los Elementos de la Matriz Resultante: " + suma);
    }
}