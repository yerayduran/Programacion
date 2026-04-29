import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Catálogo de expresiones regulares típicas de exámenes de 1º DAM.
 *
 * Diseño del catálogo:
 * - Cada expresión se declara como static final Pattern.
 * - Se compila una sola vez con Pattern.compile(...).
 * - Los grupos nombrados usan la sintaxis (?<nombre>...).
 * - Para interpretarlas:
 *      1) Se crea un Matcher con patron.matcher(texto)
 *      2) Se comprueba con matches() o find()
 *      3) Se extraen los campos con group("nombreDelGrupo")
 *
 * Regla rápida:
 * - matches() -> exige que TODA la cadena cumpla el patrón.
 * - find()    -> busca una coincidencia dentro de una cadena mayor.
 *
 * Ejemplo:
 * Matcher m = EMAIL.matcher("yeray.duran@gmail.com");
 * if (m.matches()) {
 *     System.out.println(m.group("usuario"));
 *     System.out.println(m.group("dominio"));
 *     System.out.println(m.group("extension"));
 * }
 */
public class CatalogoRegexDam {

    // 1. DNI completo: 12345678A
    // Diseño:
    // - dniNumero: exactamente 8 dígitos
    // - dniLetra: una letra mayúscula final
    public static final Pattern DNI = Pattern.compile(
            "^(?<dniNumero>[0-9]{8})(?<dniLetra>[A-Z])$"
    );

    // 2. NIF de empresa: A12345678
    // Diseño:
    // - tipo: una letra inicial
    // - numero: 8 dígitos
    public static final Pattern NIF_EMPRESA = Pattern.compile(
            "^(?<tipo>[A-Z])(?<numero>[0-9]{8})$"
    );

    // 3. Email básico: usuario@dominio.com
    // Diseño:
    // - usuario: letras, números y símbolos frecuentes
    // - dominio: nombre del dominio
    // - extension: com, es, org...
    public static final Pattern EMAIL = Pattern.compile(
            "^(?<usuario>[a-zA-Z0-9._%+-]+)@(?<dominio>[a-zA-Z0-9.-]+)\\.(?<extension>[a-zA-Z]{2,})$"
    );

    // 4. Teléfono español de 9 dígitos
    public static final Pattern TELEFONO = Pattern.compile(
            "^(?<telefono>[0-9]{9})$"
    );

    // 5. Teléfono internacional: +34 612345678
    public static final Pattern TELEFONO_INTERNACIONAL = Pattern.compile(
            "^(?<prefijo>\\+[0-9]{2,3})\\s(?<telefono>[0-9]{9})$"
    );

    // 6. Entero positivo
    public static final Pattern ENTERO_POSITIVO = Pattern.compile(
            "^(?<numero>[0-9]+)$"
    );

    // 7. Entero con signo
    public static final Pattern ENTERO_CON_SIGNO = Pattern.compile(
            "^(?<signo>[+-]?)(?<numero>[0-9]+)$"
    );

    // 8. Decimal con punto: 12.34
    public static final Pattern DECIMAL_PUNTO = Pattern.compile(
            "^(?<entero>[0-9]+)\\.(?<decimal>[0-9]+)$"
    );

    // 9. Decimal con coma: 12,34
    public static final Pattern DECIMAL_COMA = Pattern.compile(
            "^(?<entero>[0-9]+),(?<decimal>[0-9]+)$"
    );

    // 10. Decimal con coma o punto
    public static final Pattern DECIMAL_MIXTO = Pattern.compile(
            "^(?<entero>[0-9]+)(?<separador>[.,])(?<decimal>[0-9]+)$"
    );

    // 11. Fecha dd/MM/yyyy
    public static final Pattern FECHA_DDMMYYYY = Pattern.compile(
            "^(?<dia>[0-9]{2})/(?<mes>[0-9]{2})/(?<anio>[0-9]{4})$"
    );

    // 12. Fecha yyyy-MM-dd
    public static final Pattern FECHA_ISO = Pattern.compile(
            "^(?<anio>[0-9]{4})-(?<mes>[0-9]{2})-(?<dia>[0-9]{2})$"
    );

    // 13. Hora HH:mm
    public static final Pattern HORA_HHMM = Pattern.compile(
            "^(?<hora>[0-9]{2}):(?<minuto>[0-9]{2})$"
    );

    // 14. Hora HH:mm:ss
    public static final Pattern HORA_HHMMSS = Pattern.compile(
            "^(?<hora>[0-9]{2}):(?<minuto>[0-9]{2}):(?<segundo>[0-9]{2})$"
    );

    // 15. Matrícula española: 1234ABC
    public static final Pattern MATRICULA = Pattern.compile(
            "^(?<numeros>[0-9]{4})(?<letras>[A-Z]{3})$"
    );

    // 16. Código postal de 5 dígitos
    public static final Pattern CODIGO_POSTAL = Pattern.compile(
            "^(?<cp>[0-9]{5})$"
    );

    // 17. Nombre simple sin espacios
    public static final Pattern NOMBRE = Pattern.compile(
            "^(?<nombre>[A-Za-zÁÉÍÓÚáéíóúÑñ]+)$"
    );

    // 18. Nombre completo: nombre + apellidos
    public static final Pattern NOMBRE_COMPLETO = Pattern.compile(
            "^(?<nombre>[A-Za-zÁÉÍÓÚáéíóúÑñ]+)\\s(?<apellidos>[A-Za-zÁÉÍÓÚáéíóúÑñ\\s]+)$"
    );

    // 19. Usuario alfanumérico con guion bajo
    public static final Pattern USUARIO = Pattern.compile(
            "^(?<usuario>[a-zA-Z0-9_]{3,20})$"
    );

    // 20. Contraseña simple con longitud entre 8 y 20
    public static final Pattern PASSWORD_SIMPLE = Pattern.compile(
            "^(?<password>.{8,20})$"
    );

    // 21. Contraseña fuerte
    // Diseño:
    // - exige al menos una minúscula, una mayúscula y un dígito
    // - el grupo clave contiene la contraseña completa
    public static final Pattern PASSWORD_FUERTE = Pattern.compile(
            "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?<clave>[A-Za-z\\d@$!%*?&]{8,20})$"
    );

    // 22. URL básica
    public static final Pattern URL = Pattern.compile(
            "^(?<protocolo>https?)://(?<dominio>[a-zA-Z0-9.-]+)(?<ruta>/.*)?$"
    );

    // 23. Dirección IP v4
    public static final Pattern IP_V4 = Pattern.compile(
            "^(?<b1>\\d{1,3})\\.(?<b2>\\d{1,3})\\.(?<b3>\\d{1,3})\\.(?<b4>\\d{1,3})$"
    );

    // 24. Dirección MAC
    public static final Pattern MAC = Pattern.compile(
            "^(?<b1>[0-9A-Fa-f]{2}):(?<b2>[0-9A-Fa-f]{2}):(?<b3>[0-9A-Fa-f]{2}):(?<b4>[0-9A-Fa-f]{2}):(?<b5>[0-9A-Fa-f]{2}):(?<b6>[0-9A-Fa-f]{2})$"
    );

    // 25. Color hexadecimal largo: #A1B2C3
    public static final Pattern COLOR_HEX = Pattern.compile(
            "^(?<color>#[0-9A-Fa-f]{6})$"
    );

    // 26. Color hexadecimal corto: #ABC
    public static final Pattern COLOR_HEX_CORTO = Pattern.compile(
            "^(?<color>#[0-9A-Fa-f]{3})$"
    );

    // 27. Código de producto: AB12345
    public static final Pattern CODIGO_PRODUCTO = Pattern.compile(
            "^(?<letras>[A-Z]{2})(?<numero>[0-9]{5})$"
    );

    // 28. Código con guion: P-12345
    public static final Pattern CODIGO_GUION = Pattern.compile(
            "^(?<prefijo>[A-Z])-(?<numero>[0-9]{5})$"
    );

    // 29. Factura: FAC-123456
    public static final Pattern FACTURA = Pattern.compile(
            "^(?<serie>FAC)-(?<numero>[0-9]{6})$"
    );

    // 30. Pedido: PED-ABC123
    public static final Pattern PEDIDO = Pattern.compile(
            "^(?<serie>PED)-(?<codigo>[A-Z]{3})(?<numero>[0-9]{3})$"
    );

    // 31. Curso DAM/DAW/ASIR con número: DAM1
    public static final Pattern CURSO = Pattern.compile(
            "^(?<ciclo>DAM|DAW|ASIR)(?<nivel>[1-2])$"
    );

    // 32. Nota entre 0 y 10 con opcional decimal
    public static final Pattern NOTA = Pattern.compile(
            "^(?<entera>10|[0-9])(?:[.,](?<decimal>[0-9]{1,2}))?$"
    );

    // 33. Fracción: 12/5
    public static final Pattern FRACCION = Pattern.compile(
            "^(?<numerador>[0-9]+)/(?<denominador>[0-9]+)$"
    );

    // 34. Recta: y=-2x+5
    public static final Pattern RECTA = Pattern.compile(
            "^y=(?<pendiente>-?[0-9]+)x(?<signo>[+-])(?<ordenada>[0-9]+)$"
    );

    // 35. Versión: v1.2.3
    public static final Pattern VERSION = Pattern.compile(
            "^(?<prefijo>v)(?<major>[0-9]+)\\.(?<minor>[0-9]+)\\.(?<patch>[0-9]+)$"
    );

    // 36. Precio: 19,99 € o 19.99$
    public static final Pattern PRECIO = Pattern.compile(
            "^(?<importe>[0-9]+(?:[.,][0-9]{2})?)(?:\\s?(?<moneda>[€$]))?$"
    );

    // 37. Cuenta bancaria simple de 24 dígitos
    public static final Pattern CUENTA_BANCARIA = Pattern.compile(
            "^(?<cuenta>[0-9]{24})$"
    );

    // 38. Tarjeta con espacios: 1234 5678 9012 3456
    public static final Pattern TARJETA = Pattern.compile(
            "^(?<b1>[0-9]{4})\\s(?<b2>[0-9]{4})\\s(?<b3>[0-9]{4})\\s(?<b4>[0-9]{4})$"
    );

    // 39. Año entre 1900 y 2099
    public static final Pattern ANIO = Pattern.compile(
            "^(?<anio>19[0-9]{2}|20[0-9]{2})$"
    );

    // 40. ISBN-10 básico
    public static final Pattern ISBN10 = Pattern.compile(
            "^(?<grupo>[0-9]{1,5})[-.]?(?<editorial>[0-9]{1,7})[-.]?(?<titulo>[0-9]{1,7})[-.]?(?<control>[0-9X])$"
    );

    // 41. ISBN-13 básico
    public static final Pattern ISBN13 = Pattern.compile(
            "^(?<prefijo>97[89])[-.]?(?<grupo>[0-9]{1,5})[-.]?(?<editorial>[0-9]{1,7})[-.]?(?<titulo>[0-9]{1,7})[-.]?(?<control>[0-9])$"
    );

    // 42. Alumno con varios campos separados por ;
    public static final Pattern ALUMNO = Pattern.compile(
            "^nombre:(?<nombre>[^;]+);apellido1:(?<apellido1>[^;]+);apellido2:(?<apellido2>[^;]+);curso:(?<curso>[^;]+)$"
    );

    // 43. Alumno con email incluido
    public static final Pattern ALUMNO_CON_EMAIL = Pattern.compile(
            "^nombre:(?<nombre>[^;]+);apellido1:(?<apellido1>[^;]+);apellido2:(?<apellido2>[^;]+);curso:(?<curso>[^;]+);email:(?<email>[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,})$"
    );

    // 44. Producto con varios campos
    public static final Pattern PRODUCTO = Pattern.compile(
            "^codigo:(?<codigo>[A-Z]{3}[0-9]{3});nombre:(?<nombre>[^;]+);precio:(?<precio>[0-9]+(?:,[0-9]{2})?);categoria:(?<categoria>[^;]+);stock:(?<stock>[0-9]+)$"
    );

    // 45. Persona con nombre, apellidos y fecha
    public static final Pattern PERSONA_FECHA = Pattern.compile(
            "^nombre=(?<nombre>[^;]+);apellidos=(?<apellidos>[^;]+);fecha_nacimiento=(?<dia>[0-9]{2})/(?<mes>[0-9]{2})/(?<anio>[0-9]{4})$"
    );

    // 46. Línea campo:valor
    public static final Pattern CAMPO_VALOR = Pattern.compile(
            "^(?<campo>[a-zA-Z_][a-zA-Z0-9_]*)[:=](?<valor>.+)$"
    );

    // 47. SQL SELECT simple
    public static final Pattern SQL_SELECT = Pattern.compile(
            "^(?<comando>SELECT)\\s(?<campos>[\\*a-zA-Z0-9_,\\s]+)\\sFROM\\s(?<tabla>[a-zA-Z0-9_]+);?$"
    );

    // 48. Log: [2026-04-29 18:30:45] 192.168.1.10 GET /index.html 200
    public static final Pattern LOG_HTTP = Pattern.compile(
            "^\\[(?<fecha>\\d{4}-\\d{2}-\\d{2})\\s(?<hora>\\d{2}:\\d{2}:\\d{2})\\]\\s(?<ip>\\d{1,3}(?:\\.\\d{1,3}){3})\\s(?<metodo>[A-Z]+)\\s(?<ruta>/\\S*)\\s(?<codigo>[0-9]{3})$"
    );

    // 49. Nombre de fichero con extensión
    public static final Pattern FICHERO = Pattern.compile(
            "^(?<nombre>[a-zA-Z0-9_-]+)\\.(?<extension>[a-zA-Z0-9]+)$"
    );

    // 50. CSV simple de 4 columnas
    public static final Pattern CSV_4_COLUMNAS = Pattern.compile(
            "^(?<c1>[^,]+),(?<c2>[^,]+),(?<c3>[^,]+),(?<c4>[^,]+)$"
    );

    /**
     * Método de apoyo para probar cualquier patrón.
     * Usa matches() para validar que toda la cadena encaja.
     */
    public static boolean validar(Pattern patron, String texto) {
        return patron.matcher(texto).matches();
    }

    public static void main(String[] args) {
        String texto = "nombre:Pepe;apellido1:Perez;apellido2:Gomez;curso:DAM1";
        Matcher matcher = ALUMNO.matcher(texto);

        if (matcher.matches()) {
            System.out.println("Nombre: " + matcher.group("nombre"));
            System.out.println("Apellido1: " + matcher.group("apellido1"));
            System.out.println("Apellido2: " + matcher.group("apellido2"));
            System.out.println("Curso: " + matcher.group("curso"));
        } else {
            System.out.println("No coincide con el patrón ALUMNO");
        }

        System.out.println();

        String email = "yeray.duran@gmail.com";
        Matcher m2 = EMAIL.matcher(email);
        if (m2.matches()) {
            System.out.println("Usuario: " + m2.group("usuario"));
            System.out.println("Dominio: " + m2.group("dominio"));
            System.out.println("Extensión: " + m2.group("extension"));
        }
    }
}