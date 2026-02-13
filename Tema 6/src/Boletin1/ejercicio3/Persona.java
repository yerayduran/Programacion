package Boletin1.ejercicio3;

import Boletin1.ejercicio3.exceptions.PersonaExcepcion;

import java.util.*;

public abstract class Persona {

	private String nombre;
	private String dni;
	private int edad;
	private List<Mensaje> mensajes;

	public Persona(String nombre, String dni, int edad) {
		this.nombre = nombre;
		this.dni = dni;
		this.edad = edad;
		this.mensajes = new ArrayList<>();
	}

	public String getNombre() {
		return nombre;
	}

	private void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	private void setDni(String dni) {
		this.dni = dni;
	}

	public int getEdad() {
		return edad;
	}

	private void setEdad(int edad) throws PersonaExcepcion {
		if (edad < 1) {
			throw new PersonaExcepcion("No puede tener menos de 1 año");
		}
		this.edad = edad;
	}

	public List<Mensaje> getMensajes() {
		return mensajes;
	}

	public void setMensajes(List<Mensaje> mensajes) {
		this.mensajes = mensajes;
	}

	// Hacemos el equals
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Persona persona = (Persona) o;
		return Objects.equals(nombre, persona.nombre);
	}

	@Override
	public int hashCode() {
		return Objects.hashCode(nombre);
	}

	// Hacemos el toString
	@Override
	public String toString() {
		return "Persona{" +
				"nombre='" + getNombre() + '\'' +
				", dni='" + getDni() + '\'' +
				", edad=" + getEdad() +
				'}';
	}

	// Hacemos un método para enviar un mensaje a otra persona
	public abstract void enviarMensaje(Persona persona, String mensaje) throws PersonaExcepcion;

	// Hacemos un método para mostrar todos los mensajes ordenados alfabéticamente
	public List<Mensaje> mostrarBuzonOrdenado() throws PersonaExcepcion {
		if (mensajes.isEmpty()) {
			throw new PersonaExcepcion("La lista de mensajes está vacío");
		}
		this.getMensajes().sort(null);
		return this.getMensajes();
	}

	// Hacemos un método para eliminar un mensaje
	public void eliminarMensaje(int indice) throws PersonaExcepcion {
		if (this.getMensajes().isEmpty()) {
			throw new PersonaExcepcion("No hay mensajes en el buzón");
		}

		if (indice > this.getMensajes().size() || indice <= 0) {
			throw new PersonaExcepcion("Te has pasado del índice válido");
		}
		this.getMensajes().remove(indice - 1);
	}

	public String buscarCadena(String cadena) throws PersonaExcepcion {

		StringBuilder sb = new StringBuilder();

		for (Mensaje mensaje : this.mensajes) {
			if (mensaje.getMensaje().contains(cadena)) {
				sb.append(mensaje.getMensaje()).append("\n");
			}
		}
		if (sb.isEmpty()) {
			throw new PersonaExcepcion("No se ha encontrado la cadena");
		}
		return sb.toString();
	}

	public String leerMensaje() throws PersonaExcepcion {

		StringBuilder sb = new StringBuilder();

		if (mensajes.isEmpty()) {
			throw new PersonaExcepcion("No hay mensajes");
		}

		Iterator<Mensaje> it = mensajes.iterator();
		int contador = 1;

		while (it.hasNext()) {
			Mensaje m = it.next();
			sb.append("Mensaje ").append(contador++).append(": ");
			sb.append(m);
		}
		return sb.toString();
	}

	public static <T> ArrayList<T> reverse(ArrayList<T> arrayListOriginal) {
		ArrayList<T> arrayListCopia = new ArrayList<>(arrayListOriginal);
		Collections.reverse(arrayListCopia);
		return arrayListCopia;
	}
}