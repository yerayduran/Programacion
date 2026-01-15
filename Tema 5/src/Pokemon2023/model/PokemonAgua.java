package Pokemon2023.model;

import Pokemon2023.enums.WeatherCondition;
import Pokemon2023.exceptions.MuerteException;
import Pokemon2023.exceptions.RoundStartException;
import Pokemon2023.exceptions.ValorNoValidoException;
import Pokemon2023.interfaces.Atacable;
import Pokemon2023.interfaces.Atacador;

public class PokemonAgua extends Pokemon{

    private static final int VALOR_MAX_HIDRATACION = 20;
    private static final int VALOR_MIN_HIDRATACION = 10;
    private int valorHidratacion;
    private double precision;

    public PokemonAgua(String nombre, int puntosSalud, int puntosAtaque, int defensa, int valorHidratacion) throws ValorNoValidoException {
        super(nombre, puntosSalud, puntosAtaque, defensa);
        setValorHidratacion(valorHidratacion);
        precision = 1d;
    }

    public void setValorHidratacion(int valorHidratacion) throws ValorNoValidoException {
        if(valorHidratacion < VALOR_MIN_HIDRATACION || valorHidratacion > VALOR_MAX_HIDRATACION){
            throw new ValorNoValidoException("El Valor de la hidratación debe de estar entre " + VALOR_MIN_HIDRATACION + " y " + VALOR_MAX_HIDRATACION);
        }
        this.valorHidratacion = valorHidratacion;
    }

    @Override
    public void recibirDaño(WeatherCondition tiempo, int puntosAtaque, Atacador atacador) throws MuerteException {

        setPuntosSalud(getPuntosSalud() - puntosAtaque *(1 - getDefensa() / 100));
        if (!estaVivo()){
            throw new MuerteException("El pokemón " + getNombre() + " fue al cielo");
        }

    }

    @Override
    public void atacar(Atacable objetivo, WeatherCondition tiempo) throws MuerteException {
            objetivo.recibirDaño(tiempo, (int) (getPuntosAtaque() * precision), this);

    }

    @Override
    public void roundStart(WeatherCondition weatherCondition) throws RoundStartException {
        if(!estaVivo()){
            return;
        }
        if (weatherCondition == WeatherCondition.LLUVIA){
            setPuntosSalud(getPuntosSalud() + valorHidratacion);
            precision += Math.random();
            throw new RoundStartException("El Pokemón " + getNombre() + " recibe una curacion por la lluvia");
        }else{
            precision = 1d;
        }

    }

    @Override
    public boolean estaVivo() {
        return false;
    }
}



