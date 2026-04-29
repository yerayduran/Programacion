import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class EjemploDeGruposExpre {
    static void main(String[] args) {
        try {
            crearDirectorios();
        } catch (MiEntradaSalidaException e) {
            System.out.printf("%s \n",e.getMessage());
        }
    }

    public static void crearDirectorios() throws MiEntradaSalidaException {

        //Expresion regular de la ruta del contenido
        Pattern patron = Pattern.compile("^(?<nombre>\\p{Lu}\\p{Ll}+)\\s(?<apellido1>\\p{Lu}\\p{Ll}+)\\s(?<apellido2>\\p{Lu}\\p{Ll}+)\\s(?<curso>[1-6]º[A-Z]+)$");

        // Ruta del Archivo
        Path rutaArchivoContenido = Path.of("./prueba/Nombres.txt");

        // Mira si exite, es un archivo y si se puede leer
        if (Files.notExists(rutaArchivoContenido) || !Files.isRegularFile(rutaArchivoContenido) || !Files.isReadable(rutaArchivoContenido)){
            throw new MiEntradaSalidaException("No es posible acceder al archivo, o no es un archivo de texto o no se puede leer");
        }

        boolean todasLasLineasCumplenElFormato = false;

        // Comprueba si la expresion coindice con el contenido del texto
        try(Stream<String> lineas = Files.lines(rutaArchivoContenido)){
            todasLasLineasCumplenElFormato = lineas.allMatch(l -> l.matches(patron.pattern()));
        }catch (IOException e){
            System.out.printf("%s \n",e.getMessage());
        }

        //Aqui no cumple
        if (!todasLasLineasCumplenElFormato){
            throw new MiEntradaSalidaException("El archivo no cumple el patrón");
        }


        //Este fragmento de código:
        //
        //1. Lee un archivo línea a línea,
        //
        //2. aplica una expresión regular a cada línea para extraer ciertos campos (nombre, apellido1, apellido2 y curso),
        //
        //3. y según esos datos crea estructuras de directorios tipo src/prueba/salida/<curso>/<apellido1+apellido2+nombre>.

        try(Stream<String> lineas = Files.lines(rutaArchivoContenido)){
            lineas.map(patron::matcher)
                    .filter(Matcher::find)
                    .forEach(m -> {
                        String nombre = m.group("nombre");
                        String apellido1 = m.group("apellido1");
                        String apellido2 = m.group("apellido2");
                        String curso = m.group("curso");

                        try {
                            Files.createDirectories(Path.of("./prueba",curso,apellido1+apellido2+nombre));
                        } catch (IOException e) {
                            System.out.printf("%s \n", e.getMessage());
                        }
                    });
        }catch (IOException e){
            System.out.printf("%s \n",e.getMessage());
        }

    }


}