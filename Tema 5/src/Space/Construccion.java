package Space;

public abstract class Construccion extends Carta {
    protected int personasAsignadas;

    public Construccion(String nombre, int precio, int personasAsignadas) {
        super(nombre, precio);
        this.personasAsignadas = personasAsignadas;
    }

    public int getPersonasAsignadas() {
        return personasAsignadas;
    }

    @Override
    public String toString() {
        return super.toString() + " | Personas asignadas=" + personasAsignadas;
    }
}