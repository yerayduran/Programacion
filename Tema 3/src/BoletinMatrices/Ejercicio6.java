package BoletinMatrices;

public class Ejercicio6{

    public static void imprimirPorFilas(int[][] matriz) {
        for (int j = matriz[0].length - 1; j >= 0; j--) {
            for (int i = matriz.length - 1; i >=0; i--) {
                System.out.print(matriz[i][j] + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] muestra = {{1, 3, 8}, {2, 2, 7}};

        System.out.print("La salida es: ");
        imprimirPorFilas(muestra);
    }
}
