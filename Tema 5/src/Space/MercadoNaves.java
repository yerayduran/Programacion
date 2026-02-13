package Space;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MercadoNaves {
    private final List<Nave> disponibles = new ArrayList<>(4);
    private final Random rnd = new Random();

    public MercadoNaves() { rellenar(); }

    public List<Nave> getDisponibles() { return new ArrayList<>(disponibles); }

    public Nave comprar(int indice) throws MercadoException {
        if (indice < 0 || indice >= disponibles.size()) {
            throw new MercadoException("Índice de carta inválido");
        }
        Nave elegida = disponibles.remove(indice);
        reponer();
        return elegida;
    }

    private void reponer() { disponibles.add(generarAleatoria()); }

    private void rellenar() {
        while (disponibles.size() < 4) disponibles.add(generarAleatoria());
    }

    private Nave generarAleatoria() {
        int t = rnd.nextInt(3);
        if (t == 0) return new NaveAtaque();
        if (t == 1) return new NaveCarga(new Dado(4, 2)); // Class.Space.Dado A (4 caras, 2..5)
        return new NaveTransporte(new Dado(6, 10));       // Class.Space.Dado C (6 caras, 10..15)
    }
}