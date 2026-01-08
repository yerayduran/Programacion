package Space;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Inicialización del tablero con planetas
        List<String> nombresPlanetas = Arrays.asList("Marte", "Venus", "Júpiter", "Saturno");
        Tablero tablero = new Tablero(nombresPlanetas);
        Partida partida = new Partida(tablero);

        // Preguntar número de jugadores
        System.out.print("Número de jugadores (2-4): ");
        int numJugadores = sc.nextInt();
        sc.nextLine();

        List<String> nombresJugadores = new ArrayList<>();
        for (int i = 1; i <= numJugadores; i++) {
            System.out.print("Nombre del jugador " + i + ": ");
            nombresJugadores.add(sc.nextLine());
        }

        try {
            partida.inicializar(nombresJugadores);
        } catch (JuegoException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }

        boolean fin = false;
        while (!fin) {
            Jugador jugador = partida.getJugadorActual();
            System.out.println("\nSpace.Turno de " + jugador.getNombre());
            System.out.println("Oro disponible: " + jugador.getOro());
            System.out.println("Space.Acciones disponibles (elige 1-12):");
            System.out.println("1. Comprar nave");
            System.out.println("2. Comprar construcción");
            System.out.println("3. Coger carta de material");
            System.out.println("4. Construir");
            System.out.println("5. Mover nave");
            System.out.println("6. Atacar");
            System.out.println("7. Transportar carga");
            System.out.println("8. Transportar personas");
            System.out.println("9. Mejorar nave");
            System.out.println("10. Reparar");
            System.out.println("11. Mostrar información de planetas");
            System.out.println("12. Pasar turno");

            int opcion = sc.nextInt();
            sc.nextLine();

            try {
                switch (opcion) {
                    case 1 -> {
                        System.out.println("Naves disponibles en el mercado:");
                        List<Nave> mercado = tablero.getMercadoNaves().getDisponibles();
                        for (int i = 0; i < mercado.size(); i++) {
                            System.out.println(i + ". " + mercado.get(i));
                        }
                        System.out.print("Elige índice de nave: ");
                        int idx = sc.nextInt();
                        sc.nextLine();
                        Planeta planeta = jugador.getPlanetas().get(0); // simplificación
                        Acciones.comprarNave(partida, idx, planeta);
                    }
                    case 2 -> {
                        System.out.println("Comprar construcción: Space.Mina o Space.Escudo");
                        System.out.print("Tipo: ");
                        String tipo = sc.nextLine();
                        if (tipo.equalsIgnoreCase("Space.Mina")) {
                            Construccion c = new Mina("Piedra", new Dado(4, 2));
                            Acciones.comprarConstruccion(partida, c);
                        } else {
                            Construccion c = new EscudoProtector(new Dado(4, 2));
                            Acciones.comprarConstruccion(partida, c);
                        }
                    }
                    case 3 -> {
                        Planeta planeta = jugador.getPlanetas().get(0);
                        Acciones.cogerCartaMaterial(jugador, planeta);
                    }
                    case 4 -> {
                        if (jugador.getCartasConstruccion().isEmpty()) {
                            System.out.println("No tienes cartas de construcción.");
                        } else {
                            Construccion c = jugador.getCartasConstruccion().get(0);
                            Planeta planeta = jugador.getPlanetas().get(0);
                            Acciones.construir(jugador, c, planeta);
                        }
                    }
                    case 5 -> System.out.println("Mover nave (implementa selección de origen/destino)");
                    case 6 -> System.out.println("Atacar (implementa selección de nave y objetivo)");
                    case 7 -> System.out.println("Transportar carga (implementa menú interactivo)");
                    case 8 -> System.out.println("Transportar personas (implementa menú interactivo)");
                    case 9 -> System.out.println("Mejorar nave (selección de nave)");
                    case 10 -> System.out.println("Reparar (selección de nave o escudo)");
                    case 11 -> Acciones.mostrarPlanetas(jugador);
                    case 12 -> Acciones.pasarTurno(partida);
                    default -> System.out.println("Opción inválida");
                }
            } catch (Exception e) {
                System.out.println("Error en la acción: " + e.getMessage());
            }

            // Condición de fin de partida
            if (partida.getJugadores().size() <= 1) {
                fin = true;
                System.out.println("Juego terminado. Ganador: " + partida.getJugadores().get(0).getNombre());
            }
        }
    }
}