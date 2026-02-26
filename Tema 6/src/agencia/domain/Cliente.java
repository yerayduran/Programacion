package agencia.domain;

import agencia.exceptions.RutaDuplicadaException;
import agencia.exceptions.RutaNoEncontradaException;

import java.util.*;

public class Cliente {

    private int id;
    private String nombre;
    private Map<String, Ruta> rutas;

    public Cliente(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.rutas = new HashMap<>();
    }

    public String getNombre() {
        return nombre;
    }

    public Collection<Ruta> getRutas() {
        return rutas.values();
    }

    public void añadirRuta(Ruta ruta) throws RutaDuplicadaException {
        if (rutas.containsKey(ruta.getNombre())) {
            throw new RutaDuplicadaException("Ruta duplicada: " + ruta.getNombre());
        }
        rutas.put(ruta.getNombre(), ruta);
    }

    public void eliminarRuta(String nombreRuta) throws RutaNoEncontradaException {
        if (rutas.remove(nombreRuta) == null) {
            throw new RutaNoEncontradaException("Ruta no encontrada: " + nombreRuta);
        }
    }

    public Ruta getRuta(String nombreRuta) throws RutaNoEncontradaException {
        Ruta ruta = rutas.get(nombreRuta);
        if (ruta == null) {
            throw new RutaNoEncontradaException("Ruta no encontrada: " + nombreRuta);
        }
        return ruta;
    }

    public Set<String> obtenerTodasLasParadas() {
        Set<String> resultado = new TreeSet<>();
        for (Ruta r : rutas.values()) {
            resultado.addAll(r.getParadas());
        }
        return resultado;
    }
}
