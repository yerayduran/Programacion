package Boletin2.Ejercicio3;

import Boletin1.Ejercicio2.MiEntradaSalida;
import Boletin2.Ejercicio2.DiscoDuro;
import Boletin2.Ejercicio2.Microprocesador;
import Boletin2.Ejercicio2.PlacaBase;
import Boletin2.Ejercicio2.TarjetaGrafica;
import Ejercicio2.Exception.OrdenadorException;
import Ejercicio2.Montar;
import Ejercicio3.Exception.VideojuegoException;

import java.time.LocalDate;
import java.util.Scanner;

public class Ordenador {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Creamos los objetos que van a conformar el ordenador
        PlacaBase pb = new PlacaBase();
        Microprocesador mp = new Microprocesador();
        DiscoDuro dd = new DiscoDuro();
        TarjetaGrafica tg = new TarjetaGrafica();

        // Bloque 'Boletin2.Boletin4.Ejercicio2.Ejercicio2.PlacaBase'

        //Le pedimos al usuario que introduzca la marca
        String marcaPlacaBase = MiEntradaSalida.solicitarCadena("Introduce la marca de la placa base (MSI, ASUS, ...): ");
        pb.setMarca(marcaPlacaBase);

        // Le pedimos al usuario que introduzca el chipset
        String chipsetPlacaBase = MiEntradaSalida.solicitarCadena("Introduce el chipset de la placa base: ");
        pb.setChipset(chipsetPlacaBase);

        // Le pedimos al usuario que introduzca el socket
        String socketPlacaBase = MiEntradaSalida.solicitarCadena("Introduce el socket de la placa base: ");
        pb.setSocket(socketPlacaBase);

        // Bloque 'Boletin2.Boletin4.Ejercicio2.Ejercicio2.Microprocesador'

        // Solicitamos la marca
        String marcaMicroprocesador = MiEntradaSalida.solicitarCadena("Introduce la marca" + " del Boletin2.Boletin4.Ejercicio2.Ejercicio2.Microprocesador");
        mp.setMarca(marcaMicroprocesador);

        // Solicitamos el modelo
        String modeloMicroprocesador = MiEntradaSalida.solicitarCadena("Introduce el modelo" + " del Boletin2.Boletin4.Ejercicio2.Ejercicio2.Microprocesador");
        mp.setModelo(modeloMicroprocesador);

        // Solicitamos el número de núcleos
        int numeroNucleos = MiEntradaSalida.solicitarEnteroPositivo("Introduce el número de" + " núcleos del microprocesador");
        mp.setNumDeNucleos(numeroNucleos);

        // Solicitamos la velocidad base
        boolean error;

        do {
            error = true;
            try {
                System.out.println("Introduce la velocidad base del microprocesador");
                float velocidadBaseMicroprocesador = sc.nextFloat();
                mp.setVelBase(velocidadBaseMicroprocesador);
                error = false;

            } catch (OrdenadorException e) {
                System.out.println(e.getMessage());
            }
        } while (error);

        // Solicitamos el socket y comprabamos que sea compatible con el de la 'Boletin2.Boletin4.Ejercicio2.Ejercicio2.PlacaBase'

        boolean error2;

        do {
            error2 = true;
            String socketMicroprocesador = MiEntradaSalida.solicitarCadena("Introduce el socket" + " del microprocesador");
            mp.setSocket(socketMicroprocesador);
            try {
                pb.esCompatible(mp);
                error2 = false;

            } catch (OrdenadorException e) {
                System.out.println(e.getMessage());
            }
        } while (error2);


        // Bloque 'Boletin2.Boletin4.Ejercicio2.Ejercicio2.DiscoDuro'

        //Solicitamos la marca
        String marcaDiscoDuro = MiEntradaSalida.solicitarCadena("Introduzca la marca del disco duro");
        dd.setMarca(marcaDiscoDuro);

        //Solicitamos el tipo
        String tipoDiscoDuro = MiEntradaSalida.solicitarCadena("Introduce el tipo del disco duro");
        dd.setTipo(tipoDiscoDuro);

        //Solicitamos la capacidad
        int capacidadDiscoDuro = MiEntradaSalida.solicitarEnteroPositivo("Introduce la capacidad" + " del disco duro");
        dd.setCapacidad(capacidadDiscoDuro);

        // Bloque tarjeta gráfica

        // Solicitamos la marca
        String marcaTarjetaGrafica = MiEntradaSalida.solicitarCadena("Introduce la marca" + " de la tarjeta gráfica");
        tg.setMarca(marcaTarjetaGrafica);

        // Solicitamos el modelo
        String modeloTarjetaGrafica = MiEntradaSalida.solicitarCadena("Introduce el modelo de la" + " tarjeta gráfica");
        tg.setModelo(modeloTarjetaGrafica);

        // Solicitamos el número de núcleos
        int numeroDeNucleos = MiEntradaSalida.solicitarEnteroPositivo("Introduce el número de núcleos de la" + " tarjeta gráfica");
        tg.setNumDeNucleos(numeroDeNucleos);

        //Solicitamos la velocidad

        boolean error3;

        do {
            error3 = true;
            try {
                System.out.println("Introduce la velocidad de la tarjeta gráfica");
                float velocidadTarjetaGrafica = sc.nextFloat();
                tg.setVelocidad(velocidadTarjetaGrafica);
                error3 = false;

            } catch (OrdenadorException e) {
                System.out.println(e.getMessage());
            }
        } while (error3);

        // Solicitamos la cantidad de memoria
        int cantidadMemoriaTarjetaGrafica = MiEntradaSalida.solicitarEnteroPositivo("Introduce la memoria" + " de la tarjeta gráfica");
        tg.setCantidadDeMemoria(cantidadMemoriaTarjetaGrafica);

        // Creamos la clase ordenador, pasándole sus perisféricos
        Ejercicio2.Montar m = new Montar(pb, mp, dd, tg);
        // Imprimimos los atributos de todos los componentes del ordenador
        System.out.println(m);
        // Creamos la clase videojuego
        Videojuego vd = null;
        while (vd == null){
            try{
                System.out.print("Introduce el nombre del juego: ");
                String nombre = sc.nextLine();
                System.out.print("Introduce el nombre de la compañia del juego: ");
                String compañiaCreadora = sc.nextLine();
                System.out.print("Introduce la fecha del lanzamiento del juego (YYYY-MM-DD): ");
                LocalDate añoCreacion = LocalDate.parse(sc.nextLine());
                System.out.print("Introduce los nucleos del microprocesador necesarios para que funcione el juego: ");
                int nucleosMinimosMicroprocesador = Integer.parseInt(sc.nextLine());
                System.out.print("Introduce la velocidad del microprocesador necesarios para que funcione el juego: ");
                float velocidadMinimaMicroprocesador = sc.nextFloat();
                System.out.print("Introduce la velocidad minimo del microprocesador: ");
                int espacioMinimoDiscoDuro = Integer.parseInt(sc.nextLine());
                System.out.print("Introduce los nucleos minimos para el uso del juego en la tarjeta grafica: ");
                int nucleosMinimosTarjetaGrafica = Integer.parseInt(sc.nextLine());
                System.out.print("Introduce el espacio minimo para el uso del juego en la tarjeta grafica: ");
                int espacioMinimoTarjetaGrafica = Integer.parseInt(sc.nextLine());

                vd = new Videojuego(nombre, compañiaCreadora, añoCreacion, nucleosMinimosMicroprocesador, velocidadMinimaMicroprocesador, espacioMinimoDiscoDuro, nucleosMinimosTarjetaGrafica, espacioMinimoTarjetaGrafica);

                vd.mostrarInfo();
            }catch (VideojuegoException e) {
                System.out.println("Error: " + e.getMessage());
            }
            sc.close();
        }

    }
}