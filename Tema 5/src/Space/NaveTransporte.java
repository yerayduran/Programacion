package Space;

public class NaveTransporte extends Nave implements ITransportable, IMejorable, IReparable {
    private int capacidad;

    public NaveTransporte(Dado dadoC) {
        super("Space.Nave de Transporte", 2, 4);
        this.capacidad = dadoC.lanzar(); // capacidad determinada al comprar
    }

    @Override
    public void transportar(Planeta destino, int personas) {
        // La logística completa se gestiona desde Space.Acciones.transportarPersonas(...)
    }

    @Override
    public void mejorar() {
        capacidad *= 2;
    }

    @Override
    public void reparar(int puntos) {
        this.puntosDefensa += puntos;
    }

    public int getCapacidad() { return capacidad; }
}
