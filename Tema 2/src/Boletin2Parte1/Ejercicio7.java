package Boletin2Parte1;

import java.util.Scanner;

public class Ejercicio7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Introduce el primer número (mayor que 0): ");
        int a = scanner.nextInt();

        System.out.print("Introduce el segundo número (mayor que 0): ");
        int b = scanner.nextInt();


        if (a <= 0 || b <= 0) {
            System.out.println("Ambos números deben ser mayores que 0.");
        } else {

            int originalA = a;
            int originalB = b;
            while (b != 0) {
                int resto = a % b;
                a = b;
                b = resto;
            }


            System.out.println("El MCD de " + originalA + " y " + originalB + " es: " + a);
        }
    }
}