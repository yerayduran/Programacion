package Boletin2;

import java.util.Scanner;

public class Ejercicio6{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Introduce el primer número (A): ");
        int numeroA = scanner.nextInt();


        System.out.print("Introduce el segundo número (B): ");
        int numeroB = scanner.nextInt();
        int producto = 0;


        for (int i = 0; i < Math.abs(numeroB); i++) {
            producto += numeroA;
        }

        if (numeroB < 0) producto = -producto;
        System.out.println("El producto es: " + producto);
    }
}