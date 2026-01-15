package Pokemon2023.model;

import Pokemon2023.enums.WeatherCondition;
import Pokemon2023.exceptions.MuerteException;
import Pokemon2023.exceptions.RoundStartException;
import Pokemon2023.exceptions.ValorNoValidoException;
import Pokemon2023.interfaces.Atacable;
import Pokemon2023.interfaces.Atacador;

public class PokemonAgua extends Pokemon implements Atacable {

    private static final int VALOR_MAX_HIDRATACION = 20;
    private static final int VALOR_MIN_HIDRATACION = 10;

    private int valorHidratacion;
    private double precision = 1.0; // Valor inicial correcto

    public PokemonAgua(String nombre, int puntosSalud, int puntosAtaque,
                       int defensa, int valorHidratacion) throws ValorNoValidoException {

        super(nombre, puntosSalud, puntosAtaque, defensa);
        setValorHidratacion(valorHidratacion);
    }

    public void setValorHidratacion(int valorHidratacion) throws ValorNoValidoException {
        if (valorHidratacion < VALOR_MIN_HIDRATACION ||
                valorHidratacion > VALOR_MAX_HIDRATACION) {

            throw new ValorNoValidoException(
                    "El valor de hidratación debe estar entre " +
                            VALOR_MIN_HIDRATACION + " y " + VALOR_MAX_HIDRATACION
            );
        }
        this.valorHidratacion = valorHidratacion;
    }

    @Override
    public void recibirDaño(WeatherCondition tiempo, int puntosAtaque, Atacador atacador)
            throws MuerteException {

        // Cálculo correcto del daño con defensa
        double factorDefensa = 1 - (getDefensa() / 100.0);
        int dañoFinal = (int) (puntosAtaque * factorDefensa);

        setPuntosSalud(getPuntosSalud() - dañoFinal);

        if (!estaVivo()) {
            throw new MuerteException("El Pokémon " + getNombre() + " fue al cielo");
        }
    }

    @Override
    public void atacar(Atacable objetivo, WeatherCondition tiempo) throws MuerteException {
        int daño = (int) (getPuntosAtaque() * precision);
        objetivo.recibirDaño(tiempo, daño, this);
    }

    @Override
    public void roundStart(WeatherCondition weatherCondition) throws RoundStartException {
        if (!estaVivo()) {
            return;
        }

        if (weatherCondition == WeatherCondition.LLUVIA) {
            // Cura por hidratación
            setPuntosSalud(getPuntosSalud() + valorHidratacion);

            // Aumenta precisión aleatoriamente
            precision += Math.random();

            throw new RoundStartException(
                    "El Pokémon " + getNombre() + " recibe una curación por la lluvia"
            );
        } else {
            precision = 1.0; // Reset si no llueve
        }
    }

    @Override
    public boolean estaVivo() {
        return getPuntosSalud() > 0;
    }
}



