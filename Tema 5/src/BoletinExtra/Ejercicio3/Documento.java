package BoletinExtra.Ejercicio3;

public class Documento implements Enviable, Imprimible {

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo el documento...");
    }

    @Override
    public void enviar() {
        System.out.println("Enviando el documento...");
    }
}
