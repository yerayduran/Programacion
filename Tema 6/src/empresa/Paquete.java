package empresa;

public class Paquete {

    private int numDeSeguimiento;
    private String remitente;
    private String destinatario;
    private int prioridad;

    public Paquete(int numDeSeguimiento, String remitente, String destinatario, int prioridad) {
        this.numDeSeguimiento = numDeSeguimiento;
        this.remitente = remitente;
        this.destinatario = destinatario;
        this.prioridad = prioridad;
    }

    public int getNumDeSeguimiento() {
        return numDeSeguimiento;
    }

    public void setNumDeSeguimiento(int numDeSeguimiento) {
        this.numDeSeguimiento = numDeSeguimiento;
    }

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }
}
