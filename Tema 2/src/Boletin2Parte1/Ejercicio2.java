package Boletin2Parte1;

import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int base, exponente;



        do {
            System.out.print("Introduce la base (entero positivo o 0): ");
            base = scanner.nextInt();
            if (base < 0) {
                System.out.println("La base debe ser un número entero positivo o 0.");
            }
        } while (base < 0);



        do {
            System.out.print("Introduce el exponente (entero positivo o 0): ");
            exponente = scanner.nextInt();
            if (exponente < 0) {
                System.out.println("El exponente debe ser un número entero positivo o 0.");
            }
        } while (exponente < 0);



        int resultado = 1;
        for (int i = 0; i < exponente; i++) {
            resultado *= base;
        }

        System.out.println(base + " elevado a " + exponente + " es: " + resultado);
    }
}