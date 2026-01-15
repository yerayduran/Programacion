package Boletin1.Ejercicio4;

import Boletin1.Ejercicio3.Clerigo;
import Boletin1.Ejercicio3.Mago;
import Boletin1.Ejercicio3.Personaje;
import Boletin1.Ejercicio3.Raza;
import Boletin1.Ejercicio3.Exception.PersonajeException;

import java.util.Arrays;

public class MenuDOD {

    private static final int MAX_PERSONAJES = 100;
    private static Personaje[] personajes = new Personaje[MAX_PERSONAJES];

    static void main(String[] args) {

        int opcion = 0;

        do{
            try {
                String[] opciones = {"Añadir personaje", "Mago aprende hechizo", "Mago lanza hechizo", "Clérigo cura al mago", "Mostrar el listado de personajes", "Mostrar el listado de personajes ordenados por puntos actuales de mayor a menor", "Salir"};
                opcion = MiEntradaSalida.seleccionarOpcion("Elija una opción: ", opciones);
                switch (opcion) {
                    case 1:
                        String[] opciones2 = {"Mago", "Clérigo"};
                        int opcion2 = MiEntradaSalida.seleccionarOpcion("Elija un tipo de Personaje: ", opciones2);

                        switch (opcion2) {
                            case 1:
                                String nombreMago = MiEntradaSalida.solicitarCadena("Introduce el nombre del mago");
                                String razaMagoSt = MiEntradaSalida.solicitarCadena("Introduce la raza");
                                Raza razaMago = Raza.valueOf(razaMagoSt.toUpperCase());
                                int fuerzaMago = MiEntradaSalida.solicitarEnteroPositivo("Introduce la fuerza");
                                int inteligenciaMago = MiEntradaSalida.solicitarEnteroPositivo("Introduce la inteligencia");
                                int ptsMaxMago = MiEntradaSalida.solicitarEnteroPositivo("Introduce la vida máxima");
                                int ptsActualMago = MiEntradaSalida.solicitarEnteroPositivo("Introduce la vida actual");
                                Mago mago = new Mago(nombreMago, razaMago, fuerzaMago, inteligenciaMago, ptsMaxMago, ptsActualMago);
                                darAlta(mago);
                                break;

                            case 2:
                                String nombreClerigo = MiEntradaSalida.solicitarCadena("Introduce el nombre del clérigo: ");
                                String razaClerigoSt = MiEntradaSalida.solicitarCadena("Introduce la raza: ");
                                Raza razaClerigo = Raza.valueOf(razaClerigoSt.toUpperCase());
                                int fuerzaClerigo = MiEntradaSalida.solicitarEnteroPositivo("Introduce la fuerza: ");
                                int inteligenciaClerigo = MiEntradaSalida.solicitarEnteroPositivo("Introduce la inteligencia: ");
                                int ptsMaxClerigo = MiEntradaSalida.solicitarEnteroPositivo("Introduce la vida máxima: ");
                                int ptsActualClerigo = MiEntradaSalida.solicitarEnteroPositivo("Introduce la vida actual");
                                String nombreDios = MiEntradaSalida.solicitarCadena("Introduce el nombre del dios: ");
                                Clerigo clerigo = new Clerigo(nombreClerigo, razaClerigo, fuerzaClerigo, inteligenciaClerigo, ptsMaxClerigo, ptsActualClerigo, nombreDios);
                                darAlta(clerigo);
                                break;

                            default:
                                System.out.println("No has seleccionado ninguna opción");
                                break;
                        }
                        break;

                    case 2:
                        Mago[] magos = crearListaMagos();
                        mostrarMenuMago(magos);
                        int indice = MiEntradaSalida.solicitarEnteroPositivo("Elija una opción: ");

                        if (indice >= magos.length) {
                            System.out.println("Has seleccionado una opción que no es válida");

                        } else {
                            String hechizo = MiEntradaSalida.solicitarCadena("Introduce el nombre del hechizo: ");
                            magos[indice].aprendeHechizo(hechizo);
                        }
                        break;

                    case 3:
                        String nombreMagoABuscar = MiEntradaSalida.solicitarCadena("Introduce el nombre del personaje a buscar: ");
                        Mago magoABuscar = new Mago(nombreMagoABuscar, Raza.HUMANO, 14, 18, 60, 45);

                        if (personajes[buscarPersonajes(magoABuscar)] instanceof Mago) {
                            Mago magoEncontrado = (Mago) personajes[buscarPersonajes(magoABuscar)];
                            String victimaNombre = MiEntradaSalida.solicitarCadena("Introduce el nombre de la víctima: ");
                            Mago victima = new Mago(victimaNombre, Raza.HUMANO, 14, 18, 60, 45);
                            String nombreHechizo = MiEntradaSalida.solicitarCadena("Introduce el nombre del hechizo: ");
                            magoEncontrado.lanzarHechizo(personajes[buscarPersonajes(victima)], nombreHechizo);
                        } else {
                            System.out.println("No puedes lanzar un hechizo");
                        }
                        break;

                    case 4:
                        Clerigo[] clerigos = crearListaClerigos();
                        mostrarMenuClerigo(clerigos);
                        int indice2 = MiEntradaSalida.solicitarEnteroPositivo("Elija una opción: ");

                        if (indice2 >= clerigos.length) {
                            System.out.println("Has seleccionado una opción que no es válida");

                        } else {
                            String nombrePersonaje = MiEntradaSalida.solicitarCadena("Introduce el nombre del personaje: ");
                            Mago personajeABuscar = new Mago(nombrePersonaje, Raza.HUMANO, 14, 18, 60, 45);
                            clerigos[indice2].curar(personajes[buscarPersonajes(personajeABuscar)]);
                        }
                        break;

                    case 5:
                        System.out.println(Arrays.toString(personajes));
                        break;

                    case 6:
                        ordenarPersonajes();
                        System.out.println(Arrays.toString(personajes));
                        break;

                    case 7:
                        System.out.println("Hasta pronto");
                        break;

                    default:
                        System.out.println("No has seleccionado ninguna opción");
                        break;
                }

            } catch (IllegalArgumentException e) {
                System.out.println("No has introducido una raza válida");

            } catch (PersonajeException e) {
                System.out.println(e.getMessage());
            }
        } while (opcion != 7);

    }

    public static void mostrarMenuMago(Mago[] magos) throws PersonajeException {

        if (magos.length == 0) {
            throw new PersonajeException("No hay magos registrados");
        }

        for (int i = 0; i < magos.length; i++) {

            System.out.println(i + " ." + magos[i].getNombre());
        }
    }

    public static void mostrarMenuClerigo(Clerigo[] clerigos) throws PersonajeException {

        if (clerigos.length == 0) {
            throw new PersonajeException("No hay clérigos registrados");
        }

        for (int i = 0; i < clerigos.length; i++) {

            System.out.println(i + " ." + clerigos[i].getNombre());
        }
    }

    // Hacemos un método que introducirá un personaje en el array
    public static void darAlta(Personaje personaje) throws PersonajeException {

        int hayEspacio = -1;
        boolean esIgual = false;

        for (int i = 0; i < personajes.length; i++) {

            if (personaje.equals(personajes[i])) {
                esIgual = true;
            }

            if (personajes[i] == null && hayEspacio == -1) {
                hayEspacio = i;
            }
        }

        if (!esIgual && hayEspacio != -1) {
            personajes[hayEspacio] = personaje;

        } else {
            throw new PersonajeException("No se puede añadir");
        }
    }

    // Hacemos un método para crear un array exclusivamente de magos
    public static Mago[] crearListaMagos() {

        int contadorMagos = 0;
        Mago[] magos = new Mago[MAX_PERSONAJES];

        for (int i = 0; i <= personajes.length; i++) {
            // Si personaje en la posición i es una isntancia 'Boletin5Parte1.Ejercicio3.Mago' lo guardamos en el nuevo array
            if (personajes[i] instanceof Mago) {
                magos[contadorMagos++] = (Mago) personajes[i];
            }
        }
        // Devuelve el array de magos con las posiciones que tienen magos, sin posiciones null
        return Arrays.copyOfRange(magos, 1, contadorMagos);
    }

    // Hacemos un método para crear un array exclusivamente de clérigos
    public static Clerigo[] crearListaClerigos() {

        int contadorClerigos = 0;
        Clerigo[] clerigos = new Clerigo[MAX_PERSONAJES];

        for (int i = 0; i < personajes.length; i++) {

            if (personajes[i] instanceof Clerigo) {
                clerigos[contadorClerigos++] = (Clerigo) personajes[i];
            }
        }
        return Arrays.copyOfRange(clerigos, 0, contadorClerigos);
    }

    // Hacemos un método para crear un nuevo array con los personajes ordenados por sus puntos de vida
    public static void ordenarPersonajes() {

        int contadorPersonajes = 0;
        boolean noMasObjetos = false;

        for (int i = 0; i < personajes.length && !noMasObjetos; i++) {

            if (personajes[i] != null) {
                contadorPersonajes++;

            } else {
                noMasObjetos = true;
            }
        }
        Personaje[] personajesOrdenados;
        personajesOrdenados = Arrays.copyOfRange(personajes, 0, contadorPersonajes);
        System.out.println(Arrays.toString(personajesOrdenados));
    }

    // Creamos un método para buscar personajes
    private static int buscarPersonajes(Personaje personaje) throws PersonajeException {

        for (int i = 0; i < personajes.length; i++) {

            if (personaje.equals(personajes[i])) {
                return i;
            }
        }
        throw new PersonajeException("No se ha encontrado el personaje");
    }
}