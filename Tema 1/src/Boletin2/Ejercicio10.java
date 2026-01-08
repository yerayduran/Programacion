package Boletin2;

import java.util.Scanner;

public class Ejercicio10{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero;

        do {
            System.out.print("Introduce un número entero positivo o cero: ");
            numero = scanner.nextInt();
        } while (numero < 0);

        long factorial = 1;
        for (int i = 2; i <= numero; i++) {
            factorial *= i;
        }

        System.out.println("El factorial de " + numero + " es: " + factorial);
    }
}