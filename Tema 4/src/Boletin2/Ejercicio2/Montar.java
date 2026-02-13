package Boletin2.Ejercicio2;

public class Montar {


        // Atributos / componentes del ordenador
        private PlacaBase placaBase;
        private Microprocesador microprocesador;
        private DiscoDuro discoDuro;
        private TarjetaGrafica tarjetaGrafica;

        // Hacemos el constructor
        public Montar(PlacaBase placaBase, Microprocesador microprocesador, DiscoDuro discoDuro, TarjetaGrafica tarjetaGrafica) {
            this.placaBase = placaBase;
            this.microprocesador = microprocesador;
            this.discoDuro = discoDuro;
            this.tarjetaGrafica = tarjetaGrafica;
        }

        // Imprimimos las clases con sus atributos por pantalla
        @Override
        public String toString() {
            return "Boletin2.Boletin4.Ejercicio2.Ejercicio2.Ordenador{" + "placaBase=" + placaBase + ", microprocesador=" + microprocesador + ", discoDuro=" + discoDuro + ", tarjetaGrafica=" + tarjetaGrafica + '}';
        }

        public TarjetaGrafica getTarjetaGrafica() {
            return tarjetaGrafica;
        }

        public DiscoDuro getDiscoDuro() {
            return discoDuro;
        }

        public Microprocesador getMicroprocesador() {
            return microprocesador;
        }
    }
