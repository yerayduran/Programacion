package BoletinMatrices;

public class Ejercicio14 {
public static boolean transformarFilasPorColumnasYViceversa(int[][] matriz) {
    if (matriz.length != matriz[0].length) {
        return false;
    }

    for (int i = 0; i < matriz.length; i++) {
        for (int j = i + 1; j < matriz[0].length; j++) {
            int temp = matriz[i][j];
            matriz[i][j] = matriz[j][i];
            matriz[j][i] = temp;
        }
    }
    return true;
}
public static void main(String[] args) {
    int[][] matriz = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

    System.out.println("Matriz original:");
    for (int[] x : matriz) {
        for (int elemento : x) {
            System.out.print(elemento + " ");
        }
        System.out.println();
    }

    if (transformarFilasPorColumnasYViceversa(matriz)) {
        System.out.println("Matriz transpuesta:");
        for (int[] x : matriz) {
            for (int elemento : x) {
                System.out.print(elemento + " ");
            }
            System.out.println();
        }
    } else {
        System.out.println("La matriz no es cuadrada, no se puede transponer.");
    }
}
}

