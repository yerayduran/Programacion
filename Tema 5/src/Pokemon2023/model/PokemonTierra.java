package Pokemon2023.model;

import Pokemon2023.enums.WeatherCondition;
import Pokemon2023.exceptions.MuerteException;
import Pokemon2023.exceptions.RoundStartException;
import Pokemon2023.exceptions.ValorNoValidoException;
import Pokemon2023.interfaces.Atacable;
import Pokemon2023.interfaces.Atacador;

public class PokemonTierra extends Pokemon implements Atacable {

    private int resistenciaElectrica;
    private static final int MIN_RESISTENCIA_ELECTRICA = 1;
    private static final int MAX_RESISTENCIA_ELECTRICA = 9;

    private double bonificacionTormentaTierra = 1.0; // Valor por defecto

    public PokemonTierra(String nombre, int puntosSalud, int puntosAtaque, int defensa,
                         int resistenciaElectrica) throws ValorNoValidoException {
        super(nombre, puntosSalud, puntosAtaque, defensa);
        setResistenciaElectrica(resistenciaElectrica);
    }

    public void setResistenciaElectrica(int resistenciaElectrica) throws ValorNoValidoException {
        if (resistenciaElectrica < MIN_RESISTENCIA_ELECTRICA ||
                resistenciaElectrica > MAX_RESISTENCIA_ELECTRICA) {

            throw new ValorNoValidoException(
                    "La resistencia eléctrica debe estar entre " +
                            MIN_RESISTENCIA_ELECTRICA + " y " + MAX_RESISTENCIA_ELECTRICA
            );
        }
        this.resistenciaElectrica = resistenciaElectrica;
    }

    @Override
    public void atacar(Atacable objetivo, WeatherCondition tiempo) throws MuerteException {
        int daño = (int) (getPuntosAtaque() * bonificacionTormentaTierra);
        objetivo.recibirDaño(tiempo, daño, this);
    }

    @Override
    public void roundStart(WeatherCondition weatherCondition) throws RoundStartException {
        if (!estaVivo()) {
            return;
        }

        if (weatherCondition == WeatherCondition.TORMENTA_DE_ARENA) {
            bonificacionTormentaTierra = 1.0 + Math.random();
            throw new RoundStartException(
                    "El Pokémon " + getNombre() +
                            " recibe una bonificación por la tormenta de arena"
            );
        } else {
            bonificacionTormentaTierra = 1.0; // Reset si no hay tormenta
        }
    }

    @Override
    public boolean estaVivo() {
        return getPuntosSalud() > 0;
    }

    @Override
    public void recibirDaño(WeatherCondition tiempo, int puntosAtaque, Atacador atacador)
            throws MuerteException {

        // Reducción por resistencia eléctrica
        if (atacador instanceof PokemonElectrico) {
            puntosAtaque -= resistenciaElectrica;
            if (puntosAtaque < 0) {
                puntosAtaque = 0;
            }
        }

        // Cálculo correcto del daño con defensa
        double factorDefensa = 1 - (getDefensa() / 100.0);
        int dañoFinal = (int) (puntosAtaque * factorDefensa);

        setPuntosSalud(getPuntosSalud() - dañoFinal);

        if (!estaVivo()) {
            throw new MuerteException("El Pokémon " + getNombre() + " fue al cielo");
        }
    }
}
