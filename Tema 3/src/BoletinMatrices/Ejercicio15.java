package BoletinMatrices;

import java.util.Scanner;

public class Ejercicio15 {
    public static void pedirNumeroYDevuelvaCoordenadasSinMatriz(int numero) {
        int filas = 5;
        int columnas = 6;
        boolean encontrado = false;

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                int valorActual = i * columnas + j + 1; // Generar valor basado en la posición
                if (valorActual == numero) {
                    System.out.println("El número " + numero + " se encuentra en la posición: (" + i + ", " + j + ")");
                    encontrado = true;
                    break;
                }
            }
            if (encontrado) {
                break;
            }
        }

        if (!encontrado) {
            System.out.println("El número " + numero + " no se encuentra en la matriz.");
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un número entre 1 y 30: ");
        int numero = scanner.nextInt();
        pedirNumeroYDevuelvaCoordenadasSinMatriz(numero);
        scanner.close();
    }
}   