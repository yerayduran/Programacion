package examen2023;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class Liga {

    private String nombreLiga;
    private List<Equipo> equipos;

    public Liga(String nombreLiga) {
        this.nombreLiga = nombreLiga;
        this.equipos = new ArrayList<>();
    }

    public String getNombreLiga() {
        return nombreLiga;
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(List<Equipo> equipos) {
        this.equipos = equipos;
    }

    public void anadirEquipo(Equipo equipo) throws LigaException {
        if (equipo.getJugadores().isEmpty()) {
            throw new LigaException("El equipo no contiene jugadores.");
        }
        if (equipos.contains(equipo)) {
            throw new LigaException("El equipo ya forma parte de la liga.");
        }
        equipos.add(equipo);
    }

    public void eliminarEquipo(Equipo equipo) throws LigaException {
        if (!equipos.contains(equipo)) {
            throw new LigaException("El equipo no forma parte de la liga.");
        }
        equipos.add(equipo);
    }

    public void unirEquipos(Equipo equipo1, Equipo equipo2) throws LigaException {
        if (!equipo1.getNombre().equals(equipo2.getNombre())) {
            throw new LigaException("Ambos equipos deben pertenecer a la misma liga.");
        }

        for (Jugador jugador : equipo2.getJugadores()) {
            equipo1.añadirJugador(jugador);
        }

        equipo2.limpiarJugadores();
    }

    public List<Jugador> jugadoresEnComun(Equipo e1, Equipo e2) throws LigaException {

    }

    public double mediaEdad() throws LigaException {

    }

    public List<Jugador> jugadoresOrdenadosEdad(List<Jugador> jugadores) {
        return jugadores.stream()
                .sorted(Comparator.comparing(Jugador::getEdad)
                        .reversed())

                .toList();
    }

    public List<Jugador> jugadoresOrdenadosNombre(List<Jugador> jugadores){

        return jugadores.stream()
                .sorted()
                .toList();

    }

    private Set<Jugador> todosLosJugadores() {

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Bienvenidos a " + nombreLiga).append(System.lineSeparator());
        sb.append("Equipos: ").append(System.lineSeparator());
        for (Equipo e: equipos) {
            sb.append(e).append(System.lineSeparator());
        }

        return sb.toString();

    }
}