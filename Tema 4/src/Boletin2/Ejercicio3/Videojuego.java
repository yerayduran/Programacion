package Boletin2.Ejercicio3;

import Ejercicio2.DiscoDuro;
import Ejercicio2.Microprocesador;
import Ejercicio2.Montar;
import Ejercicio2.TarjetaGrafica;
import Ejercicio3.Exception.VideojuegoException;

import java.time.LocalDate;

public class Videojuego {

    // Atributos
    private String nombre;
    private String compañiaCreadora;
    private LocalDate añoCreacion;

    // Requisitos mínimos del ordenador
    private int nucleosMinimosMicroprocesador;
    private float velocidadMinimaMicroprocesador;
    private int espacioMinimoDiscoDuro;
    private int nucleosMinimosTarjetaGrafica;
    private int espacioMinimoTarjetaGrafica;

    // Creamos el constructor
    public Videojuego(String nombre, String companiaCreadora, LocalDate añoCreacion, int nucleosMinimosMicroprocesador, float velocidadMinimaMicroprocesador, int espacioMinimoDiscoDuro, int nucleosMinimosTarjetaGrafica, int espacioMinimoTarjetaGrafica) throws VideojuegoException {
        this.nombre = nombre;
        this.compañiaCreadora = companiaCreadora;

        setAñoCreacion(añoCreacion);
        setNucleosMinimosMicroprocesador(nucleosMinimosMicroprocesador);
        setVelocidadMinimaMicroprocesador(velocidadMinimaMicroprocesador);
        setEspacioMinimoDiscoDuro(espacioMinimoDiscoDuro);
        setNucleosMinimosTarjetaGrafica(nucleosMinimosTarjetaGrafica);
        setEspacioMinimoTarjetaGrafica(espacioMinimoTarjetaGrafica);
    }

    // Comprueba que el año de creación del videojuego tenga consistencia
    public void setAñoCreacion(LocalDate añoCreacion) throws VideojuegoException {
        if ((añoCreacion.isAfter(LocalDate.now())) || LocalDate.of(1951, 12, 31).isAfter(añoCreacion)){
            throw new VideojuegoException("Este año no es válido");
        }

        this.añoCreacion = añoCreacion;
    }

    // Comprueba que el número de núcleos del microprocesador no sea negativo ni 0
    public void setNucleosMinimosMicroprocesador(int nucleosMinimosMicroprocesador) throws VideojuegoException {

        if (nucleosMinimosMicroprocesador < 1) {

            throw new VideojuegoException("Introduce una cantidad válida");
        }

        this.nucleosMinimosMicroprocesador = nucleosMinimosMicroprocesador;
    }

    // Comprueba que la velocidad del microprocesador no sea negativo ni 0
    public void setVelocidadMinimaMicroprocesador(float velocidadMinimaMicroprocesador) throws VideojuegoException {

        if (velocidadMinimaMicroprocesador < 1) {
            throw new VideojuegoException("Introduce una cantidad válida");
        }
        this.velocidadMinimaMicroprocesador = velocidadMinimaMicroprocesador;
    }

    // Comprueba que el espacio del disco duro no sea negativo ni 0
    public void setEspacioMinimoDiscoDuro(int espacioMinimoDiscoDuro) throws VideojuegoException {
        if (espacioMinimoDiscoDuro < 1) {
            throw new VideojuegoException("Introduce una cantidad válida");
        }
        this.espacioMinimoDiscoDuro = espacioMinimoDiscoDuro;
    }

    // Comprueba que los núcleos de la tarjeta gráfica no sea negativo ni 0
    public void setNucleosMinimosTarjetaGrafica(int nucleosMinimosTarjetaGrafica) throws VideojuegoException {
        if (nucleosMinimosTarjetaGrafica < 1) {
            throw new VideojuegoException("Introduce una cantidad válida");
        }
        this.nucleosMinimosTarjetaGrafica = nucleosMinimosTarjetaGrafica;
    }

    // Comprueba que el espacio de la tarjeta gráfica no sea negativo
    public void setEspacioMinimoTarjetaGrafica(int espacioMinimoTarjetaGrafica) throws VideojuegoException {
        if (espacioMinimoTarjetaGrafica < 0) {
            throw new VideojuegoException("Introduce una cantidad válida");
        }
        this.espacioMinimoTarjetaGrafica = espacioMinimoTarjetaGrafica;
    }

    // Hacemos los get para mostrar los valores de estos atributos
    public String getNombre() {
        return nombre;
    }

    public String getCompaniaCreadora() {
        return compañiaCreadora;
    }

    public LocalDate getAñoCreacion() {
        return añoCreacion;
    }

    // Creamos un método para comparar los requisitos del videojuego con el ordenador
    public boolean compatibilidad(Montar m) throws VideojuegoException {

        // Creamos objetos del tipo según el objeto
        Microprocesador mc = m.getMicroprocesador();
        DiscoDuro dd = m.getDiscoDuro();
        TarjetaGrafica tg = m.getTarjetaGrafica();

        // Comprueba que se cumplan los requisitos de núcleos del microprocesador
        if (mc.getNumDeNucleos() < this.nucleosMinimosMicroprocesador) {
            throw new VideojuegoException("Los nucleos del microprocesador no cumple con los requisitos");
        }
        // Comprueba que se cumplan los requisitos de velocidad del microprocesador
        if (mc.getVelBase() < this.velocidadMinimaMicroprocesador) {
            throw new VideojuegoException("La velocidad del microprocesador no cumple los requisitos");
        }
        //Comprueba que se cumplan los requisitos de espacio en el disco duro
        if (dd.getCapacidad() < this.espacioMinimoDiscoDuro) {
            throw new VideojuegoException("El espacio del disco duro es insuficiente");
        }
        // Comprueba que se cumplan los requisitos de espacio en la tarjeta gráfica
        if (tg.getCantidadDeMemoria() < this.espacioMinimoTarjetaGrafica) {
            throw new VideojuegoException("La memoria de la tarjeta grafica es insuficiente");
        }

        // Comprueba que se cumplan los requisitos de núcleos en la tarjeta gráfica
        if (tg.getNumDeNucleos() < this.nucleosMinimosTarjetaGrafica) {
            throw new VideojuegoException("Los nucleos de la tarjeta gráfica no cumple los requisitos");
        }
        return false;
    }

    public void mostrarInfo() {
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Compañia: " + this.compañiaCreadora);
        System.out.println("Año de lanzamiento: " + this.añoCreacion);
        System.out.println("Nucleos necesarios para Boletin2.Boletin4.Ejercicio2.Ejercicio2.Microprocesador: " + this.nucleosMinimosMicroprocesador + " CPU");
        System.out.println("Velocidad necesarios para Boletin2.Boletin4.Ejercicio2.Ejercicio2.Microprocesador: " + this.velocidadMinimaMicroprocesador + " GHz");
        System.out.println("Espacio para el Disco Duro: " + this.espacioMinimoDiscoDuro + " GB");
        System.out.println("Nucleos necesarios para la Tarjeta Grafica: " + this.nucleosMinimosTarjetaGrafica + " GPU");
        System.out.println("Espacio para la Tarjeta Grafica: " + this.espacioMinimoTarjetaGrafica + " GHz");

    }
}