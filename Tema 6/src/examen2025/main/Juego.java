package examen2025.main;


import examen2025.domain.Ataque;
import examen2025.domain.Personaje;
import examen2025.domain.TRaza;
import examen2025.exceptions.DBException;

import java.util.*;

public class Juego {
    private Set<Personaje> personajes;

    public Juego() {
        this.personajes = new HashSet<>();
    }

    public static void main(String[] args) {
        try {
            Juego juego = new Juego();
            // Crear personajes
            crearPersonajes(juego);

            // Llamada al método que muestra los personajes con más ataques
            System.out.println("Personaje(s) que conocen más ataques:");
            juego.personajeConMasAtaques();
            System.out.println();
            System.out.println("Personaje(s) con el ataque más poderoso:");
            juego.personajeConAtaqueMasPoderoso();
            System.out.println();
            System.out.println("Ataques ordenados por nombre");
            juego.todosLosAtaquesOrdenadosNombre();
            System.out.println();
            System.out.println("Ataques ordenados por daño de mayor a menor");
            juego.todosLosAtaquesOrdenadosDamage();

            Personaje gohan = juego.buscarPersonaje("gohan", TRaza.SAIYAN);
            Personaje android18 = juego.buscarPersonaje("androide nº18", TRaza.ANDROIDE);

            System.out.println();
            System.out.println("El mejor ataque disponible de gohan es:");
            Ataque at = juego.ataqueMasDañino(gohan, android18);
            System.out.println(at);

            System.out.println();
            System.out.println("Gohan ataca a " + android18.getNombre());
            juego.atacar(gohan, android18, "Special Beam Cannon");

            /*System.out.println();
            System.out.println(android18.getNombre() + " intenta atacar a Gohan");
            juego.atacar(android18, gohan, "energy blast");*/

            System.out.println();
            System.out.println("Todos los ataques restantes de todos los jugadores:");
            juego.todosLosAtaquesOrdenadosNombre();

            System.out.println();
            System.out.println("Eliminamos los ataques de nivel 1.");
            juego.eliminarAtaquesInferioresANivel(2);
            System.out.println("Todos los ataques restantes de todos los jugadores:");
            juego.todosLosAtaquesOrdenadosNombre();

            System.out.println();
            System.out.println("Todos los personajes mostrador por raza:");
            Map<TRaza, List<Personaje>> mapa = juego.devuelveMapaRazas();
            mapa.entrySet().forEach(e -> {
                System.out.printf("Personajes de la raza %s:\n", e.getKey());
                e.getValue().forEach(p -> System.out.printf("\t%s\n", p.getNombre()));
            });


        } catch (DBException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void crearPersonajes(Juego juego) throws DBException {
        Personaje goku = new Personaje("Goku", TRaza.SAIYAN, 100, 100, 100, 10);
        Personaje vegeta = new Personaje("Vegeta", TRaza.SAIYAN, 90, 20, 90, 25);
        Personaje gohan = new Personaje("Gohan", TRaza.SAIYAN, 80, 15, 80, 70);
        Personaje piccolo = new Personaje("Piccolo", TRaza.NAMEKIANO, 80, 10, 50, 45);
        Personaje android18 = new Personaje("Androide nº18", TRaza.ANDROIDE, 90, 1, 60, 40);

        // Asignar ataques a Goku (3 ataques)
        Ataque kamehameha1 = new Ataque("Kamehameha", 10, 1, 20);
        Ataque kamehameha2 = new Ataque("Kamehameha", 15, 2, 30);
        Ataque kamehameha3 = new Ataque("Kamehameha", 20, 3, 40);
        goku.addAtaque(kamehameha1);
        goku.addAtaque(kamehameha2);
        goku.addAtaque(kamehameha3);

        // Asignar ataques a Vegeta (4 ataques)
        Ataque finalFlash1 = new Ataque("Final Flash", 12, 1, 25);
        Ataque galickGun = new Ataque("Galick Gun", 8, 1, 18);
        Ataque bigBangAttack = new Ataque("Big Bang Attack", 15, 2, 35);
        Ataque finalFlash2 = new Ataque("Final Flash", 12, 2, 28);
        vegeta.addAtaque(finalFlash1);
        vegeta.addAtaque(galickGun);
        vegeta.addAtaque(bigBangAttack);
        vegeta.addAtaque(finalFlash2);

        // Asignar ataques a Gohan (5 ataques)
        Ataque masenko1 = new Ataque("Masenko", 9, 1, 19);
        Ataque masenko2 = new Ataque("Masenko", 11, 2, 27);
        Ataque masenko3 = new Ataque("Masenko", 13, 3, 33);
        Ataque specialBeamCannon = new Ataque("Special Beam Cannon", 15, 2, 40);
        Ataque finalAttack = new Ataque("Final Attack", 20, 3, 50);
        gohan.addAtaque(masenko1);
        gohan.addAtaque(masenko2);
        //gohan.addAtaque(masenko3);
        gohan.addAtaque(specialBeamCannon);
        gohan.addAtaque(finalAttack);

        Ataque makankosappo1 = new Ataque("Makankosappo", 10, 1, 22);
        Ataque makankosappo2 = new Ataque("Makankosappo", 15, 2, 30);
        Ataque makankosappo3 = new Ataque("Makankosappo", 20, 3, 38);
        piccolo.addAtaque(makankosappo1);
        piccolo.addAtaque(makankosappo2);
        piccolo.addAtaque(makankosappo3);

        Ataque energyBlast = new Ataque("Energy Blast", 12, 1, 28);
        Ataque powerPunch = new Ataque("Power Punch", 8, 1, 18);
        android18.addAtaque(energyBlast);
        android18.addAtaque(powerPunch);

        // Agregar los personajes al juego
        juego.agregarPersonaje(goku);
        juego.agregarPersonaje(vegeta);
        juego.agregarPersonaje(gohan);
        juego.agregarPersonaje(piccolo);
        juego.agregarPersonaje(android18);
    }

    public Personaje buscarPersonaje(String nombre, TRaza raza) throws DBException {
        return this.personajes.stream()
                .filter(p -> p.getNombre().equalsIgnoreCase(nombre) && p.getRaza() == raza)
                .findFirst().orElseThrow(() -> new DBException("No existe un personaje con esos datos"));
    }


    public void agregarPersonaje(Personaje personaje) throws DBException {
        if (!this.personajes.add(personaje)){
            throw new DBException("El personaje ya existe");
        }
    }

    public void personajeConMasAtaques() throws DBException {
       /*
        Aquí podríamos optar por dos opciones:
        1. Calcular cuál es el número máximo de ataques que uno o varios personajes tienen y luego filtrar por aquellos que tengan ese número de ataques.
        2. Ordenar la lista de personajes por la cantidad de ataques que tienen y recorrerla hasta encontrar el primer personaje cuyo número de ataques
        se diferencie del primer personaje de la lista.
         */
        /* Opción 1 */
        /*int maxAtaques = this.personajes.stream().mapToInt(p -> p.getAtaques().size()).max().orElseThrow(() -> new DBException("No hay personajes"));
        this.personajes.stream().filter(p -> p.getAtaques().size() == maxAtaques)
                .forEach(personaje -> {
                    System.out.println(personaje.getNombre() + ": " + personaje.getAtaques().size());
                });*/

        /* Opción 2 */
        List<Personaje> nuevaLista = this.personajes.stream()
                .sorted((p1, p2) -> p2.getAtaques().size() - p1.getAtaques().size())
                .toList();
        if (nuevaLista.isEmpty()){
            throw new DBException("No hay personajes");
        }
        int maxAtaques2 = nuevaLista.getFirst().getAtaques().size();
        for (Personaje personaje : nuevaLista) {
            if (personaje.getAtaques().size() != maxAtaques2) {
                break;
            }
            System.out.println(personaje.getNombre() + ": " + personaje.getAtaques().size());
        }

    }

    public void personajeConAtaqueMasPoderoso() throws DBException {
        int maxDamage = this.personajes.stream().flatMap(p -> p.getAtaques().stream()).mapToInt(Ataque::getDamage).max().orElse(0);

        this.personajes.stream().filter(p -> {
                    Ataque a = p.getAtaqueMasPoderoso();
                    return a != null && p.getAtaqueMasPoderoso().getDamage() == maxDamage;
                })
                .forEach(personaje -> {
                    System.out.println(personaje.getNombre() + ": " + personaje.getAtaqueMasPoderoso());
                });
    }

    public void todosLosAtaquesOrdenadosNombre() {
        this.personajes.stream().flatMap(p -> p.getAtaques().stream()).distinct()
                .sorted(Comparator.comparing(Ataque::getNombre))
                .forEach(System.out::println);
    }

    public void todosLosAtaquesOrdenadosDamage() {
        this.personajes.stream().flatMap(p -> p.getAtaques().stream()).distinct()
                .sorted(Comparator.comparing(Ataque::getDamage).reversed())
                .forEach(System.out::println);
    }

    public Ataque ataqueMasDañino(Personaje p1, Personaje p2) throws DBException{
        return p1.getAtaques().stream()
                .filter(a -> a.getKiNecesario() <= p1.getKiActual())
                .max(Comparator.comparing(Ataque::getDamage)).orElseThrow(() -> new DBException("No puede lanzar ningún ataque"));
    }

    public void atacar(Personaje p1, Personaje p2, String ataque) throws DBException {
        if (p1.getVidaActual() <= 0){
            throw new DBException("No puedes atacar con un personaje muerto");
        }

        if (p2.getVidaActual() <= 0){
            throw new DBException("No puedes atacar a un personaje muerto");
        }

        try {
            p1.atacar(p2, ataque);
            if (p2.getVidaActual() == 0){
                System.out.printf("%s ha muerto debido al ataque\n", p2.getNombre());
            }
            else{
                System.out.printf("%s tiene %d puntos de vida tras el ataque", p2.getNombre(), p2.getVidaActual());
            }
        }
        catch (DBException e){
            System.out.println(e.getMessage());
        }
    }

    public void eliminarAtaquesInferioresANivel(int nivel){
        for(Personaje p: this.personajes){
            p.eliminarAtaquesConNivelInferiorA(nivel);
        }
    }

    public Map<TRaza, List<Personaje>> devuelveMapaRazas(){
        //Se puede hacer con un único flujo (más difícil) o creando un mapa y rellenándolo al recorrer
        Map<TRaza, List<Personaje>> mapaPersonajes = new HashMap<>();
        for(TRaza tRaza: TRaza.values()){
            mapaPersonajes.put(tRaza, this.personajes.stream().filter(p -> p.getRaza() == tRaza).toList());
        }

        return mapaPersonajes;
    }

}
