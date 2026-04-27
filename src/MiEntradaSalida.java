import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.stream.Stream;

//Version2.0
public class MiEntradaSalida {

    // NÚMEROS Y DÍGITOS
    public static final String REGEX_ENTERO_POSITIVO       = "^[0-9]+$";
    public static final String REGEX_ENTERO_COMPLETO       = "^-?[0-9]+$";
    public static final String REGEX_DECIMAL_POSITIVO      = "^[0-9]+(\\.[0-9]+)?$";
    public static final String REGEX_DECIMAL_COMPLETO      = "^-?[0-9]+(\\.[0-9]+)?$";

    // NOMBRES, USUARIOS Y CADENAS DE TEXTO
    public static final String REGEX_SOLO_LETRAS           = "^[a-zA-Z]+$";
    public static final String REGEX_NOMBRE_USUARIO        = "^[a-zA-Z0-9_]+$";
    public static final String REGEX_NOMBRE_COMPLETO       = "^[a-zA-Z]+( [a-zA-Z]+)*$";
    public static final String REGEX_LETRAS_O_ESPACIOS     = "^[a-zA-Z ]*$";

    // CONTRASEÑAS
    public static final String REGEX_PASS_8_LETRAS_NUMS    = "^[a-zA-Z0-9]{8,}$";
    public static final String REGEX_PASS_LETRAS_NUMS      = "^(?=.*[a-zA-Z])(?=.*[0-9])[a-zA-Z0-9]{8,}$";
    public static final String REGEX_PASS_FUERTE           = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{8,}$";

    // EMAIL, USUARIOS, URL
    public static final String REGEX_EMAIL                 = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
    public static final String REGEX_USUARIO_EMAIL         = "^[a-zA-Z0-9._%+-]+$";
    public static final String REGEX_URL_HTTP              = "^https?://[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}.*$";

    // DNI, NIE, CÓDIGO POSTAL, TELÉFONOS
    public static final String REGEX_DNI_8_DIGITOS         = "^[0-9]{8}$";
    public static final String REGEX_DNI_COMPLETO          = "^[0-9]{8}[A-Za-z]$";
    public static final String REGEX_NIE_COMPLETO          = "^[XYZ][0-9]{7}[A-Za-z]$";
    public static final String REGEX_CODIGO_POSTAL         = "^[0-9]{5}$";
    public static final String REGEX_TLF_MOVIL_ES          = "^[67][0-9]{8}$";

    // FECHAS Y HORAS
    public static final String REGEX_FECHA_DD_MM_AAAA      = "^[0-9]{2}-[0-9]{2}-[0-9]{4}$";
    public static final String REGEX_HORA_HH_MM            = "^([0-1][0-9]|2[0-3]):[0-5][0-9]$";
    public static final String REGEX_FECHA_DD_MM_AAAA_S    = "^[0-9]{2}[/\\-][0-9]{2}[/\\-][0-9]{4}$";

    // VALIDACIONES DE “VACÍO” Y FORMATO SIMPLE
    public static final String REGEX_SOLO_ESPACIOS         = "^\\s*$";
    public static final String REGEX_NO_SÓLO_ESPACIOS      = "^(?!\\s*$).+";
    public static final String REGEX_DIGITOS_GUIONES       = "^[0-9\\-]+$";

    // ARCHIVOS Y EXTENSIONES
    public static final String REGEX_NOMBRE_ARCHIVO        = "^[a-zA-Z0-9._-]+$";
    public static final String REGEX_ARCHIVO_TXT           = "^[a-zA-Z0-9._-]+\\.txt$";
    public static final String REGEX_ARCHIVO_IMAGEN        = "^[a-zA-Z0-9._-]+\\.(jpg|jpeg|png|gif)$";

    private static Scanner sc = new Scanner(System.in);

    /**
     * Lee un entero mostrando el mensaje pasado como parámetro
     *
     * @param mensaje El mensaje a mostrar
     * @return el entero leído por teclado
     */
    public static int leerEntero(String mensaje) {
        int integer = 0;
        // Variable que almacenará un booleano que indicará si se le debe volver a pedir el dato al usuario.
        boolean flag = true;

        while (flag) {
            // Pedimos el entero por pantalla.
            System.out.println(mensaje);
            // Comprobamos si el usuario está introduciendo algo correcto usando la excepción del método parseInt.
            try {
                integer = Integer.parseInt(sc.nextLine());
                // Si llegamos hasta aquí, es porque el usuario ha introducido un dato correcto.
                flag = false;
            }
            // Si se lanza la excepción, informamos al usuario de su error.
            catch (NumberFormatException e) {
                // 2. Mensaje de error específico.
                System.out.println("Error: Debe introducir un número entero.");
            }

        }

        return integer;
    }

    /**
     * Número entero
     *
     * @param mensaje      El mensaje a mostrar
     * @param seAceptaCero Si el 0 esta incluido
     * @return El entero leido por teclado
     */
    public static int leerEnteroPositivo(String mensaje, boolean seAceptaCero) {
        int a;
        do {
            a = leerEntero(mensaje);
            if (a < 0 || a == 0 && !seAceptaCero) {
                System.out.println("Numero no válido.");
            }

        } while (a < 0 || a == 0 && !seAceptaCero);
        return a;
    }

    /**
     * Leer un decimal de tipo double
     *
     * @param mensaje El mensaje a introducir
     * @return Lo introducido por el usuario
     */
    public static double leerDouble(String mensaje) {
        double integer = 0;
        // Variable que almacenará un booleano que indicará si se le debe volver a pedir el dato al usuario.
        boolean flag = true;

        while (flag) {
            // Pedimos el entero por pantalla.
            System.out.println(mensaje);
            // Comprobamos si el usuario está introduciendo algo correcto usando la excepción del método parseInt.
            try {
                integer = Double.parseDouble(sc.nextLine());
                // Si llegamos hasta aquí, es porque el usuario ha introducido un dato correcto.
                flag = false;
            }
            // Si se lanza la excepción, informamos al usuario de su error.
            catch (NumberFormatException e) {
                // 2. Mensaje de error específico.
                System.out.println("Error: Debe introducir un número decimal.");
            }

        }

        return integer;
    }

    /**
     * Leer un decimal de tipo Float
     *
     * @param mensaje mensaje a mostrar
     * @return lo introducido por el usuario
     */
    public static float leerFloat(String mensaje) {
        float integer = 0;
        // Variable que almacenará un booleano que indicará si se le debe volver a pedir el dato al usuario.
        boolean flag = true;

        while (flag) {
            // Pedimos el entero por pantalla.
            System.out.println(mensaje);
            // Comprobamos si el usuario está introduciendo algo correcto usando la excepción del método parseInt.
            try {
                integer = Float.parseFloat(sc.nextLine());
                // Si llegamos hasta aquí, es porque el usuario ha introducido un dato correcto.
                flag = false;
            }
            // Si se lanza la excepción, informamos al usuario de su error.
            catch (NumberFormatException e) {
                // 2. Mensaje de error específico.
                System.out.println("Error: Debe introducir un número entero.");
            }

        }

        return integer;
    }


    /**
     * Generar un número aleatorio determinado por un máximo
     *
     * @param max hasta que número se va a generar
     * @return número generado aleatoriamente
     */
    public static int generaAleatorio(int max) {
        return (int) (Math.random() * max + 1);
    }

    /**
     * Generar un número aleatorio entre un máximo y un mínimo
     *
     * @param min              Primer número del intervalo
     * @param max              Segundo número del intervalo
     * @param seAceptaElMaximo ¿El máximo entra en ese intervalo?
     * @return El número genrado aleatoriamente
     */
    public static int generaAleatorioEntre(int min, int max, boolean seAceptaElMaximo) {
        int ventana;

        if (seAceptaElMaximo) {
            ventana = max - min + 1;
        } else {
            ventana = max - min;
        }
        return (int) (Math.random() * ventana) + min;
    }

    /**
     * Leer una cadena de texto
     *
     * @param mensaje Mensaje a mostrar
     * @return String leido
     */
    public static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return sc.next();
    }

    /**
     * Leer entero en un rango
     *
     * @param mensaje mensaje a mostrar
     * @param min     valor mínimo incluido
     * @param max     valor máximo incluido
     * @return Numero leido por teclado
     */
    public static int leerEnteroRango(String mensaje, int min, int max) throws MiEntradaSalidaException {
        if (min > max) {
            //Mostrar error
            throw new MiEntradaSalidaException("El mínimo es mayor que el máximo");
        }
        int a;
        do {
            a = leerEntero(mensaje);
            if (a < min || a > max) {
                System.out.println("Número no válido, esta fuera del rango.");
            }
        } while (a < min || a > max);
        return a;
    }

    /**
     * Recoger el caracter 'S' o 'N'
     *
     * @param mensaje Mensaje a mostrar
     * @return El caracter obtenido por teclado
     */
    public static char leerSN(String mensaje) {
        char caracter;
        do {
            String texto = leerTexto(mensaje).toUpperCase();
            caracter = texto.charAt(0);
            if (caracter != 'S' && caracter != 'N') {
                System.out.println("Respuesta no válida");
            }
        } while (caracter != 'S' && caracter != 'N');
        return caracter;
    }

    /**
     * Imprimir una Matriz por pantalla
     *
     * @param matriz La matriz a imprimir
     */
    public static void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("[" + matriz[i][j] + "]" + " ");
            }
            System.out.println();
        }
    }

    /**
     * Imprimir una matriz de strings
     *
     * @param matriz matriz a imprimir
     */
    public static void imprimirMatrizString(String[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("[" + matriz[i][j] + "]" + " ");
            }
            System.out.println();
        }
    }

    /**
     * Leer linea de texto
     *
     * @param mensaje mensaje a mostar
     * @return mensaje introducido
     */
    public static String leerLinea(String mensaje) {
        System.out.print(mensaje);
        return sc.nextLine();
    }

    /**
     * Mostrar opciones
     *
     * @param mensaje mensaje a mostrar
     * @param array   lista a recorrer
     */
    public static void mostrarOpcionesSinNulos(String mensaje, Object[] array) {
        System.out.println(mensaje);
        int posicion = 1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                System.out.println(posicion++ + "." + " " + array[i]);
            }
        }
        System.out.println();
    }

    public static LocalDate fecha(String mensaje) throws MiEntradaSalidaException {
        int año = leerEnteroPositivo("Introduce el año: ", true);
        int mes = leerEnteroPositivo("Introduce el mes: ", true);
        int dia = leerEnteroPositivo("Introduce el dia: ", true);
        try {
            return LocalDate.of(año, mes, dia);
        } catch (DateTimeException e) {
            throw new MiEntradaSalidaException("Fecha no valida.");
        }

    }

    public static char leerChar(String mensaje) throws MiEntradaSalidaException {
        String texto = leerTexto(mensaje);
        if (texto.length() != 1) {
            throw new MiEntradaSalidaException("Debes introducir un caracter.");
        }
        return texto.charAt(0);
    }


    /*
    Metodo para crear un archivo
     */
    public static void crearArchivo() {
        Path emptyFile = Paths.get("./ejemplos_de_clase/java_nio/emptyFile.txt");
        if (Files.notExists(emptyFile)) {
            try {
                emptyFile = Files.createFile(emptyFile);
                System.out.println("Se ha creado el fichero correctamente");
            }
            catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        else {
            System.out.println("El fichero ya existía.");
        }

    }

    /*
    Lee un fichero y la convierte en una cadena
     */
    public static void ficheroTexto(){
        Path path = Paths.get("./ejemplos_de_clase/java_nio/fichero.txt");

        String content = null;
        try {
            content = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println(content);
    }

    // boolean esDni = MiEntradaSalida.validarConRegex(dni, REGEX_DNI_8_DIGITOS); para el codigo principal

    public static boolean validarConRegex(String texto, String regex) {
        return texto != null && texto.matches(regex);
    }


    public static void mostrarArchivosEnCarpeta(String nombreCarpeta) {
        Path rutaAbsoluta = Path.of(nombreCarpeta).toAbsolutePath().normalize();

        try (Stream<Path> listaDeArchivos = Files.list(rutaAbsoluta)) {
            listaDeArchivos.forEach(p -> System.out.println(p.getFileName()));
        }catch (IOException e){
            System.out.println("No se puede acceder a la ruta: " + e.getMessage());
        }
    }


    /*
    exportar lista a un archivo JSON en un destino
     */
    public static void exportarAJson(List<Persona> personas, Path destino) {

        // Configuramos Gson para que el JSON salga con saltos de línea y tabulaciones
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String json = gson.toJson(personas);

        try {
            Files.writeString(destino, json);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


    }
}