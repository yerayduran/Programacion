package Boletin1.ejercicio4;

import java.util.ArrayList;

public class OrdenInverso {

    private static <T> ArrayList<T> alReves (ArrayList<T> arrayOriginal) {

        ArrayList<T> invertida = new ArrayList<>();

        for (int i = arrayOriginal.size() - 1; i >= 0; i--) {
            invertida.add(arrayOriginal.get(i));
        }

        return invertida;
    }

    public static void main(String[] args) {

        ArrayList<Integer> numeros = new ArrayList<>();

        numeros.add(1);
        numeros.add(2);
        numeros.add(3);
        numeros.add(4);
        numeros.add(5);

        ArrayList<Integer> numerosInvertidos = alReves(numeros);
        System.out.println(numerosInvertidos);
    }
}

