package Boletin1.ejercicio7;

public class Masterchef {

    static void main(String[] args) {
        try {
            Recetario recetario = new Recetario();
            Receta ensaladilla = new Receta("Ensaladilla Rusa", 60);
            ensaladilla.añadirIngrediente(new Ingrediente("Patatas", 5));
            ensaladilla.añadirIngrediente(new Ingrediente("Atún", 3));
            ensaladilla.añadirIngrediente(new Ingrediente("Huevo", 2));
            ensaladilla.añadirIngrediente(new Ingrediente("Zanahoria", 3));
            ensaladilla.añadirIngrediente(new Ingrediente("Mayonesa", 2));
            ensaladilla.añadirIngrediente(new Ingrediente("Sal", 1));
            ensaladilla.añadirIngrediente(new Ingrediente("Pimiento rojo", 1));
            // ensaladilla.borrarIngrediente((new Ingrediente("Pimiento rojo", 1)));


            recetario.añadirReceta(ensaladilla);
            System.out.println(recetario.listadoRecetasOrdenadasAlfabeticamente());
            /**
             *  Si sustituyes patatas en este apartado por otra de la lista de arriba sale la misma receta
             *  pero si pone una que no esta te dira que no hay receta registrada
             */
            System.out.println(recetario.listadoRecetasConIngredienteOrdenadasPorTiempoPreparacion("Pimiento rojo"));

        } catch (RecetaException e){
            System.out.println(e.getMessage());
        }
    }
}
