package BoletinMatrices;

public class Ejercicio3 {

    public static void imprimirPorFilas(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
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