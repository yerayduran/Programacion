package Boletin2;

import java.util.Scanner;


public class Ejercicio3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduce 5 numeros");
        int n1 = scanner.nextInt();
        System.out.println("otro");
        int n2 = scanner.nextInt();
        System.out.println("otro");
        int n3 = scanner.nextInt();
        System.out.println("otro");
        int n4 = scanner.nextInt();
        System.out.println("otro");
        int n5 = scanner.nextInt();
        if (n1 % 2 == 0) {
            System.out.println("Este número es par");
        } else {
            System.out.println("Es impar");
        }
        if (n2 % 2 == 0) {
            System.out.println("Este número es par");
        } else {
            System.out.println("Es impar");
        }
        if (n3 % 2 == 0) {
            System.out.println("Este número es par");
        } else {
            System.out.println("Es impar");
        }
        if (n4 % 2 == 0) {
            System.out.println("Este número es par");
        } else {
            System.out.println("Es impar");
        }
        if (n5 % 2 == 0) {
            System.out.println("Este número es par");
        } else {
            System.out.println("Es impar");
        }
        scanner.close();
    }

}
