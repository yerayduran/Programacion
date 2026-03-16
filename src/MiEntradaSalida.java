import java.util.*;
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
     * @param numeroDeObjetos el número de unidades del objeto o que voy a añadir al conjunto
     * @return el número actual de unidades del objeto o resultante
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

    private static void mostrarCromos() {
        todos.stream().map(c -> c.getNombre()).forEach(System.out::println);
    }

    private static void mostrarCromosDeMazo(Mazo m) {
        m.getLista().forEach(System.out::println);
    }

    /**
     * Coge un cromo (de otro mazo, pero no se trata eso aqu�) y lo a�ade a mi mazo.
     * Al mismo tiempo, elimina una unidad de uno de mis cromos. Si fuera la �ltima
     * unidad, se ha de eliminar el cromo tambi�n.
     * @param mio El cromo de mi mazo que voy a intercambiar
     * @param nuevo El cromo de otro mazo que voy a recibir
     * @throws MazoException Si intento intercambiar un cromo de mi mazo que no tengo
     */
    public void intercambiar(Cromo mio, Cromo nuevo) throws MazoException {
        if (!this.mazo.containsKey(mio)) {
            throw new MazoException("No puedes intercambiar un cromo que no tienes");
        }

        if (this.mazo.get(mio).intValue() > 1) {
            // Tengo m�s de uno, por tanto el cromo se quedar� en el mazo
            this.mazo.put(mio, Integer.valueOf(this.mazo.get(mio).intValue() - 1));
        }
        else {
            // Tan solo tengo 1, por lo que habr� que eliminarse del mazo
            this.mazo.remove(mio);
        }

        // Por �ltimo a�adimos el nuevo cromo al mazo
        this.addCromo(nuevo);
    }

    /**
     * Mezcla mi mazo con otro que recibo como par�metro
     * @param otro el mazo con el que voy a mezclar el m�o
     */
    public void mezclar (Mazo otro) {
        otro.getMazo().forEach((cromo, unidades) -> this.addCromo(cromo, unidades));
    }

    /**
     * Al no permitir los Map elementos repetidos, el tama�o del mismo representa
     * el n�mero de cromos distintos que tengo
     * @return
     */
    public int contarDiferentes() {
        return this.mazo.size();
    }

    /**
     * Devuelve los cromos de un equipo dado
     * @param equipo El nombre del equipo
     * @return Una lista con los cromos de dicho equipo
     */
    public List<Cromo> cromosDeUnEquipo(String equipo) {
        /*
         * Filtramos los cromos del mazo. Solo pasar�n el filtro aquellos escudos
         * cuyo nombre sea equipo, o aquellos jugadores cuyo equipo sea equipo.
         */
        return mazo.keySet().stream().filter(c -> {
            if (c instanceof Escudo) {
                Escudo e = (Escudo) c;
                return e.getNombre().equals(equipo);
            }
            else {
                return ((Jugador) c).getEquipo().equals(equipo);
            }
        }).collect(Collectors.toList());
    }

    /**
     * Calcula la altura media de un equipo
     * @param equipo El nombre del equipo
     * @return La altura media de los jugadores de un equipo dado o NaN
     * si no existe dicho equipo o no tenemos jugadores del mismo
     */
    public double alturaMedia(String equipo) {
        return mazo.keySet().stream().filter(c -> {
                    if (c instanceof Jugador) {
                        Jugador j = (Jugador) c;
                        return j.getEquipo().equals(equipo);
                    }
                    else {
                        return false;
                    }
                }).mapToInt(c -> ((Jugador) c).getAltura())
                .average().orElse(Double.NaN);
    }

    /**
     * Devuelve los cromos de nuestro mapa
     * @return
     */
    public List<Cromo> getLista() {
        return mazo.keySet().stream().collect(Collectors.toList());
    }

    /**
     * Devuelve una lista con todos nuestros cromos ordenados por el orden dado
     * @return Una lista con todos nuestros cromos ordenados por el orden dado
     */
    public List<Cromo> ordenar(){
        return mazo.keySet().stream().sorted((a, b) -> {
            if (a instanceof Escudo) {
                // a es un escudo, �y b?
                if (b instanceof Escudo) {
                    // Los dos son escudos, comparamos por nombre
                    Escudo e1 = (Escudo) a;
                    Escudo e2 = (Escudo) b;
                    return e1.getNombre().compareTo(e2.getNombre());
                }
                else {
                    // a es un escudo y b un jugador
                    return -1;
                }
            }
            else {
                // a es un jugador, �y b?
                if (b instanceof Jugador) {
                    // Los dos son jugadores, comparamos por nombre
                    Jugador j1 = (Jugador) a;
                    Jugador j2 = (Jugador) b;
                    return j1.getNombre().compareTo(j2.getNombre());
                }
                else {
                    // a es un jugador y b un escudo
                    return 1;
                }
            }
        }).collect(Collectors.toList());
    }

    /**
     * Devuelve una lista de aquellos equipos de los cuales tengo todos sus jugadores,
     * incluido el escudo
     * @return
     */
    public List<String> equipoCompleto(){
        List<String> equipos = new LinkedList<>();
        // Primero obtengo los escudos, para despu�s ver si tengo todos sus jugadores.
        Iterator<Cromo> it = mazo.keySet().stream().filter(c -> c instanceof Escudo).iterator();

        // Por cada escudo, cuento los jugadores que tengo. Si los tengo todos, lo a�ado a la lista
        while (it.hasNext()) {
            Escudo escudo = (Escudo) it.next();
            long jugadoresQueTengo = mazo.keySet().stream()
                    .filter(c -> c instanceof Jugador)
                    .filter(c -> ((Jugador) c).getEquipo().equals(escudo.getNombre()))
                    .count();
            if (jugadoresQueTengo == escudo.getNumeroJugadores()) {
                equipos.add(escudo.getNombre());
            }
        }

        return equipos;
    }


    /*

    DESDE AQUI AL FINAL FUE LO QUE SE PUSO EN EL EXAMEN DE 2025 DE DRANGON BALL

     */

    /**
     * Buscamos un personaje por su nombre y raza, para ello antes nos
     * creamos un personaje a partir de lo pasado
     *
     * @param nombre
     * @param raza
     * @return personaje
     * @throws DBException
     */
    public Personaje buscarPersonaje(String nombre, TRaza raza) throws DBException {
        return this.personajes.stream()
                .filter(p -> p.getNombre().equalsIgnoreCase(nombre) && p.getRaza() == raza)
                .findFirst().orElseThrow(() -> new DBException("No existe un personaje con esos datos"));
    }


    /**
     * Hacemos un método para añadir un personaje comprobando que no exista
     *
     * @param personaje
     * @throws DBException
     */
    public void agregarPersonaje(Personaje personaje) throws DBException {
        if (!personajes.add(personaje)) {
            throw new DBException("El personaje ya existe");
        }
    }

    /**
     * Imprimimos los personajes que tienen más ataques, si hay varios con el
     * valor máximo se coge también
     *
     * @throws DBException
     */
    public void personajeConMasAtaques() throws DBException {
        int maxAtaques = this.personajes.stream().mapToInt(p -> p.getAtaques().size()).max().orElseThrow(() -> new DBException("No hay personajes"));
        this.personajes.stream().filter(p -> p.getAtaques().size() == maxAtaques)
                .forEach(personaje -> {
                    System.out.println(personaje.getNombre() + ": " + personaje.getAtaques().size());
                });
    }

    public void personajeConAtaqueMasPoderoso() throws DBException {
        int maxDamage = this.personajes.stream().flatMap(p -> p.getAtaques().stream()).mapToInt(Ataque::getDamage).max().orElse(0);

        this.personajes.stream().filter(p -> {
                    Ataque a = p.getAtaqueMasPoderoso();
                    return a != null && p.getAtaqueMasPoderoso().getDamage() == maxDamage;
                })
                .forEach(personaje -> {
                    System.out.println(personaje.getNombre() + ": " + personaje.getAtaqueMasPoderoso());
                });
    }

    /**
     * Todos los ataques de los personajes ordenados por el nombre
     */
    public void todosLosAtaquesOrdenadosNombre() {
        personajes.stream().flatMap(p -> p.getAtaques().stream()).distinct()
                .sorted(Comparator.comparing(Ataque::getNombre))
                .forEach(System.out::println);

    }

    /**
     * Todos los ataques de los personajes ordenados por el daño
     */
    public void todosLosAtaquesOrdenadosDamage() {
        personajes.stream().flatMap(p -> p.getAtaques().stream()).distinct()
                .sorted(Comparator.comparingInt(Ataque::getDano).reversed())
                .forEach(System.out::println);

    }

    /**
     * Cogemos el ataque entre dos personajes el que más daño tenga, en caso
     * de que haya ataques con el mismo daño, se coge cualquiera
     *
     * @param p1
     * @param p2
     * @return ataque con más daño
     * @throws DBException
     */
    public Ataque ataqueMasDañino(Personaje p1, Personaje p2) throws DBException{
        return p1.getAtaques().stream()
                .filter(a -> a.getKiNecesario() <= p1.getKiActual())
                .max(Comparator.comparing(Ataque::getDamage)).orElseThrow(() -> new DBException("No puede lanzar ningún ataque"));
    }

    public void atacar(Personaje p1, Personaje p2, String ataque) throws DBException {
        if (p1.getVidaActual() <= 0){
            throw new DBException("No puedes atacar con un personaje muerto");
        }

        if (p2.getVidaActual() <= 0){
            throw new DBException("No puedes atacar a un personaje muerto");
        }

        try {
            p1.atacar(p2, ataque);

            /**
             * Dentro de la clase personaje de ese examen habria que crea esto:
             *
             *
             public void atacar(Personaje p2, String nombreAtaque) throws DBException {

             //Primero buscamos el ataque. Puede haber varios, pero lo primero es filtrar por nombre y por ki necesario.
             //Después seleccionamos el que más daño requiera

            Ataque ataque = this.ataques.stream()
                    .filter(a -> a.getNombre().equalsIgnoreCase(nombreAtaque) && a.getKiNecesario() <= this.getKiActual())
                    .max(Comparator.comparing(Ataque::getDamage))
                    .orElseThrow(() -> new DBException("No existe el ataque o no tiene suficiente Ki"));

            if (p2.getVidaActual() - ataque.getDamage() > 0){
                p2.setVidaActual(p2.getVidaActual() - ataque.getDamage());
            }
            else {
                p2.setVidaActual(0);
            }

            this.ataques.remove(ataque);
        }
             */
            if (p2.getVidaActual() == 0){
                System.out.printf("%s ha muerto debido al ataque\n", p2.getNombre());
            }
            else{
                System.out.printf("%s tiene %d puntos de vida tras el ataque", p2.getNombre(), p2.getVidaActual());
            }
        }
        catch (DBException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * Eliminamos los ataques que tengan un nivel menor al
     * pasado por parámetros
     *
     * @param nivel
     */
    public void eliminarAtaquesInferioresANivel(int nivel) {
        for (Personaje p : personajes) {
            Iterator<Ataque> itAtaque = p.getAtaques().iterator();
            while (itAtaque.hasNext()) {
                Ataque ataque = itAtaque.next();
                if (ataque.getNivelPerfeccion() < nivel) {
                    itAtaque.remove();
                }
            }
        }
    }

    /**
     * Hacemos un mapa con las razas y las razas que pertenecen
     * a esa raza
     *
     * @return mapa de razas
     */
    public Map<TRaza, List<Personaje>> devuelveMapaRazas() {
        return personajes.stream().map(p -> Map.entry(p.getRaza(), p))
                .collect(Collectors.groupingBy(Map.Entry::getKey,
                        Collectors.mapping(Map.Entry::getValue, Collectors.toList())));
    }


    /**
     *
     * Set: se divide en (SortedSet(TreeSet), HashSet y LinkedHashSet)
     * List: se divide en (ArrayList, LinkedList)
     * Queue: se divide en (PriorityQueue y LinkedList)
     * Map: se divide en (SortedMap( TreeMap), HashMap, Hashtable y LinkedHashMap)
     *
     *
     * Los Hash se debe de utilizar un equals y HashCode, ademas de añadir un toString en el codigo
     * Si utilizas Comparable en el codigo, se debe de utilizar un compareTo
     */




}
