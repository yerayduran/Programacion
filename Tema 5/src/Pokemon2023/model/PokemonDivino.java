package Pokemon2023.model;

import Pokemon2023.enums.WeatherCondition;
import Pokemon2023.exceptions.MuerteException;
import Pokemon2023.exceptions.RoundStartException;
import Pokemon2023.exceptions.ValorNoValidoException;
import Pokemon2023.interfaces.Atacable;

/**
 * Representa un Pokémon de tipo Divino.
 * Este tipo especial posee características únicas:
 * <ul>
 *     <li>No puede morir bajo ninguna circunstancia.</li>
 *     <li>Ignora efectos climáticos negativos o positivos.</li>
 *     <li>Ataca usando únicamente su valor base de ataque.</li>
 * </ul>
 *
 * Extiende la clase {@link Pokemon}, heredando sus atributos básicos.
 */
public class PokemonDivino extends Pokemon {

    /**
     * Constructor del Pokémon Divino.
     *
     * @param nombre Nombre del Pokémon.
     * @param puntosSalud Salud inicial (aunque no afecta a su inmortalidad).
     * @param puntosAtaque Ataque base.
     * @param defensa Defensa base.
     * @throws ValorNoValidoException Si ataque o defensa están fuera de los rangos permitidos.
     */
    public PokemonDivino(String nombre, int puntosSalud, int puntosAtaque, int defensa) throws ValorNoValidoException {
        super(nombre, puntosSalud, puntosAtaque, defensa);
    }

    /**
     * Acción realizada al inicio de cada ronda.
     * En el caso del Pokémon Divino, simplemente informa que no puede morir gracias al maldito profesor Bermudo.
     *
     * @param weatherCondition Condición climática actual (sin efecto en este tipo).
     * @throws RoundStartException Siempre se lanza para indicar su naturaleza divina.
     */
    @Override
    public void roundStart(WeatherCondition weatherCondition) throws RoundStartException {
        throw new RoundStartException("El Pokémon " + getNombre() + " es divino y no puede morir. Maldito Bermudo");
    }

    /**
     * Ataca a un objetivo utilizando únicamente su ataque base,
     * sin aplicar modificadores ni efectos especiales.
     *
     * @param objetivo Pokémon objetivo del ataque.
     * @param tiempo Condición climática actual (sin efecto en este tipo).
     * @throws MuerteException Si el ataque provoca la muerte del objetivo.
     */
    @Override
    public void atacar(Atacable objetivo, WeatherCondition tiempo) throws MuerteException {
        objetivo.recibirDaño(tiempo, getPuntosAtaque(), this);
    }

    /**
     * Indica si el Pokémon está vivo.
     * En este caso, siempre devuelve true, ya que un Pokémon Divino es inmortal.
     *
     * @return true siempre.
     */
    @Override
    public boolean estaVivo() {
        return true;
    }
}