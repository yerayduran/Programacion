package Boletin2.Ejercicio2;

import Ejercicio2.Exception.OrdenadorException;

public class Microprocesador {

    private String marca;
    private String modelo;
    private int numDeNucleos;
    private float velBase;
    private String socket;

    public Microprocesador(){

    }

    public String getSocket() {
        return socket;
    }

    @Override
    public String toString() {
        return "Boletin2.Boletin4.Ejercicio2.Ejercicio2.Microprocesador{" + "marca='" + marca + '\'' + ", modelo='" + modelo + '\'' + ", numeroDeNucleos=" + numDeNucleos + ", velocidadBase=" + velBase + ", socket='" + socket + '\'' + '}';
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setNumDeNucleos(int numDeNucleos) {
        this.numDeNucleos = numDeNucleos;
    }

    public void setVelBase(float velBase) throws OrdenadorException {
        if (velBase <= 0){
            throw new OrdenadorException("Los Gigahercios no puede ser negativo");
        }
        this.velBase = velBase;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }

    public int getNumDeNucleos() {
        return numDeNucleos;
    }

    public float getVelBase() {
        return velBase;
    }
}
