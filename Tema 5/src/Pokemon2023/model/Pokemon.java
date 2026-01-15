package Pokemon2023.model;

import Pokemon2023.enums.WeatherCondition;
import Pokemon2023.exceptions.MuerteException;
import Pokemon2023.exceptions.RoundStartException;
import Pokemon2023.exceptions.ValorNoValidoException;
import Pokemon2023.interfaces.Atacable;
import Pokemon2023.interfaces.Atacador;

public abstract class Pokemon implements Atacador {

    public static final int MAX_SALUD = 100;
    public static final int MIN_ATAQUE = 5;
    public static final int MAX_ATAQUE = 15;
    public static final int MIN_DEFENSA = 5;
    public static final int MAX_DEFENSA = 25;

    private int puntosSalud;
    private int puntosAtaque;
    private int defensa;
    private final String nombre;

    public Pokemon(String nombre, int puntosSalud, int puntosAtaque, int defensa) throws ValorNoValidoException {
        this.nombre = nombre;
        setPuntosSalud(puntosSalud);
        setPuntosAtaque(puntosAtaque);
        setDefensa(defensa);
    }

    public void setPuntosSalud(int puntosSalud) {
        if (puntosSalud < 0) {
            puntosSalud = 0;
        } else if (puntosSalud > MAX_SALUD) {
            puntosSalud = MAX_SALUD;
        }
        this.puntosSalud = puntosSalud;
    }

    public void setPuntosAtaque(int puntosAtaque) throws ValorNoValidoException {
        if (puntosAtaque < MIN_ATAQUE || puntosAtaque > MAX_ATAQUE) {
            throw new ValorNoValidoException(
                    "El valor de ataque debe estar entre " + MIN_ATAQUE + " y " + MAX_ATAQUE
            );
        }
        this.puntosAtaque = puntosAtaque;
    }

    public void setDefensa(int defensa) throws ValorNoValidoException {
        if (defensa < MIN_DEFENSA || defensa > MAX_DEFENSA) {
            throw new ValorNoValidoException(
                    "El valor de defensa debe estar entre " + MIN_DEFENSA + " y " + MAX_DEFENSA
            );
        }
        this.defensa = defensa;
    }

    public int getPuntosSalud() {
        return puntosSalud;
    }

    public int getPuntosAtaque() {
        return puntosAtaque;
    }

    public int getDefensa() {
        return defensa;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public void atacar(Atacable objetivo, WeatherCondition tiempo) throws MuerteException {
    }

    public abstract void roundStart(WeatherCondition weatherCondition) throws RoundStartException;

    public abstract boolean estaVivo();
}