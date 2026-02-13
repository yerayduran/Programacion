package Boletin2.Ejercicio2;

import Ejercicio2.Exception.OrdenadorException;

public class TarjetaGrafica {

    private String marca;
    private String modelo;
    private int numDeNucleos;
    private float velocidad;
    private int cantidadDeMemoria;

    public TarjetaGrafica() {
    }

    @Override
    public String toString() {
        return "Boletin2.Boletin4.Ejercicio2.Ejercicio2.TarjetaGrafica{" + "marca='" + marca + '\'' + ", modelo='" + modelo + '\'' + ", numeroDeNucleos=" + numDeNucleos + ", velocidad=" + velocidad + ", cantidadDeMemoria=" + cantidadDeMemoria + '}';
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setCantidadDeMemoria(int cantidadDeMemoria) {
        this.cantidadDeMemoria = cantidadDeMemoria;
    }

    public void setVelocidad(float velocidad) throws OrdenadorException {

        if (velocidad < 0) {

            throw new OrdenadorException("La velocidad de la tarjeta gráfica bo puede ser negativa");
        }

        this.velocidad = velocidad;
    }

    public void setNumDeNucleos(int numeroDeNucleos) {
        this.numDeNucleos = numeroDeNucleos;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCantidadDeMemoria() {
        return cantidadDeMemoria;
    }

    public int getNumDeNucleos() {
        return numDeNucleos;
    }
}

