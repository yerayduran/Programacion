package Pokemon2023.model;

import Pokemon2023.enums.WeatherCondition;
import Pokemon2023.exceptions.MuerteException;
import Pokemon2023.exceptions.RoundStartException;
import Pokemon2023.exceptions.ValorNoValidoException;
import Pokemon2023.interfaces.Atacable;

public class PokemonDivino extends Pokemon {

    public PokemonDivino(String nombre, int puntosSalud, int puntosAtaque, int defensa)
            throws ValorNoValidoException {
        super(nombre, puntosSalud, puntosAtaque, defensa);
    }

    @Override
    public void roundStart(WeatherCondition weatherCondition) throws RoundStartException {
        // Un Pokémon divino nunca muere, así que siempre está vivo
        throw new RoundStartException("El Pokémon " + getNombre() + " es divino y no puede morir"
        );
    }

    @Override
    public void atacar(Atacable objetivo, WeatherCondition tiempo) throws MuerteException {
        // Usa el ataque base sin bonificaciones especiales
        objetivo.recibirDaño(tiempo, getPuntosAtaque(), this);
    }

    @Override
    public boolean estaVivo() {
        return true; // Siempre vivo
    }
}
