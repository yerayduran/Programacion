package Boletin4.Ejercicio4;

import java.util.Scanner;

public class palabraEscondida {

    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce una frase");
        String cadena = sc.nextLine();
        System.out.println("Introduce una palabra a buscar: ");
        String palabraOculta = sc.nextLine();
        System.out.println(encontrarPalabraOculta(cadena, palabraOculta));
    }

    public static boolean encontrarPalabraOculta(String cadena, String palabraOculta){

        int indice = 0;

        for (int i = 0; i < palabraOculta.length(); i++){
            indice = cadena.indexOf(palabraOculta.charAt(i), indice);

            if(indice == -1){
                return false;
            }
        }
        return true;
    }
}
