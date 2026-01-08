package BoletinMatrices;

public class Ejercicio1 {

    public static boolean tieneNegativo(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] < 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] valores = {{1, 2, -3}, {4, 5, 6}, {-7, 8, 9}};

        boolean hayNegativo = tieneNegativo(valores);
        System.out.println("¿Contiene algún valor negativo?: " + hayNegativo);
    }
}