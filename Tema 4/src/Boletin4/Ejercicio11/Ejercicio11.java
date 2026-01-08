package Boletin4.Ejercicio11;

import Boletin1.Ejercicio2.MiEntradaSalida;

public class Ejercicio11 {

    static void main(String[] args) {
        buscarLetra("Murcielago");
    }

    public static void buscarLetra(String cadena) {
        cadena = cadena.toLowerCase();
        int numFallos = 0;
        int numAciertos = 0;
        char[] progreso = new char[cadena.length()];

        for (int i = 0; i < progreso.length; i++) {
            progreso[i] = '_';
        }

        do {
            System.out.println("Palabra: " + String.valueOf(progreso));
            char letra = MiEntradaSalida.solicitarCaracter("Introduce la letra: ");

            boolean acierto = false;
            boolean repetida = false;

            for (int i = 0; i < cadena.length(); i++) {
                if (cadena.charAt(i) == letra) {
                    if (progreso[i] == letra) {
                        repetida = true;
                    } else {
                        progreso[i] = letra;
                        numAciertos++;
                        acierto = true;
                    }
                }
            }

            if (repetida) {
                System.out.println("Ya habías acertado esa letra.");
            } else if (acierto) {
                System.out.println("¡Bien hecho!");
            } else {
                System.out.println("Fallaste.");
                numFallos++;
            }

            if (numFallos == 7) {
                System.out.println("Has perdido mira que te lo deje a huevo. La palabra era: " + cadena);
            } else if (numAciertos == cadena.length()) {
                System.out.println("¡Has ganado! En un futuro te lo pondre más dificil");
            }

        } while (numFallos != 7 && numAciertos < cadena.length());
    }
}