package BoletinMatrices;

public class Ejercicio5 {

    public static void imprimirPorColumnas(int[][] matriz) {
        if (matriz.length == 0) return;

        for (int j = 0; j < matriz[0].length; j++) {
            for (int i = 0; i < matriz.length; i++) {
                System.out.print(matriz[i][j] + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] muestra = {{1, 3, 5}, {2, 2, 7}};

        System.out.print("La salida es: ");
        imprimirPorColumnas(muestra);
    }
}