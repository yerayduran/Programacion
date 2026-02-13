package Boletin2.Ejercicio1;

import Ejercicio1.Exception.PersonaException;
import java.time.LocalDate;

public class Persona {

    private String nombre;
    private LocalDate fechaDeNacimiento;
    private int dniSinLetra;
    private char sexo;
    private float altura; // en metros
    private float peso;   // en kilos

    private static final char[] LETRA_DNI = {'T','R','W','A','G','M','Y','F','P','D','X','B', 'N','J','Z','S','Q','V','H','L','C','K','E'};


    public Persona(String nombre, LocalDate fechaDeNacimiento, int dniSinLetra, char sexo, float altura, float peso) throws PersonaException {
        setNombre(nombre);
        setFechaDeNacimiento(fechaDeNacimiento);
        setDniSinLetra(dniSinLetra);
        setSexo(sexo);
        setAltura(altura);
        setPeso(peso);
    }

    public void setNombre(String nombre) throws PersonaException {
        if (nombre == null || nombre.isEmpty()) {
            throw new PersonaException("El nombre no puede estar vacío");
        }
        this.nombre = nombre;
    }

    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) throws PersonaException {
        if (fechaDeNacimiento == null || fechaDeNacimiento.isAfter(LocalDate.now())) {
            throw new PersonaException("La fecha de nacimiento no puede ser nula ni futura");
        }
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public void setDniSinLetra(int dniSinLetra) throws PersonaException {
        String dniStr = String.valueOf(dniSinLetra);
        if (dniStr.length() != 8) {
            throw new PersonaException("El DNI debe tener exactamente 8 dígitos");
        }
        if (dniSinLetra < 0) {
            throw new PersonaException("El DNI no puede ser negativo");
        }
        this.dniSinLetra = dniSinLetra;
    }

    public void setSexo(char sexo) throws PersonaException {
        if (sexo != 'H' && sexo != 'V') {
            throw new PersonaException("En España solo hay dos generos asi decide alguno de los dos sin tonterias");
        }
        this.sexo = sexo;
    }

    public void setAltura(float altura) throws PersonaException {
        if (altura <= 1.30 || altura > 2.50) {
            throw new PersonaException("Altura fuera de rango razonable");
        }
        this.altura = altura;
    }

    public void setPeso(float peso) throws PersonaException {
        if (peso <= 45.00 || peso > 300.00) {
            throw new PersonaException("Peso fuera de rango razonable");
        }
        this.peso = peso;
    }

    public String getNombre() {
        return this.nombre;
    }
    public LocalDate getFechaDeNacimiento() {
        return this.fechaDeNacimiento;
    }
    public int getDniSinLetra() {
        return this.dniSinLetra;
    }
    public char getSexo() {
        return this.sexo;
    }
    public float getAltura() {
        return this.altura;
    }
    public float getPeso() {
        return this.peso;
    }

    public char getLetraDni() {
        int resto = dniSinLetra % 23;
        return LETRA_DNI[resto];
    }

    public float getIMC() {
        return this.peso / (this.altura * this.altura);
    }

    public void mostrarInfo() {
        System.out.println("Nombre: " + this.nombre);
        System.out.println("Fecha de nacimiento: " + this.fechaDeNacimiento);
        System.out.println("DNI: " + this.dniSinLetra + getLetraDni());
        System.out.println("Sexo: " + this.sexo);
        System.out.println("Altura: " + this.altura + " m");
        System.out.println("Peso: " + this.peso + " kg");
        System.out.printf("IMC: %.2f%n", getIMC());
    }
}