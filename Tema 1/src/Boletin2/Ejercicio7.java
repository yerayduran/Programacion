package Boletin2;

import java.util.Scanner;

public class Ejercicio7{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cantidad;


        do {
            System.out.print("¿Cuántos números deseas introducir? ");
            cantidad = scanner.nextInt();
        } while (cantidad <= 0);


        int suma = 0;


        for (int i = 1; i <= cantidad; i++) {
            System.out.print("Número " + i + ": ");
            suma += scanner.nextInt();
        }


        double media = (double) suma / cantidad;
        System.out.println("La media es: " + media);
    }
}