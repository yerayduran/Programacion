package examen2023;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class Liga {
    private List<Equipo> equipos;
    private String nombre;

    public Liga(String nombre) {
        super();
        this.equipos = new ArrayList<>();
        this.nombre = nombre;
    }
    /**
     * Añade un nuevo equipo a la liga, siempre que tenga jugadores y no esté repetido.
     *
     * @param e El equipo a añadir.
     * @return El número total de equipos en la liga tras la inserción.
     * @throws LigaException Si el equipo está vacío o ya existe en la liga.
     */
    public int addEquipo(Equipo e) throws LigaException {
        if (e.getJugadores().isEmpty()) {
            throw new LigaException("No puedes añadir un equipo vacío");
        }

        if (!equipos.contains(e)) {
            equipos.add(e);
            return equipos.size();
        } else {
            throw new LigaException("El equipo ya se había añadido");
        }
    }

    /**
     * Elimina un equipo existente de la liga.
     *
     * @param e El equipo a eliminar.
     * @return El número de equipos restantes en la liga.
     * @throws LigaException Si el equipo no pertenece a la liga.
     */
    public int eliminaEquipo(Equipo e) throws LigaException {
        if (!equipos.contains(e)) {
            throw new LigaException("El equipo que buscas no juega en esta liga");
        }

        equipos.remove(e);
        return equipos.size();
    }

    /**
     * Une dos equipos de la liga, transfiriendo todos los jugadores del segundo al primero.
     *
     * @param e1 El equipo que recibirá los jugadores.
     * @param e2 El equipo del que se tomarán los jugadores.
     * @throws LigaException Si alguno de los equipos no pertenece a la liga.
     */
    public void unirEquipos(Equipo e1, Equipo e2) throws LigaException {
        if (equipos.contains(e1) && equipos.contains(e2)) {
            e1.getJugadores().addAll(e2.getJugadores());
        } else {
            throw new LigaException("Los dos equipos deben pertenecer a la liga");
        }
    }

    /**
     * Obtiene una lista de jugadores que están en ambos equipos.
     *
     * @param e1 El primer equipo.
     * @param e2 El segundo equipo.
     * @return Lista de jugadores comunes entre ambos equipos.
     * @throws LigaException Si alguno de los equipos no pertenece a la liga.
     */
    public List<Jugador> jugadoresEnComun(Equipo e1, Equipo e2) throws LigaException {
        if (equipos.contains(e1) && equipos.contains(e2)) {
            return e1.getJugadores().stream()
                    .filter(e2.getJugadores()::contains)
                    .toList();
        } else {
            throw new LigaException("Los equipos indicados no juegan en esta liga");
        }
    }

    /**
     * Calcula la edad media de todos los jugadores de la liga.
     *
     * @return La edad media en años de los jugadores.
     * @throws LigaException Si la liga no tiene jugadores registrados.
     */
    public double mediaEdad() throws LigaException {
        LocalDate fechaActual = LocalDate.now();

        return todosLosJugadores().stream()
                .mapToDouble(j -> {
                    Period periodo = Period.between(j.getFechaNacimiento(), fechaActual);
                    return periodo.getYears();
                })
                .average()
                .orElseThrow(() -> new LigaException("No hay jugadores en la liga"));
    }

    /**
     * Devuelve una lista de todos los jugadores de la liga, ordenados por edad.
     *
     * @return Lista de jugadores ordenados según el criterio natural (edad si Jugador implementa Comparable).
     */
    public List<Jugador> jugadoresOrdenadosEdad() {
        return todosLosJugadores().stream()
                .sorted()
                .toList();
    }

    /**
     * Devuelve una lista de todos los jugadores de la liga ordenados alfabéticamente por nombre.
     *
     * @return Lista de jugadores ordenada por nombre.
     */
    public List<Jugador> jugadoresOrdenadosNombre() {
        return todosLosJugadores().stream()
                .sorted(Comparator.comparing(Jugador::getNombre))
                .toList();
    }

    /**
     * Obtiene un conjunto con todos los jugadores pertenecientes a los equipos de la liga.
     * Los jugadores duplicados se eliminan automáticamente al usar un {@link HashSet}.
     *
     * @return Un conjunto que contiene todos los jugadores de la liga.
     */
    public Set<Jugador> todosLosJugadores() {
        Set<Jugador> todosLosJugadores = new HashSet<>();
        equipos.forEach(e -> todosLosJugadores.addAll(e.getJugadores()));
        return todosLosJugadores;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Bienvenidos a " + nombre).append(System.lineSeparator());
        sb.append("Equipos: ").append(System.lineSeparator());
        for (Equipo e: equipos) {
            sb.append(e).append(System.lineSeparator());
        }

        return sb.toString();

    }
}