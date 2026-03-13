package examen2025.domain;

import examen2025.exceptions.DBException;

import java.util.Objects;

public class Ataque implements Comparable<Ataque> {

    private String nombre;
    private int kiNecesario;
    private int nivelPerfeccion;
    private int daño;


    public Ataque(String nombre, int kiNecesario, int nivelPerfeccion, int daño) throws DBException {
        this.nombre = nombre;
        this.kiNecesario = kiNecesario;
        setNivelPerfeccion(nivelPerfeccion);
        setDaño(daño);
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivelPerfeccion() {
        return nivelPerfeccion;
    }

    public void setNivelPerfeccion(int nivelPerfeccion) throws DBException {
        if (nivelPerfeccion < 1 || nivelPerfeccion > 3) {
            throw new DBException("El nivel de perfección no es válido");
        }
        this.nivelPerfeccion = nivelPerfeccion;
    }

    public int getDaño() {
        return daño;
    }

    public void setDaño(int daño) throws DBException {
        if (daño < 1) {
            throw new DBException("El daño no es válido");
        }
        this.daño = daño;
    }

    public int getKiNecesario() {
        return kiNecesario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ataque ataque = (Ataque) o;
        return nivelPerfeccion == ataque.nivelPerfeccion && daño == ataque.daño && Objects.equals(nombre, ataque.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, nivelPerfeccion, daño);
    }


    @Override
    public String toString() {
        return String.format("Nombre: %s, Ki necesario: %d, Nivel perfección: %d, Daño: %d", this.nombre, this.kiNecesario,
                this.nivelPerfeccion, this.daño);
    }

    @Override
    public int compareTo(Ataque o) {
        return this.nombre.compareTo(o.nombre);
    }
}