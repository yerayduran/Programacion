package Pokemon2023.model;

import Pokemon2023.enums.WeatherCondition;
import Pokemon2023.exceptions.MuerteException;
import Pokemon2023.exceptions.ValorNoValidoException;
import Pokemon2023.interfaces.Atacable;
import Pokemon2023.interfaces.Atacador;

public abstract class PokemonAtacable extends Pokemon implements Atacable {

    public PokemonAtacable(String nombre, int puntosSalud, int puntosAtaque, int defensa) throws ValorNoValidoException {
        super(nombre, puntosSalud, puntosAtaque, defensa);
    }

    @Override
    public void recibirDaño(WeatherCondition tiempo, int puntosAtaque, Atacador atacador) throws MuerteException {
        if(puntosAtaque <= 0) {
            return;
        }

        // Cálculo del daño reducido por defensa
        double factorDefensa = 1 - (getDefensa() / 100.0);
        int dañoFinal = (int) (puntosAtaque * factorDefensa);

        setPuntosSalud(getPuntosSalud() - dañoFinal);

        if (!estaVivo()) {
            throw new MuerteException("El Pokémon " + getNombre() + " fue al cielo");
        }
    }
}
