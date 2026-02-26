package agencia.main;

import agencia.domain.Agencia;
import agencia.domain.Cliente;
import agencia.domain.Ruta;

public class Aplicacion {

    public static void main(String[] args) {

        try {
            Cliente c1 = new Cliente(1, "Yeray");
            Cliente c2 = new Cliente(2, "Bermudo");
            Cliente c3 = new Cliente(3, "Manuel");
            Cliente c4 = new Cliente(4, "Isaac");


            Ruta r1 = new Ruta("Ruta Norte", "París");
            r1.añadirParada("Huelva");
            r1.añadirParada("Caceres");

            Ruta r2 = new Ruta("Ruta Sur", "Roma");
            r2.añadirParada("Madrid");
            r2.añadirParada("Sevilla");

            c1.añadirRuta(r1);
            c1.añadirRuta(r2);

            System.out.println("Paradas de Yeray:");
            System.out.println(c1.obtenerTodasLasParadas());

            Agencia agencia = new Agencia();
            agencia.añadirCliente(c1);
            agencia.añadirCliente(c2);
            agencia.añadirCliente(c3);
            agencia.añadirCliente(c4);

            System.out.println("\nClientes con parada 'Huelva':");
            for (Cliente c : agencia.clientesConParada("Huelva")) {
                System.out.println(c.getNombre());
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
