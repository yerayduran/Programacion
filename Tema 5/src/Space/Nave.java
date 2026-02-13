package Space;

public abstract class Nave extends Carta implements IAtacable {
    protected int puntosDefensa;
    protected Jugador propietario; // quien la posee
    protected Planeta orbitando;   // planeta actual

    public Nave(String nombre, int precio, int puntosDefensa) {
        super(nombre, precio);
        this.puntosDefensa = puntosDefensa;
    }

    public void asignarPropietario(Jugador propietario) {
        this.propietario = propietario;
    }

    public Jugador getPropietario() { return propietario; }

    public Planeta getOrbitando() { return orbitando; }

    public void setOrbitando(Planeta planeta) { this.orbitando = planeta; }

    @Override
    public int getPuntosDefensa() {
        return puntosDefensa;
    }

    @Override
    public void serAtacado(int daño, Jugador atacante) {
        puntosDefensa -= daño;
        if (puntosDefensa < 0) puntosDefensa = 0;
        // Las naves no cambian de propietario por ser atacadas
    }

    @Override
    public String toString() {
        return super.toString() + " | Defensa=" + puntosDefensa +
                " | Propietario=" + (propietario != null ? propietario.getNombre() : "Nadie") +
                " | Orbitando=" + (orbitando != null ? orbitando.getNombre() : "Ninguno");
    }
}