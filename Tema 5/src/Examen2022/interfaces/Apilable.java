package Examen2022.interfaces;

import Examen2022.domain.Juguete;
import Examen2022.exceptcion.JugueteException;

public interface Apilable {

    public default void apilar(Juguete a) throws JugueteException {
        if (this == a) {
            throw new JugueteException("No puedes apilar un juguete consigo mismo");
        }
        if (!(a instanceof Apilable)) {
            throw new JugueteException("El juguete " + a.getNombre() + " no es apilable");
        }

        if (this.getClass() != a.getClass()) {
            throw new JugueteException("No puedo apilar un juguete de tipo " + this.getClass().getCanonicalName() + " con uno de tipo " + a.getClass().getCanonicalName());
        }
    }
}