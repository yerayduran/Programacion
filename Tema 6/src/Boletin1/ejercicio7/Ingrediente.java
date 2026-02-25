package Boletin1.ejercicio7;

import java.util.Objects;

public class Ingrediente {

    private String nombre;
    private int cantidad;

    public Ingrediente(String nombre, int cantidad) throws RecetaException {
        this.nombre = nombre.toUpperCase();
        setCantidad(cantidad);
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) throws RecetaException{
        if (cantidad <= 0) {
            throw new RecetaException("El cantidad debe ser mayor a 0");
        }
        this.cantidad = cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Ingrediente that)) return false;
        return Objects.equals(nombre, that.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nombre);
    }
}
