package agencia.domain;

import java.util.ArrayList;
import java.util.List;

public class Agencia {

    private List<Ruta> rutas;

    private String nombre;
    private int id;

    public Agencia(String nombre, int id) {
        this.nombre = nombre;
        this.id = id;
        this.rutas = new ArrayList<>();
    }

    public List<Ruta> getRutas() {
        return rutas;
    }

    public void setRutas(List<Ruta> rutas) {
        this.rutas = rutas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
