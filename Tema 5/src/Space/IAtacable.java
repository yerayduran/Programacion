package Space;

public interface IAtacable {
    int getPuntosDefensa();
    void serAtacado(int daño, Jugador atacante);
}