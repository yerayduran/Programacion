package Space;

import java.util.*;

public class Partida {
    private final Tablero tablero;
    private final List<Jugador> jugadores = new ArrayList<>();
    private int jugadorActual = 0;
    private int rondasRestantes = 10; // configurable
    private final Dado dadoB = new Dado(12, 1); // para decidir quién empieza

    public Partida(Tablero tablero) { this.tablero = tablero; }

    public Tablero getTablero() { return tablero; }
    public List<Jugador> getJugadores() { return new ArrayList<>(jugadores); }

    public void inicializar(List<String> nombresJugadores) throws JuegoException {
        if (nombresJugadores.size() < 2 || nombresJugadores.size() > 4) {
            throw new JuegoException("Número de jugadores debe ser entre 2 y 4");
        }
        for (String nombre : nombresJugadores) jugadores.add(new Jugador(nombre, 3)); // 3 de oro inicial
        decidirQuienEmpieza();
        asignarBasesAleatorias();
        tablero.mostrarPlanetas();
    }

    private void decidirQuienEmpieza() {
        int mejor = -1, idx = 0, i = 0;
        for (Jugador j : jugadores) {
            int tirada = dadoB.lanzar();
            if (tirada > mejor) { mejor = tirada; idx = i; }
            i++;
        }
        jugadorActual = idx;
    }

    private void asignarBasesAleatorias() {
        List<Planeta> libres = new ArrayList<>(tablero.getPlanetas());
        Collections.shuffle(libres);
        for (int i = 0; i < jugadores.size(); i++) {
            Planeta base = libres.get(i);
            base.conquistar(jugadores.get(i));
        }
    }

    public Jugador getJugadorActual() { return jugadores.get(jugadorActual); }

    public void pasarTurno() {
        jugadorActual = (jugadorActual + 1) % jugadores.size();
        if (jugadorActual == 0) finalizarRonda();
    }

    private void finalizarRonda() {
        // 1) Minas producen
        for (Planeta p : tablero.getPlanetas()) p.producirMinas();

        // 2) Nacen 2 personas asignables
        for (Planeta p : tablero.getPlanetas()) p.nacerPersonas(2);

        // 3) Mostrar ranking por puntuación actual
        jugadores.sort(Comparator.comparingInt(Jugador::puntuacionActual).reversed());
        System.out.println("Ranking:");
        for (Jugador j : jugadores) System.out.println(j.getNombre() + " -> " + j.puntuacionActual());

        // 4) Rondas restantes o fin de juego
        rondasRestantes--;
        System.out.println("Rondas restantes: " + Math.max(rondasRestantes, 0));
        eliminarJugadoresSinPlanetas();
        if (rondasRestantes <= 0 || jugadores.size() == 1) {
            System.out.println("Fin de la partida.");
        }
    }

    private void eliminarJugadoresSinPlanetas() {
        Iterator<Jugador> it = jugadores.iterator();
        while (it.hasNext()) {
            Jugador j = it.next();
            if (j.getPlanetas().isEmpty()) {
                System.out.println("El jugador " + j.getNombre() + " ha sido eliminado.");
                j.eliminarNaves();
                it.remove();
                if (jugadorActual >= jugadores.size()) jugadorActual = 0;
            }
        }
    }
}