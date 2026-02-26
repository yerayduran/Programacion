package agencia.domain;

import agencia.exceptions.ParadaNoEncontradaException;

import java.util.Set;
import java.util.TreeSet;

public class Ruta {

    private String nombre;
    private String destinoFinal;
    private Set<String> paradas;

    public Ruta(String nombre, String destinoFinal) {
        this.nombre = nombre;
        this.destinoFinal = destinoFinal;
        this.paradas = new TreeSet<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getDestinoFinal() {
        return destinoFinal;
    }

    public Set<String> getParadas() {
        return paradas;
    }

    public void añadirParada(String parada) {
        paradas.add(parada);
    }

    public void eliminarParada(String parada) throws ParadaNoEncontradaException {
        if (!paradas.remove(parada)) {
            throw new ParadaNoEncontradaException("La parada no existe: " + parada);
        }
    }
}