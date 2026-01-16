package Pokemon2023.model;

import Pokemon2023.enums.WeatherCondition;
import Pokemon2023.exceptions.MuerteException;
import Pokemon2023.exceptions.RoundStartException;
import Pokemon2023.exceptions.ValorNoValidoException;
import Pokemon2023.interfaces.Atacable;
import Pokemon2023.interfaces.Atacador;

/**
 * Representa un Pokémon de tipo Tierra dentro del sistema.
 * Este tipo posee mecánicas especiales relacionadas con:
 * <ul>
 *     <li>Resistencia natural frente a ataques eléctricos.</li>
 *     <li>Bonificaciones de ataque durante tormentas de arena.</li>
 * </ul>
 *
 * Extiende la clase {@link Pokemon} e implementa {@link Atacable}.
 */
public class PokemonTierra extends PokemonAtacable {

    /** Cantidad de daño reducido cuando recibe ataques de tipo Eléctrico. */
    private int resistenciaElectrica;

    /** Valor mínimo permitido para la resistencia eléctrica. */
    private static final int MIN_RESISTENCIA_ELECTRICA = 1;

    /** Valor máximo permitido para la resistencia eléctrica. */
    private static final int MAX_RESISTENCIA_ELECTRICA = 9;

    /** Bonificación aplicada al ataque durante tormentas de arena. */
    private double bonificacionTormentaTierra;

    /**
     * Constructor del Pokémon de tipo Tierra.
     *
     * @param nombre Nombre del Pokémon.
     * @param puntosSalud Salud inicial.
     * @param puntosAtaque Ataque base.
     * @param defensa Defensa base.
     * @param resistenciaElectrica Reducción de daño recibido frente a ataques eléctricos.
     * @throws ValorNoValidoException Si ataque, defensa o resistencia están fuera de rango.
     */
    public PokemonTierra(String nombre, int puntosSalud, int puntosAtaque, int defensa, int resistenciaElectrica) throws ValorNoValidoException {
        super(nombre, puntosSalud, puntosAtaque, defensa);
        setResistenciaElectrica(resistenciaElectrica);
        bonificacionTormentaTierra = 1.0;
    }

    /**
     * Establece la resistencia eléctrica, validando que esté dentro del rango permitido.
     *
     * @param resistenciaElectrica Valor de resistencia eléctrica.
     * @throws ValorNoValidoException Si está fuera del rango permitido.
     */
    public void setResistenciaElectrica(int resistenciaElectrica) throws ValorNoValidoException {
        if (resistenciaElectrica < MIN_RESISTENCIA_ELECTRICA || resistenciaElectrica > MAX_RESISTENCIA_ELECTRICA) {
            throw new ValorNoValidoException("La resistencia eléctrica debe estar entre " + MIN_RESISTENCIA_ELECTRICA + " y " + MAX_RESISTENCIA_ELECTRICA);
        }
        this.resistenciaElectrica = resistenciaElectrica;
    }

    /**
     * Ataca a un objetivo aplicando la bonificación por tormenta de arena si corresponde.
     *
     * @param objetivo Pokémon objetivo del ataque.
     * @param tiempo Condición climática actual.
     * @throws MuerteException Si el ataque provoca la muerte del objetivo.
     */
    @Override
    public void atacar(Atacable objetivo, WeatherCondition tiempo) throws MuerteException {
        int daño = (int) (getPuntosAtaque() * bonificacionTormentaTierra);
        objetivo.recibirDaño(tiempo, daño, this);
    }

    /**
     * Acciones realizadas al inicio de cada ronda.
     * Durante tormentas de arena, el Pokémon recibe una bonificación aleatoria al ataque.
     *
     * @param weatherCondition Condición climática actual.
     * @throws RoundStartException Si ocurre un evento especial al iniciar la ronda.
     */
    @Override
    public void roundStart(WeatherCondition weatherCondition) throws RoundStartException {
        if (!estaVivo()) {
            return;
        }

        if (weatherCondition == WeatherCondition.TORMENTA_DE_ARENA) {
            bonificacionTormentaTierra = 1.0 + Math.random();
            throw new RoundStartException("El Pokémon " + getNombre() + " recibe una bonificación por la tormenta de arena");
        } else {
            bonificacionTormentaTierra = 1.0; // Reset si no hay tormenta
        }
    }

    /**
     * Recibe daño de un atacante, aplicando defensa y resistencia eléctrica si corresponde.
     *
     * @param tiempo Condición climática actual.
     * @param puntosAtaque Puntos de ataque del atacante.
     * @param atacador Instancia del atacante.
     * @throws MuerteException Si el Pokémon muere tras recibir el daño.
     */
    @Override
    public void recibirDaño(WeatherCondition tiempo, int puntosAtaque, Atacador atacador) throws MuerteException {

        // Reducción por resistencia eléctrica si el atacante es de tipo Eléctrico
        if (atacador instanceof PokemonElectrico) {
            puntosAtaque -= resistenciaElectrica;
            if (puntosAtaque < 0) {
                puntosAtaque = 0;
            }
        }
        super.recibirDaño(tiempo, puntosAtaque, atacador);
    }
}