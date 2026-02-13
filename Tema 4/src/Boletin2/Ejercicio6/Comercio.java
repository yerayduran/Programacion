package Boletin2.Ejercicio6;

import Ejercicio6.Exception.ProductoException;

import java.util.Scanner;

public class Comercio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Producto p = null;
        while(p == null){
            System.out.printf("Introduce el producto: ");
            String descripcion = sc.nextLine();
            System.out.printf("Introduce precio sin IVA: ");
            double precio = sc.nextDouble();

            p = new Producto(descripcion, precio);
            p.mostrarInfo();
            sc.close();
        }

    }
}
