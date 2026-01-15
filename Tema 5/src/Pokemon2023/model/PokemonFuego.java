package Pokemon2023.model;

import Pokemon2023.enums.WeatherCondition;
import Pokemon2023.exceptions.MuerteException;
import Pokemon2023.exceptions.RoundStartException;
import Pokemon2023.exceptions.ValorNoValidoException;
import Pokemon2023.interfaces.Atacable;
import Pokemon2023.interfaces.Atacador;

public class PokemonFuego extends Pokemon implements Atacable {

    private static final int MIN_RESISTENCIA_AGUA = 5;
    private static final int MAX_RESISTENCIA_AGUA = 10;

    private int resistenciaAgua;
    private double bonificacionSol = 1.0; // Valor por defecto

    public PokemonFuego(String nombre, int puntosSalud, int puntosAtaque,
                        int defensa, int resistenciaAgua) throws ValorNoValidoException {

        super(nombre, puntosSalud, puntosAtaque, defensa);
        setResistenciaAgua(resistenciaAgua);
    }

    public void setResistenciaAgua(int resistenciaAgua) throws ValorNoValidoException {
        if (resistenciaAgua < MIN_RESISTENCIA_AGUA || resistenciaAgua > MAX_RESISTENCIA_AGUA) {
            throw new ValorNoValidoException(
                    "La resistencia al agua debe estar entre " +
                            MIN_RESISTENCIA_AGUA + " y " + MAX_RESISTENCIA_AGUA
            );
        }
        this.resistenciaAgua = resistenciaAgua;
    }

    @Override
    public void roundStart(WeatherCondition weatherCondition) throws RoundStartException {
        if (!estaVivo()) {
            return;
        }

        if (weatherCondition == WeatherCondition.SOL) {
            bonificacionSol = 1.0 + Math.random();
            throw new RoundStartException(
                    "El Pokémon " + getNombre() + " recibe una bonificación por el sol"
            );
        } else {
            bonificacionSol = 1.0; // Reset si no hay sol
        }
    }

    @Override
    public void recibirDaño(WeatherCondition tiempo, int puntosAtaque, Atacador atacador)
            throws MuerteException {

        // Reducción por resistencia al agua
        if (atacador instanceof PokemonAgua) {
            puntosAtaque -= resistenciaAgua;
            if (puntosAtaque < 0) {
                puntosAtaque = 0;
            }
        }

        // Cálculo correcto del daño con defensa
        double factorDefensa = 1 - (getDefensa() / 100.0);
        int dañoFinal = (int) (puntosAtaque * factorDefensa);

        setPuntosSalud(getPuntosSalud() - dañoFinal);

        if (!estaVivo()) {
            throw new MuerteException("El Pokémon " + getNombre() + " nos ha dejado");
        }
    }

    @Override
    public void atacar(Atacable objetivo, WeatherCondition tiempo) throws MuerteException {
        int daño = (int) (getPuntosAtaque() * bonificacionSol);
        objetivo.recibirDaño(tiempo, daño, this);
    }

    @Override
    public boolean estaVivo() {
        return getPuntosSalud() > 0;
    }
}