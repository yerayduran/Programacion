package Boletin1.Ejercicio5;

public class Construcion {
    public static void main(String[] args) {

        Object[] array = new Object[5];

        array[0] = new Polideportivo("Poli Norte", 1200.5, 1);
        array[1] = new Polideportivo("Poli Sur", 1500.0, 2);
        array[2] = new Polideportivo("Poli Centro", 1800.75, 1);

        array[3] = new Oficina(900.0, 25);
        array[4] = new Oficina(1200.0, 40);

        for (Object o : array) {
            System.out.println(o.toString());
        }
    }
}
