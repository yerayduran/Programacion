package Boletin1.Ejercicio2;

import Boletin1.Ejercicio2.Exception.CuentaException;

public class Cuenta {
    private double saldo;
    private double contadorRetiradas;
    private double contadorIngresos;

    public Cuenta(double saldoInicial) throws CuentaException {
        this.setSaldo(saldoInicial);
        this.contadorRetiradas = 0;
        this.contadorIngresos = 0;
    }

    public void setSaldo(double saldo) throws CuentaException{
        if(saldo < 0){
            throw new CuentaException("Tu saldo debe de ser positivo");
        }
        this.saldo = saldo;
    }

    public void reintegro(double dineroRetirado) throws CuentaException {
        if (dineroRetirado < 0 || dineroRetirado > saldo){
            throw new CuentaException("Hazlo bien hermano");
        }
        this.saldo = this.saldo - dineroRetirado;
        this.contadorRetiradas++;
    }


    public void ingreso(double dineroIngresa) throws CuentaException {
        if (dineroIngresa < 0) {
            throw new CuentaException("Como vas a ingresar un numero negativo melón");
        }
        this.saldo += dineroIngresa;
        this.contadorIngresos++;
    }

    public double getSaldo() {
        return saldo;
    }

    public void consultarOperaciones() {
        System.out.println("El saldo es de " + getSaldo() + " $");
        System.out.println("Se han realizado " + this.contadorRetiradas + " reintegros");
        System.out.println("Se han realizado " + this.contadorIngresos + " ingresos");
    }

    public void finalizar() {
        System.out.println("Has salido, te has quedado con un saldo de " + this.saldo + " $");
    }
}