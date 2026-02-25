package Boletin1.ejercicio7;

import java.util.HashSet;
import java.util.LinkedList;

public class Receta {

    private String nombreReceta;
    private int tiempoReceta;
    private HashSet<Ingrediente> ingredientes;
    private LinkedList<String> pasos;

    public Receta(String nombreReceta, int tiempoReceta) {
        this.nombreReceta = nombreReceta;
        this.tiempoReceta = tiempoReceta;
        this.ingredientes = new HashSet<>();
        this.pasos = new LinkedList<>();
    }

    public String getNombreReceta() {
        return nombreReceta;
    }


    public int getTiempoReceta() {
        return tiempoReceta;
    }


    public boolean necesitaIngrediente(String nombreIngrediente){
        for(Ingrediente ingred : ingredientes){
            if (ingred.getNombre().equalsIgnoreCase(nombreIngrediente)){
                return true;
            }
        }

        return false;
    }

    public void añadirIngrediente(Ingrediente ingredienteNuevo){
        for(Ingrediente ingred : ingredientes){
            if (ingred.getNombre().equalsIgnoreCase(ingredienteNuevo.getNombre())){

                ingred.setCantidad(ingred.getCantidad() + ingredienteNuevo.getCantidad());

                return;
            }
        }

        ingredientes.add(new Ingrediente(ingredienteNuevo.getNombre(), ingredienteNuevo.getCantidad()));
    }

    public void borrarIngrediente(Ingrediente ingredienteABorrar) throws RecetaException{

        String nombre = ingredienteABorrar.getNombre();
        boolean borrado = ingredientes.removeIf(ingred -> ingred.getNombre().equalsIgnoreCase(nombre));

        if (!borrado && !ingredientes.isEmpty()) {

            throw new RecetaException("Ingrediente no encontrado: " + nombre);
        }
        pasos.removeIf(paso -> paso.toLowerCase().contains(nombre.toLowerCase()));
    }

    public void añadirPasoDetrasDe(String pasoNuevo, String pasoExistente) throws RecetaException{

        int paso = pasos.indexOf(pasoExistente);

        if (paso == -1) {
            throw new RecetaException("Paso existente no encontrado: " + pasoExistente);
        }
        pasos.add(paso + 1, pasoNuevo);
    }

}