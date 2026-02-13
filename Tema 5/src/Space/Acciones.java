package Space;

import java.util.Random;

public class Acciones {

    // Opción 1/2: Comprar nave del mercado y asignar a planeta propio
    public static void comprarNave(Partida partida, int indiceMercado, Planeta planetaPropio)
            throws MercadoException, PropiedadException {
        Jugador j = partida.getJugadorActual();
        if (!planetaPropio.estaConquistado() || !planetaPropio.getConquistador().equals(j)) {
            throw new PropiedadException("Debes asignar la nave a un planeta conquistado por ti");
        }
        Nave carta = partida.getTablero().getMercadoNaves().comprar(indiceMercado);
        j.pagarOro(carta.getPrecio());
        j.agregarNave(carta, planetaPropio);
    }

    // Opción 2: Comprar construcción (se guarda en mazo del jugador)
    public static void comprarConstruccion(Partida partida, Construccion carta) {
        Jugador j = partida.getJugadorActual();
        j.pagarOro(carta.getPrecio());
        j.agregarCartaConstruccion(carta);
    }

    // Opción 3: Coger carta de material (1 punto al azar). Oro al jugador; otras al planeta.
    public static void cogerCartaMaterial(Jugador jugador, Planeta planetaAsignacion) {
        String[] materiales = {"Piedra", "Hierro", "Boletin5Parte1.Ejercicio2.Combustible", "Oro"};
        int idx = new Random().nextInt(materiales.length);
        String material = materiales[idx];
        CartaMaterial carta = new CartaMaterial(material);

        if (material.equalsIgnoreCase("Oro")) {
            jugador.agregarOro(1);
        } else {
            // agregar al planeta concreto
            switch (material.toLowerCase()) {
                case "piedra" -> planetaAsignacion.consumirRecursos(-1, 0, 0); // sumar 1 (consumir negativo)
                case "hierro" -> planetaAsignacion.consumirRecursos(0, -1, 0);
                case "combustible" -> planetaAsignacion.consumirRecursos(0, 0, -1);
            }
        }
        System.out.println(jugador.getNombre() + " recibe " + carta.getNombre());
    }

    // Opción 4: Construir (consumir carta del mazo y recursos del planeta)
    public static void construir(Jugador jugador, Construccion carta, Planeta planeta)
            throws ConstruccionException, RecursosInsuficientesException, PropiedadException {
        if (!planeta.estaConquistado() || !planeta.getConquistador().equals(jugador)) {
            throw new PropiedadException("Debes construir en un planeta propio (o mover 1 persona si está libre)");
        }
        if (!jugador.getCartasConstruccion().contains(carta)) {
            throw new ConstruccionException("No tienes esta carta en tu mazo de construcciones");
        }

        if (carta instanceof Mina mina) {
            if (!planeta.tieneRecursos(Costes.MINA_PIEDRA, Costes.MINA_HIERRO, Costes.MINA_COMBUSTIBLE)) {
                throw new RecursosInsuficientesException("Faltan recursos en el planeta para construir la mina");
            }
            if (planeta.getHabitantesDisponibles() < Costes.MINA_PERSONAS) {
                throw new ConstruccionException("Faltan personas asignables para la mina (10 requeridas)");
            }
            planeta.consumirRecursos(Costes.MINA_PIEDRA, Costes.MINA_HIERRO, Costes.MINA_COMBUSTIBLE);
            planeta.asignarPersonas(Costes.MINA_PERSONAS);
            planeta.agregarConstruccion(mina);
        } else if (carta instanceof EscudoProtector escudo) {
            if (!planeta.tieneRecursos(Costes.ESCUDO_PIEDRA, Costes.ESCUDO_HIERRO, Costes.ESCUDO_COMBUSTIBLE)) {
                throw new RecursosInsuficientesException("Faltan recursos en el planeta para construir el escudo");
            }
            if (planeta.getHabitantesDisponibles() < Costes.ESCUDO_PERSONAS) {
                throw new ConstruccionException("Faltan personas asignables para el escudo (15 requeridas)");
            }
            planeta.consumirRecursos(Costes.ESCUDO_PIEDRA, Costes.ESCUDO_HIERRO, Costes.ESCUDO_COMBUSTIBLE);
            planeta.asignarPersonas(Costes.ESCUDO_PERSONAS);
            planeta.asignarEscudo(escudo);
        } else {
            throw new ConstruccionException("Tipo de construcción no soportado");
        }

        jugador.removerCartaConstruccion(carta);
    }

    // Opción 5: Mover nave entre planetas, con restricciones
    public static void moverNave(Nave nave, Planeta origen, Planeta destino) throws PropiedadException {
        if (origen.equals(destino)) throw new IllegalStateException("No puedes mover la nave al mismo planeta");
        if (nave instanceof NaveCarga || nave instanceof NaveTransporte) {
            if (destino.estaConquistado() && !destino.getConquistador().equals(nave.getPropietario())) {
                throw new PropiedadException("No puedes mover la nave a un planeta conquistado por otro jugador");
            }
        }
        origen.retirarNave(nave);
        destino.agregarNave(nave);
    }

    // Opción 6: Atacar (la nave debe estar en el mismo planeta que el objetivo)
    public static void atacar(NaveAtaque nave, IAtacable objetivo, Planeta planeta) {
        if (!planeta.getNaves().contains(nave)) {
            throw new IllegalStateException("La nave atacante debe estar en el mismo planeta que el objetivo");
        }
        nave.atacar(objetivo); // lógica de fallo por escudo ya está en Class.Space.Planeta.serAtacado
    }

    // Opción 7: Transportar carga (validaciones básicas; la interacción UI se haría fuera)
    public static void transportarCarga(NaveCarga nave, Planeta origen, Planeta destino,
                                        String[] materiales, int[] cantidades) throws PropiedadException {
        int total = 0;
        for (int c : cantidades) total += c;
        if (total > nave.getCapacidadCarga()) throw new IllegalStateException("Excede capacidad de la nave");

        if (origen.getConquistador() == null || !origen.getConquistador().equals(nave.getPropietario())) {
            throw new PropiedadException("Las naves de carga no pueden cargar desde un planeta ajeno");
        }
        if (destino.estaConquistado() && !destino.getConquistador().equals(nave.getPropietario())) {
            throw new PropiedadException("Las naves de carga no pueden transportar a planetas ajenos");
        }

        for (int i = 0; i < materiales.length; i++) {
            String mat = materiales[i].toLowerCase();
            int cant = cantidades[i];
            switch (mat) {
                case "piedra" -> {
                    if (origen.getPiedra() < cant) throw new IllegalStateException("No hay suficiente piedra");
                    origen.consumirRecursos(cant, 0, 0);
                    destino.consumirRecursos(-cant, 0, 0);
                }
                case "hierro" -> {
                    if (origen.getHierro() < cant) throw new IllegalStateException("No hay suficiente hierro");
                    origen.consumirRecursos(0, cant, 0);
                    destino.consumirRecursos(0, -cant, 0);
                }
                case "combustible" -> {
                    if (origen.getCombustible() < cant) throw new IllegalStateException("No hay suficiente combustible");
                    origen.consumirRecursos(0, 0, cant);
                    destino.consumirRecursos(0, 0, -cant);
                }
                default -> throw new IllegalArgumentException("Material no válido: " + mat);
            }
        }
    }

    // Opción 8: Transportar personas (validaciones básicas)
    public static void transportarPersonas(NaveTransporte nave, Planeta origen, Planeta destino, int personas)
            throws PropiedadException {
        if (personas == 0) {
            System.out.println("Operación cancelada. No se cuenta como jugada.");
            return;
        }
        if (personas > nave.getCapacidad()) throw new IllegalStateException("Excede capacidad de la nave");

        if (destino.estaConquistado() && !destino.getConquistador().equals(nave.getPropietario())) {
            throw new PropiedadException("No puedes transportar personas a planetas de otros");
        }

        if (origen.getHabitantesDisponibles() < personas)
            throw new IllegalStateException("No hay suficientes habitantes asignables en el planeta origen");

        origen.asignarPersonas(personas);
        destino.liberarPersonas(personas); // llegan y quedan asignables
    }

    // Opción 9: Mejorar nave (costes deben estar en el planeta de la nave)
    public static void mejorarNave(Planeta planeta, IMejorable nave)
            throws RecursosInsuficientesException {
        if (!planeta.tieneRecursos(Costes.MEJORA_PIEDRA, Costes.MEJORA_HIERRO, Costes.MEJORA_COMBUSTIBLE)) {
            throw new RecursosInsuficientesException("Faltan recursos en el planeta para mejorar la nave");
        }
        planeta.consumirRecursos(Costes.MEJORA_PIEDRA, Costes.MEJORA_HIERRO, Costes.MEJORA_COMBUSTIBLE);
        nave.mejorar();
    }

    // Opción 10: Reparar (requiere recursos en el planeta donde está el objeto)
    public static void repararEnPlaneta(Planeta planeta, IReparable objetivo)
            throws RecursosInsuficientesException {
        if (objetivo instanceof EscudoProtector) {
            if (!planeta.tieneRecursos(Costes.REPARAR_ESCUDO_PIEDRA,
                    Costes.REPARAR_ESCUDO_HIERRO,
                    Costes.REPARAR_ESCUDO_COMBUSTIBLE)) {
                throw new RecursosInsuficientesException("Faltan recursos en el planeta para reparar el escudo");
            }
            planeta.consumirRecursos(Costes.REPARAR_ESCUDO_PIEDRA,
                    Costes.REPARAR_ESCUDO_HIERRO,
                    Costes.REPARAR_ESCUDO_COMBUSTIBLE);
            objetivo.reparar(Costes.REPARAR_ESCUDO_DEFENSA);
        } else {
            if (!planeta.tieneRecursos(0, Costes.REPARAR_NAVE_HIERRO, Costes.REPARAR_NAVE_COMBUSTIBLE)) {
                throw new RecursosInsuficientesException("Faltan recursos en el planeta para reparar la nave");
            }
            planeta.consumirRecursos(0, Costes.REPARAR_NAVE_HIERRO, Costes.REPARAR_NAVE_COMBUSTIBLE);
            objetivo.reparar(Costes.REPARAR_NAVE_DEFENSA);
        }
    }

    // Opción 11: Mostrar información de planetas (no cuenta como jugada)
    public static void mostrarPlanetas(Jugador jugador) {
        for (Planeta p : jugador.getPlanetas()) {
            System.out.println(p);
        }
    }

    // Opción 12: Pasar turno
    public static void pasarTurno(Partida partida) {
        System.out.println(partida.getJugadorActual().getNombre() + " pasa el turno.");
        partida.pasarTurno();
    }
}