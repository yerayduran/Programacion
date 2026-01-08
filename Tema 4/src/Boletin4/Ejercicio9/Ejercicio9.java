package Boletin4.Ejercicio9;

import java.util.Scanner;

public class Ejercicio9 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce una frase que contenga varios numero enteros: ");
        String cadena = sc.nextLine();
        System.out.printf("El total de los digitos en la frase son de %d en total",sumarNumeros(cadena));
    }

    public static int sumarNumeros(String cadena) {

        StringBuilder sb = new StringBuilder();
        int suma = 0;

        for (int i = 0; i < cadena.length(); i++) {
            if (Character.isDigit(cadena.charAt(i))) {
                sb.append(cadena.charAt(i));
            } else if (cadena.charAt(i) == ' ' && sb.length() > 0) {
                String digitos = sb.toString();
                suma += Integer.parseInt(digitos);
                sb.setLength(0);
            }
        }
        if (sb.length() > 0) {
            String digitos = sb.toString();
            suma += Integer.parseInt(digitos);
        }
        return suma;
    }
}