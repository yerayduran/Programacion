package Space;

import java.util.ArrayList;
import java.util.List;

public class Planeta implements IAtacable {
    private final String nombre;
    private Jugador conquistador; // null si está libre
    private int habitantesTotales;        // total habitantes del planeta
    private int habitantesDisponibles;    // asignables (no vinculados a construcciones)
    private int piedra;
    private int hierro;
    private int combustible;
    private final List<Mina> minas = new ArrayList<>();
    private EscudoProtector escudo;
    private final List<Nave> naves = new ArrayList<>();

    private static final int MAX_MINAS = 10;
    private static final int MAX_NAVES_ORBITA = 100;

    public Planeta(String nombre) {
        this.nombre = nombre;
        this.conquistador = null;
        this.habitantesTotales = 30;
        this.habitantesDisponibles = 30;
        this.piedra = 5;
        this.hierro = 4;
        this.combustible = 2;
    }

    public String getNombre() { return nombre; }
    public Jugador getConquistador() { return conquistador; }
    public boolean estaConquistado() { return conquistador != null; }

    public int getHabitantesTotales() { return habitantesTotales; }
    public int getHabitantesDisponibles() { return habitantesDisponibles; }

    public int getPiedra() { return piedra; }
    public int getHierro() { return hierro; }
    public int getCombustible() { return combustible; }

    public List<Mina> getMinas() { return new ArrayList<>(minas); }
    public EscudoProtector getEscudo() { return escudo; }

    public List<Nave> getNaves() { return new ArrayList<>(naves); }

    public void conquistar(Jugador jugador) {
        this.conquistador = jugador;
        jugador.agregarPlaneta(this);
        jugador.agregarRecursos(piedra, hierro, combustible);
        jugador.agregarHabitantes(habitantesDisponibles);
        jugador.agregarMinas(minas);
    }

    public void agregarNave(Nave nave) {
        if (naves.size() >= MAX_NAVES_ORBITA) {
            throw new IllegalStateException("Máximo 100 naves orbitando el planeta");
        }
        naves.add(nave);
        nave.setOrbitando(this);
    }

    public void retirarNave(Nave nave) {
        naves.remove(nave);
        if (nave.getOrbitando() == this) nave.setOrbitando(null);
    }

    public void agregarConstruccion(Mina mina) {
        if (minas.size() >= MAX_MINAS) {
            throw new IllegalStateException("El planeta ya tiene el máximo de minas (10)");
        }
        minas.add(mina);
        // Las personas quedan asignadas; no se pueden desasignar según reglas
        habitantesDisponibles -= mina.getPersonasAsignadas();
    }

    public void asignarEscudo(EscudoProtector esc) {
        this.escudo = esc;
        habitantesDisponibles -= esc.getPersonasAsignadas();
    }

    public boolean tieneRecursos(int reqPiedra, int reqHierro, int reqCombustible) {
        return piedra >= reqPiedra && hierro >= reqHierro && combustible >= reqCombustible;
    }

    public void consumirRecursos(int consPiedra, int consHierro, int consCombustible) {
        piedra -= consPiedra;
        hierro -= consHierro;
        combustible -= consCombustible;
    }

    public void asignarPersonas(int cantidad) {
        if (habitantesDisponibles < cantidad) throw new IllegalStateException("No hay suficientes habitantes asignables");
        habitantesDisponibles -= cantidad;
    }

    public void liberarPersonas(int cantidad) {
        habitantesDisponibles += cantidad;
        habitantesTotales += 0; // no cambia el total, se re-asignan
    }

    public void nacerPersonas(int cantidad) {
        habitantesTotales += cantidad;
        habitantesDisponibles += cantidad;
    }

    public void producirMinas() {
        for (Mina m : minas) {
            switch (m.getMaterial().toLowerCase()) {
                case "piedra" -> piedra += m.getProduccionPorTurno();
                case "hierro" -> hierro += m.getProduccionPorTurno();
                case "combustible" -> combustible += m.getProduccionPorTurno();
                case "oro" -> {
                    if (conquistador != null) conquistador.agregarOro(2); // oro va al jugador
                }
            }
        }
    }

    @Override
    public int getPuntosDefensa() {
        return escudo != null ? escudo.getPuntosDefensa() : 0;
    }

    @Override
    public void serAtacado(int daño, Jugador atacante) {
        // No es posible atacar un planeta no conquistado por otro jugador
        if (!estaConquistado()) {
            System.out.println("No puedes atacar un planeta desocupado.");
            return;
        }

        if (escudo != null) {
            // Probabilidad de esquivar: tirada del dado B igual al min o al max
            Dado dadoB = new Dado(12, 1);
            int tirada = dadoB.lanzar();
            if (tirada == dadoB.getMin() || tirada == dadoB.getMax()) {
                System.out.println("El escudo esquiva el ataque!");
                return;
            }
            escudo.serAtacado(daño, atacante);
            if (escudo.estaDestruido()) {
                System.out.println("Space.Escudo destruido. El planeta es conquistado por " + atacante.getNombre());
                // Al destruir escudo, las personas asignadas regresan al pool (regla)
                liberarPersonas(escudo.getPersonasAsignadas());
                conquistar(atacante);
            }
        } else {
            System.out.println("El planeta no tiene escudo. Es conquistado por " + atacante.getNombre());
            conquistar(atacante);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Space.Planeta: ").append(nombre).append("\n");
        sb.append("Conquistado: ").append(estaConquistado() ? "Sí, por " + conquistador.getNombre() : "No").append("\n");
        sb.append("Habitantes: totales=").append(habitantesTotales).append(", disponibles=").append(habitantesDisponibles).append("\n");
        sb.append("Materias primas: Piedra=").append(piedra).append(", Hierro=").append(hierro).append(", Boletin5Parte1.Ejercicio2.Combustible=").append(combustible).append("\n");
        sb.append("Minas actuales: ").append(minas.isEmpty() ? "Ninguna" : minas.size()).append("\n");
        sb.append("Space.Escudo protector: ");
        if (escudo != null) sb.append("Sí, defensa=").append(escudo.getPuntosDefensa()).append("\n");
        else sb.append("No\n");
        sb.append("Naves orbitando: ").append(naves.size()).append("\n");
        return sb.toString();
    }
}