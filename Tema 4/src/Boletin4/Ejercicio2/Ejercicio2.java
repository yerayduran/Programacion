package Boletin4.Ejercicio2;

import Boletin1.Ejercicio2.MiEntradaSalida;

public class Ejercicio2 {

    public static void main(String[] args) {

        String cadena = MiEntradaSalida.solicitarCadena("Introduce una cadena: ");

        int minuscula = contarMinuscula(cadena);
        int mayuscula = contarMayuscula(cadena);
        int numero = contarDigito(cadena);

        System.out.println("La cadena tiene " + minuscula + " minusculas, " + mayuscula + " mayusculas y " + numero + " digitos");
    }

    public static int contarMinuscula(String cadena){

        int contador = 0;

        for(int i = 0; i < cadena.length(); i++){
            if(Character.isLetter(cadena.charAt(i))){
                if(Character.isLowerCase(cadena.charAt(i))){
                    contador++;
                }
            }
        }
        return contador;
    }

    public static int contarMayuscula(String cadena){

        int contador = 0;

        for(int i = 0; i < cadena.length(); i++){
            if(Character.isLetter(cadena.charAt(i))){
                if(Character.isUpperCase(cadena.charAt(i))){
                    contador++;
                }
            }
        }
        return contador;
    }

    public static int contarDigito(String cadena){

        int contador = 0;

        for(int i = 0; i < cadena.length(); i++){
            if(Character.isDigit(cadena.charAt(i))){
                contador++;
            }
        }
        return contador;
    }
}
