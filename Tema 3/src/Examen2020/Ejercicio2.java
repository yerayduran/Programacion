package Examen2020;

public class Ejercicio2 {


    public static void main(String[] args) {
        int[][] jardin = {
                {1, 0, 0, 0, 1, 0, 0, 0, 2, 1, 1, 0, 0, 5, 0},
                {0, 2, 0, 5, 0, 0, 3, 0, 1, 0, 0, 0, 1, 0, 0},
                {3, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 2, 4},
                {0, 0, 2, 0, 0, 0, 0, 0, 2, 1, 3, 0, 0, 0, 1},
                {0, 0, 1, 0, 0, 0, 3, 0, 1, 0, 0, 0, 0, 0, 3},
                {4, 3, 0, 0, 0, 2, 1, 0, 0, 0, 0, 5, 0, 0, 0},
                {1, 2, 0, 5, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 2},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1},
                {3, 0, 0, 0, 0, 0, 2, 1, 4, 0, 0, 0, 1, 0, 0},
                {2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 3, 0},
                {0, 0, 5, 1, 0, 0, 0, 5, 0, 3, 0, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 5, 2, 4, 0},
                {0, 0, 1, 3, 0, 0, 1, 0, 0, 1, 0, 0, 1, 3, 0},
                {0, 1, 2, 1, 0, 0, 0, 0, 0, 2, 3, 1, 0, 0, 1},
                {1, 3, 4, 0, 0, 5, 0, 0, 1, 0, 0, 0, 0, 4, 2}
        };
        for (int i = 0; i < jardin.length; i++) {  //Hacemos un recorrido por el jardín para encontrar las flores
            for (int j = 0; j < jardin[0].length; j++) {
                if (jardin[i][j] == 1) {
                    if (puedeFlorecer(jardin, i, j)) {
                        System.out.println("La flor de la posición " + i + "," + j + " florecerá");
                    }
                }
            }
        }
    }

    public static boolean puedeFlorecer(int[][] jardin, int fila, int col) {  //Función que comprueba si una flor puede florecer o no con las condiciones dadas
        if(!tieneAguaCercana(jardin, fila, col) || !tieneAbejaCercana(jardin, fila, col)){
            return false;
        }
        if(tieneMalaHierba(jardin, fila, col) && !tieneGusanoCercanoAMalaHierba(jardin, fila, col)){
            return false;
        }
        return true;
    }


    public static boolean tieneAguaCercana(int[][] jardin, int fila, int col) {  //Función que comprueba si hay agua cerca de la flor
        for (int i = fila - 1; i <= fila + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i == fila && j == col) continue;
                if (i >= 0 && i < jardin.length && j >= 0 && j < jardin[0].length) {
                    if (jardin[i][j] == 2) return true;
                }
            }
        }
        return false;
    }

    public static boolean tieneAbejaCercana(int[][] jardin, int fila, int col) {  //Función que comprueba si hay una abeja cerca de la flor
        for (int i = fila - 3; i <= fila + 3; i++) {
            for (int j = col - 3; j <= col + 3; j++) {
                if (i >= 0 && i < jardin.length && j >= 0 && j < jardin[0].length) {
                    if (jardin[i][j] == 5) return true;
                }
            }
        }
        return false;
    }

    public static boolean tieneMalaHierba(int[][] jardin, int fila, int col) {  //Función que comprueba si hay mala hierba cerca de la flor
        for (int i = fila - 1; i <= fila + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i == fila && j == col) continue;
                if (i >= 0 && i < jardin.length && j >= 0 && j < jardin[0].length) {
                    if (jardin[i][j] == 3) return true;
                }
            }
        }
        return false;
    }

    public static boolean tieneGusanoCercanoAMalaHierba(int[][] jardin, int fila, int col) { //Función que comprueba si hay un gusano cerca de la mala hierba
        for (int i = fila - 1; i <= fila + 1; i++) {
            for (int j = col - 1; j <= col + 1; j++) {
                if (i == fila && j == col) continue;
                if (i >= 0 && i < jardin.length && j >= 0 && j < jardin[0].length) {
                    if (jardin[i][j] == 4) return true;
                }
            }
        }
        return false;
    }
}