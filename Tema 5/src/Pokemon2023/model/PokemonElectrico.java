package Pokemon2023.model;

import Pokemon2023.enums.WeatherCondition;
import Pokemon2023.exceptions.MuerteException;
import Pokemon2023.exceptions.RoundStartException;
import Pokemon2023.exceptions.ValorNoValidoException;
import Pokemon2023.interfaces.Atacable;
import Pokemon2023.interfaces.Atacador;

public class PokemonElectrico extends Pokemon implements Atacable {

    private int resistenciaDeLluvia;
    private double bonificacionTormenta = 1.0; // Valor por defecto

    private static final int VALOR_MINIMO_DE_DAÑO_LLUVIA = 10;
    private static final int VALOR_MAXIMO_DE_DAÑO_LLUVIA = 15;

    public PokemonElectrico(String nombre, int puntosSalud, int puntosAtaque,
                            int defensa, int resistenciaDeLluvia)
            throws ValorNoValidoException {

        super(nombre, puntosSalud, puntosAtaque, defensa);
        setResistenciaDeLluvia(resistenciaDeLluvia);
    }

    public void setResistenciaDeLluvia(int resistenciaDeLluvia) throws ValorNoValidoException {
        if (resistenciaDeLluvia < VALOR_MINIMO_DE_DAÑO_LLUVIA ||
                resistenciaDeLluvia > VALOR_MAXIMO_DE_DAÑO_LLUVIA) {

            throw new ValorNoValidoException(
                    "La resistencia de lluvia debe estar entre " +
                            VALOR_MINIMO_DE_DAÑO_LLUVIA + " y " + VALOR_MAXIMO_DE_DAÑO_LLUVIA
            );
        }
        this.resistenciaDeLluvia = resistenciaDeLluvia;
    }

    @Override
    public void atacar(Atacable objetivo, WeatherCondition tiempo) throws MuerteException {
        int daño = (int) (getPuntosAtaque() * bonificacionTormenta);
        objetivo.recibirDaño(tiempo, daño, this);
    }

    @Override
    public void recibirDaño(WeatherCondition tiempo, int puntosAtaque, Atacador atacador)
            throws MuerteException {

        // Si llueve y el atacante es eléctrico, el daño aumenta
        if (tiempo == WeatherCondition.LLUVIA && atacador instanceof PokemonElectrico) {
            puntosAtaque += resistenciaDeLluvia;
        }

        // Cálculo correcto del daño con defensa
        double factorDefensa = 1 - (getDefensa() / 100.0);
        int dañoFinal = (int) (puntosAtaque * factorDefensa);

        setPuntosSalud(getPuntosSalud() - dañoFinal);

        if (!estaVivo()) {
            throw new MuerteException("El Pokémon " + getNombre() + " fue al cielo");
        }
    }

    @Override
    public void roundStart(WeatherCondition weatherCondition) throws RoundStartException {
        if (!estaVivo()) {
            return;
        }

        if (weatherCondition == WeatherCondition.TORMENTA_ELECTRICA) {
            bonificacionTormenta = 1.0 + Math.random();
            throw new RoundStartException(
                    "El Pokémon " + getNombre() + " recibe una bonificación por la tormenta eléctrica"
            );
        } else {
            bonificacionTormenta = 1.0; // Reset si no hay tormenta
        }
    }

    @Override
    public boolean estaVivo() {
        return getPuntosSalud() > 0;
    }
}