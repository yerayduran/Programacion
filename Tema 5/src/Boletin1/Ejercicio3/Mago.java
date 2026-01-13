package Boletin1.Ejercicio3;

import Boletin1.Ejercicio3.Exception.PersonajeException;

import java.util.Arrays;

public class Mago extends Personaje {

    private static final int HECHIZOS_MAXIMOS = 4;
    private String[] hechizos;

    public Mago(String nombre, Raza raza, int fuerza, int inteligencia, int ptsMax, int ptsActual) throws PersonajeException {
        super(nombre, raza, fuerza, inteligencia, ptsMax, ptsActual);
        setFuerza(fuerza);
        setInteligencia(inteligencia);
        this.hechizos = new String[HECHIZOS_MAXIMOS];
    }

    @Override
    public void setFuerza(int fuerza) throws PersonajeException {
        if(fuerza > 15){
            throw new PersonajeException("Fuerza debe ser menor o igual a 15");
        }
        super.setFuerza(fuerza);
    }

    @Override
    public void setInteligencia(int inteligencia) throws PersonajeException {
        if(inteligencia < 17){
            throw new PersonajeException("Inteligencia debe ser mayor o igual a 17");
        }
        super.setInteligencia(inteligencia);
    }

    public void aprendeHechizo(String hechizo) throws PersonajeException {

        boolean sonIgual = false;
        int hayEspacio = -1;

        for(int i = 0; i < hechizos.length && !sonIgual; i++){
            if(hechizo.equals(hechizos[i])){
                sonIgual = true;
            }
            if(hechizos[i] == null && hayEspacio == -1){
                hayEspacio = i;
            }
        }

        if (!sonIgual && hayEspacio != -1) {
            hechizos[hayEspacio] = hechizo;
        } else {
            throw new PersonajeException("El Mago no puede aprender este hechizo");
        }
    }

    public void lanzarHechizo(Personaje victima, String hechizoALanzar) throws PersonajeException {

        boolean hechizoEncontrado = false;

        if (victima.getNombre().equals(this.getNombre())){
            throw new PersonajeException("Como te vas a lanzar un hechizo a ti mismo bobo");
        }

        for (int i = 0; i < hechizos.length; i++) {
            if(hechizoALanzar.equals(hechizos[i])){
                hechizoEncontrado = true;
                hechizos[i] = null;

                if(victima.getPtsActual() > getFuerza()){
                    victima.setPtsActual(victima.getPtsActual() - getFuerza());
                } else {
                    victima.setPtsActual(0);
                    System.out.println("Tu Enemigo ha muerto");
                }
            }
        }
        if (!hechizoEncontrado) {
            throw new PersonajeException("Aún no has aprendido ese hechizo");
        }
    }

    @Override
    public String toString() {
        return "Mago {" + "Hechizos = " + Arrays.toString(hechizos) + "} " + super.toString();
    }
}
