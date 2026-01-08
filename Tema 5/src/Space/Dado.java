package Space;

import java.util.Random;

public class Dado implements ILanzable {
    private final int numCaras;   // mínimo 4
    private final int valorMin;   // valor de la cara de menor puntuación
    private final Random random = new Random();

    public Dado(int numCaras, int valorMin) {
        if (numCaras < 4) throw new IllegalArgumentException("El dado debe tener al menos 4 caras");
        this.numCaras = numCaras;
        this.valorMin = valorMin;
    }

    @Override
    public int lanzar() {
        return valorMin + random.nextInt(numCaras);
    }

    @Override
    public int getMin() { return valorMin; }

    @Override
    public int getMax() { return valorMin + numCaras - 1; }

    @Override
    public String toString() {
        return "Space.Dado{" + "caras=" + numCaras + ", min=" + getMin() + ", max=" + getMax() + '}';
    }
}