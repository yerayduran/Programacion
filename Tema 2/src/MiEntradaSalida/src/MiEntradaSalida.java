package MiEntradaSalida.src;

import java.util.Scanner;

public class MiEntradaSalida {
    private static Scanner sc = new Scanner(System.in);



    public static int leerEntero(String mensaje) {
        System.out.print("Introduce un número: ");
        return sc.nextInt();
    }


    static void main(String[] args) {
        int b = MiEntradaSalida.leerEntero("Introduce un número positivo");
        while(b<0) {
            System.out.printf(b + ", no es un numero positivo");
            b = sc.nextInt();
        }
        if(b>0) {
            System.out.printf(b + ", Es positivo");
            b = sc.nextInt();

        }

    }

}