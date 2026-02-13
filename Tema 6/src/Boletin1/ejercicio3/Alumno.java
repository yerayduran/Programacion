package Boletin1.ejercicio3;

import Boletin1.ejercicio3.exceptions.PersonaExcepcion;

public class Alumno extends Persona {


	public Alumno(String nombre, String dni, int edad) {
		super(nombre, dni, edad);
	}


	@Override
	public void enviarMensaje(Persona persona, String cuerpo) throws PersonaExcepcion {

		if (persona instanceof Alumno) {
			if (this.getEdad() < 18) {
				throw new PersonaExcepcion("Eres menor, no puedes enviar el mensaje a otro alumno");
			}
		}

		Mensaje mensaje = new Mensaje(this, cuerpo);
		persona.getMensajes().add(mensaje);
	}
}