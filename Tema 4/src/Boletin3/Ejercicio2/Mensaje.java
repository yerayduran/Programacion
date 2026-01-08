package Boletin3.Ejercicio2;

import Boletin2.Ejercicio1.Persona;

import java.time.LocalDateTime;

public class Mensaje {

    private String asunto;
    private String cuerpo;
    private LocalDateTime fechaEnvio;
    private Persona remitente;
    private Persona destinatario;

    public Mensaje(String asunto, String cuerpo, Persona remitente, Persona destinatario) {
        this.asunto = asunto;
        this.cuerpo = cuerpo;
        this.fechaEnvio = LocalDateTime.now();
        this.remitente = remitente;
        this.destinatario = destinatario;
    }

    public void setAsunto (String asunto){
        this.asunto = asunto;
    }

    public void setCuerpo (String cuerpo){
        this.cuerpo = cuerpo;
    }

    public void setDestinatario (Persona destinatario){
        this.destinatario = destinatario;
    }

    public void setFechaEnvio (LocalDateTime fechaEnvio){
        this.fechaEnvio = fechaEnvio;
    }

    public void setRemitente (Persona remitente){
        this.remitente = remitente;
    }

    public String getAsunto () {
        return asunto;
    }

    public String getCuerpo () {
        return cuerpo;
    }

    public LocalDateTime getFechaEnvio () {
        return fechaEnvio;
    }

    public Persona getRemitente () {
        return remitente;
    }
    public Persona getDestinatario () {
        return destinatario;
    }
}


