package Pokemon2023.interfaces;

import Pokemon2023.enums.WeatherCondition;
import Pokemon2023.exceptions.MuerteException;

public interface Atacador {

    /**
     * Método de la interfaz para bajar la vida a tus contringantes y ganarles en tus peleas
     * Pokemón
     *
     * @param objetivo parametro para seleccionar al pokemon que quieres atacar
     * @param tiempo al usar este parámetro nos ayuda si un Pokémon recibe más o menos daño dependiendo
     *               que tiempo meteorologico hace en batalla.
     * @throws MuerteException hace que si el Pokémon que atacaste tenga de vida actual 0 muestre por pantalla que esté derrotado
     */
    void atacar(Atacable objetivo, WeatherCondition tiempo) throws MuerteException;
}
