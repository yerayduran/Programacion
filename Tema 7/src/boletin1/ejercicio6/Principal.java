package boletin1.ejercicio6;
import utils.MiEntradaSalida;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Principal {

    private static void mostrarPesoEnKB() {
        String nombre = MiEntradaSalida.leerCadena("Indica el nombre del directorio");
        Path directorio = Path.of("boletin1", "ejercicio6", nombre);

        if (Files.exists(directorio)) {
            try {
                System.out.println(Arrays.toString(Files.readAllBytes(directorio)));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void mostrarPesoEnKB2() {
        String nombreDirectorio = MiEntradaSalida.leerCadena("Introduce el nombre del  directorio \n");

        Path p = Path.of(nombreDirectorio);
        if (Files.exists(p)) {
            if (Files.isDirectory(p)) {
                try {
                    Files.list(p).forEach(path -> {
                        if (Files.isDirectory(path)) {
                            System.out.printf("%s - directorio %n", path.getFileName());
                        } else {
                            try {
                                System.out.printf("%s %.2f kb %n", path.getFileName(), Files.size(path) / 1024.0);
                            } catch (IOException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                    });
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            } //TODO Hacer el else
        } else {
            System.out.println("No existe crack");
        }
    }

    public static void main(String[] args) {
        mostrarPesoEnKB();
    }

}