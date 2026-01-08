package Boletin1.Ejercicio1;

import Boletin1.Ejercicio1.Exception.CuentaCreditoException;

public class CuentaCredito extends Cuenta {

    //Atributos necesarios
    private static final double SALDO_INICIAL = 0.00;
    private static final double VALOR_CREDITO = 100.00;
    private static final double CREDITO_BASEMAX = 300.00;

    private final double CREDITO_BASE;
    private double credito;

    // Constructor con saldo y crédito que puedes elegir a tu gusto con la restricción de crédito (1-300)
    public CuentaCredito(double saldoInicial, double credito) throws CuentaCreditoException {
        super(saldoInicial);
        this.CREDITO_BASE = credito;
        setCredito(credito);
    }

    // Constructor con saldo inicial que tu puedes elegir a tu gusto y crédito por defecto (100)

    public CuentaCredito(double saldoInicial) throws CuentaCreditoException {
        super(saldoInicial);
        this.CREDITO_BASE = VALOR_CREDITO;
        setCredito(VALOR_CREDITO);
    }

    // Constructor por defecto con saldo = 0 y crédito = 100

    public CuentaCredito() throws CuentaCreditoException {
        super(SALDO_INICIAL);
        this.CREDITO_BASE = VALOR_CREDITO;
        setCredito(VALOR_CREDITO);
    }


    public double getCredito() {
        return credito;
    }

    public void setCredito(double credito) throws CuentaCreditoException {
        if (credito > CREDITO_BASEMAX) {
            throw new CuentaCreditoException("Crédito máximo alcanzado");
        }
        if (credito < 0) {
            throw new CuentaCreditoException("El crédito no puede ser negativo");
        }
        this.credito = credito;
    }

    @Override
    public void reintegro(double dineroRetirado) throws CuentaCreditoException {
        if (dineroRetirado <= 0) {
            throw new CuentaCreditoException("La cantidad a retirar debe ser positiva");
        }
        if (getSaldo() + credito < dineroRetirado) {
            throw new CuentaCreditoException("Fondos insuficientes");
        }

        /* La transición entre el dinero que tienes y el coste del producto el cual si es necesario coger el dinero del credito*/
        if (dineroRetirado <= getSaldo()) {
            super.reintegro(dineroRetirado);
        } else {
            double restante = dineroRetirado - getSaldo();
            if(getSaldo() > 0){
                super.reintegro(getSaldo()); // vaciar saldo
            }
            credito -= restante;         // usar crédito
        }
    }

    @Override
    public void ingreso(double dineroIngresa) throws CuentaCreditoException {
        if (dineroIngresa <= 0) {
            throw new CuentaCreditoException("La cantidad a ingresar debe ser positiva");
        }

        // Primero reponer crédito si se ha usado
        double deudaCredito = CREDITO_BASE - credito;
        if (deudaCredito > 0) {
            if (dineroIngresa >= deudaCredito) {
                credito = CREDITO_BASE; // reponemos todo el crédito para cuando este lleno empezar a llenar el saldo y no quedarte en numeros rojos
                super.ingreso(dineroIngresa - deudaCredito); // el resto va al saldo
            } else {
                credito += dineroIngresa; // solo reponemos parte del crédito
            }
        } else {
            super.ingreso(dineroIngresa); // si no hay deuda de crédito, todo va al saldo
        }
    }
}