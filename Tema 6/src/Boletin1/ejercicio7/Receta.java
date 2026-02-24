package Boletin1.ejercicio7;

import java.util.HashSet;
import java.util.LinkedList;

public class Receta {

    private String nombreReceta;
    private int tiempoReceta;
    private HashSet<Ingrediente> ingredientes;
    private LinkedList<String> pasos;

    public Receta(String nombreReceta, int tiempoReceta, HashSet<Ingrediente> ingredientes, LinkedList<String> pasos) throws RecetaException {
        this.nombreReceta = nombreReceta.toUpperCase();
        setTiempoReceta(tiempoReceta);
        ingredientes = new HashSet<Ingrediente>();
        pasos = new LinkedList<String>();
    }

    public String getNombreReceta() {
        return nombreReceta;
    }

    public void setNombreReceta(String nombreReceta) {
        this.nombreReceta = nombreReceta;
    }

    public int getTiempoReceta() {
        return tiempoReceta;
    }

    public void setTiempoReceta(int tiempoReceta) throws RecetaException {
        if (tiempoReceta < 0) {
            throw new RecetaException("El tiempo de receta no puede ser negativo");
        }
        this.tiempoReceta = tiempoReceta;
    }

    public HashSet<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(HashSet<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public LinkedList<String> getPasos() {
        return pasos;
    }

    public void setPasos(LinkedList<String> pasos) {
        this.pasos = pasos;
    }


    public boolean necesitaIngrediente(String nombreIngrediente){

    }

    public void añadirIngrediente(Ingrediente ingredienteNuevo){

    }

    public void borrarIngrediente(Ingrediente ingredienteABorrar) throws RecetaException{

    }

    public void añadirPasoDetrasDe(String pasoNuevo, String pasoExistente) throws RecetaException{

    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Receta{");
        sb.append("nombreReceta='").append(nombreReceta).append('\'');
        sb.append(", tiempoReceta=").append(tiempoReceta);
        sb.append(", ingredientes=").append(ingredientes);
        sb.append(", pasos=").append(pasos);
        sb.append('}');
        return sb.toString();
    }
}
