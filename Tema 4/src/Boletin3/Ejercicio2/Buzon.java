package Boletin3.Ejercicio2;

import Boletin1.Ejercicio2.MiEntradaSalida;
import Boletin2.Ejercicio1.Persona;
import Ejercicio2.Exception.MensajeException;

public class Buzon {
    public static void main(String[] args) {

        Persona p1 = new Persona("Yeray");
        Persona p2 = new Persona("Bermudo");

        int opcion;
        do {
            System.out.println("1. Enviar mensaje");
            System.out.println("2. Eliminar mensaje más antiguo enviado");
            System.out.println("3. Eliminar mensaje más antiguo recibido");
            System.out.println("4. Salir");

            opcion = MiEntradaSalida.solicitarEnteroPositivo("Seleccione:");

            switch (opcion) {
                case 1:
                    int opcion2 = MiEntradaSalida.solicitarEnteroPositivo("Pulsa 1 si eres " + p1.getNombre() + ", 2 si eres " + p2.getNombre());
                    switch (opcion2) {
                        case 1:
                            try {
                                String asunto = MiEntradaSalida.solicitarCadena("Introduce el asunto");
                                String cuerpo = MiEntradaSalida.solicitarCadena("Introduce el cuerpo");
                                p1.enviarMensaje(p2, asunto, cuerpo);
                                System.out.println(" ");
                                System.out.println("¡Boletin3.Boletin4.Ejercicio2.Ejercicio2.Mensaje Enviado!");
                                System.out.println(" ");
                            } catch (MensajeException e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        case 2:
                            try {
                                String asunto = MiEntradaSalida.solicitarCadena("Introduce el asunto");
                                String cuerpo = MiEntradaSalida.solicitarCadena("Introduce el cuerpo");
                                p2.enviarMensaje(p1, asunto, cuerpo);
                                System.out.println(" ");
                                System.out.println("¡Boletin3.Boletin4.Ejercicio2.Ejercicio2.Mensaje Enviado!");
                                System.out.println(" ");
                            } catch (MensajeException e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        default:
                            System.out.println("No has seleccionado nada");
                            break;
                    }
                    break;
                case 2:
                    int opcion3 = MiEntradaSalida.solicitarEnteroPositivo("Pulsa 1 si eres " + p1.getNombre() + ", 2 si eres " + p2.getNombre());
                    switch (opcion3) {
                        case 1:
                            try {
                                p1.borrarMensajeEnviadoMasAntiguo();
                                System.out.println(" ");
                                System.out.println("¡Boletin3.Boletin4.Ejercicio2.Ejercicio2.Mensaje Borrado!");
                                System.out.println(" ");
                            } catch (MensajeException e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        case 2:
                            try {
                                p2.borrarMensajeEnviadoMasAntiguo();
                                System.out.println(" ");
                                System.out.println("¡Boletin3.Boletin4.Ejercicio2.Ejercicio2.Mensaje Borrado!");
                                System.out.println(" ");
                            } catch (MensajeException e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        default:
                            System.out.println("No has seleccionado ninguna opción");
                            break;
                    }
                    break;
                case 3:
                    int opcion4 = MiEntradaSalida.solicitarEnteroPositivo("Pulsa 1 si eres " + p1.getNombre() + ", 2 si eres " + p2.getNombre());
                    switch (opcion4) {
                        case 1:
                            try {
                                p1.borrarMensajeRecibidoMasAntiguo();
                                System.out.println(" ");
                                System.out.println("¡Boletin3.Boletin4.Ejercicio2.Ejercicio2.Mensaje Borrado!");
                                System.out.println(" ");
                            } catch (MensajeException e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        case 2:
                            try {
                                p2.borrarMensajeRecibidoMasAntiguo();
                                System.out.println(" ");
                                System.out.println("¡Boletin3.Boletin4.Ejercicio2.Ejercicio2.Mensaje Borrado!");
                                System.out.println(" ");
                            } catch (MensajeException e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                    }
                    break;
                case 4:
                    System.out.println("Hasta pronto");
                    break;
                default:
                    System.out.println("No has seleccionado ninguna opción");
                    break;
            }
        } while (opcion != 4);
    }
}