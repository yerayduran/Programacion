package Pokemon2023.enums;

/**
 * Enumeración que representa las distintas condiciones climáticas
 * que pueden afectar a los Pokémon durante una ronda de combate.
 *
 * Cada condición puede activar bonificaciones, penalizaciones o
 * efectos especiales dependiendo del tipo de Pokémon.
 */
public enum WeatherCondition {

    /** Clima soleado. Beneficia especialmente a los Pokémon de tipo Fuego. */
    SOL,

    /** Lluvia. Beneficia a los Pokémon de tipo Agua y potencia ataques eléctricos. */
    LLUVIA,

    /** Tormenta eléctrica. Aumenta el poder de los Pokémon de tipo Eléctrico. */
    TORMENTA_ELECTRICA,

    /** Tormenta de arena. Favorece a los Pokémon de tipo Tierra. */
    TORMENTA_DE_ARENA;
}
