package Interfaces;

import java.time.LocalDate;

public abstract class Fichero {

    private String nombre;
    private LocalDate fechaDeCreacion;

    public Fichero(String nombre) {
        this.nombre = nombre;
        this.fechaDeCreacion = LocalDate.now();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public void setFechaDeCreacion(LocalDate fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public abstract long getTamaño();

    @Override
    public final String toString() {
        return "Fichero {" +
                "Nombre = '" + nombre + '\'' +
                ", Fecha de Creacion=" + fechaDeCreacion + ", Tamaño = " + getTamaño() +
                '}';
    }
}
