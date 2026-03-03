package agencia.domain;

import agencia.exceptions.ParadaNoEncontradaException;
import agencia.exceptions.RutaDuplicadaException;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Ruta {

    private String nombre;
    private String destinoFinal;
    private List<String> paradas;

    public Ruta(String nombre, String destinoFinal) {
        this.nombre = nombre;
        this.destinoFinal = destinoFinal;
        this.paradas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getDestinoFinal() {
        return destinoFinal;
    }

    public List<String> getParadas() {
        return paradas;
    }

    public void añadirParada(String parada) throws RutaDuplicadaException {
        if (!(this.paradas.contains(parada))) {
            this.paradas.add(parada);
        }
        else{
            throw new RutaDuplicadaException("Esta ruta no se puede añadir: " + parada);
        }
    }

    public void eliminarParada(String parada) throws ParadaNoEncontradaException {
        if (!paradas.remove(parada)) {
            throw new ParadaNoEncontradaException("La parada no existe: " + parada);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Ruta: ").append(nombre)
                .append("\nDestino: ")
                .append(destinoFinal)
                .append("\nParadas: ")
                .append(paradas.stream().sorted().collect(Collectors.joining(",")));
        return sb.toString();
    }
}