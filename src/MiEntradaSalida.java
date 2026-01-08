import java.util.Scanner;

public class MiEntradaSalida {

    public static Scanner sc = new Scanner(System.in);

    public static int solicitarEntero(String mensaje) {
        // Variable que almacenará el entero introducido por teclado.
        int integer = 0;
        // Variable que almacenará un booleano que indicará si se le debe volver a pedir el dato al usuario.
        boolean flag = true;

        while(flag) {
            // Pedimos el entero por pantalla.
            System.out.println(mensaje);
            // Comprobamos si el usuario está introduciendo algo correcto usando la excepción del método parseInt.
            try {
                integer = Integer.parseInt(sc.nextLine());
                // Si llegamos hasta aquí, es porque el usuario ha introducido un dato correcto y no se ha lanzado ninguna excepción.
                flag = false;
            }
            // Si se lanza la excepción, informamos al usuario de su error.
            catch(NumberFormatException e) {
                System.out.println("Ha introducido un dato incorrecto.");
            }
        }
        return integer;
    }

    public static int solicitarEnteroPositivo(String mensaje) {
        // Variable que almacenará el entero introducido por teclado.
        int integer = 0;
        // Variable que almacenará un booleano que indicará si se le debe volver a pedir el dato al usuario.
        boolean flag = true;

        while(flag) {
            // Pedimos el entero por pantalla.
            System.out.println(mensaje);
            // Comprobamos si el usuario está introduciendo algo correcto usando la excepción del método parseInt.
            try {
                integer = Integer.parseInt(sc.nextLine());
                // Si llegamos hasta aquí, es porque el usuario ha introducido un dato correcto y no se ha lanzado ninguna excepción.
                if (integer >= 0) {
                    flag = false;
                }
            }
            // Si se lanza la excepción, informamos al usuario de su error.
            catch(NumberFormatException e) {
                System.out.println("Ha introducido un dato incorrecto.");
            }
        }

        return integer;
    }

    public static int solicitarEnteroEnRango(String mensaje, int limiteInferior, int limiteSuperior) {
        // Variable que almacenará el entero introducido por teclado.
        int integer = 0;
        // Variable que almacenará un booleano que indicará si se le debe volver a pedir el dato al usuario.
        boolean flag = true;

        while(flag) {
            // Pedimos el entero por pantalla.
            System.out.println(mensaje);
            // Comprobamos si el usuario está introduciendo algo correcto usando la excepción del método parseInt.
            try {
                integer = Integer.parseInt(sc.nextLine());
                // Si llegamos hasta aquí, es porque el usuario ha introducido un dato correcto y no se ha lanzado ninguna excepción.
                if (integer >= limiteInferior && integer <= limiteSuperior) {
                    flag = false;
                }
            }
            // Si se lanza la excepción, informamos al usuario de su error.
            catch(NumberFormatException e) {
                System.out.println("Ha introducido un dato incorrecto.");
            }
        }

        return integer;
    }

    public static char solicitarCaracter(String mensaje) {
        char c = '0';

        // Variable que almacenará un booleano que indicará si se le debe volver a pedir el dato al usuario.
        boolean flag = true;

        while(flag) {
            // Pedimos el entero por pantalla.
            System.out.println(mensaje);
            // Comprobamos si el usuario está introduciendo algo correcto usando la excepción del método parseInt.
            try {
                c = sc.nextLine().charAt(0);
                // Si llegamos hasta aquí, es porque el usuario ha introducido un dato correcto y no se ha lanzado ninguna excepción.
                flag = false;
            }
            // Si se lanza la excepción, informamos al usuario de su error.
            catch(IndexOutOfBoundsException e) {
                System.out.println("Ha introducido un dato incorrecto.");
            }
        }
        return c;
    }

    public static char solicitarCaracterSN(String mensaje) {
        char c = '0';

        // Variable que almacenará un booleano que indicará si se le debe volver a pedir el dato al usuario.
        boolean flag = true;

        while(flag) {
            // Pedimos el entero por pantalla.
            System.out.println(mensaje);
            // Comprobamos si el usuario está introduciendo algo correcto usando la excepción del método parseInt.

            String cadena = sc.nextLine();

            if (cadena.length() == 1) {
                c = cadena.toUpperCase().charAt(0);

                if (c == 'S' || c == 'N') {
                    // Si llegamos hasta aquí, es porque el usuario ha introducido un dato correcto y no se ha lanzado ninguna excepción.
                    flag = false;
                }
            }
        }
        return c;
    }

    public static String solicitarCadena(String mensaje) {
        String cadena = "";

        // Variable que almacenará un booleano que indicará si se le debe volver a pedir el dato al usuario.
        boolean flag = true;

        while(flag) {
            // Pedimos el string por pantalla.
            System.out.println(mensaje);
            // Comprobamos si el usuario está introduciendo algo correcto usando la excepción del método parseInt.

            cadena = sc.nextLine();

            if (cadena.length() > 0) {
                // Si llegamos hasta aquí, es porque el usuario ha introducido un dato correcto y no se ha lanzado ninguna excepción.
                flag = false;
            }
        }
        return cadena;
    }

    public static int seleccionarOpcion(String mensaje, String[] opciones) {

        boolean flag = true;
        int opcionElegida = -1;

        while (flag) {

            for (int i = 0; i < opciones.length; i++) {

                System.out.printf("%d: %s\n", (i+1),opciones[i]);
            }
            opcionElegida = MiEntradaSalida.solicitarEnteroEnRango(mensaje, 1, opciones.length);
            flag = false;
        }
        return opcionElegida;
    }

    public static double solicitarDoublePositivo(String mensaje) {
        // Variable que almacenará el entero introducido por teclado.
        double numero = 0;
        // Variable que almacenará un booleano que indicará si se le debe volver a pedir el dato al usuario.
        boolean flag = true;

        while(flag) {
            // Pedimos el entero por pantalla.
            System.out.println(mensaje);
            // Comprobamos si el usuario está introduciendo algo correcto usando la excepción del método parseInt.
            try {
                numero = Double.parseDouble(sc.nextLine());
                // Si llegamos hasta aquí, es porque el usuario ha introducido un dato correcto y no se ha lanzado ninguna excepción.
                if (numero >= 0) {
                    flag = false;
                }
            }
            // Si se lanza la excepción, informamos al usuario de su error.
            catch(NumberFormatException e) {
                System.out.println("Ha introducido un dato incorrecto.");
            }
        }
        return numero;
    }

    public static int sumarContenidoDeArrays(int[] a) {
        int suma = 0;
        for (int i = 0; i < a.length; i++) {
            suma += a[i];
        }
        return suma;
    }

    public static float solicitarFloat(String mensaje) {
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

    public static char solicitarChar(String mensaje) {
        char integer = 0;
        // Variable que almacenará un booleano que indicará si se le debe volver a pedir el dato al usuario.
        boolean flag = true;

        while (flag) {
            // Pedimos el entero por pantalla.
            System.out.println(mensaje);
            // Comprobamos si el usuario está introduciendo algo correcto usando la excepción del método chartAt.
            try {
                integer = sc.nextLine().charAt(0);
                // Si llegamos hasta aquí, es porque el usuario ha introducido un dato correcto.
                flag = false;
            }
            // Si se lanza la excepción, informamos al usuario de su error.
            catch (NumberFormatException e) {
                // 2. Mensaje de error específico.
                System.out.println("Error: Debe introducir un solo caracter.");
            }

        }
        return integer;
    }
    public static int generaAleatorio(int max) {
        return (int) (Math.random() * max + 1);
    }

    /**
     * Generar un número aleatorio entre un máximo y un mínimo
     *
     * @param min              Primer número del intervalo
     * @param max              Segundo número del intervalo
     * @param seAceptaElMaximo ¿El máximo entra en ese intervalo?
     * @return El número generado aleatoriamente
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
}