package boletin1.ejercicio7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.stream.Stream;

public class Ejercicio7 {
    public static void main(String[] args) {
        try {
            listarFicherosDirectorioYPeso("./src/boletin1");
            listarFicherosTerminadosEn("./src/boletin1", "3.java");
            buscarFicherosPorExtension("./src/boletin1", "java");
            System.out.println(buscarFicheroDeDirectorio("./src/boletin1", "Ejercicio1.java"));
            buscarFicheroRecursivamente("./", "Principal.java");


        } catch (Ejercicio7Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public static void listarFicherosDirectorioYPeso(String ruta) throws Ejercicio7Exception {
        try {
            Path archivo = Path.of(ruta);
            if (!Files.exists(archivo)) {
                throw new Ejercicio7Exception("No existe el directorio");
            }
            if (!Files.isReadable(archivo)) {
                throw new Ejercicio7Exception("El directorio no es legible");
            }
            try (Stream<Path> flujo = Files.list(archivo)) {
                flujo.map(p -> {
                    if (Files.isDirectory(p)) {
                        return String.format("Nombre: %s", p.getFileName());

                    } else {
                        try {
                            return String.format("Nombre: %s, Peso: %.2f", p.getFileName(), (double) Files.size(p) / 1024);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }).forEach(System.out::println);

            } catch (IOException e) {
                throw new Ejercicio7Exception(e.getMessage());
            }

        } catch (InvalidPathException e) {
            throw new Ejercicio7Exception(e.getMessage());
        }
    }

    public static void listarFicherosTerminadosEn(String ruta, String ultima) throws Ejercicio7Exception {
        try {
            Path directorio = Path.of(ruta);
            try (Stream<Path> flujo = Files.list(directorio)) {
                flujo.filter(p -> p.toFile().getName().endsWith(ultima))
                        .map(p -> {
                            if (Files.isDirectory(p)) {
                                return String.format("Nombre: %s", p.getFileName());

                            } else {
                                try {
                                    return String.format("Nombre: %s, Peso: %.2f", p.getFileName(), (double) Files.size(p) / 1024);

                                } catch (IOException e) {
                                    return "Error";
                                }
                            }
                        }).forEach(System.out::println);

            } catch (IOException e) {
                throw new Ejercicio7Exception(e.getMessage());
            }

        } catch (InvalidPathException e) {
            throw new Ejercicio7Exception(e.getMessage());
        }
    }


    public static void buscarFicherosPorExtension(String ruta, String extension) throws Ejercicio7Exception {
        try {
            Path directorio = Path.of(ruta);
            try (Stream<Path> flujo = Files.list(directorio)) {

                flujo.filter(p -> {
                            String[] array = (p.toFile().getName().split("\\."));
                            return array[array.length - 1].equalsIgnoreCase(extension);
                        })
                        .map(p -> {
                            if (Files.isDirectory(p)) {
                                return String.format("Nombre: %s", p.getFileName());

                            } else {
                                try {
                                    return String.format("Nombre: %s, Peso: %.2f", p.getFileName(), (double) Files.size(p) / 1024);

                                } catch (IOException e) {
                                    return "Error";
                                }
                            }
                        }).forEach(System.out::println);

            } catch (IOException e) {
                throw new Ejercicio7Exception(e.getMessage());
            }

        } catch (InvalidPathException e) {
            throw new Ejercicio7Exception(e.getMessage());
        }
    }

    public static Path buscarFicheroDeDirectorio(String directorioP, String fichero) throws Ejercicio7Exception {
        try {
            Path directorio = Path.of(directorioP);
            try (Stream<Path> flujo = Files.list(directorio)) {
                return flujo.filter(Files::isRegularFile)
                        .filter(p -> p.toFile().getName().equalsIgnoreCase(fichero)).findFirst()
                        .orElseThrow(() -> new Ejercicio7Exception("No se encuentra el fichero"));

            } catch (IOException e) {
                throw new Ejercicio7Exception(e.getMessage());
            }

        } catch (InvalidPathException e) {
            throw new Ejercicio7Exception(e.getMessage());
        }
    }

    public static void buscarFicheroRecursivamente(String directorioP, String fichero) throws Ejercicio7Exception {
        try {
            Path directorio = Path.of(directorioP);
            try (Stream<Path> flujo = Files.walk(directorio)) {
                flujo.filter(p -> p.toFile().getName().equalsIgnoreCase(fichero))
                        .forEach(System.out::println);

            } catch (IOException e) {
                throw new Ejercicio7Exception(e.getMessage());
            }

        } catch (InvalidPathException e) {
            throw new Ejercicio7Exception(e.getMessage());
        }
    }
}