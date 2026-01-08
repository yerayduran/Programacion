package Boletin2Parte2;

import java.util.Scanner;
public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numero, numeroOriginal, resto, inverso;
        inverso = 0;
        System.out.print("Introduce un número entero positivo: ");
        numero = Integer.parseInt(scanner.nextLine());
        numeroOriginal = numero;
        scanner.close();

        while (numero > 0) {
            resto = numero % 10;
            numero = numero / 10;
            inverso = inverso * 10;
            inverso = inverso + resto;
        }

        if (numeroOriginal == inverso) {
            System.out.printf("El número %d es capicúa", numeroOriginal);
        }

        else {
            System.out.printf("El número %d NO es capicúa", numeroOriginal);
        }
    }
}
