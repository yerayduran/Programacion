package boletin1.ejercicio11;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Principal {

    public static void main(String[] args) {
        try {
            crearEstructuraDirectoriosYCarpetasAlumnos();
        } catch (Ejercicio11Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    /**
     * Crea una carpeta por cada curso y dentro una carpeta por cada alumno
     * con el nombre Apellido1Apellido2Nombre.
     * Si se detecta algún error en el formato del fichero, se detiene el proceso.
     *
     * @throws Ejercicio11Exception si hay error de formato o I/O
     */
    public static void crearEstructuraDirectoriosYCarpetasAlumnos() throws Ejercicio11Exception {
        Pattern patronCurso   = Pattern.compile("^[1-4]º[A-Z]{3,}$");
        Pattern patronNombre  = Pattern.compile("^\\p{Lu}\\p{Ll}+\\s+\\p{Lu}\\p{Ll}+\\s+\\p{Lu}\\p{Ll}+\\s+[1-4]º[A-Z]{3,}$");

        Path rutaFichero;
        try {
            rutaFichero = Path.of("./boletin1/ejercicio11/alumnos.txt");
        } catch (InvalidPathException e) {
            throw new Ejercicio11Exception("Ruta del fichero inválida: " + e.getMessage());
        }

        try (BufferedReader br = Files.newBufferedReader(rutaFichero)) {
            Map<String, List<String>> cursos = br.lines()
                    .map(String::trim)
                    .filter(linea -> !linea.isEmpty())
                    .peek(linea -> {
                        Matcher m = patronNombre.matcher(linea);
                        if (!m.matches()) {
                            throw new RuntimeException("Formato de línea inválida: " + linea);
                        }
                    })
                    .map(linea -> linea.split("\\s+"))
                    .collect(Collectors.groupingBy(
                            partes -> partes[3],
                            Collectors.mapping(partes -> partes[0] + partes[1] + partes[2],
                                    Collectors.toList()
                            )
                    ));

            // Crear una carpeta por cada curso
            for (Map.Entry<String, List<String>> entrada : cursos.entrySet()) {
                String curso = entrada.getKey();
                List<String> nombres = entrada.getValue();

                // Validar curso
                Matcher matcherCurso = patronCurso.matcher(curso);
                if (!matcherCurso.matches()) {
                    throw new Ejercicio11Exception("Nombre de curso no válido: " + curso);
                }

                Path raiz = rutaFichero.getParent();
                Path dirCurso = raiz.resolve(curso);

                if (!Files.exists(dirCurso)) {
                    try {
                        Files.createDirectory(dirCurso);
                    } catch (IOException e) {
                        throw new Ejercicio11Exception("No se pudo crear el directorio del curso '" + curso + "': " + e.getMessage());
                    }
                }

                // Crear carpeta por cada alumno dentro del curso
                for (String nombre : nombres) {
                    Path carpetaAlumno = dirCurso.resolve(nombre);
                    if (!Files.exists(carpetaAlumno)) {
                        try {
                            Files.createDirectory(carpetaAlumno);
                        } catch (IOException e) {
                            throw new Ejercicio11Exception(
                                    "No se pudo crear la carpeta del alumno '" + nombre + "': " + e.getMessage()
                            );
                        }
                    }
                }
            }

        } catch (IOException e) {
            throw new Ejercicio11Exception("Error al leer el fichero: " + e.getMessage());
        } catch (RuntimeException e) {
            if (e.getCause() instanceof Ejercicio11Exception) {
                throw (Ejercicio11Exception) e.getCause();
            } else {
                throw new Ejercicio11Exception("Formato de línea incorrecto en el fichero: " + e.getMessage());
            }
        }
    }
}