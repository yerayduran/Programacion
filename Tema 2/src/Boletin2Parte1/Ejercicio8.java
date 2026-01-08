package Boletin2Parte1;

import java.util.Scanner;

public class Ejercicio8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Introduce el coeficiente A: ");
        double a = scanner.nextDouble();

        System.out.print("Introduce el coeficiente B: ");
        double b = scanner.nextDouble();

        System.out.print("Introduce el coeficiente C: ");
        double c = scanner.nextDouble();


        if (a == 0) {
            System.out.println("No es una ecuación de segundo grado (A no puede ser 0).");
        } else {

            double discriminante = b * b - 4 * a * c;


            if (discriminante > 0) {
                double x1 = (-b + Math.sqrt(discriminante)) / (2 * a);
                double x2 = (-b - Math.sqrt(discriminante)) / (2 * a);
                System.out.println("La ecuación tiene dos soluciones reales:");
                System.out.println("x1 = " + x1);
                System.out.println("x2 = " + x2);
            } else if (discriminante == 0) {
                double x = -b / (2 * a);
                System.out.println("La ecuación tiene una única solución real:");
                System.out.println("x = " + x);
            } else {
                System.out.println("La ecuación no tiene soluciones reales.");
            }
        }
    }
}