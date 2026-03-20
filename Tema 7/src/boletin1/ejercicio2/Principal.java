package boletin1.ejercicio2;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Principal {
    public static void main(String[] args) {
        Path f = Path.of("./boletin1/ejercicio1/leeme.txt");

        try (Stream<String> lineas = Files.lines(f)) {
            System.out.println(lineas.collect(Collectors.joining(" ")));

        } catch (IOException e) {
            System.out.println("Error al abrir archivo");
        }
    }
}
