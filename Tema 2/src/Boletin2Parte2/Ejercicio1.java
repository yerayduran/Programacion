package Boletin2Parte2;

import java.util.Scanner;


    public class Ejercicio1 {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            int numero, resto, inverso;
            inverso = 0;
            System.out.print("Introduce un número entero positivo: ");
            numero = Integer.parseInt(scanner.nextLine());
            scanner.close();

            while (numero > 0) {
                resto = numero % 10;
                numero = numero / 10;
                inverso *= 10;
                inverso += resto;
            }

            System.out.printf("El número espejo %d de es %d ", numero, inverso);
    }
}