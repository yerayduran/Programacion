package Pokemon2023.model;

import Pokemon2023.enums.WeatherCondition;
import Pokemon2023.exceptions.MuerteException;
import Pokemon2023.exceptions.RoundStartException;
import Pokemon2023.exceptions.ValorNoValidoException;
import Pokemon2023.interfaces.Atacable;
import Pokemon2023.interfaces.Atacador;

/**
 * Representa un Pokémon de tipo Fuego dentro del sistema.
 * Este tipo posee mecánicas especiales relacionadas con el clima soleado
 * y una resistencia natural frente a ataques de tipo Agua.
 *
 * Extiende la clase {@link Pokemon} e implementa {@link Atacable}.
 */
public class PokemonFuego extends PokemonAtacable{

    /** Valor mínimo permitido para la resistencia al agua. */
    private static final int MIN_RESISTENCIA_AGUA = 5;

    /** Valor máximo permitido para la resistencia al agua. */
    private static final int MAX_RESISTENCIA_AGUA = 15;

    /** Cantidad de daño reducido cuando recibe ataques de tipo Agua. */
    private int resistenciaAgua;

    /** Bonificación aplicada al ataque durante clima soleado. */
    private double bonificacionSol = 1.0;

    /**
     * Constructor del Pokémon de tipo Fuego.
     *
     * @param nombre Nombre del Pokémon.
     * @param puntosSalud Salud inicial.
     * @param puntosAtaque Ataque base.
     * @param defensa Defensa base.
     * @param resistenciaAgua Reducción de daño recibido frente a ataques de tipo Agua.
     * @throws ValorNoValidoException Si ataque, defensa o resistencia están fuera de rango.
     */
    public PokemonFuego(String nombre, int puntosSalud, int puntosAtaque, int defensa, int resistenciaAgua) throws ValorNoValidoException {

        super(nombre, puntosSalud, puntosAtaque, defensa);
        setResistenciaAgua(resistenciaAgua);
    }

    /**
     * Establece la resistencia al agua, validando que esté dentro del rango permitido.
     *
     * @param resistenciaAgua Valor de resistencia al agua.
     * @throws ValorNoValidoException Si está fuera del rango permitido.
     */
    public void setResistenciaAgua(int resistenciaAgua) throws ValorNoValidoException {
        if (resistenciaAgua < MIN_RESISTENCIA_AGUA || resistenciaAgua > MAX_RESISTENCIA_AGUA) {
            throw new ValorNoValidoException("La resistencia al agua debe estar entre " + MIN_RESISTENCIA_AGUA + " y " + MAX_RESISTENCIA_AGUA);
        }
        this.resistenciaAgua = resistenciaAgua;
    }

    /**
     * Acciones realizadas al inicio de cada ronda.
     * Durante clima soleado, el Pokémon recibe una bonificación aleatoria al ataque.
     *
     * @param weatherCondition Condición climática actual.
     * @throws RoundStartException Si ocurre un evento especial al iniciar la ronda.
     */
    @Override
    public void roundStart(WeatherCondition weatherCondition) throws RoundStartException {
        if (!estaVivo()) {
            return;
        }

        if (weatherCondition == WeatherCondition.SOL) {
            bonificacionSol = 1.0 + Math.random();
            throw new RoundStartException("El Pokémon " + getNombre() + " recibe una bonificación por el sol");
        } else {
            bonificacionSol = 1.0; // Reset si no hay sol
        }
    }

    /**
     * Recibe daño de un atacante, aplicando defensa y resistencia al agua si corresponde.
     *
     * @param tiempo Condición climática actual.
     * @param puntosAtaque Puntos de ataque del atacante.
     * @param atacador Instancia del atacante.
     * @throws MuerteException Si el Pokémon muere tras recibir el daño.
     */
    @Override
    public void recibirDaño(WeatherCondition tiempo, int puntosAtaque, Atacador atacador) throws MuerteException {

        // Reducción por resistencia al agua si el atacante es de tipo Agua
        if (atacador instanceof PokemonAgua) {
            puntosAtaque -= resistenciaAgua;
            if (puntosAtaque < 0) {
                puntosAtaque = 0;
            }
        }
        super.recibirDaño(tiempo, puntosAtaque, atacador);

    }

    /**
     * Ataca a un objetivo aplicando la bonificación por sol si corresponde.
     *
     * @param objetivo Pokémon objetivo del ataque.
     * @param tiempo Condición climática actual.
     * @throws MuerteException Si el ataque provoca la muerte del objetivo.
     */
    @Override
    public void atacar(Atacable objetivo, WeatherCondition tiempo) throws MuerteException {
        int daño = (int) (getPuntosAtaque() * bonificacionSol);
        objetivo.recibirDaño(tiempo, daño, this);
    }
}