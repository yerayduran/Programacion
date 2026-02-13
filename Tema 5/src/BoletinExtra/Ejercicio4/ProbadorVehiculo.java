package BoletinExtra.Ejercicio4;

public class ProbadorVehiculo {
    static void main(String[] args) {

        Movibles coche = new Coche("Honda");
        Movibles autobus = new Autobus("M309");
        Movibles bicicleta = new Bicicleta("BMX");

        Movibles[] vehiculos = {coche, autobus, bicicleta};

        probarMobilidad(bicicleta);
        probarCargaYDescargaPasajeros(vehiculos);
    }

    public static void probarMobilidad(Movibles movible) {
        movible.acelerar();
        movible.frenar();
    }

    public static void probarCargaYDescargaPasajeros(Movibles[] vehiculos) {

        for(Movibles vehiculo : vehiculos) {
            if(vehiculo instanceof Cargable c){
                c.cargar();
                c.descargar();
            }
        }
    }
}
