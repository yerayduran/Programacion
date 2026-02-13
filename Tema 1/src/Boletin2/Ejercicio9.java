package Boletin2;

import java.util.Scanner;

public class Ejercicio9{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num;

        do {
            System.out.print("Introduce un número entero positivo: ");
            num = scanner.nextInt();
        } while (num <= 0);

        //Formula de numero perfecto 2^(n-1) x ( 2^n - 1 )


        int suma = 0;
        for (int i = 1; i < num; i++) {
            if (num % i == 0) suma += i;
        }

        if (suma == num) {
            System.out.println(num + " es un número perfecto.");
        } else {
            System.out.println(num + " no es un número perfecto.");
        }
    }
}