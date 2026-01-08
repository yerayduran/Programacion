package Boletin4.Ejercicio8;

import java.util.Scanner;

public class Ejercicio8 {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce una frase: ");
        String cadena = sc.nextLine();
        int numDePalabras = contarPalabra(cadena);
        System.out.printf("La frase que has colocado tiene %d palabra", numDePalabras);
    }

    public static int contarPalabra(String cadena){
        String[] cadenaPorPartes = cadena.split(" ");
        int contador = cadenaPorPartes.length;

        for (int i = 0; i < cadenaPorPartes.length; i++){
            if(cadenaPorPartes[i].isBlank()){
                contador++;
            }
        }
        return contador;
    }
}
