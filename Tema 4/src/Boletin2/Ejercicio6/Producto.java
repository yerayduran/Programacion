package Boletin2.Ejercicio6;

import Ejercicio6.Exception.ProductoException;

public class Producto {

    private int idProducto;
    private String descripcion;
    private double precio;

    private static int contadorId = 1;
    private static double IVA = 0.2;

    public Producto(String descripcion, double precio){
        this.descripcion = descripcion;
        this.precio = precio;
        this.idProducto = contadorId++;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio)  throws ProductoException{
        if (precio <= 0){
            throw new ProductoException("Error: El precio no puede ser ni gratis ni negativo");
        }
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public static double getIVA(){
        return IVA;
    }

    public double precioVenta(){
        return precio * (1 + getIVA());
    }

    public void mostrarInfo(){
        System.out.println("Boletin2.Boletin4.Ejercicio6.Ejercicio6.Producto: " + this.descripcion);
        System.out.println("Precio sin IVA: " + this.precio);
        System.out.println("Precio con IVA: " + this.precioVenta());
    }
}