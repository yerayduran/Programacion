package BoletinMatrices;

public class Ejercicio2 {

    public static int sumarMatriz(int[][] matriz) {
        int suma = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                suma += matriz[i][j];
            }
        }
        return suma;
    }

    public static void main(String[] args) {
        int[][] muestra = {{1, 21, -3}, {42, -5, 6}, {7, 18, 9}, {-10, 11, 12}};

        int total = sumarMatriz(muestra);
        System.out.println("La suma total de la matriz es: " + total);
    }
}