package Boletin2.Ejercicio8;

import Ejercicio8.Exception.FutbolException;

public class Partidos {

    // Atributos
    private int jornada;
    private String quiniela;
    private String estadio;
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private int golesEquipoLocal;
    private int golesEquipoVisitante;

    // Comprobar si el partido se ha jugado
    private boolean jugado;

    // Le pasaremos por parámetros el nombre del estadio y el número de la jornada
    public Partidos(int jornada, String estadio, Equipo equipoLocal, Equipo equipoVisitante) throws FutbolException {
        setJornada(jornada);
        this.estadio = estadio;
        if(equipoLocal.equals(equipoVisitante)){
            throw new FutbolException("Melón, como va a jugar los mismos equipos");
        }
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.jugado = false;
    }

    // Hacemos los get para devolver los valores de los atributos
    public int getJornada() {
        return jornada;
    }

    public String getEstadio() {
        return estadio;
    }

    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }

    // Hacemos los sets para modificar los atributos
    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    private void setGolesEquipoLocal(int golesEquipoLocal) {
        this.golesEquipoLocal = golesEquipoLocal;
    }

    private int getGolesEquipoVisitante() {
        return golesEquipoVisitante;
    }

    private void setGolesEquipoVisitante(int golesEquipoVisitante) {
        this.golesEquipoVisitante = golesEquipoVisitante;
    }

    private int getGolesEquipoLocal() {
        return golesEquipoLocal;
    }

    public void setJornada(int jornada) throws FutbolException {
        if (jornada < 1 || jornada > 38) {
            throw new FutbolException("Este número no es válido para una jornada");
        }
        this.jornada = jornada;
    }

    public String getQuiniela(){
        if (golesEquipoLocal > golesEquipoVisitante) {
            return "1";
        } else if (golesEquipoLocal < golesEquipoVisitante) {
            return "2";
        } else {
            return "X";
        }
    }

    public void ponerResultado(String resultado) {
        // Si se ha jugado el partido pasará a true
        jugado = true;

        String[] resultados = resultado.split("-");
        int golesEquipoLocal = Integer.parseInt(resultados[0]);
        int golesEquipoVisitante = Integer.parseInt(resultados[1]);

        // Actualizamos los goles
        this.setGolesEquipoLocal(golesEquipoLocal);
        this.setGolesEquipoVisitante(golesEquipoVisitante);

        if (golesEquipoLocal > golesEquipoVisitante) {
            this.equipoLocal.sumarPartidoGanado();
        } else if (golesEquipoLocal < golesEquipoVisitante) {
            this.equipoVisitante.sumarPartidoGanado();
        }

    }

    // Hacemos un toString
    @Override
    public String toString() {

        if (jugado) {
            return "Partido: {" + "Jornada = " + jornada + " , Quiniela = '" + getQuiniela() + '\'' + " , Estadio = '" + estadio + '\'' + " , Boletin2.Boletin4.Ejercicio8.Ejercicio8.Equipo Local = " + equipoLocal + ", Goles = " + getGolesEquipoLocal() + " , Boletin2.Boletin4.Ejercicio8.Ejercicio8.Equipo Visitante = " + equipoVisitante + ", Goles = " + getGolesEquipoVisitante() + "}";
        } else {
            return "Partido: {" + "Jornada = " + jornada + " , Boletin2.Boletin4.Ejercicio8.Ejercicio8.Equipo Local = " + equipoLocal.getNombre() + " , Boletin2.Boletin4.Ejercicio8.Ejercicio8.Equipo Visitante = " + equipoVisitante.getNombre() + "}" + " Aún no se ha jugado";
        }
    }
}
