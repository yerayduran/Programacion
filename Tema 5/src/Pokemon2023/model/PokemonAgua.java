package Pokemon2023.model;

import Pokemon2023.enums.WeatherCondition;
import Pokemon2023.exceptions.MuerteException;
import Pokemon2023.exceptions.RoundStartException;
import Pokemon2023.exceptions.ValorNoValidoException;
import Pokemon2023.interfaces.Atacable;
import Pokemon2023.interfaces.Atacador;

/**
 * Representa un Pokémon de tipo Agua dentro del sistema.
 * Extiende la clase {@link Pokemon} e implementa la interfaz {@link Atacable},
 * añadiendo mecánicas propias como hidratación y precisión variable.
 */
public class PokemonAgua extends Pokemon implements Atacable {

    /** Valor máximo permitido para la hidratación. */
    private static final int VALOR_MAX_HIDRATACION = 20;

    /** Valor mínimo permitido para la hidratación. */
    private static final int VALOR_MIN_HIDRATACION = 10;

    /** Cantidad de hidratación que influye en la curación bajo lluvia. */
    private int valorHidratacion;

    /** Precisión del ataque, que puede aumentar bajo lluvia. */
    private double precision = 1.0;

    /**
     * Constructor del Pokémon de tipo Agua.
     *
     * @param nombre Nombre del Pokémon.
     * @param puntosSalud Salud inicial.
     * @param puntosAtaque Ataque inicial.
     * @param defensa Defensa inicial.
     * @param valorHidratacion Valor de hidratación.
     * @throws ValorNoValidoException Si hidratación, ataque o defensa están fuera de rango.
     */
    public PokemonAgua(String nombre, int puntosSalud, int puntosAtaque, int defensa, int valorHidratacion) throws ValorNoValidoException {

        super(nombre, puntosSalud, puntosAtaque, defensa);
        setValorHidratacion(valorHidratacion);
    }

    /**
     * Establece el valor de hidratación, validando que esté dentro del rango permitido.
     *
     * @param valorHidratacion Valor de hidratación.
     * @throws ValorNoValidoException Si está fuera del rango permitido.
     */
    public void setValorHidratacion(int valorHidratacion) throws ValorNoValidoException {
        if (valorHidratacion < VALOR_MIN_HIDRATACION || valorHidratacion > VALOR_MAX_HIDRATACION) {

            throw new ValorNoValidoException("El valor de hidratación debe estar entre " + VALOR_MIN_HIDRATACION + " y " + VALOR_MAX_HIDRATACION);
        }
        this.valorHidratacion = valorHidratacion;
    }

    /**
     * Recibe daño de un atacante, aplicando la defensa del Pokémon de tipo Agua.
     *
     * @param tiempo Condición climática actual.
     * @param puntosAtaque Puntos de ataque del atacante.
     * @param atacador Instancia del atacante.
     * @throws MuerteException Si el Pokémon muere tras recibir el daño.
     */
    @Override
    public void recibirDaño(WeatherCondition tiempo, int puntosAtaque, Atacador atacador) throws MuerteException {

        // Cálculo del daño reducido por defensa
        double factorDefensa = 1 - (getDefensa() / 100.0);
        int dañoFinal = (int) (puntosAtaque * factorDefensa);

        setPuntosSalud(getPuntosSalud() - dañoFinal);

        if (!estaVivo()) {
            throw new MuerteException("El Pokémon " + getNombre() + " fue al cielo");
        }
    }

    /**
     * Ataca a un objetivo aplicando la precisión actual del Pokémon.
     *
     * @param objetivo Pokémon objetivo del ataque.
     * @param tiempo Condición climática actual.
     * @throws MuerteException Si el ataque provoca la muerte del objetivo.
     */
    @Override
    public void atacar(Atacable objetivo, WeatherCondition tiempo) throws MuerteException {
        int daño = (int) (getPuntosAtaque() * precision);
        objetivo.recibirDaño(tiempo, daño, this);
    }

    /**
     * Acciones que ocurren al inicio de cada ronda.
     * Bajo lluvia, el Pokémon se cura y aumenta su precisión.
     *
     * @param weatherCondition Condición climática actual.
     * @throws RoundStartException Si ocurre un evento especial al iniciar la ronda.
     */
    @Override
    public void roundStart(WeatherCondition weatherCondition) throws RoundStartException {
        if (!estaVivo()) {
            return;
        }

        if (weatherCondition == WeatherCondition.LLUVIA) {
            // Cura por hidratación
            setPuntosSalud(getPuntosSalud() + valorHidratacion);

            // Aumenta precisión aleatoriamente
            precision += Math.random();

            throw new RoundStartException("El Pokémon " + getNombre() + " recibe una curación por la lluvia");
        } else {
            precision = 1.0; // Reinicio si no llueve
        }
    }

    /**
     * Indica si el Pokémon sigue vivo.
     *
     * @return true si tiene salud mayor que 0, false en caso contrario.
     */
    @Override
    public boolean estaVivo() {
        return getPuntosSalud() > 0;
    }
}


