package BoletinMatrices;

public class Ejercicio4{

    public static void imprimirPorFilas(int[][] matriz) {
        for (int i = matriz.length - 1; i >= 0; i--) {
            for (int j = matriz[i].length - 1; j >=0; j--) {
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
