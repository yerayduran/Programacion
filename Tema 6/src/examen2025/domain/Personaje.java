package examen2025.domain;

import examen2025.exceptions.DBException;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class Personaje {

    private String nombre;
    private TRaza raza;
    private int vida;
    private int ki;

    private Set<Ataque> ataques;

    private final int vidaMax;
    private final int kiMax;

    public Personaje(String nombre, TRaza raza, int vidaMax, int vida, int kiMax, int ki) throws DBException {
        this.nombre = nombre;
        this.raza = raza;
        this.vidaMax = vidaMax;
        setVida(vida);
        this.kiMax = kiMax;
        setKi(ki);
        this.ataques = new LinkedHashSet<>();
    }

    public String getNombre() {
        return nombre;
    }

    public TRaza getRaza() {
        return raza;
    }

    public int getVida() {
        return vida;
    }

    public int getKi() {
        return ki;
    }

    public Set<Ataque> getAtaques() {
        return ataques;
    }

    public void setVida(int vida) throws DBException {
        if (vida > this.vidaMax || vida < 0){
            throw new DBException("Valores no validos en vida");
        }
        this.vida = vida;
    }

    public void setKi(int ki) throws DBException {
        if (ki > this.kiMax || ki < 0){
            throw new DBException("Valores no validos en ki");
        }

        this.ki = ki;
    }

    public void addAtaque(Ataque ataque) throws DBException{
        if (!ataques.add(ataque)){
            throw new DBException("El Ataque ya existe");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Personaje personaje)) return false;
        return vida == personaje.vida && ki == personaje.ki && vidaMax == personaje.vidaMax && kiMax == personaje.kiMax && Objects.equals(nombre, personaje.nombre) && raza == personaje.raza && Objects.equals(ataques, personaje.ataques);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, raza, vida, ki, ataques, vidaMax, kiMax);
    }

    @Override
    public String toString() {
        return "Personaje{" +
                "nombre='" + nombre + '\'' +
                ", raza=" + raza +
                ", vida=" + vida +
                ", ki=" + ki +
                ", ataques=" + ataques +
                ", vidaMax=" + vidaMax +
                ", kiMax=" + kiMax +
                '}';
    }
}