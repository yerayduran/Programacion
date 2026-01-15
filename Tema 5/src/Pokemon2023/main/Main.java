package Pokemon2023.main;

import java.util.ArrayList;
import Pokemon2023.utils.UserDataCollector;
import Pokemon2023.model.*;
import Pokemon2023.interfaces.Atacable;
import Pokemon2023.exceptions.RoundStartException;
import Pokemon2023.exceptions.ValorNoValidoException;
import Pokemon2023.exceptions.MuerteException;
import Pokemon2023.enums.*;

/**
 * Clase principal del programa. Gestiona la simulación completa del combate Pokémon:
 * <ul>
 *     <li>Generación aleatoria de Pokémon.</li>
 *     <li>Selección de clima por ronda.</li>
 *     <li>Aplicación de efectos climáticos.</li>
 *     <li>Turnos de ataque entre Pokémon.</li>
 *     <li>Detección del ganador.</li>
 * </ul>
 *
 * El combate continúa hasta que solo queda un Pokémon vivo (excluyendo los divinos).
 */
public class Main {

    /**
     * Método principal que inicia la simulación del combate Pokémon.
     *
     * @param args Argumentos de línea de comandos (no utilizados).
     */
    public static void main(String[] args) {

        Pokemon[] pokemons = new Pokemon[6];

        // Generación aleatoria de los 6 Pokémon
        for (int i = 0; i < pokemons.length; i++) {
            pokemons[i] = generateRandomPokemon();
        }

        // Mostrar los Pokémon seleccionados
        System.out.println("Los pokemons que han sido seleccionados son:");
        for (Pokemon pokemon : pokemons) {
            System.out.println(pokemon.getNombre() + " - " + pokemon.getClass().getSimpleName() + " - " + pokemon.getPuntosSalud() + " puntos de salud");
        }

        // Bucle principal del combate
        while (!hayGanador(pokemons)) {

            WeatherCondition weatherCondition = generateRandomWeatherCondition();

            System.out.println();
            System.out.println("##################################################");
            System.out.println("##################################################");
            System.out.println("El clima en esta ronda es " + weatherCondition);

            // Efectos de inicio de ronda
            for (Pokemon pokemon : pokemons) {
                try {
                    pokemon.roundStart(weatherCondition);
                } catch (RoundStartException e) {
                    System.out.println(e.getMessage());
                }
            }

            // Turnos de ataque
            for (int i = 0; i < pokemons.length; i++) {

                Pokemon atacante = pokemons[i];

                if (atacante.estaVivo()) {

                    System.out.println();
                    System.out.println("Es el turno de " + atacante.getNombre());

                    Atacable objetivo = seleccionaPokemonAtacable(pokemons, i);

                    try {
                        atacante.atacar(objetivo, weatherCondition);

                        Pokemon objetivoPokemon = (Pokemon) objetivo;

                        System.out.println(atacante.getNombre() + " ha atacado a " + objetivoPokemon.getNombre() + " - " + objetivoPokemon.getPuntosSalud() + " puntos de salud"
                        );

                    } catch (MuerteException e) {
                        System.out.println(e.getMessage());
                        if (hayGanador(pokemons)) {
                            break;
                        }
                    }
                }
            }
        }

        System.out.println("El ganador es " + getGanador(pokemons).getNombre());
    }

    /**
     * Obtiene el Pokémon ganador, es decir, el único que sigue vivo
     * y que no es de tipo {@link PokemonDivino}.
     *
     * @param pokemons Array de Pokémon participantes.
     * @return El Pokémon ganador, o null si no se encuentra.
     */
    private static Pokemon getGanador(Pokemon[] pokemons) {
        for (Pokemon pokemon : pokemons) {
            if (pokemon.estaVivo() && !(pokemon instanceof PokemonDivino)) {
                return pokemon;
            }
        }
        return null;
    }

    /**
     * Permite seleccionar un objetivo válido para atacar.
     * Muestra los Pokémon rivales vivos y permite elegir uno.
     *
     * @param pokemons Array de Pokémon participantes.
     * @param indiceAtacante Índice del Pokémon que está atacando.
     * @return El Pokémon objetivo seleccionado.
     */
    private static Atacable seleccionaPokemonAtacable(Pokemon[] pokemons, int indiceAtacante) {

        System.out.println("Estos son tus rivales:");

        ArrayList<Atacable> atacables = new ArrayList<>();
        int contador = 0;

        for (int j = 0; j < pokemons.length; j++) {
            if (j != indiceAtacante && pokemons[j].estaVivo() && pokemons[j] instanceof Atacable) {

                contador++;
                System.out.println(contador + ": " + pokemons[j].getNombre() + " - " + pokemons[j].getClass().getSimpleName() + " - " + pokemons[j].getPuntosSalud() + " puntos de salud"
                );

                atacables.add((Atacable) pokemons[j]);
            }
        }

        int opcion = UserDataCollector.getEnteroMinMax("Selecciona un pokemon para atacar", 1, contador);

        return atacables.get(opcion - 1);
    }

    /**
     * Determina si ya existe un ganador.
     * Un ganador existe cuando solo queda un Pokémon vivo (no divino).
     *
     * @param pokemons Array de Pokémon participantes.
     * @return true si hay un ganador, false en caso contrario.
     */
    private static boolean hayGanador(Pokemon[] pokemons) {
        int vivos = 0;

        for (Pokemon pokemon : pokemons) {
            if (!(pokemon instanceof PokemonDivino) && pokemon.estaVivo()) {
                vivos++;
            }
        }

        return vivos == 1;
    }

    /**
     * Genera un Pokémon aleatorio de cualquier tipo disponible.
     * Si algún valor aleatorio no es válido, reintenta automáticamente.
     *
     * @return Un Pokémon generado aleatoriamente.
     */
    private static Pokemon generateRandomPokemon() {

        while (true) {
            try {
                int random = (int) (Math.random() * 5);

                return switch (random) {
                    case 0 -> new PokemonAgua(generaNombrePokemonAleatorio(), (int) (Math.random() * 51 + 50), (int) (Math.random() * 11 + 5), (int) (Math.random() * 21 + 5), (int) (Math.random() * 11 + 10)
                    );
                    case 1 -> new PokemonFuego(generaNombrePokemonAleatorio(), (int) (Math.random() * 51 + 50), (int) (Math.random() * 11 + 5), (int) (Math.random() * 21 + 5), (int) (Math.random() * 6 + 5)
                    );
                    case 2 -> new PokemonElectrico(generaNombrePokemonAleatorio(), (int) (Math.random() * 51 + 50), (int) (Math.random() * 11 + 5), (int) (Math.random() * 21 + 5), (int) (Math.random() * 6 + 10)
                    );
                    case 3 -> new PokemonTierra(generaNombrePokemonAleatorio(), (int) (Math.random() * 51 + 50), (int) (Math.random() * 11 + 5), (int) (Math.random() * 21 + 5), (int) (Math.random() * 9 + 1)
                    );
                    case 4 -> new PokemonDivino(generaNombrePokemonAleatorio(), (int) (Math.random() * 51 + 50), (int) (Math.random() * 11 + 5), (int) (Math.random() * 21 + 5)
                    );
                    default -> null;
                };

            } catch (ValorNoValidoException e) {
            }
        }
    }

    /**
     * Genera un nombre aleatorio para un Pokémon a partir de una lista predefinida.
     *
     * @return Un nombre aleatorio.
     */
    private static String generaNombrePokemonAleatorio() {
        String[] nombres = {"Pikachu", "Charmander", "Squirtle", "Bulbasaur", "Jigglypuff", "Meowth", "Psyduck", "Vulpix", "Gengar", "Gyarados", "Lapras", "Eevee", "Snorlax", "Articuno", "Zapdos", "Moltres", "Mewtwo", "Mew", "Chikorita", "Cyndaquil", "Totodile", "Togepi", "Ampharos", "Bellossom", "Marill", "Sudowoodo", "Unown", "Wobbuffet", "Girafarig", "Pineco", "Dunsparce", "Gligar", "Steelix", "Snubbull", "Qwilfish", "Scizor", "Shuckle", "Heracross", "Sneasel", "Teddiursa", "Ursaring", "Slugma", "Swinub", "Corsola", "Remoraid", "Delibird", "Mantine", "Skarmory", "Houndour", "Phanpy"};
        return nombres[(int) (Math.random() * nombres.length)];
    }

    /**
     * Genera una condición climática aleatoria para la ronda.
     *
     * @return Una condición climática aleatoria.
     */
    private static WeatherCondition generateRandomWeatherCondition() {
        int random = (int) (Math.random() * 4);
        return WeatherCondition.values()[random];
    }
}