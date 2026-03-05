package examen2023;


import java.util.HashSet;
import java.util.Set;

public class Equipo {

    private String nombre;
    private Set<Jugador> jugadores;

    public Equipo(String nombre) {
        this.nombre = nombre;
        this.jugadores = new HashSet<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(Set<Jugador> jugadores){
        this.jugadores = jugadores;
    }

    public void añadirJugador(Jugador jugador) throws LigaException {
        if (!jugadores.add(jugador)) {
            throw new LigaException("Este Jugador ya esta en el equipo");
        }
    }

}
