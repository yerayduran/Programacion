package Boletin1.Ejercicio1;

import java.util.Scanner;

public class Principal {
    static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Rectangulo r = new Rectangulo();


        System.out.println("Introduce la longitud del rectángulo: ");
        int numeroLongitud = sc.nextInt();

        while (numeroLongitud < 0 || numeroLongitud >= 20) {
            System.out.println("La longitud debe estar entre 0 y 20: ");
            numeroLongitud = sc.nextInt();
        }

        System.out.println("Introduce el ancho del rectángulo: ");
        int numeroAncho = sc.nextInt();

        while (numeroAncho < 0 || numeroAncho >= 20) {
            System.out.println("El ancho debe estar entre 0 y 20: ");
            numeroAncho = sc.nextInt();
        }

        r.setAncho(numeroAncho);
        r.setLongitud(numeroLongitud);

        System.out.printf("Las medidas del rectangulo son: %n> Longitud = %d%n> Ancho = %d%n> Perimetro = %d%n> Areá = %d", numeroLongitud, numeroAncho, r.perimetroRectangulo(),r.areaRectangulo());
    }
}