package agencia.domain;

import java.util.*;

public class Agencia {

    private Map<Integer, Cliente> clientes;

    public Agencia() {
        this.clientes = new HashMap<>();
    }

    public void añadirCliente(Cliente cliente) {
        clientes.put(cliente.hashCode(), cliente);
    }

    public List<Cliente> clientesConParada(String parada) {
        List<Cliente> resultado = new ArrayList<>();

        for (Cliente c : clientes.values()) {
            for (Ruta r : c.getRutas()) {
                if (r.getParadas().contains(parada)) {
                    resultado.add(c);
                    break;
                }
            }
        }

        resultado.sort(Comparator.comparing(Cliente::getNombre));
        return resultado;
    }

    public List<Cliente> clientesConParadaStream(String parada) {
        return  clientes.values().stream()
                .filter(c -> c.getRutas().stream()
                    .flatMap(r-> r.getParadas().stream())
                    .anyMatch(p -> p.equalsIgnoreCase(parada))
                ).toList();
    }

    public void mostrarRutasDeUnCliente(Cliente cliente) {
        cliente.getRutas().forEach(System.out::println);
    }
}
