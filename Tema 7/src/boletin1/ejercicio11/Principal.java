package boletin1.ejercicio11;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Principal {
    static void main(String[] args) {
        try {
            crearDirectorios();
        } catch (Ejercicio11Exception e) {
            System.out.printf("%s \n",e.getMessage());
        }
    }

    public static void crearDirectorios() throws Ejercicio11Exception {

        Pattern patron = Pattern.compile("^(?<nombre>\\p{Lu}\\p{Ll}+)\\s(?<apellido1>\\p{Lu}\\p{Ll}+)\\s(?<apellido2>\\p{Lu}\\p{Ll}+)\\s(?<curso>[1-6]º[A-Z]+)$");

        Path rutaArchivoContenido = Path.of("./src/boletin1/ejercicio11/alumnos.txt");

        if (Files.notExists(rutaArchivoContenido) || !Files.isRegularFile(rutaArchivoContenido) || !Files.isReadable(rutaArchivoContenido)){
            throw new Ejercicio11Exception("Moisés friki galaxy, la película (No es posible acceder al archivo, o no es un archivo de texto o no se puede leer)");
        }

        boolean todasLasLineasCumplenElFormato = false;

        try(Stream<String> lineas = Files.lines(rutaArchivoContenido)){
            todasLasLineasCumplenElFormato = lineas.allMatch(l -> l.matches(patron.pattern()));
        }catch (IOException e){
            System.out.printf("%s \n",e.getMessage());
        }

        if (!todasLasLineasCumplenElFormato){
            throw new Ejercicio11Exception("El archivo no cumple el patrón");
        }

        try(Stream<String> lineas = Files.lines(rutaArchivoContenido)){
            lineas.map(patron::matcher)
                    .filter(Matcher::find)
                    .forEach(m -> {
                        String nombre = m.group("nombre");
                        String apellido1 = m.group("apellido1");
                        String apellido2 = m.group("apellido2");
                        String curso = m.group("curso");

                        try {
                            Files.createDirectories(Path.of("./src/boletin1/salida",curso,apellido1+apellido2+nombre));
                        } catch (IOException e) {
                            System.out.printf("%s \n", e.getMessage());
                        }
                    });
        }catch (IOException e){
            System.out.printf("%s \n",e.getMessage());
        }

    }


}