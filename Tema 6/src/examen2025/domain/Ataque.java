package examen2025.domain;

import java.util.Objects;

public class Ataque {

    private String nombre;
    private int ki;
    private int nivel;
    private int daño;

    public Ataque(String nombre, int ki, int nivel, int daño) {
        this.nombre = nombre;
        setKi(ki);
        setNivel(nivel);
        setDaño(daño);

    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setKi(int ki) {
        this.ki = (ki > 0) ? ki : 1;
    }

    public void setNivel(int nivel) {
        this.nivel = (nivel >= 1 && nivel <= 3) ? nivel : 1;
    }

    public void setDaño(int daño) {
        this.daño = (daño > 0) ? daño : 1;
    }

    public String getNombre() {
        return nombre;
    }

    public int getKi() {
        return ki;
    }
    public int getNivel() {
        return nivel;
    }
    public int getDaño() {
        return daño;
    }


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Ataque ataque)) return false;
        return ki == ataque.ki && nivel == ataque.nivel && daño == ataque.daño && Objects.equals(nombre, ataque.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, ki, nivel, daño);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Ataque{");
        sb.append("nombre='").append(nombre).append('\'');
        sb.append(", ki=").append(ki);
        sb.append(", nivel=").append(nivel);
        sb.append(", daño=").append(daño);
        sb.append('}');
        return sb.toString();
    }
}