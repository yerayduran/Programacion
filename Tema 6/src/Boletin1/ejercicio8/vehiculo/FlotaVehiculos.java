package Boletin1.ejercicio8.vehiculo;

import Boletin1.ejercicio8.vehiculo.Exception.CocheException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class FlotaVehiculos {

    private HashMap<String, Vehiculo> vehiculos;

    public FlotaVehiculos() {
        this.vehiculos = new HashMap<>();
    }


    public void introducirVehiculo(Vehiculo vehiculo) throws CocheException {

        if (vehiculos.containsKey(vehiculo.getMatricula())){
            throw new CocheException("Ya existe un vehiculo con la matricula " + vehiculo.getMatricula() +
                    " en la flota");
        }

        vehiculos.put(vehiculo.getMatricula(), vehiculo);
    }


    public double precioAlquiler(String matricula, int dias) throws CocheException {
        double precio;
        Vehiculo vehiculoEncontrado;

        vehiculoEncontrado= vehiculos.get(matricula);

        if (vehiculoEncontrado == null ) {
            throw new CocheException("No existe el vehiculo con matricula " + matricula);
        }

        if (dias <= 0) {
            throw new CocheException("Dias de alquier incorrecto");
        }

        precio = vehiculoEncontrado.calcularAlquiler(dias);


        return precio;
    }

    public String toString() {

        StringBuilder sb=new StringBuilder();
        ArrayList<Vehiculo>  coleccion= (ArrayList<Vehiculo>) vehiculos.values();
        Collections.sort(coleccion);


        for ( Vehiculo veh: coleccion) {
            sb.append(veh + "\n");
        }

        return sb.toString();


    }

    public String listadoFurgonetasPorPMA() {

        StringBuilder sb=new StringBuilder();
        ArrayList<Furgoneta> furgonetasOrdenadas=new ArrayList<Furgoneta>();

        for (Vehiculo veh: vehiculos.values()) {

            if ( veh instanceof Furgoneta) {
                furgonetasOrdenadas.add(((Furgoneta)veh));
            }
        }

        Collections.sort(furgonetasOrdenadas);

        for ( Furgoneta f: furgonetasOrdenadas) {
            sb.append(f + "\n");
        }
        return sb.toString();

    }

    public String listadoVehiculosOrdenadosPorGama() {

        StringBuilder sb=new StringBuilder();
        ArrayList<Vehiculo>  coleccion= (ArrayList<Vehiculo>) vehiculos.values();
        ComparadorPorGama comparador = new ComparadorPorGama();

        Collections.sort( coleccion, comparador);

        for ( Vehiculo veh: coleccion) {
            sb.append(veh + "\n");
        }

        return sb.toString();



    }


}
