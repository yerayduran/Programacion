package Examen2022.domain;

import Examen2022.enums.Tipo;

public class JuguetePlastico extends Juguete {

    private Tipo tipo;

    public JuguetePlastico(String nombre, String marca, Tipo tipo) {
        super(nombre, marca);
        this.tipo = tipo;
    }

    public Tipo getTipo() {
        return tipo;
    }
}

