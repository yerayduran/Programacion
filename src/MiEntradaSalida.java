import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MiEntradaSalida {

    public static Scanner sc = new Scanner(System.in);

    public static int solicitarEntero(String mensaje) {
        // Variable que almacenará el entero introducido por teclado.
        int integer = 0;
        // Variable que almacenará un booleano que indicará si se le debe volver a pedir el dato al usuario.
        boolean flag = true;

        while(flag) {
            // Pedimos el entero por pantalla.
            System.out.println(mensaje);
            // Comprobamos si el usuario está introduciendo algo correcto usando la excepción del método parseInt.
            try {
                integer = Integer.parseInt(sc.nextLine());
                // Si llegamos hasta aquí, es porque el usuario ha introducido un dato correcto y no se ha lanzado ninguna excepción.
                flag = false;
            }
            // Si se lanza la excepción, informamos al usuario de su error.
            catch(NumberFormatException e) {
                System.out.println("Ha introducido un dato incorrecto.");
            }
        }
        return integer;
    }

    public static int solicitarEnteroPositivo(String mensaje) {
        // Variable que almacenará el entero introducido por teclado.
        int integer = 0;
        // Variable que almacenará un booleano que indicará si se le debe volver a pedir el dato al usuario.
        boolean flag = true;

        while(flag) {
            // Pedimos el entero por pantalla.
            System.out.println(mensaje);
            // Comprobamos si el usuario está introduciendo algo correcto usando la excepción del método parseInt.
            try {
                integer = Integer.parseInt(sc.nextLine());
                // Si llegamos hasta aquí, es porque el usuario ha introducido un dato correcto y no se ha lanzado ninguna excepción.
                if (integer >= 0) {
                    flag = false;
                }
            }
            // Si se lanza la excepción, informamos al usuario de su error.
            catch(NumberFormatException e) {
                System.out.println("Ha introducido un dato incorrecto.");
            }
        }

        return integer;
    }

    public static int solicitarEnteroEnRango(String mensaje, int limiteInferior, int limiteSuperior) {
        // Variable que almacenará el entero introducido por teclado.
        int integer = 0;
        // Variable que almacenará un booleano que indicará si se le debe volver a pedir el dato al usuario.
        boolean flag = true;

        while(flag) {
            // Pedimos el entero por pantalla.
            System.out.println(mensaje);
            // Comprobamos si el usuario está introduciendo algo correcto usando la excepción del método parseInt.
            try {
                integer = Integer.parseInt(sc.nextLine());
                // Si llegamos hasta aquí, es porque el usuario ha introducido un dato correcto y no se ha lanzado ninguna excepción.
                if (integer >= limiteInferior && integer <= limiteSuperior) {
                    flag = false;
                }
            }
            // Si se lanza la excepción, informamos al usuario de su error.
            catch(NumberFormatException e) {
                System.out.println("Ha introducido un dato incorrecto.");
            }
        }

        return integer;
    }

    public static char solicitarCaracter(String mensaje) {
        char c = '0';

        // Variable que almacenará un booleano que indicará si se le debe volver a pedir el dato al usuario.
        boolean flag = true;

        while(flag) {
            // Pedimos el entero por pantalla.
            System.out.println(mensaje);
            // Comprobamos si el usuario está introduciendo algo correcto usando la excepción del método parseInt.
            try {
                c = sc.nextLine().charAt(0);
                // Si llegamos hasta aquí, es porque el usuario ha introducido un dato correcto y no se ha lanzado ninguna excepción.
                flag = false;
            }
            // Si se lanza la excepción, informamos al usuario de su error.
            catch(IndexOutOfBoundsException e) {
                System.out.println("Ha introducido un dato incorrecto.");
            }
        }
        return c;
    }

    public static char solicitarCaracterSN(String mensaje) {
        char c = '0';

        // Variable que almacenará un booleano que indicará si se le debe volver a pedir el dato al usuario.
        boolean flag = true;

        while(flag) {
            // Pedimos el entero por pantalla.
            System.out.println(mensaje);
            // Comprobamos si el usuario está introduciendo algo correcto usando la excepción del método parseInt.

            String cadena = sc.nextLine();

            if (cadena.length() == 1) {
                c = cadena.toUpperCase().charAt(0);

                if (c == 'S' || c == 'N') {
                    // Si llegamos hasta aquí, es porque el usuario ha introducido un dato correcto y no se ha lanzado ninguna excepción.
                    flag = false;
                }
            }
        }
        return c;
    }

    public static String solicitarCadena(String mensaje) {
        String cadena = "";

        // Variable que almacenará un booleano que indicará si se le debe volver a pedir el dato al usuario.
        boolean flag = true;

        while(flag) {
            // Pedimos el string por pantalla.
            System.out.println(mensaje);
            // Comprobamos si el usuario está introduciendo algo correcto usando la excepción del método parseInt.

            cadena = sc.nextLine();

            if (cadena.length() > 0) {
                // Si llegamos hasta aquí, es porque el usuario ha introducido un dato correcto y no se ha lanzado ninguna excepción.
                flag = false;
            }
        }
        return cadena;
    }

    public static int seleccionarOpcion(String mensaje, String[] opciones) {

        boolean flag = true;
        int opcionElegida = -1;

        while (flag) {

            for (int i = 0; i < opciones.length; i++) {

                System.out.printf("%d: %s\n", (i+1),opciones[i]);
            }
            opcionElegida = MiEntradaSalida.solicitarEnteroEnRango(mensaje, 1, opciones.length);
            flag = false;
        }
        return opcionElegida;
    }

    public static double solicitarDoublePositivo(String mensaje) {
        // Variable que almacenará el entero introducido por teclado.
        double numero = 0;
        // Variable que almacenará un booleano que indicará si se le debe volver a pedir el dato al usuario.
        boolean flag = true;

        while(flag) {
            // Pedimos el entero por pantalla.
            System.out.println(mensaje);
            // Comprobamos si el usuario está introduciendo algo correcto usando la excepción del método parseInt.
            try {
                numero = Double.parseDouble(sc.nextLine());
                // Si llegamos hasta aquí, es porque el usuario ha introducido un dato correcto y no se ha lanzado ninguna excepción.
                if (numero >= 0) {
                    flag = false;
                }
            }
            // Si se lanza la excepción, informamos al usuario de su error.
            catch(NumberFormatException e) {
                System.out.println("Ha introducido un dato incorrecto.");
            }
        }
        return numero;
    }

    public static int sumarContenidoDeArrays(int[] a) {
        int suma = 0;
        for (int i = 0; i < a.length; i++) {
            suma += a[i];
        }
        return suma;
    }

    public static float solicitarFloat(String mensaje) {
        float integer = 0;
        // Variable que almacenará un booleano que indicará si se le debe volver a pedir el dato al usuario.
        boolean flag = true;

        while (flag) {
            // Pedimos el entero por pantalla.
            System.out.println(mensaje);
            // Comprobamos si el usuario está introduciendo algo correcto usando la excepción del método parseInt.
            try {
                integer = Float.parseFloat(sc.nextLine());
                // Si llegamos hasta aquí, es porque el usuario ha introducido un dato correcto.
                flag = false;
            }
            // Si se lanza la excepción, informamos al usuario de su error.
            catch (NumberFormatException e) {
                // 2. Mensaje de error específico.
                System.out.println("Error: Debe introducir un número entero.");
            }

        }
        return integer;
    }

    public static char solicitarChar(String mensaje) {
        char integer = 0;
        // Variable que almacenará un booleano que indicará si se le debe volver a pedir el dato al usuario.
        boolean flag = true;

        while (flag) {
            // Pedimos el entero por pantalla.
            System.out.println(mensaje);
            // Comprobamos si el usuario está introduciendo algo correcto usando la excepción del método chartAt.
            try {
                integer = sc.nextLine().charAt(0);
                // Si llegamos hasta aquí, es porque el usuario ha introducido un dato correcto.
                flag = false;
            }
            // Si se lanza la excepción, informamos al usuario de su error.
            catch (NumberFormatException e) {
                // 2. Mensaje de error específico.
                System.out.println("Error: Debe introducir un solo caracter.");
            }

        }
        return integer;
    }
    public static int generaAleatorio(int max) {
        return (int) (Math.random() * max + 1);
    }

    /**
     * Generar un número aleatorio entre un máximo y un mínimo
     *
     * @param min              Primer número del intervalo
     * @param max              Segundo número del intervalo
     * @param seAceptaElMaximo ¿El máximo entra en ese intervalo?
     * @return El número generado aleatoriamente
     */
    public static int generaAleatorioEntre(int min, int max, boolean seAceptaElMaximo) {
        int ventana;

        if (seAceptaElMaximo) {
            ventana = max - min + 1;
        } else {
            ventana = max - min;
        }
        return (int) (Math.random() * ventana) + min;
    }

    /**
     * Leer una cadena de texto
     *
     * @param mensaje Mensaje a mostrar
     * @return String leido
     */
    public static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return sc.next();
    }

    public static void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("[" + matriz[i][j] + "]" + " ");
            }
            System.out.println();
        }
    }

    /**
     * Imprimir una matriz de strings
     *
     * @param matriz matriz a imprimir
     */
    public static void imprimirMatrizString(String[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("[" + matriz[i][j] + "]" + " ");
            }
            System.out.println();
        }
    }

    /**
     * Añade un objeto(Cartas, Juguetes, Piezas) en un conjunto de ese objeto(Mazo, bolsa, etc)
     * @param o
     * @return
     */
    public int addObjeto(Objeto o) {
        return this.addObjeto(o, 1);
    }

    /**
     * Permite añadir cualquier cantidad de un objeto dado a mi conjunto
     * @param o el objeto del cual voy a añadir numeroDeObjetos unidades
     * @param numeroDeObjetos el numero de unidades del objeto o que voy a añadir al conjunto
     * @return el numero actual de unidades del objeto o resultante
     */
    public int addObjeto(Objeto o, int numeroDeObjetos) {
        if (this.conjunto.containsKey(o)) {
            this.conjunto.put(o, Integer.valueOf(this.conjunto.get(o).intValue() + numeroDeObjetos));
        }
        else {
            this.conjunto.put(o, Integer.valueOf(numeroDeObjetos));
        }

        return this.conjunto.get(o).intValue();
    }

    /**
     * Añade un equipo a la liga.
     *
     * QUE HACE:
     * - Comprueba que el equipo tenga jugadores.
     * - Comprueba que el equipo no esté ya dentro de la liga.
     * - Si todo está correcto, lo añade a la colección de equipos.
     *
     * QUE DEBES ADAPTAR EN OTRO PROYECTO:
     * - La clase Equipo debe tener el método getJugadores().
     * - La variable "equipos" debe ser una colección (Set o List) que almacene los equipos de la liga.
     * - La excepción LigaException debe existir o sustituirse por otra (por ejemplo Exception o IllegalArgumentException).
     */
    public void anadirEquipo(Equipo equipo) throws LigaException {
        if (equipo.getJugadores().isEmpty()) {
            throw new LigaException("El equipo no contiene jugadores.");
        }
        if (equipos.contains(equipo)) {
            throw new LigaException("El equipo ya forma parte de la liga.");
        }
        equipos.add(equipo);
    }

    /**
     * Elimina un equipo de la liga.
     *
     * QUE HACE:
     * - Intenta eliminar el equipo de la colección de equipos.
     * - Si no existe en la liga lanza una excepción.
     *
     * QUE DEBES ADAPTAR:
     * - La variable "equipos" debe ser una colección que contenga objetos Equipo.
     * - Puede necesitar equals() en la clase Equipo para que remove funcione correctamente.
     */
    public void eliminarEquipo(Equipo equipo) throws LigaException {
        if (!equipos.remove(equipo)) {
            throw new LigaException("El equipo no forma parte de la liga.");
        }
    }

    /**
     * Une los jugadores de dos equipos.
     *
     * QUE HACE:
     * - Comprueba que ambos equipos estén en la liga.
     * - Crea un nuevo Set con todos los jugadores del equipo1.
     * - Añade los jugadores del equipo2.
     * - Asigna esa nueva lista de jugadores al equipo1.
     *
     * RESULTADO:
     * equipo1 tendrá los jugadores de ambos equipos.
     *
     * QUE DEBES ADAPTAR:
     * - Equipo debe tener:
     *      getJugadores()
     *      setJugadores(Set<Jugador>)
     * - Jugador debe ser una clase existente.
     */
    public void unirEquipos(Equipo equipo1, Equipo equipo2) throws LigaException {
        if (equipos.contains(equipo1) && equipos.contains(equipo2)) {
            Set<Jugador> nuevoJugadores = new HashSet<>(equipo1.getJugadores());
            nuevoJugadores.addAll(equipo2.getJugadores());
            equipo1.setJugadores(nuevoJugadores);
        }
        else {
            throw new LigaException("Uno de estos dos equipos no esta en la liga");
        }
    }

    /**
     * Devuelve los nombres de los jugadores que están en ambos equipos.
     *
     * QUE HACE:
     * - Busca los jugadores que aparecen en los dos equipos.
     * - Devuelve sus nombres separados por comas.
     *
     * EJEMPLO RESULTADO:
     * "Carlos, Juan, Pedro"
     *
     * QUE DEBES ADAPTAR:
     * - Jugador debe tener:
     *      getNombre()
     * - Equipo debe tener:
     *      getJugadores()
     */
    public String jugadoresEnComun(Equipo e1, Equipo e2) throws LigaException {
        if (equipos.contains(e1) && equipos.contains(e2)) {
            return e1.getJugadores().stream()
                    .filter(e2.getJugadores()::contains)
                    .map(Jugador::getNombre)
                    .collect(Collectors.joining(", "));
        }
        else {
            throw new LigaException("Uno de estos dos equipos ya esta en la liga");
        }
    }

    /**
     * Calcula la edad media de todos los jugadores de la liga.
     *
     * QUE HACE:
     * - Obtiene todos los jugadores de todos los equipos.
     * - Calcula la media de sus edades.
     * - Si no hay jugadores lanza una excepción.
     *
     * QUE DEBES ADAPTAR:
     * - Jugador debe tener:
     *      getEdad()
     * - Debe existir el método todosLosJugadores().
     */
    public double mediaEdad() throws LigaException {
        return todosLosJugadores().stream().mapToDouble(Jugador::getEdad)
                .average().orElseThrow(()  -> new LigaException("No se puede cargar la edad media"));
    }

    /**
     * Ordena una lista de jugadores por edad (de mayor a menor).
     *
     * QUE HACE:
     * - Recibe una lista de jugadores.
     * - Los ordena por edad descendente.
     * - Devuelve una nueva lista ordenada.
     *
     * QUE DEBES ADAPTAR:
     * - Jugador debe tener:
     *      getEdad()
     */
    public List<Jugador> jugadoresOrdenadosEdad(List<Jugador> jugadores) {
        return jugadores.stream()
                .sorted(Comparator.comparing(Jugador::getEdad)
                        .reversed())
                .toList();
    }

    /**
     * Ordena jugadores alfabéticamente por nombre.
     *
     * QUE HACE:
     * - Ordena la lista usando el orden natural.
     *
     * QUE DEBES ADAPTAR:
     * - La clase Jugador debe implementar Comparable.
     *
     * Ejemplo:
     * public class Jugador implements Comparable<Jugador>
     */
    public List<Jugador> jugadoresOrdenadosNombre(List<Jugador> jugadores){
        return jugadores.stream()
                .sorted()
                .toList();
    }

    /**
     * Devuelve todos los jugadores de todos los equipos sin repetir.
     *
     * QUE HACE:
     * - Recorre todos los equipos de la liga.
     * - Extrae sus jugadores.
     * - Los une en un único Set para evitar duplicados.
     *
     * QUE DEBES ADAPTAR:
     * - Equipo debe tener getJugadores()
     * - Jugador debe tener equals() y hashCode() bien definidos si se usa Set.
     */
    public Set<Jugador> todosLosJugadores() {
        return equipos.stream()
                .flatMap(equipo -> equipo.getJugadores().stream())
                .collect(Collectors.toSet());
    }

    /**
     * Devuelve una representación en texto de la liga.
     *
     * QUE HACE:
     * - Muestra el nombre de la liga.
     * - Muestra todos los equipos que contiene.
     *
     * QUE DEBES ADAPTAR:
     * - Debe existir la variable:
     *      nombreLiga
     * - La clase Equipo debería tener su propio toString().
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Bienvenidos a " + nombreLiga).append(System.lineSeparator());
        sb.append("Equipos: ").append(System.lineSeparator());

        for (Equipo e: equipos) {
            sb.append(e).append(System.lineSeparator());
        }

        return sb.toString();
    }


}