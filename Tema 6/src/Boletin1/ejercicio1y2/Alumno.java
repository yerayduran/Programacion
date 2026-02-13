package Boletin1.ejercicio1y2;

public class Alumno {

    private String nombre;
    private String adn;

    public Alumno(String nombre, String adn) {
        this.nombre = nombre;
        this.adn = adn;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAdn() {
        return adn;
    }

    public void setAdn(String adn) {
        this.adn = adn;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + getNombre() + '\'' +
                ", adn='" + getAdn() + '\'' +
                '}';
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Alumno alumno)) return false;

        return adn.equals(alumno.adn);
    }

    @Override
    public int hashCode() {
        return adn.hashCode();
    }
}