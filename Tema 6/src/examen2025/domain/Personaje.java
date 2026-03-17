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
    /**
     * Añade un ataque al conjunto de ataques del personaje.
     *
     * @param ataque El ataque que se desea añadir.
     */
    public void addAtaque(Ataque ataque) {
        this.ataques.add(ataque);
    }

    /**
     * Devuelve la lista de ataques disponibles del personaje.
     *
     * @return Una lista con todos los ataques del personaje.
     */
    public List<Ataque> getAtaques() {
        return this.ataques;
    }

    /**
     * Obtiene el nombre del personaje.
     *
     * @return El nombre del personaje.
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Devuelve el ataque más poderoso del personaje, es decir, el que tiene mayor daño.
     *
     * @return El ataque con mayor daño, o {@code null} si no hay ataques disponibles.
     */
    public Ataque getAtaqueMasPoderoso() {
        // Se usa max() para obtener el ataque con mayor daño.
        return this.ataques.stream()
                .max(Comparator.comparingInt(Ataque::getDamage))
                .orElse(null);
    }

    /**
     * Realiza un ataque contra otro personaje usando un ataque específico por nombre.
     * Debe existir un ataque con suficiente Ki disponible.
     *
     * @param p2 El personaje objetivo del ataque.
     * @param nombreAtaque El nombre del ataque que se desea usar.
     * @throws DBException Si el ataque no existe o el personaje no tiene suficiente Ki.
     */
    public void atacar(Personaje p2, String nombreAtaque) throws DBException {
        Ataque ataque = this.ataques.stream()
                .filter(a -> a.getNombre().equalsIgnoreCase(nombreAtaque)
                        && a.getKiNecesario() <= this.getKiActual())
                .max(Comparator.comparing(Ataque::getDamage))
                .orElseThrow(() -> new DBException("No existe el ataque o no tiene suficiente Ki"));

        if (p2.getVidaActual() - ataque.getDamage() > 0) {
            p2.setVidaActual(p2.getVidaActual() - ataque.getDamage());
        } else {
            p2.setVidaActual(0);
        }

        this.ataques.remove(ataque);
    }

    /**
     * Elimina de la lista de ataques todos aquellos cuyo nivel sea inferior
     * al nivel especificado.
     *
     * @param nivel Nivel mínimo que deben tener los ataques para conservarse.
     */
    public void eliminarAtaquesConNivelInferiorA(int nivel) {
        Iterator<Ataque> it = this.ataques.iterator();
        while (it.hasNext()) {
            if (it.next().getNivel() < nivel) {
                it.remove();
            }
        }
    }

}
