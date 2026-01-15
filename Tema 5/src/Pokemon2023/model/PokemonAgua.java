package Pokemon2023.model;

import Pokemon2023.interfaces.Atacado;

public class PokemonAgua extends Pokemon implements Atacado {

    private int numDeHidratacion;

    public PokemonAgua(String nombre, int pts, int fuerza, int defensa, int numDeHidratacion) {
        super(nombre, pts, fuerza, defensa);
        this.setNumDeHidratacion(numDeHidratacion);
    }

    public int getNumDeHidratacion() {
        return numDeHidratacion;
    }

    public void setNumDeHidratacion(int numDeHidratacion) {
        this.numDeHidratacion = numDeHidratacion;
    }

    @Override
    public void atacar() {

    }

    @Override
    public void atacado() {

    }
}
