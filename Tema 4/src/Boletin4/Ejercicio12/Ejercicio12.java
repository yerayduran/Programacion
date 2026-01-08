package Boletin4.Ejercicio12;

import Boletin1.Ejercicio2.MiEntradaSalida;

public class Ejercicio12 {
    static void main(String[] args) {

        String cadena = MiEntradaSalida.solicitarCadena("Introduce el correo");
        int error = validarCorreo(cadena);

        if (error == -1) {
            System.out.println("El correo es inválido");

        } else {
            System.out.println("El correo es válido");
        }
    }

    public static int validarCorreo(String cadena){

        String[] usuario = cadena.split("@");

        for (int i = 0; i < usuario.length; i++) {
            if (!Character.isDigit(usuario[0].charAt(i)) && !Character.isLetter(usuario[0].charAt(i)) && usuario[0].charAt(i) != '.') {
                return -1;
            }
        }
        if (!Character.isLetter(usuario[0].charAt(0))) {
            return -1;
        }

        String[] organizacionFin = usuario[1].split("\\.");

        for (int i = 0; i < organizacionFin[0].length(); i++) {

            if (!Character.isDigit(organizacionFin[0].charAt(i)) && !Character.isLetter(organizacionFin[0].charAt(i))) {
                return -1;
            }
        }

        if (!Character.isLetter(organizacionFin[0].charAt(0))) {
            return -1;
        }

        for (int i = 0; i < organizacionFin[1].length(); i++) {

            if (!Character.isLetter(organizacionFin[1].charAt(i))) {
                return -1;
            }
        }

        if (organizacionFin[1].length() > 3 || organizacionFin[1].length() < 2) {
            return -1;
        }
        return 1;
    }
}
