package Pokemon2023.model;

import Pokemon2023.enums.WeatherCondition;
import Pokemon2023.exceptions.MuerteException;
import Pokemon2023.exceptions.RoundStartException;
import Pokemon2023.exceptions.ValorNoValidoException;
import Pokemon2023.interfaces.Atacable;
import Pokemon2023.interfaces.Atacador;

public class PokemonFuego extends Pokemon{
    private static final int MIN_RESISTENCIA_AGUA= 5;
    private static final int MAX_RESISTENCIA_AGUA= 10;
    private int resistenciaAgua;
    private double bonificacionSol;

    public PokemonFuego(String nombre, int puntosSalud, int puntosAtaque, int defensa, int resistenciaAgua) throws ValorNoValidoException {
        super(nombre, puntosSalud, puntosAtaque, defensa);
        setResistenciaAgua(resistenciaAgua);
    }

    public void setResistenciaAgua(int resistenciaAgua) throws ValorNoValidoException {
        if (resistenciaAgua < MIN_RESISTENCIA_AGUA || resistenciaAgua > MAX_RESISTENCIA_AGUA){
            throw new ValorNoValidoException("El valor de resistencia al agua debe estar entre los valores min y max");
        }
        this.resistenciaAgua = resistenciaAgua;
    }

    @Override
    public void roundStart(WeatherCondition weatherCondition) throws RoundStartException {
        if (!estaVivo()){
            return;
        }
        if (weatherCondition == WeatherCondition.SOL){
            bonificacionSol = 1d + Math.random();
            throw new RoundStartException("El Pokemón "+ getNombre() + " recibe una bonificacion por sol");
        }

    }

    @Override
    public void recibirDaño(WeatherCondition tiempo, int puntosAtaque, Atacador atacador) throws MuerteException {
        if (atacador instanceof PokemonAgua){
            puntosAtaque -= resistenciaAgua;

            if (puntosAtaque < 0 ){
                puntosAtaque = 0;
            }
        }

        setPuntosSalud(getPuntosSalud() - puntosAtaque *(1 - getDefensa() / 100));

        if (!estaVivo()){
            throw new MuerteException("El Pokemón "+ getNombre() + "  nos ha dejado");
        }
    }

    @Override
    public void atacar(Atacable objetivo, WeatherCondition tiempo) throws MuerteException {
        objetivo.recibirDaño(tiempo, (int) (getPuntosAtaque() * bonificacionSol), this);
    }

    @Override
    public boolean estaVivo() {
        return false;
    }
}
