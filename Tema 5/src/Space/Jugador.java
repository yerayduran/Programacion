package Space;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
    private final String nombre;
    private int oro;
    private final List<Planeta> planetas = new ArrayList<>();
    private final List<Nave> naves = new ArrayList<>();
    private final List<Construccion> mazoConstrucciones = new ArrayList<>();

    private int piedra;      // inventario del jugador (opcional)
    private int hierro;      // usado para costes de mejora/reparación si decides modelarlo así
    private int combustible;

    public Jugador(String nombre, int oroInicial) {
        this.nombre = nombre;
        this.oro = oroInicial;
    }

    public String getNombre() { return nombre; }
    public int getOro() { return oro; }
    public List<Planeta> getPlanetas() { return new ArrayList<>(planetas); }
    public List<Nave> getNaves() { return new ArrayList<>(naves); }
    public List<Construccion> getCartasConstruccion() { return new ArrayList<>(mazoConstrucciones); }

    public void pagarOro(int cantidad) {
        if (oro < cantidad) throw new IllegalStateException("No tienes suficiente oro");
        oro -= cantidad;
    }

    public void agregarOro(int cantidad) { oro += cantidad; }

    public void agregarPlaneta(Planeta planeta) { if (!planetas.contains(planeta)) planetas.add(planeta); }

    public void agregarRecursos(int piedra, int hierro, int combustible) {
        // si decides acumular en inventario de jugador adicionalmente
        this.piedra += piedra;
        this.hierro += hierro;
        this.combustible += combustible;
    }

    public void agregarHabitantes(int cantidad) {
        // opcional: tracking a nivel jugador
    }

    public void agregarMinas(List<Mina> minas) {
        // opcional: tracking a nivel jugador
    }

    public void agregarCartaConstruccion(Construccion c) { mazoConstrucciones.add(c); }
    public void removerCartaConstruccion(Construccion c) { mazoConstrucciones.remove(c); }

    public void agregarNave(Nave nave, Planeta planeta) {
        naves.add(nave);
        nave.asignarPropietario(this);
        planeta.agregarNave(nave);
    }

    public void eliminarNaves() {
        for (Nave n : naves) {
            Planeta p = n.getOrbitando();
            if (p != null) p.retirarNave(n);
        }
        naves.clear();
    }

    // Puntuación según reglas
    public int puntuacionActual() {
        int puntos = 0;

        // 1. Planetas conquistados
        puntos += planetas.size() * 10;

        // 2. Escudos protectores en pie
        for (Planeta p : planetas) {
            if (p.getEscudo() != null && !p.getEscudo().estaDestruido()) puntos += 3;
        }

        // 3. Minas en tus planetas
        for (Planeta p : planetas) {
            puntos += p.getMinas().size() * 2;
        }

        // 4. Habitantes (1 punto por cada 20)
        int totalHabitantes = 0;
        for (Planeta p : planetas) {
            totalHabitantes += p.getHabitantesTotales();
        }
        puntos += totalHabitantes / 20;

        // 5. Naves no destruidas (2 puntos cada una)
        for (Nave n : naves) {
            if (n.getPuntosDefensa() > 0) puntos += 2;
        }

        // 6. Oro (1 punto por cada unidad)
        puntos += oro;

        // 7. Materias primas en planetas (cada 3 suman 1 punto)
        int totalMaterias = 0;
        for (Planeta p : planetas) {
            totalMaterias += p.getPiedra();
            totalMaterias += p.getHierro();
            totalMaterias += p.getCombustible();
        }
        puntos += totalMaterias / 3;

        return puntos;
    }

    @Override
    public String toString() {
        return "Space.Jugador{" +
                "nombre='" + nombre + '\'' +
                ", oro=" + oro +
                ", planetas=" + planetas.size() +
                ", naves=" + naves.size() +
                '}';
    }
}