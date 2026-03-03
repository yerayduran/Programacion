package empresa;

import java.util.PriorityQueue;
import java.util.Queue;

public class Ruta {

    private String nombreDeRuta;
    private Queue<Paquete> listaDeEspera;

    public Ruta(String nombreDeRuta) {
        this.nombreDeRuta = nombreDeRuta;
        this.listaDeEspera = new PriorityQueue<>();
    }

    public String getNombreDeRuta() {
        return nombreDeRuta;
    }

    public void setNombreDeRuta(String nombreDeRuta) {
        this.nombreDeRuta = nombreDeRuta;
    }

    public Queue<Paquete> getListaDeEspera() {
        return listaDeEspera;
    }

    public void setListaDeEspera(Queue<Paquete> listaDeEspera) {
        this.listaDeEspera = listaDeEspera;
    }

    // Hacemos un método para añadir un paquete a la ruta
    public String registrarPaquete(Paquete p) throws PaqueteException{
        if (listaDeEspera.stream().anyMatch(p :: equals)){
            throw new PaqueteException("Este Paquete ya esta registrado");
        }

        listaDeEspera.add(p);

        return "El paquete " + p.getNumDeSeguimiento() + " ha sido registrado";
    }

    // Hacemos un método para entregar un paquete
    public String entregarPaquete() throws PaqueteException {
        Paquete paquete = listaDeEspera.poll();
        if (paquete == null) {
            throw new PaqueteException("No hay paquetes registrados");
        }
        return "El paquete " + paquete.getNumDeSeguimiento() + " ha sido entregado";
    }
}
