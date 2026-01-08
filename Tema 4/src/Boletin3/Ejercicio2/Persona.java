package Boletin3.Ejercicio2;

import Ejercicio2.Exception.MensajeException;

public class Persona {

    private String nombre;
    private Mensaje[] mensajesRecibidos;
    private Mensaje[] mensajesEnviados;
    private int espacioOcupadoBuzonEntrega;
    private int espacioOcupadoBuzonEnvio;
    private static final int TAMANO_BUZON = 5;

    public Persona(String nombre) {
        this.nombre = nombre;
        mensajesRecibidos = new Mensaje[TAMANO_BUZON];
        mensajesEnviados = new Mensaje[TAMANO_BUZON];
        espacioOcupadoBuzonEnvio = 0;
        espacioOcupadoBuzonEntrega = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void enviarMensaje(Boletin2.Ejercicio1.Persona destinatario, String asunto, String cuerpo) throws MensajeException {
        if (asunto.isBlank()) {
            throw new MensajeException("El mensaje debe tener asunto");
        }
        if (cuerpo.isBlank()) {
            throw new MensajeException("El mensaje debe tener cuerpo");
        }
        assert destinatario != null: "El destinatario no puede ser nulo";
        if (destinatario == this) {
            throw new MensajeException("No puedes enviarte un correo a tí mismo");
        }

        int enviarMensaje = -1;
        int recibirMensaje = -1;

        for (int i = 0; i < this.mensajesEnviados.length; i++) {
            if (this.mensajesEnviados[i] == null) {
                enviarMensaje = i;
                break;
            }
        }

        for (int i = 0; i < destinatario.mensajesRecibidos.length; i++) {
            if (destinatario.mensajesRecibidos[i] == null) {
                recibirMensaje = i;
                break;
            }
        }

        if (enviarMensaje == -1 || recibirMensaje == -1) {
            throw new MensajeException("No hay espacio en alguno de los buzones");
        }

        Mensaje mensaje = new Mensaje(asunto, cuerpo, this, destinatario);

        this.mensajesEnviados[enviarMensaje] = mensaje;
        this.espacioOcupadoBuzonEnvio++;
        destinatario.mensajesRecibidos[recibirMensaje] = mensaje;
        destinatario.espacioOcupadoBuzonEntrega++;
    }

    public void borrarMensajeEnviadoMasAntiguo() throws MensajeException {
        if (this.espacioOcupadoBuzonEnvio == 0) {
            throw new MensajeException("El buzón de envios está vacío");
        }

        for (int i = 0; i < this.mensajesEnviados.length - 1; i++) {
            this.mensajesEnviados[i] = this.mensajesEnviados[i + 1];
        }
        this.mensajesEnviados[this.mensajesEnviados.length - 1] = null;
        this.espacioOcupadoBuzonEnvio--;
    }

    public void borrarMensajeRecibidoMasAntiguo() throws MensajeException {
        if (this.espacioOcupadoBuzonEntrega == 0) {
            throw new MensajeException("El buzón de mensajes entregados está vacío");
        }
        for (int i = 0; i < this.mensajesRecibidos.length - 1; i++) {

            this.mensajesRecibidos[i] = this.mensajesRecibidos[i + 1];
        }

        this.mensajesRecibidos[this.mensajesRecibidos.length - 1] = null;
        this.espacioOcupadoBuzonEntrega--;
    }
}