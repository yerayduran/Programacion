package Boletin4.Ejercicio3;

import java.util.Scanner;

public class Palindromo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce una palabra o frase:");
        String entrada = sc.nextLine();

        if (esPalindromo(entrada)) {
            System.out.println("Es un palíndromo");
        } else {
            System.out.println("Pon otra frase anda que la que has puesto no es un Boletin4.Ejercicio3.Palindromo");
        }
        sc.close();
    }

    public static boolean esPalindromo(String cadena){
        cadena = cadena.replaceAll("\\s+", "").toLowerCase();

        for(int i = 0; i < cadena.length()/2; i++){
            if (cadena.charAt(i) != cadena.charAt(cadena.length() - i - 1)){
                return false;
            }
        }
        return true;
    }

}