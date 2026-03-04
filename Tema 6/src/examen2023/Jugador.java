package examen2023;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Jugador implements Comparable<Jugador> {
    private String nombre;
    private LocalDate fechaNacimiento;
    private Posicion posicion;
    private String pais;

    public Jugador(String nombre, LocalDate fechaNacimiento, String posicion, String pais) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.posicion = Posicion.valueOf(posicion.toUpperCase());
        this.pais = pais;
    }


    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public int getEdad(){
        LocalDate fechaActual = LocalDate.now();
        Period periodo = Period.between(fechaNacimiento, fechaActual);
        return periodo.getYears();


    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public String getPais() { return pais; }


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Jugador jugador)) return false;
        return Objects.equals(nombre, jugador.nombre) && Objects.equals(fechaNacimiento, jugador.fechaNacimiento) && posicion == jugador.posicion && Objects.equals(pais, jugador.pais);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, fechaNacimiento, posicion, pais);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(nombre).append(": ");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        sb.append(fechaNacimiento.format(formatter)).append(". ")
                .append(posicion).append(" (").append(pais).append(")");

        return sb.toString();

    }

    @Override
    public int compareTo(Jugador o) {
        return this.getNombre().compareTo(o.getNombre());
    }
}
