package Pokemon2023.utils;

import java.util.Arrays;
import java.util.Scanner;

public class UserDataCollector {

    public static Scanner sc = new Scanner(System.in);

    /**
     * Muestra un mensaje por pantalla y solicita un entero. Repite la operación
     * hasta que se introduce un número entero válido
     *
     * @param mensaje El mensaje que se mostrará
     * @return el número introducido por el cliente
     */
    public static int getEntero(String mensaje) {
        System.out.print(mensaje + ": ");

        int entero = 0;
        boolean ok = false;

        while (!ok) {
            try {
                entero = Integer.parseInt(sc.nextLine());
                ok = true;
            } catch (NumberFormatException e) {
                System.out.print("Error. Introduce un número entero: ");
            }
        }

        return entero;
    }

    /**
     * Muestra un mensaje por pantalla y solicita un entero comprendido entre min y max.
     * Repite la operación hasta que se introduce un número entero comprendido entre min y max.
     *
     * @param mensaje El mensaje que se mostrará
     * @param min     El mínimo entero aceptado
     * @param max     El máximo entero aceptado
     * @return el número introducido por el cliente
     */
    public static int getEnteroMinMax(String mensaje, int min, int max) {
        int enteroIntroducido = UserDataCollector.getEntero(mensaje);
        while (enteroIntroducido < min || enteroIntroducido > max) {
            System.out.println("Por favor, introduce un número entre " + min + " y " + max);
            enteroIntroducido = UserDataCollector.getEntero(mensaje);
        }

        return enteroIntroducido;
    }
}


