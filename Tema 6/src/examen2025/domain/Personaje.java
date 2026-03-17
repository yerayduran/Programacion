package examen2025.domain;
import examen2025.exceptions.DBException;

import java.util.Comparator;
import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;

public class Personaje {
    private String nombre;
    private TRaza raza;
    private int kiActual;
    private int kiMaximo;
    private int vidaActual;
    private int vidaMaxima;
    private List<Ataque> ataques;

    public Personaje(String nombre, TRaza raza, int kiMaximo, int kiActual, int vidaMaxima, int vidaActual) throws DBException {
        this.nombre = nombre;
        this.raza = raza;
        this.setKiMaximo(kiMaximo);
        this.setVidaMaxima(vidaMaxima);
        this.setKiActual(kiActual);
        this.setVidaActual(vidaActual);
        this.ataques = new LinkedList<>();
    }

    private void setVidaMaxima(int vidaMaxima) throws DBException {
        // La vida máxima debe ser mayor que 0
        if (vidaMaxima <= 0) {
            throw new DBException("La vida máxima debe ser mayor que 0");
        }
        this.vidaMaxima = vidaMaxima;
    }

    private void setKiMaximo(int kiMaximo) throws DBException {
        // El ki máximo debe ser mayor que 0
        if (kiMaximo <= 0) {
            throw new DBException("El ki máximo debe ser mayor que 0");
        }
        this.kiMaximo = kiMaximo;
    }

    private void setKiActual(int kiActual) throws DBException {
        // El ki actual debe ser mayor que 0
        if (kiActual <= 0) {
            throw new DBException("El ki actual debe ser mayor que 0");
        }
        if (kiActual > this.kiMaximo) {
            throw new DBException("El ki actual no puede ser mayor que el ki máximo");
        }
        this.kiActual = kiActual;
    }

    private void setVidaActual(int vidaActual) throws DBException {
        // La vida actual debe ser mayor que 0
        if (vidaActual < 0) {
            vidaActual = 0;
        }
        if (vidaActual > this.vidaMaxima) {
            throw new DBException("La vida actual no puede ser mayor que la vida máxima");
        }
        this.vidaActual = vidaActual;
    }

    public int getVidaActual() {
        return vidaActual;
    }

    public int getKiActual() {
        return kiActual;
    }

    public TRaza getRaza() {
        return raza;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Personaje personaje = (Personaje) o;
        return nombre.equals(personaje.nombre) && raza == personaje.raza;
    }

    @Override
    public int hashCode() {
        int result = nombre.hashCode();
        result = 31 * result + raza.hashCode();
        return result;
    }

    public void addAtaque(Ataque ataque) {
        this.ataques.add(ataque);
    }

    public List<Ataque> getAtaques() {
        return this.ataques;
    }

    public String getNombre() {
        return this.nombre;
    }

    public Ataque getAtaqueMasPoderoso() {
        return this.ataques.stream().min((a1, a2) -> a2.getDamage() - a1.getDamage()).orElse(null);
    }


    public void atacar(Personaje p2, String nombreAtaque) throws DBException {
        /*
         Primero buscamos el ataque. Puede haber varios, pero lo primero es filtrar por nombre y por ki necesario.
         Después seleccionamos el que más daño requiera
         */
        Ataque ataque = this.ataques.stream()
                .filter(a -> a.getNombre().equalsIgnoreCase(nombreAtaque) && a.getKiNecesario() <= this.getKiActual())
                .max(Comparator.comparing(Ataque::getDamage))
                .orElseThrow(() -> new DBException("No existe el ataque o no tiene suficiente Ki"));

        if (p2.getVidaActual() - ataque.getDamage() > 0){
            p2.setVidaActual(p2.getVidaActual() - ataque.getDamage());
        }
        else {
            p2.setVidaActual(0);
        }

        this.ataques.remove(ataque);
    }

    public void eliminarAtaquesConNivelInferiorA(int nivel) {
        //2 formas, usando flujos y creando como resultado una nueva lista, o con un iterador
        Iterator<Ataque> it = this.ataques.iterator();
        while(it.hasNext()){
            if(it.next().getNivel() < nivel){
                it.remove();
            }
        }

        //this.ataques.removeIf(ataque -> ataque.getNivel() < nivel);
    }
}
