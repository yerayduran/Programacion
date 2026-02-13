package Pokemon2023.model;

import Pokemon2023.enums.WeatherCondition;
import Pokemon2023.exceptions.MuerteException;
import Pokemon2023.exceptions.RoundStartException;
import Pokemon2023.exceptions.ValorNoValidoException;
import Pokemon2023.interfaces.Atacable;
import Pokemon2023.interfaces.Atacador;

/**
 * Clase abstracta que representa un Pokémon dentro del sistema.
 * Define atributos comunes como salud, ataque, defensa y nombre,
 * así como validaciones y comportamientos básicos.
 *
 * Implementa la interfaz {@link Atacador}, por lo que cualquier
 * subclase deberá definir su comportamiento de ataque.
 */
public abstract class Pokemon implements Atacador {

    /** Salud máxima permitida para cualquier Pokémon. */
    public static final int MAX_SALUD = 100;

    /** Valor mínimo permitido para el ataque. */
    public static final int MIN_ATAQUE = 5;

    /** Valor máximo permitido para el ataque. */
    public static final int MAX_ATAQUE = 15;

    /** Valor mínimo permitido para la defensa. */
    public static final int MIN_DEFENSA = 5;

    /** Valor máximo permitido para la defensa. */
    public static final int MAX_DEFENSA = 25;

    /** Puntos de salud actuales del Pokémon. */
    private int puntosSalud;

    /** Puntos de ataque del Pokémon. */
    private int puntosAtaque;

    /** Puntos de defensa del Pokémon. */
    private int defensa;

    /** Nombre del Pokémon. Es inmutable. */
    private final String nombre;

    /**
     * Constructor principal del Pokémon.
     *
     * @param nombre Nombre del Pokémon.
     * @param puntosSalud Salud inicial.
     * @param puntosAtaque Ataque inicial.
     * @param defensa Defensa inicial.
     * @throws ValorNoValidoException Si ataque o defensa están fuera de rango.
     */
    public Pokemon(String nombre, int puntosSalud, int puntosAtaque, int defensa) throws ValorNoValidoException {
        this.nombre = nombre;
        setPuntosSalud(puntosSalud);
        setPuntosAtaque(puntosAtaque);
        setDefensa(defensa);
    }

    /**
     * Establece los puntos de salud, ajustándolos automáticamente
     * si están fuera del rango permitido (0 - MAX_SALUD).
     *
     * @param puntosSalud Valor de salud a asignar.
     */
    public void setPuntosSalud(int puntosSalud) {
        if (puntosSalud < 0) {
            puntosSalud = 0;
        } else if (puntosSalud > MAX_SALUD) {
            puntosSalud = MAX_SALUD;
        }
        this.puntosSalud = puntosSalud;
    }

    /**
     * Establece los puntos de ataque, validando que estén dentro del rango permitido.
     *
     * @param puntosAtaque Valor de ataque.
     * @throws ValorNoValidoException Si el ataque está fuera del rango permitido.
     */
    public void setPuntosAtaque(int puntosAtaque) throws ValorNoValidoException {
        if (puntosAtaque < MIN_ATAQUE || puntosAtaque > MAX_ATAQUE) {
            throw new ValorNoValidoException("El valor de ataque debe estar entre " + MIN_ATAQUE + " y " + MAX_ATAQUE);
        }
        this.puntosAtaque = puntosAtaque;
    }

    /**
     * Establece los puntos de defensa, validando que estén dentro del rango permitido.
     *
     * @param defensa Valor de defensa.
     * @throws ValorNoValidoException Si la defensa está fuera del rango permitido.
     */
    public void setDefensa(int defensa) throws ValorNoValidoException {
        if (defensa < MIN_DEFENSA || defensa > MAX_DEFENSA) {
            throw new ValorNoValidoException("El valor de defensa debe estar entre " + MIN_DEFENSA + " y " + MAX_DEFENSA);
        }
        this.defensa = defensa;
    }

    /**
     * @return Puntos de salud actuales.
     */
    public int getPuntosSalud() {
        return puntosSalud;
    }

    /**
     * @return Puntos de ataque actuales.
     */
    public int getPuntosAtaque() {
        return puntosAtaque;
    }

    /**
     * @return Puntos de defensa actuales.
     */
    public int getDefensa() {
        return defensa;
    }

    /**
     * @return Nombre del Pokémon.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método de ataque. La implementación concreta dependerá de cada tipo de Pokémon.
     *
     * @param objetivo Pokémon objetivo del ataque.
     * @param tiempo Condición climática actual.
     * @throws MuerteException Si el ataque provoca la muerte del objetivo.
     */
    @Override
    public abstract void atacar(Atacable objetivo, WeatherCondition tiempo) throws MuerteException;

    /**
     * Método abstracto que define el comportamiento del Pokémon
     * al inicio de cada ronda, pudiendo verse afectado por el clima.
     *
     * @param weatherCondition Condición climática actual.
     * @throws RoundStartException Si ocurre un evento inesperado al iniciar la ronda.
     */
    public abstract void roundStart(WeatherCondition weatherCondition) throws RoundStartException;

    /**
     * Indica si el Pokémon sigue vivo.
     *
     * @return true si tiene salud mayor que 0, false en caso contrario.
     */
    public boolean estaVivo(){
        return getPuntosSalud() > 0;
    }
}