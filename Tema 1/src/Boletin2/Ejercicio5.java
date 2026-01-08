package Boletin2;

import java.util.Scanner;

public class Ejercicio5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int contador = 0;

        int numero;
        do {
            System.out.print("Introduce un número (negativo para terminar): ");
            numero = scanner.nextInt();
            if (numero >= 0) {
                ++contador;
            }
        } while(numero >= 0);

        System.out.println("Has introducido " + contador + " números positivos");
        scanner.close();
    }
}