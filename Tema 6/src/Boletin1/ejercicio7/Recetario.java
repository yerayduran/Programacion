package Boletin1.ejercicio7;

import java.util.*;

public class Recetario {

    private HashMap<String, Receta> recetas;

    public Recetario(){
        this.recetas = new HashMap<>();
    }

    public void añadirReceta(Receta nuevaReceta) throws RecetaException{
        if (recetas.containsKey(nuevaReceta.getNombreReceta())){
            throw new RecetaException("Esta Receta ya existe en tu recetario " + nuevaReceta.getNombreReceta());
        }

        recetas.put(nuevaReceta.getNombreReceta(), nuevaReceta);
    }

    public String listadoRecetasOrdenadasAlfabeticamente() throws RecetaException{

        if (recetas.isEmpty()) {
            throw new RecetaException("No hay recetas en el recetario");
        }

        List<String> nombres = new ArrayList<>();
        Collections.sort(nombres, String.CASE_INSENSITIVE_ORDER);
        StringBuilder sb = new StringBuilder();

        for (String nombre : nombres) {
            Receta r = recetas.get(nombre);
            sb.append(r.getNombreReceta()).append(" - ").append(r.getTiempoReceta()).append(" min\n");
        }

        return sb.toString();
    }


    public String listadoRecetasConIngredienteOrdenadasPorTiempoPreparacion(String ingrediente) throws RecetaException{

        List<Receta> matching = new ArrayList<>();

        for (Receta receta : recetas.values()) {
            if (receta.necesitaIngrediente(ingrediente)) {
                matching.add(receta);
            }
        }

        if (matching.isEmpty()) {
            throw new RecetaException("No hay recetas con ingrediente: " + ingrediente);
        }

        matching.sort(Comparator.comparingInt(Receta::getTiempoReceta));

        StringBuilder sb = new StringBuilder();

        for (Receta receta : matching) {
            sb.append(receta.getNombreReceta()).append(" - ").append(receta.getTiempoReceta()).append(" min\n");
        }

        return sb.toString();
    }

}
