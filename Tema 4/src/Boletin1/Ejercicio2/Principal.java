package Boletin1.Ejercicio2;

import Boletin1.Ejercicio2.Exception.CuentaException;

public class Principal {
    public static void main(String[] args) {
        Cuenta c = null;
        while (c == null) {
            try {
                double saldoInicial = MiEntradaSalida.solicitarEnteroPositivo("Introduce el saldo inicial");
                c = new Cuenta(saldoInicial);
            } catch (CuentaException e) {
                System.out.println(e.getMessage());
            }
        }

        int opcion;

        do {
            mostarMenu();

            opcion = MiEntradaSalida.solicitarEnteroEnRango("Escribe una opción: ", 0, 3);

            switch (opcion) {
                case 3:
                    c.consultarOperaciones();
                    break;
                case 2:
                    int dineroAIngresar = MiEntradaSalida.solicitarEnteroPositivo("¿Cuánto dinero desea ingresar");
                    try {
                        c.ingreso(dineroAIngresar);
                        System.out.printf("Su saldo actual es de %.2f%n", c.getSaldo());
                    } catch (CuentaException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 1:
                    int dineroARetirar = MiEntradaSalida.solicitarEnteroPositivo("¿Cuánto dinero desea retirar");
                    try {
                        c.reintegro(dineroARetirar);
                        System.out.printf("Su saldo actual es de %.2f%n", c.getSaldo());
                    } catch (CuentaException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 0:
                    c.finalizar();
                    break;

            }
        } while (opcion != 0);
    }

    public static void mostarMenu() {
        System.out.println("¿Qué desea hacer?");
        System.out.println("0. Salir");
        System.out.println("1. Retirar");
        System.out.println("2. Ingresar");
        System.out.println("3. Consultar movimientos en la cuenta");
    }
}