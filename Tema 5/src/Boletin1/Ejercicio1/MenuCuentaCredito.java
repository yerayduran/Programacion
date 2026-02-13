package Boletin1.Ejercicio1;
import Boletin1.Ejercicio1.Exception.CuentaCreditoException;

import java.util.Scanner;

public class MenuCuentaCredito {
     static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CuentaCredito c;

        try {
            c = new CuentaCredito(12, 200);
            /* En el apartado superior podemos definir cuanta cantidad de sueldo quieres que tenga por defecto
            lo mismo le pasa al credito, pero con una pequeña restricción que solo puedes poner una cantidad entre 1-300
            el cual para ponerlo seria:
            c = new Boletin5Parte1.Ejercicio1.CuentaCredito(saldo inicial: ,credito: 1-300);
             */
        } catch (CuentaCreditoException e) {
            System.out.println(e.getMessage());
            return;
        }

        String[] opciones ={"Ingresar dinero", "Sacar dinero", "Mostrar saldo y crédito", "Salir"};
        int opcion;
        do {
            System.out.println("\n--------------- Boletin5Parte1.Ejercicio1.Cuenta de Crédito ---------------|");
            opcion = MiEntradaSalida.seleccionarOpcion("\nSeleccione una opción: ",  opciones);
            try {
                switch (opcion) {
                    case 1:
                        double ingreso = MiEntradaSalida.solicitarDoublePositivo("Introduce una cantidad a ingresar: ");
                        c.ingreso(ingreso);
                        break;

                    case 2:
                        double retiro = MiEntradaSalida.solicitarDoublePositivo("Introduce una cantidad a retirar: ");
                        c.reintegro(retiro);
                        break;

                    case 3:
                        System.out.println("Saldo actual: " + c.getSaldo() + " €");
                        System.out.println("Crédito disponible: " + c.getCredito() + " €");
                        break;

                    case 4:
                        c.finalizar();
                        break;

                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (CuentaCreditoException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (opcion != 4);
        sc.close();
    }
}