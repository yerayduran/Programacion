package Boletin2.Ejercicio2;

import Ejercicio2.Exception.OrdenadorException;

public class PlacaBase {

    private String marca;
    private String chipset;
    private String socket;

    public PlacaBase() {
    }

    public boolean esCompatible(Microprocesador mp) throws OrdenadorException{
        return this.socket.equals(mp.getSocket());
    }

    @Override
    public String toString(){
        return "Placa base: {" + "marca: " + marca + " chipset: " + chipset + "socket: " + socket + " }";
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setChipset(String chipset) {
        this.chipset = chipset;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }
}
