package Examen2021Obj;

import java.util.Objects;

public class Libro {

    private String nombre;
    private String autor;
    private String sinopsis;
    private int numeroEjemplares;
    private int ejemplaresDisponibles;

    public Libro(String nombre, String sinopsis, String autor) {
        this.nombre = nombre;
        this.numeroEjemplares = 5;
        this.ejemplaresDisponibles = 2;
        this.sinopsis = sinopsis;
        this.autor = autor;
    }

    public String getNombre() {
        return nombre;
    }

    public String getAutor() {
        return autor;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public int getNumeroEjemplares() {
        return numeroEjemplares;
    }

    public int getEjemplaresDisponibles() {
        return ejemplaresDisponibles;
    }

    public void setNumeroEjemplares(int numeroEjemplares) {
        this.numeroEjemplares = numeroEjemplares;
    }

    public void setEjemplaresDisponibles(int ejemplaresDisponibles) {
        this.ejemplaresDisponibles = ejemplaresDisponibles;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return Objects.equals(nombre, libro.nombre) && Objects.equals(autor, libro.autor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, autor);
    }

    @Override
    public String toString() {
        return "Examen2021Obj.Libro{" + "nombre = '" + nombre + '\'' + ", autor = '" + autor + '\'' + ", sinopsis = '" + sinopsis + '\'' + ", nº de Ejemplares = " + numeroEjemplares + ", Ejemplares disponibles = " + ejemplaresDisponibles + '}';
    }
}