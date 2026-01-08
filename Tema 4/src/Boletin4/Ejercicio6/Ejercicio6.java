package Boletin4.Ejercicio6;

import java.util.Scanner;

public class Ejercicio6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la palabra o frase para saber el número de vocales distintas: ");
        String cadena = sc.nextLine();

        int numDeVeces = cantidadDeVocales(cadena);
        System.out.printf("La cantidad de vocales distintas es: %d%n", numDeVeces);
    }

    public static int cantidadDeVocales(String cadena) {
        String cadenaSinEspacios = cadena.replaceAll("\\s+", "").toLowerCase();
        String vocales = "aeiou";

        boolean[] vocalesEncontradas = new boolean[vocales.length()];
        int numeroVocalesDistintas = 0;

        for (int i = 0; i < cadenaSinEspacios.length(); i++) {
            char c = cadenaSinEspacios.charAt(i);
            int indice = vocales.indexOf(c);

            if (indice != -1 && !vocalesEncontradas[indice]) {
                vocalesEncontradas[indice] = true;
                numeroVocalesDistintas++;
            }
        }
        return numeroVocalesDistintas;
    }
}