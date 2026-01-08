package Boletin2Parte1;

import java.util.Scanner;

public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Introduce un número: ");
        int numero = scanner.nextInt();


        numero = Math.abs(numero);


        int cifras = (numero == 0) ? 1 : (int) Math.log10(numero) + 1;


        System.out.println("El número " + numero + " tiene " + cifras + " cifras.");
    }
}