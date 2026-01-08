package Boletin2Parte1;

import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);



        int numeroSecreto = (int)(Math.random() * 100 + 1);
        int intentos = 0;
        final int MAX_INTENTOS = 5;
        boolean acertado = false;


        System.out.println("¡Bienvenido al juego de adivinar el número secreto!");
        System.out.println("Tienes 5 intentos para acertar un número entre 1 y 100.");


        while (intentos < MAX_INTENTOS && !acertado) {
            System.out.print("Introduce tu intento " + (intentos + 1) + "/5 : ");
            int numeroUsuario = scanner.nextInt();


            if (numeroUsuario < 1 || numeroUsuario > 100) {
                System.out.println("El número debe estar entre 1 y 100.");
                intentos++;
                continue;
            }


            if (numeroUsuario == numeroSecreto) {
                System.out.println("¡Felicidades! Has acertado el número secreto.");
                acertado = true;
            } else if (numeroUsuario < numeroSecreto) {
                System.out.println("El número secreto es mayor que " + numeroUsuario);
                intentos++;
            } else {
                System.out.println("El número secreto es menor que " + numeroUsuario);
                intentos++;
            }
        }


        if (!acertado) {
            System.out.println("Has agotado tus intentos. El número secreto era: " + numeroSecreto);
        }
    }
}