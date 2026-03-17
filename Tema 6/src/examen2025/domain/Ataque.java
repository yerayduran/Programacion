package examen2025.domain;
import examen2025.exceptions.DBException;

public class Ataque {
    private String nombre;
    private int kiNecesario;
    private int nivel;
    private int damage;

    public Ataque(String nombre, int kiNecesario, int nivel, int damage) throws DBException {
        this.nombre = nombre;
        this.setKiNecesario(kiNecesario);
        this.setNivel(nivel);
        this.setDamage(damage);
    }

    public String getNombre() {
        return nombre;
    }

    public int getKiNecesario() {
        return kiNecesario;
    }

    public void setKiNecesario(int kiNecesario) throws DBException {
        // El ki debe ser mayor que 0
        if (kiNecesario <= 0) {
            throw new DBException("El ki debe ser mayor que 0");
        }
        this.kiNecesario = kiNecesario;
    }

    public void setNivel(int nivel) throws DBException {
        //Nivel debe estar entre 1 y 3
        if (nivel < 1 || nivel > 3) {
            throw new DBException("El nivel debe estar entre 1 y 3");
        }
        this.nivel = nivel;
    }

    public void setDamage(int damage) throws DBException {
        // El daño debe ser mayor que 0
        if (damage <= 0) {
            throw new DBException("El daño debe ser mayor que 0");
        }
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public int getNivel() {
        return nivel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ataque ataque = (Ataque) o;
        return nivel == ataque.nivel && damage == ataque.damage && nombre.equals(ataque.nombre);
    }

    @Override
    public int hashCode() {
        int result = nombre.hashCode();
        result = 31 * result + nivel;
        result = 31 * result + damage;
        return result;
    }

    @Override
    public String toString() {
        return "Ataque{" +
                "nombre='" + nombre + '\'' +
                ", kiNecesario=" + kiNecesario +
                ", nivel=" + nivel +
                ", damage=" + damage +
                '}';
    }
}
