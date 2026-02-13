package Boletin2;

import java.util.Scanner;

public class Ejercicio8{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int menor = Integer.MAX_VALUE;
        String respuesta;


        do {

            System.out.print("Introduce un número: ");
            int numero = scanner.nextInt();
            if (numero < menor) menor = numero;



            do {

                System.out.print("¿Desea introducir más números (S/N)? ");
                respuesta = scanner.next().toUpperCase();
            } while (!respuesta.equals("S") && !respuesta.equals("N"));


        } while (respuesta.equals("S"));


        System.out.println("El menor número introducido fue: " + menor);

    }
}