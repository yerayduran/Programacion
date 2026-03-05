package examen2023;


import java.util.*;
import java.util.stream.Collectors;

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
        if (!equipos.remove(equipo)) {
            throw new LigaException("El equipo no forma parte de la liga.");
        }
    }

    public void unirEquipos(Equipo equipo1, Equipo equipo2) throws LigaException {
        if (equipos.contains(equipo1) && equipos.contains(equipo2)) {
            Set<Jugador> nuevoJugadores = new HashSet<>(equipo1.getJugadores());
            nuevoJugadores.addAll(equipo2.getJugadores());
            equipo1.setJugadores(nuevoJugadores);
        }
        else {
            throw new LigaException("Uno de estos dos equipos no esta en la liga");
        }
    }

    public String jugadoresEnComun(Equipo e1, Equipo e2) throws LigaException {
        if (equipos.contains(e1) && equipos.contains(e2)) {
            return e1.getJugadores().stream()
                    .filter(e2.getJugadores()::contains)
                    .map(Jugador::getNombre)
                    .collect(Collectors.joining(", "));
        }
        else {
            throw new LigaException("Uno de estos dos equipos ya esta en la liga");
        }
    }

    public double mediaEdad() throws LigaException {
        return todosLosJugadores().stream().mapToDouble(Jugador::getEdad)
                .average().orElseThrow(()  -> new LigaException("No se puede cargar la edad media"));
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

    public Set<Jugador> todosLosJugadores() {
        return equipos.stream().flatMap(equipo -> equipo.getJugadores().stream()).collect(Collectors.toSet());
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