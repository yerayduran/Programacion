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
public class PokemonAgua extends PokemonAtacable {

    /**
     * Valor máximo permitido para la hidratación.
     */
    private static final int VALOR_MAX_HIDRATACION = 20;

    /**
     * Valor mínimo permitido para la hidratación.
     */
    private static final int VALOR_MIN_HIDRATACION = 10;

    /**
     * Cantidad de hidratación que influye en la curación bajo lluvia.
     */
    private int valorHidratacion;

    /**
     * Precisión del ataque, que puede aumentar bajo lluvia.
     */
    private double precision = 1.0;

    /**
     * Constructor del Pokémon de tipo Agua.
     *
     * @param nombre           Nombre del Pokémon.
     * @param puntosSalud      Salud inicial.
     * @param puntosAtaque     Ataque inicial.
     * @param defensa          Defensa inicial.
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
     * Ataca a un objetivo aplicando la precisión actual del Pokémon.
     *
     * @param objetivo Pokémon objetivo del ataque.
     * @param tiempo   Condición climática actual.
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

        precision = 1.0;

        if (weatherCondition == WeatherCondition.LLUVIA) {
            // Cura por hidratación
            setPuntosSalud(getPuntosSalud() + valorHidratacion);

            // Aumenta precisión aleatoriamente
            precision += Math.random();

            throw new RoundStartException("El Pokémon " + getNombre() + " recibe una curación por la lluvia");
        }
    }

}


