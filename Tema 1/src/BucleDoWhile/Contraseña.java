package BucleDoWhile;

import java.util.Scanner;

public class Contraseña {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String contrasenaCorrecta = "1DAM";  //es la contraseña correcta es la clase que estamos
        String contrasenaIngresada;

        do {
            System.out.print("Introduce la contraseña: ");
            contrasenaIngresada = scanner.nextLine();
        } while (!contrasenaIngresada.equals(contrasenaCorrecta));

        System.out.println("¡Contraseña válida! Bienvenido.");
        scanner.close();
    }
}