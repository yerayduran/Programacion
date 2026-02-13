package Pokemon2023.model;

import Pokemon2023.enums.WeatherCondition;
import Pokemon2023.exceptions.MuerteException;
import Pokemon2023.exceptions.RoundStartException;
import Pokemon2023.exceptions.ValorNoValidoException;
import Pokemon2023.interfaces.Atacable;
import Pokemon2023.interfaces.Atacador;

/**
 * Representa un Pokémon de tipo Eléctrico dentro del sistema.
 * Este tipo posee mecánicas especiales relacionadas con la lluvia
 * y las tormentas eléctricas, que pueden aumentar su daño o modificar
 * el daño recibido.
 *
 * Extiende la clase {@link Pokemon} e implementa {@link Atacable}.
 */
public class PokemonElectrico extends PokemonAtacable{

    /** Cantidad de daño adicional que recibe bajo lluvia si el atacante también es eléctrico. */
    private int resistenciaDeLluvia;

    /** Bonificación aplicada al ataque durante tormentas eléctricas. */
    private double bonificacionTormenta;

    /** Valor mínimo permitido para la resistencia a la lluvia. */
    private static final int VALOR_MINIMO_DE_DAÑO_LLUVIA = 10;

    /** Valor máximo permitido para la resistencia a la lluvia. */
    private static final int VALOR_MAXIMO_DE_DAÑO_LLUVIA = 15;

    /**
     * Constructor del Pokémon Eléctrico.
     *
     * @param nombre Nombre del Pokémon.
     * @param puntosSalud Salud inicial.
     * @param puntosAtaque Ataque base.
     * @param defensa Defensa base.
     * @param resistenciaDeLluvia Daño adicional recibido bajo lluvia si el atacante es eléctrico.
     * @throws ValorNoValidoException Si ataque, defensa o resistencia están fuera de rango.
     */
    public PokemonElectrico(String nombre, int puntosSalud, int puntosAtaque, int defensa, int resistenciaDeLluvia) throws ValorNoValidoException {

        super(nombre, puntosSalud, puntosAtaque, defensa);
        setResistenciaDeLluvia(resistenciaDeLluvia);
        bonificacionTormenta = 1.0;
    }

    /**
     * Establece la resistencia a la lluvia, validando que esté dentro del rango permitido.
     *
     * @param resistenciaDeLluvia Valor de resistencia.
     * @throws ValorNoValidoException Si está fuera del rango permitido.
     */
    public void setResistenciaDeLluvia(int resistenciaDeLluvia) throws ValorNoValidoException {
        if (resistenciaDeLluvia < VALOR_MINIMO_DE_DAÑO_LLUVIA || resistenciaDeLluvia > VALOR_MAXIMO_DE_DAÑO_LLUVIA) {
            throw new ValorNoValidoException("La resistencia de lluvia debe estar entre " + VALOR_MINIMO_DE_DAÑO_LLUVIA + " y " + VALOR_MAXIMO_DE_DAÑO_LLUVIA);
        }
        this.resistenciaDeLluvia = resistenciaDeLluvia;
    }

    /**
     * Ataca a un objetivo aplicando la bonificación por tormenta si corresponde.
     *
     * @param objetivo Pokémon objetivo del ataque.
     * @param tiempo Condición climática actual.
     * @throws MuerteException Si el ataque provoca la muerte del objetivo.
     */
    @Override
    public void atacar(Atacable objetivo, WeatherCondition tiempo) throws MuerteException {
        int daño = (int) (getPuntosAtaque() * bonificacionTormenta);
        objetivo.recibirDaño(tiempo, daño, this);
    }

    /**
     * Recibe daño de un atacante, aplicando defensa y efectos climáticos.
     * Si llueve y el atacante es eléctrico, el daño aumenta según la resistencia.
     *
     * @param tiempo Condición climática actual.
     * @param puntosAtaque Puntos de ataque del atacante.
     * @param atacador Instancia del atacante.
     * @throws MuerteException Si el Pokémon muere tras recibir el daño.
     */
    @Override
    public void recibirDaño(WeatherCondition tiempo, int puntosAtaque, Atacador atacador) throws MuerteException {

        // Si llueve y el atacante es eléctrico, el daño aumenta
        if (tiempo == WeatherCondition.LLUVIA) {
            puntosAtaque -= puntosAtaque * (resistenciaDeLluvia/100);
        }
        super.recibirDaño(tiempo, puntosAtaque, atacador);
    }

    /**
     * Acciones realizadas al inicio de cada ronda.
     * Durante tormentas eléctricas, el Pokémon recibe una bonificación aleatoria al ataque.
     *
     * @param weatherCondition Condición climática actual.
     * @throws RoundStartException Si ocurre un evento especial al iniciar la ronda.
     */
    @Override
    public void roundStart(WeatherCondition weatherCondition) throws RoundStartException {
        if (!estaVivo()) {
            return;
        }

        if (weatherCondition == WeatherCondition.TORMENTA_ELECTRICA) {
            bonificacionTormenta = 1.0 + Math.random();
            throw new RoundStartException("El Pokémon " + getNombre() + " recibe una bonificación por la tormenta eléctrica");
        } else if (weatherCondition == WeatherCondition.LLUVIA) {
            bonificacionTormenta = 1.0;
            throw new RoundStartException("Esta ronda disminuye el daño recibido");
        } else {
            bonificacionTormenta = 1.0; // Reset si no hay tormenta
        }
    }

}