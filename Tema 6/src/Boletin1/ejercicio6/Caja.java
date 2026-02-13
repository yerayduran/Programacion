package Boletin1.ejercicio6;

import java.util.LinkedList;


public class Caja{

    private int numeroCaja;
    private boolean estaAbierta;
    private LinkedList<Integer> colaCliente;

    public Caja(int numeroCaja) {
        this.numeroCaja = numeroCaja;
        estaAbierta = false;
        colaCliente = new LinkedList<>();
    }

    public int getNumeroCaja() {
        return numeroCaja;
    }

    public void setEstaAbierta(boolean estaAbierta) {
        this.estaAbierta = estaAbierta;
    }

    public boolean isEstaAbierta() {
        return estaAbierta;
    }


    public void abrirCaja() throws CajaException {
        if(estaAbierta){
            throw new CajaException("La caja esta abierta");
        }
        estaAbierta = true;

    }

    public void cerrarCaja() throws CajaException {
        if(!estaAbierta){
            throw new CajaException("La caja esta cerrada");
        }

        if(colaCliente.size() > 0){
            throw new CajaException("La caja no puede estar cerrado");
        }
        estaAbierta = false;
    }

    public int tamañoColaCliente(){

        return colaCliente.size();
    }

    public void agregarNuevoClienteCaja(Integer cliente) throws CajaException{
        if(!estaAbierta){
            throw new CajaException("No puedes meter un cliente en la caja porque esta cerrada");
        }
        colaCliente.add(cliente);

    }

    public Integer atenderCliente() throws CajaException {
        Integer cliente;

        if(!estaAbierta){
            throw new CajaException("No puedes atender cliente en la caja porque esta cerrada");
        }
        if(colaCliente.isEmpty()){
            throw new CajaException("No hay clientes en la caja");
        }


        cliente = colaCliente.get(0);
        colaCliente.remove(0);

        return cliente;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Caja{");
        sb.append("numeroCaja=").append(numeroCaja);
        sb.append(", estaAbierta=").append(estaAbierta);
        sb.append(", colaCliente=").append(colaCliente);
        sb.append('}');
        return sb.toString();
    }
}
