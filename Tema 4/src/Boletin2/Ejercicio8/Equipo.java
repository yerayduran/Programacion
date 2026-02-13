package Boletin2.Ejercicio8;

import Ejercicio8.Exception.FutbolException;

import java.util.Objects;

public class Equipo {

    // Atributos
    private String nombre;
    private int goles;
    private int partidosGanados;

    // Creamos el constructor
    public Equipo(String nombre) throws FutbolException {
        this.nombre = nombre;
    }

    public void setGoles(int goles) {
        this.goles = goles;
    }

    // Hacemos los get para acceder a estos atributos
    public String getNombre() {
        return nombre;
    }

    public int getGoles() {
        return goles;
    }

    public int getPartidosGanados() {
        return partidosGanados;
    }

    // Comparamos los nombres de los equipos para ver si son el mismo equipo
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipo equipo = (Equipo) o;
        return Objects.equals(nombre, equipo.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nombre);
    }

    // Método para sumar 1 a los partidos ganados
    public void sumarPartidoGanado() {
        this.partidosGanados++;
    }

    // Hacemos un toString
    @Override
    public String toString() {
        return "Boletin2.Boletin4.Ejercicio8.Ejercicio8.Equipo: {" + "Nombre = '" + nombre + '\'' +  ", Boletin2.Boletin4.Ejercicio8.Ejercicio8.Partidos Ganados = " + partidosGanados + " }";
    }
}