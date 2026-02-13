package Boletin3.Ejercicio1;

public class Carta {

    // Atributos
    private String palo;
    private String numero;

    // Hacemos el constructor
    public Carta(String palo, String numero) {
        this.palo = palo;
        this.numero = numero;
    }

    // Hacemos un toString, para poder imprimir las cartas que contiene la baraja en la clase 'Boletin3.Boletin4.Ejercicio1.Ejercicio1.Juego'
    @Override
    public String toString() {
        //return "Boletin3.Boletin4.Ejercicio1.Ejercicio1.Carta {" + "palo = '" + palo + '\'' + ", numero = '" + numero + '\'' + "}";
        return "%s de %s".formatted(numero, palo);
    }
}