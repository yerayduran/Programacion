package examen2022.domain;

import examen2022.exceptions.MazoException;

import java.util.*;
import java.util.stream.Collectors;

public class Mazo {

    Map<Cromo, Integer> mazo;

    public Mazo() {
        this.mazo = new HashMap<>();
    }

    public Map<Cromo, Integer> getMazo() {
        return mazo;
    }

    public void setMazo(Map<Cromo, Integer> mazo) {
        this.mazo = mazo;
    }

    public int addCromo(Cromo cromo) {
        return this.addCromo(cromo, 1);
    }
    
    public int addCromo(Cromo cromo, int numeroDeCromos) {
        if (this.mazo.containsKey(cromo)) {
            this.mazo.put(cromo, Integer.valueOf(this.mazo.get(cromo).intValue() + numeroDeCromos));
        }
        else {
            this.mazo.put(cromo, Integer.valueOf(numeroDeCromos));
        }

        return this.mazo.get(cromo).intValue();
    }


    public int intercambiar(Cromo cromoParaCambiar, Cromo cromoDelOtro) throws MazoException {
        if (!this.mazo.containsKey(cromoParaCambiar)) {
            throw new MazoException("No puede cambiar un cromo que no tienes.");
        }else {
            if(this.mazo.get(cromoParaCambiar).intValue() > 1) {
                this.mazo.put(cromoParaCambiar, Integer.valueOf(this.mazo.get(cromoParaCambiar).intValue() - 1));
            } else {
                this.mazo.remove(cromoParaCambiar);
            }
        }
        return this.addCromo(cromoDelOtro);
    }

    public void mezclar (Mazo m2) {
        m2.getMazo().forEach((cromo, unidades) -> this.addCromo(cromo, unidades));
    }


    public String contarDiferentes() {
        return this.mazo.size() + " diferentes.";
    }

    public List<Cromo> cromosDeUnEquipo(String equipoMostrar) {
        return mazo.keySet().stream().filter(c -> {
            if (c instanceof Escudo) {
                Escudo e = (Escudo) c;
                return e.getNombre().equals(equipoMostrar);
            }
            else {
                return ((Jugador) c).getEquipoQueJuega().equals(equipoMostrar);
            }
        }).collect(Collectors.toList());
    }

    public List<Cromo> getLista() {
        return mazo.keySet().stream()
                .filter(c -> c instanceof Escudo)
                .collect(Collectors.toList());
    }

    public double alturaMedia(String equipo) {
        return mazo.keySet().stream().filter(c -> {
                    if (c instanceof Jugador) {
                        Jugador jugador = (Jugador) c;
                        return jugador.getEquipoQueJuega().equals(equipo);
                    }
                    else {
                        return false;
                    }
                }).mapToInt(c -> ((Jugador) c).getAltura())
                .average().orElse(Double.NaN);
    }

    public List<Cromo> ordenar(){
        return mazo.keySet().stream().sorted((a, b) -> {
            if (a instanceof Escudo) {
                if (b instanceof Escudo) {
                    Escudo e1 = (Escudo) a;
                    Escudo e2 = (Escudo) b;
                    return e1.getNombre().compareTo(e2.getNombre());
                }
                else {
                    return -1;
                }
            }
            else {
                if (b instanceof Jugador) {
                    Jugador j1 = (Jugador) a;
                    Jugador j2 = (Jugador) b;
                    return j1.getNombre().compareTo(j2.getNombre());
                }
                else {
                    return 1;
                }
            }
        }).collect(Collectors.toList());
    }

    public List<String> equipoCompleto(){
        List<String> equipos = new LinkedList<>();
        Iterator<Cromo> it = mazo.keySet().stream().filter(c -> c instanceof Escudo).iterator();

        while (it.hasNext()) {
            Escudo escudo = (Escudo) it.next();
            long jugadoresQueTengo = mazo.keySet().stream()
                    .filter(c -> c instanceof Jugador)
                    .filter(c -> ((Jugador) c).getEquipoQueJuega().equals(escudo.getNombre()))
                    .count();
            if (jugadoresQueTengo == escudo.getNumDeJugadores()) {
                equipos.add(escudo.getNombre());
            }
        }

        return equipos;
    }
}
