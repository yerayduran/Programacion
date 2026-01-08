package Boletin3.Ejercicio1;

import Boletin1.Ejercicio2.MiEntradaSalida;
import Ejercicio1.Exception.CartaException;

public class Poker {
    public static void main(String[] args) {

        // Creamos el objeto juego
        Juego juego = new Juego();

        // Creamos la baraja
        juego.crearCartasEnBaraja();

        // Mostramos la baraja que se ha creado
        System.out.println("Baraja antes de barajar");
        System.out.println(juego);

        // Barajamos la baraja
        System.out.println(" ");
        juego.barajar();

        System.out.println("Baraja ya una vez barajada");
        System.out.println(juego);
        System.out.println(" ");

        boolean error;
        int respuesta;
        int cartasPendientes = 0; // aquí guardaremos las cartas que faltaron

        do {
            do {
                error = true;
                try {
                    int jugadores = MiEntradaSalida.solicitarEnteroPositivo("Introduce el número de jugadores");

                    int cartasARepartir;
                    // Si quedaron cartas pendientes y el usuario eligió continuar, usamos ese número
                    if (cartasPendientes > 0) {
                        cartasARepartir = cartasPendientes;
                        cartasPendientes = 0; // las vamos a repartir ahora
                        System.out.println("Repartiendo las " + cartasARepartir + " cartas pendientes...");
                    } else {
                        cartasARepartir = MiEntradaSalida.solicitarEnteroPositivo("Introduce el número de cartas");
                    }

                    // Intentamos repartir
                    cartasPendientes = juego.repartir(jugadores, cartasARepartir);
                    // IMPORTANTE: el método repartir debe devolver cuántas cartas quedaron sin repartir
                    error = false;

                } catch (CartaException e) {
                    System.out.println(e.getMessage());
                }
            } while (error);

            // Mostramos las cartas que quedan en el mazo
            juego.cartasRestantes();

            respuesta = MiEntradaSalida.solicitarEnteroPositivo("Pulsa 1 si no quieres repartir más cartas, pulsa 2 para continuar con las pendientes"
            );

        } while (respuesta != 1);
    }
}