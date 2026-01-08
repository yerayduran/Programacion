package Boletin1.Ejercicio3;

import Boletin1.Ejercicio3.Exception.PersonajeException;
import java.util.Objects;

public abstract class Personaje implements Comparable<Personaje> {

    private String nombre;
    private Raza raza;
    private int fuerza;
    private int inteligencia;
    private int ptsMax;
    private int ptsActual;

    public Personaje(String nombre, Raza raza, int fuerza, int inteligencia, int ptsMax, int ptsActual) throws PersonajeException {
        this.nombre = nombre;
        this.raza = raza;
        setFuerza(fuerza);
        setInteligencia(inteligencia);
        setPtsMax(ptsMax);       // primero se define el máximo
        setPtsActual(ptsActual); // luego se valida el actual contra el máximo
    }

    public void setFuerza(int fuerza) throws PersonajeException {
        if (fuerza < 1 || fuerza > 20) {
            throw new PersonajeException("La fuerza debe estar entre 1 y 20");
        }
        this.fuerza = fuerza;
    }

    public void setInteligencia(int inteligencia) throws PersonajeException {
        if (inteligencia < 1 || inteligencia > 20) {
            throw new PersonajeException("La inteligencia debe estar entre 1 y 20");
        }
        this.inteligencia = inteligencia;
    }

    public void setPtsActual(int ptsActual) throws PersonajeException {
        if (ptsActual < 0 || ptsActual > getPtsMax()) {
            throw new PersonajeException("Los puntos de vida actuales deben estar entre 0 y el máximo permitido");
        }
        this.ptsActual = ptsActual;
    }

    public void setPtsMax(int ptsMax) throws PersonajeException {
        if (ptsMax <= 0 || ptsMax > 100) {
            throw new PersonajeException("Los puntos de vida máximos deben estar entre 1 y 100");
        }
        this.ptsMax = ptsMax;
    }

    public int getFuerza() {
        return fuerza;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPtsActual() {
        return ptsActual;
    }

    public int getPtsMax() {
        return ptsMax;
    }

    public Raza getRaza() {
        return raza;
    }

    @Override
    public String toString() {
        return "\nPersonaje {" +
                "Nombre = '" + nombre + '\'' +
                ", Raza = " + raza +
                ", Fuerza = " + fuerza +
                ", Inteligencia = " + inteligencia +
                ", ptsMax = " + ptsMax +
                ", ptsActual = " + ptsActual +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Personaje)) return false;
        Personaje personaje = (Personaje) o;
        return Objects.equals(nombre, personaje.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }

    @Override
    public int compareTo(Personaje o) {
        return Integer.compare(this.ptsActual, o.ptsActual);
    }
}
