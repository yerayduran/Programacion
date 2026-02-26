package Boletin1.ejercicio7;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Receta {

    private String nombreReceta;
    private int tiempoReceta;
    private Set<Ingrediente> ingredientes;
    private List<String> pasos;

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

    // Nota para cambiar
    public void añadirIngrediente(Ingrediente ingredienteNuevo) throws RecetaException {

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

        if (!borrado) {

            throw new RecetaException("Ingrediente no encontrado: " + nombre);
        }
        pasos.removeIf(paso -> paso.toLowerCase().contains(nombre.toLowerCase()));
    }

    public void añadirPasoDetrasDe(String pasoNuevo, String pasoExistente) throws RecetaException{

        int paso = pasos.indexOf(pasoExistente);

        if (paso == -1) {
            throw new RecetaException("Paso existente de la receta no se ha encontrado: " + pasoExistente);
        }
        pasos.set(paso + 1, pasoNuevo);
    }

}