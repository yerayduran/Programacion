package Boletin1.Ejercicio2;

import Boletin1.Ejercicio2.Exception.CocheException;

public class Empresa {
    static final int NUM_MAXIMO_DE_VEHICULO = 200;
    static Vehiculo[] vehiculos = new Vehiculo[NUM_MAXIMO_DE_VEHICULO];

    static void main(String[] args) {

    int opcion;
    String[] opciones = {"Dar de alta vehículo", "Calcular el precio final", "Salir"};

    do{
        System.out.println("----------RentaCar----------");
        opcion = MiEntradaSalida.seleccionarOpcion("\nElige una opción: ", opciones);
        try{
            switch(opcion){
                case 1:
                    String[] opciones2 = {"Dar de alta coche", "Dar de alta furgoneta", "Dar de alta microbus"};
                    int opcion2 = MiEntradaSalida.seleccionarOpcion("\nSelecciona una opción: ", opciones2);

                    switch (opcion2){
                        case 1:
                            String matriculaCoche = MiEntradaSalida.solicitarCadena("Introduce la matrícula: ");
                            int numDiasCoche = MiEntradaSalida.solicitarEnteroPositivo("Introduce los días alquilados: ");
                            String gamaCocheSt = MiEntradaSalida.solicitarCadena("Introduce la gama, BAJA, MEDIA o ALTA: ");
                            Gama gamaCoche = Gama.valueOf(gamaCocheSt.toUpperCase());
                            String combustibleCocheSt = MiEntradaSalida.solicitarCadena("Introduce el tipo de combustible: ");
                            Combustible combustibleCoche = Combustible.valueOf(combustibleCocheSt.toUpperCase());

                            Coche coche = new Coche(matriculaCoche, numDiasCoche, gamaCoche, combustibleCoche);

                            darDeAlta(coche);
                            break;

                        case 2:
                            String matriculaFurgoneta = MiEntradaSalida.solicitarCadena("Introduce la matrícula de la furgoneta: ");
                            int numDiasFurgoneta = MiEntradaSalida.solicitarEnteroPositivo("Introduce los días alquilados: ");
                            String gamaFurgonetaSt = MiEntradaSalida.solicitarCadena("Introduce la gama, BAJA, MEDIA o ALTA: ");
                            Gama gamaFurgoneta = Gama.valueOf(gamaFurgonetaSt.toUpperCase());
                            double masaMaximaAutorizada = MiEntradaSalida.solicitarDoublePositivo("Introduce el peso máximo autorizado: ");

                            Furgoneta furgoneta = new Furgoneta(matriculaFurgoneta, numDiasFurgoneta, gamaFurgoneta, masaMaximaAutorizada);

                            darDeAlta(furgoneta);
                            break;

                        case 3:
                            String matriculaMicrobus = MiEntradaSalida.solicitarCadena("Introduce la matrícula del microbus: ");
                            int numDiasMicrobus = MiEntradaSalida.solicitarEnteroPositivo("Introduce el número de días alquilados: ");
                            String gamaMicrobusSt = MiEntradaSalida.solicitarCadena("Introduce la gama, BAJA, MEDIA o ALTA: ");
                            Gama gamaMicrobus = Gama.valueOf(gamaMicrobusSt.toUpperCase());
                            int plazasMicrobus = MiEntradaSalida.solicitarEnteroPositivo("Introduce el número de plazas: ");

                            Microbus microbus = new Microbus(matriculaMicrobus, numDiasMicrobus, gamaMicrobus, plazasMicrobus);

                            darDeAlta(microbus);
                            break;

                        default:
                            System.out.println("No has seleccionado ninguna opción");
                            break;
                    }
                    break;
                case 2:
                    String matriculaABuscar = MiEntradaSalida.solicitarCadena("Introduce la matrícula del vehículo: ");

                    boolean encontrado = false;

                    for (int i = 0; i < vehiculos.length && !encontrado; i++) {
                        if (vehiculos[i] != null) {
                            if (matriculaABuscar.equals(vehiculos[i].MATRICULA)) {
                                double resultado = vehiculos[i].precioTotal();
                                System.out.println("El total es de " + resultado + " €");
                                encontrado = true;
                            }
                        }
                    }

                    if (!encontrado) {
                        System.out.printf("\nLa matrícula %s no se ha encontrado en el concesionario\n", matriculaABuscar);
                    }
                    break;

                case 3:
                    System.out.println("Hasta pronto");
                    break;
                default:
                    System.out.println("No has seleccionado ninguna opción");
                    break;
                }
            } catch (CocheException e) {
                System.out.println(e.getMessage());

            } catch (IllegalArgumentException e) {
                System.out.println("El tipo de gama o combustible no es el correcto");
                }

            } while (opcion != 3);
        }

    // Hacemos un método para dar de alta a un vehículo, lo almacenamos en un array
    public static void darDeAlta(Vehiculo vehiculo) throws CocheException {

        boolean encontrado = false;
        int hayEspacio = -1;

        for (int i = 0; i < vehiculos.length && !encontrado; i++) {
            if(vehiculo.equals(vehiculos[i])){
                encontrado = true;
            }
            if (vehiculos[i] == null && hayEspacio == -1) {
                hayEspacio = i;
            }
        }
        if (!encontrado && hayEspacio != -1) {
            vehiculos[hayEspacio] = vehiculo;
        } else {
            throw new CocheException("Este Boletin5Parte1.Ejercicio2.Vehiculo no puede darse de alta");
        }
    }
}