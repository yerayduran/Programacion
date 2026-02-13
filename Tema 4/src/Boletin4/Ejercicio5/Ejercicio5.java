package Boletin4.Ejercicio5;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio5 {

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce la frase: ");
        String frase = sc.nextLine();
        System.out.println("Introduce la palabra que quieres cambiar: ");
        String palabra = sc.nextLine();
        System.out.println("Introduce la palabra que quieres sustituir: ");
        String reemplazar = sc.nextLine();

        reemplazarTexto(frase, palabra, reemplazar);
    }

    public static void reemplazarTexto(String frase, String palabra, String reemplazar){

        frase = frase.toLowerCase();
        palabra = palabra.toLowerCase();
        reemplazar = reemplazar.toLowerCase();
        String[] porPartes = frase.split(" ");

        for(int i = 0; i < porPartes.length; i++){
            if(porPartes[i].equals(palabra)){
                porPartes[i] = reemplazar;
            }
        }
        System.out.println(Arrays.toString(porPartes));
    }
}
