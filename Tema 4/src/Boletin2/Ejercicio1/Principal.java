package Boletin2.Ejercicio1;

import Ejercicio1.Exception.PersonaException;
import java.time.LocalDate;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Persona p = null;
        while (p == null) {
            try {
                System.out.print("Introduce tu nombre completo: ");
                String nombre = sc.nextLine();
                System.out.print("Introduce tu fecha de nacimiento (YYYY-MM-DD): ");
                LocalDate fechaNacimiento = LocalDate.parse(sc.nextLine());
                System.out.print("Introduce los 8 dígitos de tu DNI: ");
                int dni = Integer.parseInt(sc.nextLine());
                System.out.print("Introduce tu sexo (H = hembra, V = varón): ");
                char sexo = sc.nextLine().toUpperCase().charAt(0);
                System.out.print("Introduce tu altura en metros (ej: 1,75): ");
                float altura = Float.parseFloat(sc.nextLine());
                System.out.print("Introduce tu peso en kilos (ej: 70,5): ");
                float peso = Float.parseFloat(sc.nextLine());
                p = new Persona(nombre, fechaNacimiento, dni, sexo, altura, peso);

                p.mostrarInfo();

            } catch (PersonaException e) {
                System.out.println("Error: " + e.getMessage());

            }

            sc.close();
        }
    }
}