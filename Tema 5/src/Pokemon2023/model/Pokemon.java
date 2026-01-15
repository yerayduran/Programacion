package Pokemon2023.model;

import Pokemon2023.enums.WeatherCondition;
import Pokemon2023.exceptions.MuerteException;
import Pokemon2023.exceptions.ValorNoValidoException;
import Pokemon2023.interfaces.Atacable;

public abstract class Pokemon implements Atacable {

    private String nombre;
    private int pts;
    private int fuerza;
    private int defensa;

    public Pokemon(String nombre, int pts, int fuerza, int defensa) {
        this.nombre = nombre;
        this.pts = pts;
        this.fuerza = fuerza;
        this.defensa = defensa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPts() {
        return pts;
    }

    public void setPts(int pts) throws ValorNoValidoException {
        if(pts <= 0 || pts > 100) {
            throw new ValorNoValidoException("los Valores de vida estarian entre 1 - 100");
        }
        this.pts = pts;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) throws ValorNoValidoException {
        if(fuerza < 5 || fuerza > 25) {
            throw new ValorNoValidoException("los Valores de fuerza deberian de estar entre 5 - 25");
        }
        this.fuerza = fuerza;
    }

    public int getDefensa() {
        return defensa;
    }

    public void setDefensa(int defensa) throws ValorNoValidoException {
        if(defensa < 5 || defensa > 25) {
            throw new ValorNoValidoException("los Valores de defensa deberian de estar entre 5 - 25");
        }
        this.defensa = defensa;
    }

}
