package Examen2021Obj;

import Boletin1.Ejercicio2.MiEntradaSalida;
import Examen2021.Exception.BibliotecaException;

public class LibroApp {

    static int numSocios = 0;
    static int numLibros = 0;

    public static void main(String[] args) {

        Usuario us1 = new Usuario("Yeray", "Durán", "49728089L");
        Usuario us2 = new Usuario("Manuel", "Pérez", "29123587Y");

        int opcion;

        do {
            System.out.println("1. Convertir a socio");
            System.out.println("2. Añadir libro a la biblioteca");
            System.out.println("3. Coger prestado un libro");
            System.out.println("4. Devolver un libro");
            System.out.println("5. Número de socios");
            System.out.println("6. Número de libros en la biblioteca");
            System.out.println("7. Datos de los libros");
            System.out.println("8. Adiós");

            System.out.println(" ");
            opcion = MiEntradaSalida.solicitarEnteroPositivo("Elija una opción:");

            switch (opcion) {

                case 1:
                    int opcion2 = MiEntradaSalida.solicitarEnteroPositivo("Pulsa 1 si eres " + us1.getNombre() + " 2, si eres " + us2.getNombre());
                    switch (opcion2) {
                        case 1:
                            try {
                                us1.convertirASocio(us2);
                                System.out.println(" ");
                                System.out.println("Registro realizado exitosamente");
                                System.out.println(" ");
                                numSocios++;
                            } catch (BibliotecaException e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        case 2:
                            try {
                                us2.convertirASocio(us1);
                                System.out.println(" ");
                                System.out.println("Registro realizado exitosamente");
                                System.out.println(" ");
                                numSocios++;
                            } catch (BibliotecaException e) {
                                System.out.println(e.getMessage());
                            }
                            break;
                        default:
                            System.out.println("No has seleccionado ninguna opción");
                            break;
                    }
                    break;

                case 2:
                    int opcion3 = MiEntradaSalida.solicitarEnteroPositivo("Pulsa 1 si eres " + us1.getNombre() + " 2, si eres " + us2.getNombre());

                    switch (opcion3) {

                        case 1:
                            try {
                                String tituloLibro = MiEntradaSalida.solicitarCadena("Introduce el título: ");
                                String sinopsisLibro = MiEntradaSalida.solicitarCadena("Introduce la sinopsis: ");
                                String autorLibro = MiEntradaSalida.solicitarCadena("Introduce el autor: ");
                                Libro libro = new Libro(tituloLibro, sinopsisLibro, autorLibro);
                                us1.introducirLibro(libro);
                                System.out.println(" ");
                                System.out.println("Examen2021Obj.Libro registrado correctamente");
                                System.out.println(" ");
                                numLibros++;

                            } catch (BibliotecaException e) {
                                System.out.println(e.getMessage());
                            }
                            break;

                        case 2:
                            try {
                                String tituloLibro = MiEntradaSalida.solicitarCadena("Introduce el título: ");
                                String sinopsisLibro = MiEntradaSalida.solicitarCadena("Introduce la sinopsis: ");
                                String autorLibro = MiEntradaSalida.solicitarCadena("Introduce el autor: ");
                                Libro libro = new Libro(tituloLibro, sinopsisLibro, autorLibro);
                                us2.introducirLibro(libro);
                                System.out.println(" ");
                                System.out.println("Examen2021Obj.Libro registrado correctamente");
                                System.out.println(" ");

                                numLibros++;

                            } catch (BibliotecaException e) {
                                System.out.println(e.getMessage());
                            }
                            break;

                        default:
                            System.out.println("No has seleccionado ninguna opción");
                            break;
                    }
                    break;

                case 3:
                    int opcion4 = MiEntradaSalida.solicitarEnteroPositivo("Pulsa 1 si eres " + us1.getNombre() + " 2, si eres " + us2.getNombre());
                    switch (opcion4) {

                        case 1:
                            try {
                                String tituloLibro = MiEntradaSalida.solicitarCadena("Introduce el título del" + " libro que buscas");
                                String snopsisLibro = MiEntradaSalida.solicitarCadena("Introduce la snopsis" + " del libro que buscas");
                                String autorLibro = MiEntradaSalida.solicitarCadena("Introduce el autor del" + " libro que buscas");
                                Libro libro = new Libro(tituloLibro, snopsisLibro, autorLibro);
                                us1.prestamoLibro(libro);
                                System.out.println(" ");
                                System.out.println("Prestamo realizado exitosamente");
                                System.out.println(" ");

                            } catch (BibliotecaException e) {
                                System.out.println(e.getMessage());
                            }
                            break;

                        case 2:
                            try {
                                String tituloLibro = MiEntradaSalida.solicitarCadena("Introduce el título del" + " libro que buscas: ");
                                String snopsisLibro = MiEntradaSalida.solicitarCadena("Introduce la snopsis" + " del libro que buscas: ");
                                String autorLibro = MiEntradaSalida.solicitarCadena("Introduce el autor del" + " libro que buscas: ");
                                Libro libro = new Libro(tituloLibro, snopsisLibro, autorLibro);
                                System.out.println(" ");
                                System.out.println("Prestamo realizado exitosamente");
                                System.out.println(" ");
                                us2.prestamoLibro(libro);

                            } catch (BibliotecaException e) {
                                System.out.println(e.getMessage());
                            }
                            break;

                        default:
                            System.out.println("No has seleccionado ninguna opción");
                            break;
                    }
                    break;

                case 4:
                    int opcion5 = MiEntradaSalida.solicitarEnteroPositivo("Pulsa 1 si eres " + us1.getNombre() + " 2, si eres " + us2.getNombre());
                    switch (opcion5) {
                        case 1:
                            try {
                                String tituloLibro = MiEntradaSalida.solicitarCadena("Introduce el título del" + " libro que quieres devolver");
                                String snopsisLibro = MiEntradaSalida.solicitarCadena("Introduce la snopsis" + " del libro que quieres devolver");
                                String autorLibro = MiEntradaSalida.solicitarCadena("Introduce el autor del" + " libro que quieres devolver");
                                Libro libro = new Libro(tituloLibro, snopsisLibro, autorLibro);
                                us1.devolucionLibro(libro);
                                System.out.println(" ");
                                System.out.println("Devolución exitosamente");
                                System.out.println(" ");

                            } catch (BibliotecaException e) {
                                System.out.println(e.getMessage());
                            }
                            break;

                        case 2:
                            try {
                                String tituloLibro = MiEntradaSalida.solicitarCadena("Introduce el título del" + " libro que quieres devolver: ");
                                String snopsisLibro = MiEntradaSalida.solicitarCadena("Introduce la sinopsis" + " del libro que quieres devolver: ");
                                String autorLibro = MiEntradaSalida.solicitarCadena("Introduce el autor del" + " libro que quieres devolver: ");
                                Libro libro = new Libro(tituloLibro, snopsisLibro, autorLibro);
                                us2.devolucionLibro(libro);
                                System.out.println(" ");
                                System.out.println("Devolución exitosamente");
                                System.out.println(" ");

                            } catch (BibliotecaException e) {
                                System.out.println(e.getMessage());
                            }
                            break;

                        default:
                            System.out.println("No has seleccionado ninguna opción");
                            break;
                    }
                    break;

                case 5:
                    System.out.println(" ");
                    System.out.println("El número de socios es de: " + numSocios + " socios");
                    System.out.println(" ");
                    break;

                case 6:
                    System.out.println(" ");
                    System.out.println("El número de libros en la biblioteca es de: " + numLibros);
                    System.out.println(" ");
                    break;

                case 7:
                    us1.imprimirBiblioteca();
                    break;

                case 8:
                    System.out.println(" ");
                    System.out.println("Adiós lector");
                    System.out.println(" ");
                    break;

                default:
                    System.out.println("No has seleccionado ninguna opción");
                    break;
            }
        } while (opcion != 8);
    }
}