package Boletin1.Ejercicio3;

import Boletin1.Ejercicio3.Exception.PersonajeException;

public class Clerigo extends Personaje {

    private String nombreDeDios;

    public Clerigo(String nombre, Raza raza, int fuerza, int inteligencia, int ptsMax, int ptsActual, String nombreDeDios) throws PersonajeException {
        super(nombre, raza, fuerza, inteligencia, ptsMax, ptsActual);
        setFuerza(fuerza);
        setInteligencia(inteligencia);
        this.nombreDeDios = nombreDeDios;
    }

    public void setFuerza(int fuerza) throws PersonajeException {
        if (fuerza < 18) {
            throw  new PersonajeException("Fuerza debe ser mayor o igual al 18");
        }
        super.setFuerza(fuerza);
    }

    public void setInteligencia(int inteligencia) throws PersonajeException {
        if (inteligencia <= 12 || inteligencia >= 16) {
            throw new PersonajeException("Inteligencia debe ser entre los parametros 13-15");
        }
        super.setInteligencia(inteligencia);
    }

    public void curar(Personaje personaje) throws PersonajeException {

        if (personaje.getNombre().equals(this.getNombre())) {
            throw new PersonajeException("No te puedes curar a ti mismo");
        }
        if (personaje.getPtsActual() < personaje.getPtsMax()) {
            if(personaje.getPtsActual() + 10 <= personaje.getPtsMax()) {
                personaje.setPtsActual(personaje.getPtsActual() + 10);
            }else {
                personaje.setPtsActual(personaje.getPtsMax());
            }
        } else {
            personaje.setPtsActual(personaje.getPtsMax());
            throw new PersonajeException("No te puedes curar, estás al máximo");
        }
    }

    @Override
    public String toString() {
        return "Clerigo {" + " Dios que le reza = '" + nombreDeDios + '\'' + "} " + super.toString();
    }
}
