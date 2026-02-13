package Examen2021Obj;

import Examen2021.Exception.BibliotecaException;

import java.util.Arrays;

public class Usuario {

    private String nombre;
    private String apellido;
    private String dni;
    private int numeroSocio;


    private static int numeroSocioAsigando = 1;

    private static final Libro[] biblioteca = new Libro[5];

    public Usuario(String nombre, String apellido, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.numeroSocio = -1;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNumeroSocio(int numeroSocio) {
        this.numeroSocio = numeroSocio;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }

    public int getNumeroSocio() {
        return numeroSocio;
    }

    public void convertirASocio(Usuario usuario) throws BibliotecaException {

        if (this.dni.equals(usuario.dni)) {
            if (this.numeroSocio != -1 || usuario.numeroSocio != -1) {
                throw new BibliotecaException("No puedes convertirte en socio porque ya lo eres");
            }

        } else {
            if (this.numeroSocio != -1) {
                throw new BibliotecaException("Ya eres socio");
            }
        }
        this.numeroSocio = numeroSocioAsigando;
        numeroSocioAsigando++;
    }

    public void introducirLibro(Libro libroAMeter) throws BibliotecaException {

        int hayEspacio = -1;
        boolean esDiferente = true;
        int posicionMismoLibro = 0;

        for (int i = 0; i < biblioteca.length; i++) {
            if (libroAMeter.equals(biblioteca[i])) {
                esDiferente = false;
                posicionMismoLibro = i;
            }
            if (biblioteca[i] == null && hayEspacio == -1) {
                hayEspacio = i;
            }
        }
        if (esDiferente && hayEspacio != -1) {

            biblioteca[hayEspacio] = libroAMeter;

        } else if (!esDiferente) {

            biblioteca[posicionMismoLibro].setNumeroEjemplares(biblioteca[posicionMismoLibro].getNumeroEjemplares() + 1);
            biblioteca[posicionMismoLibro].setEjemplaresDisponibles(biblioteca[posicionMismoLibro].getNumeroEjemplares() + 1);
        } else {

            throw new BibliotecaException("No hay espacio en la biblioteca");
        }
    }

    public void prestamoLibro(Libro libro) throws BibliotecaException {
        boolean libroEncontrado = false;
        for (int i = 0; i < biblioteca.length; i++) {
            if (libro.equals(biblioteca[i])) {
                libroEncontrado = true;
                if (biblioteca[i].getEjemplaresDisponibles() > 0) {
                    biblioteca[i].setNumeroEjemplares(biblioteca[i].getNumeroEjemplares() - 1);
                    biblioteca[i].setEjemplaresDisponibles(biblioteca[i].getEjemplaresDisponibles() - 1);
                    break;
                } else {
                    throw new BibliotecaException("No hay ejemplares disponibles del libro");
                }
            }
        }
        if (!libroEncontrado) {
            throw new BibliotecaException("El libro no se encuentra en la biblioteca");
        }
    }

    public void devolucionLibro(Libro libro) throws BibliotecaException {
        boolean libroEncontrado = false;

        for (int i = 0; i < biblioteca.length; i++) {
            if (biblioteca[i].equals(libro)) {
                biblioteca[i].setNumeroEjemplares(biblioteca[i].getNumeroEjemplares() + 1);
                biblioteca[i].setEjemplaresDisponibles(biblioteca[i].getEjemplaresDisponibles() + 1);
                libroEncontrado = true;
            }
        }
        if (!libroEncontrado) {
            throw new BibliotecaException("El libro no está en la biblioteca");
        }
    }

    public void imprimirBiblioteca() {
        System.out.println(Arrays.toString(biblioteca));
    }
}