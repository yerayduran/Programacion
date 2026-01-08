package Boletin2Parte2;

import java.util.Scanner;

public class Ejercicio4{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Introduce la hora base: ");
        int hora = scanner.nextInt();
        System.out.print("Introduce los minutos base: ");
        int minutos = scanner.nextInt();
        System.out.print("Introduce los segundos base: ");
        int segundos = scanner.nextInt();


        System.out.print("¿Cuántas horas quieres sumar?: ");
        int sumaHoras = scanner.nextInt();
        System.out.print("¿Cuántos minutos quieres sumar?: ");
        int sumaMinutos = scanner.nextInt();
        System.out.print("¿Cuántos segundos quieres sumar?: ");
        int sumaSegundos = scanner.nextInt();


        segundos += sumaSegundos;
        minutos += segundos / 60;
        segundos = segundos % 60;


        minutos += sumaMinutos;
        hora += minutos / 60;
        minutos = minutos % 60;

        int dias = 0;
        hora += sumaHoras;
        boolean cambioDia = false;
        if (hora >= 24) {
            dias = hora / 24;
            hora = hora % 24;
            cambioDia = true;
        }


        System.out.printf("La hora resultante es: %02d:%02d:%02d", hora, minutos, segundos);
        if (cambioDia) {
            System.out.print(" (Han pasado " + dias + " día/s)");
        }
        System.out.println();
    }
}