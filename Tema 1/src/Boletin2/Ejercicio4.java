package Boletin2;

import java.util.Scanner;

public class Ejercicio4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N;
        do {
            System.out.print("Introduce un número positivo: ");
            N = scanner.nextInt();
        } while(N <= 0);

        int suma = 0;

        for(int i = 1; i <= N; ++i) {
            suma += i;
        }

        System.out.println("La suma de los " + N + " primeros números es: " + suma);
        scanner.close();
    }
}
