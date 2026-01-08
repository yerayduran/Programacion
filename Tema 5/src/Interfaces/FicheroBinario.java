package Interfaces;

public abstract class FicheroBinario extends Fichero implements ILeible{

    private Byte[] bytes;

    public FicheroBinario(String nombre, Byte[] bytes) {
        super(nombre);
        this.bytes = bytes;
    }

    public Byte[] getBytes() {
        return bytes;
    }

    public void setBytes(Byte[] bytes) {
        this.bytes = bytes;
    }

    public long getTamaño(){
        return bytes.length;
    }
}
