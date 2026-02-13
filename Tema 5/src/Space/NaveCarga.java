package Space;

public class NaveCarga extends Nave implements ITransportador, IMejorable, IReparable {
    private int capacidadCarga;

    public NaveCarga(Dado dadoA) {
        super("Space.Nave de Carga", 3, 4);
        this.capacidadCarga = dadoA.lanzar(); // capacidad determinada al comprar
    }

    @Override
    public void transportar(Planeta destino, String[] materiales, int[] cantidades) {
        // La logística completa se gestiona desde Class.Space.Acciones.transportarCarga(...)
        // Esta implementación es intencionalmente mínima.
    }

    @Override
    public void mejorar() {
        capacidadCarga *= 2;
    }

    @Override
    public void reparar(int puntos) {
        this.puntosDefensa += puntos;
    }

    public int getCapacidadCarga() { return capacidadCarga; }
}