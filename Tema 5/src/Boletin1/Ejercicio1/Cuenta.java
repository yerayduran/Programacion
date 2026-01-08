package Boletin1.Ejercicio1;

import Boletin1.Ejercicio1.Exception.CuentaCreditoException;

public class Cuenta {
    private double saldo;
    private int contadorRetiradas;
    private int contadorIngresos;

    public Cuenta(double saldoInicial) throws CuentaCreditoException {
        this.setSaldo(saldoInicial);
        this.contadorRetiradas = 0;
        this.contadorIngresos = 0;
    }

    public void setSaldo(double saldo) throws CuentaCreditoException {
        if (saldo < 0) {
            throw new CuentaCreditoException("El saldo inicial debe ser positivo");
        }
        this.saldo = saldo;
    }

    public void reintegro(double dineroRetirado) throws CuentaCreditoException {
        if (dineroRetirado <= 0) {
            throw new CuentaCreditoException("La cantidad a retirar debe ser positiva");
        }
        if (dineroRetirado > saldo) {
            throw new CuentaCreditoException("Saldo insuficiente para realizar el reintegro");
        }
        this.saldo -= dineroRetirado;
        this.contadorRetiradas++;
    }

    public void ingreso(double dineroIngresa) throws CuentaCreditoException {
        if (dineroIngresa <= 0) {
            throw new CuentaCreditoException("La cantidad a ingresar debe ser positiva");
        }
        this.saldo += dineroIngresa;
        this.contadorIngresos++;
    }

    public double getSaldo() {
        return saldo;
    }


    public void finalizar() {
        System.out.println("Has salido, tu saldo final es de " + this.saldo + " €");
    }
}