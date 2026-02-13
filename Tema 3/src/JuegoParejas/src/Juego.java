package JuegoParejas.src;

import JuegoParejas.src.util.MiEntradaSalida;

public class Juego {
    private static final int TAM = 4;
    private static final int MAX_INTENTOS = 1;
    private static final char CHAR_OCULTO = '?';

    private static int[][] parejas = {{1,2,3,4}, {5,6,7,8}, {1,2,3,4}, {5,6,7,8}};
    private static boolean[][] visibles = new boolean[TAM][TAM];

    public static void main(String[] args) {
        int intentos = 0;

        while(intentos < MAX_INTENTOS && !haGanado()){
            mostrarMatriz();

            System.out.printf("Te quedan %d intentos%n", MAX_INTENTOS - intentos);

            //Pedir la primera coordenada
            boolean coordenadaCorrecta = false;
            int fila1 = 0, col1 = 0, fila2 = 0, col2 = 0;
            while (!coordenadaCorrecta){
                fila1 = MiEntradaSalida.solicitarEnteroEnRango("Introduce la primera fila: ", 1, 4) - 1;
                col1 = MiEntradaSalida.solicitarEnteroEnRango("Introduce la primera columna: ", 1, 4) - 1;

                if (visibles[fila1][col1]){
                    System.out.println("La casilla ya estaba levantada. Vuelve a introducir otra.");
                }
                else {
                    // Pongo la casilla visible
                    visibles[fila1][col1] = true;
                    coordenadaCorrecta = true;
                }
            }

            //Pedir la segunda coordenada
            mostrarMatriz();
            coordenadaCorrecta = false;
            while (!coordenadaCorrecta){
                fila2 = MiEntradaSalida.solicitarEnteroEnRango("Introduce la segunda fila: ", 1, 4) - 1;
                col2 = MiEntradaSalida.solicitarEnteroEnRango("Introduce la segunda columna: ", 1, 4) - 1;

                if (fila1 == fila2 && col1 == col2){
                    System.out.println("Has elegido las mismas coordenadas que para la primera casilla");
                }
                else if (visibles[fila2][col2]){
                    System.out.println("La casilla ya estaba levantada. Vuelve a introducir otra.");
                }
                else {
                    // Pongo visible la segunda casilla
                    visibles[fila2][col2] = true;
                    coordenadaCorrecta = true;
                }
            }
            mostrarMatriz();

            //Comprobar si acierto
            if (parejas[fila1][col1] == parejas[fila2][col2]){
                //acierto
                System.out.println("Has adivinado una pareja");
            }
            else {
                System.out.println("¡Qué mal! No has acertado esta vez");
                intentos++;
                // oculto las filas
                visibles[fila1][col1] = false;
                visibles[fila2][col2] = false;

            }
        }

        if (intentos == MAX_INTENTOS){
            System.out.println("Oooooooh, has perdido. Esta era la solución");
            mostrarMatrizCompleta();
        }
        else {
            System.out.println("Eres un p*** crack");
        }

    }

    public static void mostrarMatriz() {
        for (int i = 0; i < parejas.length; i++) {
            for (int j = 0; j < parejas[i].length; j++) {
                if (visibles[i][j]){
                    System.out.printf("%d " , parejas[i][j]);
                }
                else {
                    System.out.print(CHAR_OCULTO + " ");
                }
            }
            System.out.println();
        }
    }

    public static void mostrarMatrizCompleta() {
        for (int i = 0; i < parejas.length; i++) {
            for (int j = 0; j < parejas[i].length; j++) {
                System.out.printf("%d " , parejas[i][j]);
            }
            System.out.println();
        }
    }

    public static boolean haGanado() {
        for (int i = 0; i < visibles.length; i++) {
            for (int j = 0; j < visibles[i].length; j++) {
                if (!visibles[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}