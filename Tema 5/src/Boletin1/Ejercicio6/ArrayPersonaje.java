package Boletin1.Ejercicio6;

import Boletin1.Ejercicio3.Personaje;

import java.util.Arrays;

public class ArrayPersonaje implements ICreableEstadisticas {

    private static final int MAX = 100;
    private Personaje[] personajes = new Personaje[MAX];
    private int contador = 0;

    public void add(Personaje p) {
        if (contador < MAX) {
            personajes[contador++] = p;
        }
    }

    @Override
    public double minimo() {
        if (contador == 0) return 0;

        double min = personajes[0].getPtsActual();

        for (int i = 1; i < contador; i++) {
            if (personajes[i].getPtsActual() < min) {
                min = personajes[i].getPtsActual();
            }
        }
        return min;
    }

    @Override
    public double maximo() {
        if (contador == 0) return 0;

        double max = personajes[0].getPtsActual();

        for (int i = 1; i < contador; i++) {
            if (personajes[i].getPtsActual() > max) {
                max = personajes[i].getPtsActual();
            }
        }
        return max;
    }

    @Override
    public double media() {
        if (contador == 0) return 0;

        double suma = 0;

        for (int i = 0; i < contador; i++) {
            suma += personajes[i].getPtsActual();
        }

        return suma / contador;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(personajes, contador));
    }
}