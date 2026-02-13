package BucleWhile;

import java.util.Scanner;

public class Divisor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce un número entero: ");
        int numero = scanner.nextInt();

        int divisor = 2;
        while (divisor <= numero) {
            if (numero % divisor == 0) {
                System.out.println("El primer divisor de " + numero + " es: " + divisor);
                break;
            }
            divisor++;
        }

        scanner.close();
    }
}