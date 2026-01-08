package Boletin2Parte2;

import java.util.Scanner;


public class Ejercicio3 {
    public static void main(String[] args) {
        final int M = 1000;
        final int D = 500;
        final int C = 100;
        final int L = 50;
        final int X = 10;
        final int V = 5;
        final int I = 1;
        Scanner scanner = new Scanner(System.in);
        String numRomano;
        int acumulado = 0;
        int temporal = 0;
        int anterior = Integer.MAX_VALUE;
        System.out.print("Introduce el número romano: ");
        numRomano = scanner.nextLine();


        for (int i = 0; i < numRomano.length(); i++) {
            char letraActual = numRomano.charAt(i);
            int valorDeLetra = 0;


            switch (letraActual) {
                case 'M': {
                    valorDeLetra = M;
                    break;
                }
                case 'D': {
                    valorDeLetra = D;
                    break;
                }
                case 'C': {
                    valorDeLetra = C;
                    break;
                }
                case 'L': {
                    valorDeLetra = L;
                    break;
                }
                case 'X': {
                    valorDeLetra = X;
                    break;
                }
                case 'V': {
                    valorDeLetra = V;
                    break;
                }
                case 'I': {
                    valorDeLetra = I;
                    break;
                }
            }


            if (valorDeLetra < anterior) {
                if (temporal > 0) {

                    acumulado += temporal;
                }

                temporal = valorDeLetra;
            } else if (valorDeLetra == anterior) {

                acumulado += temporal + valorDeLetra;
                temporal = 0;
            }
            else {
                acumulado += valorDeLetra - temporal;
                temporal = 0;
            }
            anterior = valorDeLetra;
        }
        if (temporal > 0) {
            acumulado += temporal;
        }


        System.out.printf("El número %s en decimal es %d", numRomano, acumulado);
    }
}