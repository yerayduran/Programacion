package Boletin2.Ejercicio8;

import Ejercicio4.MiEntradaSalida;
import Ejercicio8.Exception.FutbolException;

public class BeSoccer {
    public static void main(String[] args) {

        // Creamos los partidos
        Partidos partido;
        Partidos partido2;
        Partidos partido3;

        //Creamos los equipos y sus atributos
        Equipo equipo1;
        Equipo equipo2;
        Equipo equipo3;

        // Hacemos que se repita hasta que se haya jugado el partido
        int opcion;
        try {
            // Definimos los atributos de los equipos
            equipo1 = new Equipo("Barcelona");
            equipo2 = new Equipo("Sevilla F.C.");
            equipo3 = new Equipo("Rayo Vallecano");

            // Definimos los atributos del partido
            partido = new Partidos(7, "Camp Nou", equipo1, equipo2);

            // Creamos el resultado del partido, se lo pasamos por parámetros al método
            opcion = MiEntradaSalida.solicitarEnteroPositivo("Pulsa 1 para jugar el primer partido");
            if (opcion == 1) {
                partido.ponerResultado("2-1");
            }

            // Mostramos la información
            System.out.println(partido);

            int opcion2;

            partido2 = new Partidos(12, "Estadio de Vallecas", equipo3, equipo2);

            opcion2 = MiEntradaSalida.solicitarEnteroPositivo("Pulsa 1 para jugar el segundo partido");
            if (opcion2 == 1) {
                partido2.ponerResultado("0-0");
            }

            System.out.println(partido2);

            int opcion3;

            partido3 = new Partidos(24, "Estadio de Vallecas", equipo3, equipo1);

            opcion3 = MiEntradaSalida.solicitarEnteroPositivo("Pulsa 1 para jugar el tercer partido");
            if (opcion3 == 1) {

                partido3.ponerResultado("1-2");
            }

            System.out.println(partido3);

        } catch (FutbolException e) {
            System.out.println(e.getMessage());
        }
    }
}