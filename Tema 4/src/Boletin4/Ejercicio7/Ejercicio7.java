package Boletin4.Ejercicio7;

import java.util.Scanner;

public class Ejercicio7 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce una frase para quitar sus vocales y desplazarla a la derecha: ");
        String cadena = sc.nextLine();

        StringBuilder fraseModificada = moverVocales(cadena);
        System.out.println(fraseModificada);
    }

    public static StringBuilder moverVocales(String cadena) {

        cadena = cadena.toLowerCase();
        StringBuilder fraseFinal = new StringBuilder();
        StringBuilder fraseVocales = new StringBuilder();
        StringBuilder fraseConsonante = new StringBuilder();

        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) == 'a' || cadena.charAt(i) == 'e' || cadena.charAt(i) == 'i' ||
                    cadena.charAt(i) == 'o' || cadena.charAt(i) == 'u') {

                fraseVocales.append(cadena.charAt(i));

            } else if (cadena.charAt(i) != ' '){

                fraseConsonante.append(cadena.charAt(i));
            }
        }
        fraseFinal.append(fraseConsonante).append(fraseVocales);
        return  fraseFinal;
    }
}