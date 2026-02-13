package Space;

import java.util.ArrayList;
import java.util.List;

/**
 * Controla el número de acciones que un jugador realiza en su turno.
 * - Máximo de 2 acciones por turno (configurable).
 * - Algunas acciones NO cuentan (por ejemplo, mostrar información).
 * - Space.Acciones canceladas por el usuario NO se contabilizan.
 * - Al pasar turno, se pierden las acciones restantes.
 */
public class Turno {
    private Jugador jugador;
    private final int maxAcciones;
    private int accionesUsadas;
    private final List<AccionTurno> historial;

    public Turno(Jugador jugador) {
        this(jugador, 2);
    }

    public Turno(Jugador jugador, int maxAcciones) {
        this.jugador = jugador;
        this.maxAcciones = Math.max(1, maxAcciones);
        this.accionesUsadas = 0;
        this.historial = new ArrayList<>();
    }

    /**
     * Reinicia el turno para un nuevo jugador (se usa al rotar el turno en la Space.Partida).
     */
    public void iniciarPara(Jugador nuevoJugador) {
        this.jugador = nuevoJugador;
        this.accionesUsadas = 0;
        this.historial.clear();
    }

    /**
     * Intenta registrar una acción de turno.
     * @param accion Tipo de acción
     * @param cuentaAccion true si la acción consume una de las 2 acciones del turno; false si no
     * @throws AccionNoPermitidaException si no quedan acciones disponibles y la acción cuenta
     */
    public void registrarAccion(AccionTurno accion, boolean cuentaAccion) throws AccionNoPermitidaException {
        if (cuentaAccion && accionesUsadas >= maxAcciones) {
            throw new AccionNoPermitidaException("Ya has realizado las " + maxAcciones + " acciones permitidas en este turno");
        }
        if (cuentaAccion) accionesUsadas++;
        historial.add(accion);
    }

    /**
     * Marca explícitamente una cancelación de acción por parte del usuario.
     * No consume acción y deja constancia en el historial.
     */
    public void registrarCancelacion(String motivo) {
        // Se registra como "acción no contable" para trazabilidad
        historial.add(AccionTurno.CANCELADA);
        // Puedes loguear el motivo si necesitas auditoría
        // System.out.println("Acción cancelada: " + motivo);
    }

    /**
     * Indica si el jugador aún puede realizar alguna acción contable.
     */
    public boolean puedeAunActuar() {
        return accionesUsadas < maxAcciones;
    }

    public int getAccionesUsadas() {
        return accionesUsadas;
    }

    public int getAccionesRestantes() {
        return maxAcciones - accionesUsadas;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public List<AccionTurno> getHistorial() {
        return new ArrayList<>(historial);
    }

    /**
     * El jugador decide pasar: pierde las acciones restantes.
     * Este método solo registra la decisión; la rotación de turno la debe gestionar Space.Partida.
     */
    public void pasar() {
        historial.add(AccionTurno.PASAR);
        // No modifica accionesUsadas; simplemente no se ejecutarán más acciones este turno.
    }
}