package Space;

public class Escudo {
    private int defensa;

    public Escudo(int defensa) {
        this.defensa = defensa;
    }

    public int getDefensa() {
        return defensa;
    }

    public void recibirAtaque(int daño) {
        defensa -= daño;
        if (defensa < 0) defensa = 0;
    }

    @Override
    public String toString() {
        return "Space.Escudo{defensa=" + defensa + "}";
    }
}
