package Boletin4.Ejercicio1;

import Boletin1.Ejercicio2.MiEntradaSalida;

public class Ejercicio1 {
    public static void main(String[] args) {

        String palabra = MiEntradaSalida.solicitarCadena("Introduce una cadena: ");
        char caracter = MiEntradaSalida.solicitarCaracter("Introduce el caracter: ");

        int vecesAparece = contarCaracter(palabra.toLowerCase(), caracter = Character.toLowerCase(caracter));
        System.out.println("En la frase " + palabra + " aparece " + caracter + " " + vecesAparece + " veces");
    }

    public static int contarCaracter(String cadena, char caracter) {
        int vecesAparece = 0;

        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) == caracter) {
                vecesAparece++;
            }
        }
        return vecesAparece;
    }
}