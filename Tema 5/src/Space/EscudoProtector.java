package Space;

public class EscudoProtector extends Construccion implements IAtacable, IReparable {
    private int puntosDefensa;

    public EscudoProtector(Dado dadoA) {
        super("Class.Space.Escudo Protector", 5, Costes.ESCUDO_PERSONAS); // precio=5 oro
        this.puntosDefensa = 20 + dadoA.lanzar(); // base 20 + dado A
    }

    @Override
    public int getPuntosDefensa() {
        return puntosDefensa;
    }

    @Override
    public void serAtacado(int daño, Jugador atacante) {
        puntosDefensa -= daño;
        if (puntosDefensa < 0) puntosDefensa = 0;
    }

    @Override
    public void reparar(int puntos) {
        this.puntosDefensa += puntos;
    }

    public boolean estaDestruido() {
        return puntosDefensa <= 0;
    }

    @Override
    public String toString() {
        return super.toString() + " | Defensa=" + puntosDefensa;
    }
}
