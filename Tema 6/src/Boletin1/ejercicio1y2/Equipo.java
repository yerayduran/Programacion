package Boletin1.ejercicio1y2;

import Boletin1.ejercicio1y2.exceptions.AlumnoException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Equipo<T> {

    private Set<T> alumnos;
    private String nombre;

    public Equipo(String nombre) {
        alumnos = new HashSet<>();
        this.nombre = nombre;
    }

    public Equipo(Set<T> lista, String nombre) {
        this.alumnos = lista;
        this.nombre = nombre;
    }

    public void addAlumno(T a) throws AlumnoException {
        if (!alumnos.add(a)) {
            throw new AlumnoException("Ese alumno ya esta en el equipo");
        }

    }

    public void removeAlumno(T a) throws AlumnoException {
        if (!alumnos.remove(a)) {
            throw new AlumnoException("Ese alumno no esta en el equipo");
        }
    }

    public T containsAlumno(T a) {
        if (alumnos.contains(a)) {
            return a;
        }
        return null;
    }

    public List<T> devolverListaAlumnos() {
        return new ArrayList<>(alumnos);
    }

    public Equipo<T> interseccionEquipos(String nombreEquipo, Equipo<T> equipo2) {
        Set<T> nuevaLista = new HashSet<>(this.alumnos);
        nuevaLista.retainAll(equipo2.alumnos);
        return new Equipo<>(nuevaLista, nombreEquipo);
    }

    public Equipo<T> unifyEquipos(String nombreEquipo, Equipo<T> equipo2) {
        Set<T> nuevoAlumnos = new HashSet<>();
        nuevoAlumnos.addAll(alumnos);
        nuevoAlumnos.addAll(equipo2.alumnos);

        return new Equipo<>(nuevoAlumnos, nombreEquipo);
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "alumnos=" + alumnos +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Alumno a1 = new Alumno("Jorge", "1");
        Alumno a2 = new Alumno("Jorge", "2");
        Alumno a3 = new Alumno("Moi", "3");

        Equipo<Alumno> e1 = new Equipo<>("lolo");
        Equipo<Alumno> e2 = new Equipo<>("bla bla bla");

        try {
            e1.addAlumno(a1);
        } catch (AlumnoException e) {
            System.out.println(e.getMessage());
        }

        try {
            e1.addAlumno(a3);
        } catch (AlumnoException e) {
            System.out.println(e.getMessage());
        }

        try {
            e1.addAlumno(a1);
        } catch (AlumnoException e) {
            System.out.println(e.getMessage());
        }

        try {
            e2.addAlumno(a2);
        } catch (AlumnoException e) {
            System.out.println(e.getMessage());
        }

        try {
            e2.addAlumno(a3);
        } catch (AlumnoException e) {
            System.out.println(e.getMessage());
        }

        try {
            e2.addAlumno(a2);
        } catch (AlumnoException e) {
            System.out.println(e.getMessage());
        }

        Equipo<Alumno> nuevo = e1.unifyEquipos("lobla", e2);
        Equipo<Alumno> nuevo2 = e1.interseccionEquipos("blalo", e2);

        System.out.println(e1.devolverListaAlumnos());
        System.out.println(e2.devolverListaAlumnos());
        System.out.println(nuevo.devolverListaAlumnos());
        System.out.println(nuevo2.devolverListaAlumnos());
    }

}