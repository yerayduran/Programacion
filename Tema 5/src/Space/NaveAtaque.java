package Space;

public class NaveAtaque extends Nave implements IAtacador, IMejorable, IReparable {
    private int poderAtaque = 3; // por defecto

    public NaveAtaque() {
        super("Space.Nave de Ataque", 5, 7);
    }

    @Override
    public void atacar(IAtacable objetivo) {
        objetivo.serAtacado(poderAtaque, this.propietario);
    }

    @Override
    public void mejorar() {
        // mejora: suma el poder por defecto al actual
        poderAtaque += 3;
    }

    @Override
    public void reparar(int puntos) {
        this.puntosDefensa += puntos;
    }

    public int getPoderAtaque() { return poderAtaque; }
}
