package examen2025.domain;

import examen2025.exceptions.DBException;

import java.util.*;

public class Personaje {

    private String nombre;
    private TRaza raza;
    private final int vidaMax;
    private int vida;
    private final int kiMax;
    private int ki;
    private Set<Ataque> ataques;

    public Personaje(String nombre, TRaza raza, int vidaMax, int vida, int kiMax, int ki) {
        this.nombre = nombre;
        this.raza = raza;
        this.vidaMax = vidaMax;
        this.vida = vida;
        this.kiMax = kiMax;
        this.ki = ki;
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
        if (vida > vidaMax || vida < 0) {
            throw new DBException("Vida no valida");
        }
        this.vida = vida;
    }

    public void setKi(int ki) throws DBException {
        if (ki > kiMax || ki < 0) {
            throw new DBException("Vida no valida");
        }
        this.ki = ki;
    }

    public void setAtaques(Set<Ataque> ataques) {
        this.ataques = ataques;
    }

    public void addAtaque(Ataque ataque) {
        this.ataques.add(ataque);
    }
}