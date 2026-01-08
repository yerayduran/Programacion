package Boletin1.Ejercicio3;

import Boletin1.Ejercicio2.MiEntradaSalida;
import Ejercicio3.Exception.MaquinaException;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Maquina m = new Maquina();
        int opcion;
        String[] opciones = {"Pulse 1 para pedir un café solo (1 euro)          |",
                "Pulse 2 para pedir leche (0,8 euros)              |",
                "Pulse 3 para pedir café con leche (1.5 euros)     |",
                "Pulse 4 para ver el estado de la máquina          |",
                "Pulsa 5 para vaciar el monedero                   |",
                "Pulse 6 para apagar la máquina y salir            |"};

        do {
            System.out.println("------------------ Boletin1.Ejercicio3.Maquina de Café ------------------|");
            opcion = MiEntradaSalida.seleccionarOpcion("\nSelecciona una opción: ", opciones);
            try {
                if (opcion == 1) {
                    System.out.println("Introduzca su dinero");
                    double dineroCafe = sc.nextDouble();
                    m.pedirCafeSolo(dineroCafe);
                }
                if (opcion == 2) {
                    System.out.println("Introduzca su dinero");
                    double dineroLeche = sc.nextDouble();
                    m.pedirLeche(dineroLeche);
                }
                if (opcion == 3) {
                    System.out.println("Introduzca su dinero");
                    double dineroCafeConLeche = sc.nextDouble();
                    m.pedirCafeConLeche(dineroCafeConLeche);
                }
                if (opcion == 4) {
                    estadoMaquina(m);
                }
                if (opcion == 5) {
                    m.vaciarMonedero();
                }
                if (opcion == 6) {
                    System.out.println("Apagando máquina, hasta pronto");
                }
            } catch (MaquinaException e) {
                System.out.println(e.getMessage());
            }
        } while (opcion != 6);
    }

    private static void estadoMaquina(Maquina m) {
        System.out.println("\nLa máquina tiene " + m.getDepositoCafe() + " de café solo, " + m.getDepositoLeche() + " de leche, " + m.getDepositoVasos() + " vasos y " + m.getMonedero() + " euros en el monedero\n4");
    }
}