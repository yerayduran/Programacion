package Space;

import java.util.ArrayList;
import java.util.List;

public class Tablero {
    private final List<Planeta> planetas = new ArrayList<>();
    private final MercadoNaves mercadoNaves = new MercadoNaves();

    public Tablero(List<String> nombresPlanetas) {
        for (String nombre : nombresPlanetas) planetas.add(new Planeta(nombre));
    }

    public List<Planeta> getPlanetas() { return planetas; }
    public MercadoNaves getMercadoNaves() { return mercadoNaves; }

    public void mostrarPlanetas() {
        for (Planeta p : planetas) System.out.println(p);
    }

    // Planetas que no están conquistados por otros (libres o del propio jugador)
    public List<Planeta> planetasNoConquistadosPorContrarios(Jugador jugador) {
        List<Planeta> res = new ArrayList<>();
        for (Planeta p : planetas) {
            if (!p.estaConquistado() || p.getConquistador().equals(jugador)) res.add(p);
        }
        return res;
    }
}
