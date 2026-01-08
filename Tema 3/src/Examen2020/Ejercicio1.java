package Examen2020;

public class Ejercicio1 {

    public static void main(String[] args) {// Datos de los estados, electores y votos de cada partido en las elecciones presidenciales de EE.UU. de 2016

        String[] estados = {"Alabama", "Alaska", "Arizona", "Arkansas", "California", "Carolina del Norte", "Carolina del Sur", "Colorado", "Connecticut", "Dakota del Norte", "Dakota del Sur", "Delaware", "Distrito de Columbia", "Florida", "Georgia", "Hawái", "Idaho", "Illinois", "Indiana", "Iowa", "Kansas", "Kentucky", "Luisiana", "Maine", "Maryland", "Massachusetts", "Míchigan", "Minnesota", "Mississippi", "Misuri", "Montana", "Nebraska", "Nevada", "Nueva Jersey", "Nueva York", "Nuevo Hampshire", "Nuevo México", "Ohio", "Oklahoma", "Oregón", "Pensilvania", "Rhode Island", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Virginia Occidental", "Washington", "Wisconsin", "Wyoming"};

        int[] electores = {9, 3, 11, 6, 55, 15, 9, 9, 7, 3, 3, 3, 3, 29, 16, 4, 4, 20, 11, 6, 6, 8, 8, 4, 10, 11, 16, 10, 6, 10, 3, 5, 6, 14, 29, 4, 5, 18, 7, 7, 20, 4, 11, 38, 6, 3, 13, 5, 12, 10, 3};
        int[] votosDemocrata = {729547, 116454, 1161167, 380494, 8753788, 1338870, 897572, 235603, 282830, 4504975, 1877963, 266891, 189765, 3090729, 1033126, 653669, 427005, 628854, 780154, 715326, 1677928, 1995196, 2268839, 1367716, 485131, 1071068, 177709, 568988, 539260, 348526, 2148278, 385234, 4556124, 2189316, 93758, 2394164, 420375, 1002106, 2926441, 252525, 855373, 117458, 870695, 3877868, 310676, 178573, 1981473, 1742718, 188794, 1382536, 55973};
        int[] votosRepublicano = {1318255, 163387, 1252401, 684872, 4483810, 1202484, 673215, 185127, 12723, 4617886, 2089104, 128847, 409055, 2146015, 1557286, 800983, 671018, 1202971, 1178638, 671154, 943169, 1090893, 2279543, 1322951, 700714, 1594511, 279240, 991922, 512058, 345790, 1601933, 319667, 2819534, 2362631, 216794, 2841005, 949136, 782403, 2970733, 180543, 1155389, 227721, 1522925, 4685047, 515231, 95369, 1769443, 1221747, 489371, 1405284, 174419};

        int electoresDemocrata = 0;
        int electoresRepublicano = 0;
        int votosTotalesDemocrata = 0;
        int votosTotalesRepublicano = 0;
        int estadosDemocrata = 0;
        int estadosRepublicano = 0;

        String estadoMaxDemocrata = "";  // Variables para almacenar el estado con más electores ganado por cada partido
        String estadoMaxRepublicano = "";

        int maxElectoresDemocrata = 0;
        int maxElectoresRepublicano = 0;

        for (int i = 0; i < estados.length; i++) {   // Recorremos todos los estados para calcular los resultados finales
            if (votosDemocrata[i] > votosRepublicano[i]) {
                electoresDemocrata += electores[i];
                votosTotalesDemocrata += votosDemocrata[i];
                estadosDemocrata++;
                if (electores[i] > maxElectoresDemocrata) {  // Comprobamos si es el estado con más electores ganado por el partido demócrata
                    maxElectoresDemocrata = electores[i];
                    estadoMaxDemocrata = estados[i];
                }
            } else {  // En caso de empate gana el republicano ya que es el partido en el poder
                electoresRepublicano += electores[i];
                votosTotalesRepublicano += votosRepublicano[i];
                estadosRepublicano++;
                if (electores[i] > maxElectoresRepublicano) {  // Comprobamos si es el estado con más electores ganado por el partido republicano
                    maxElectoresRepublicano = electores[i];
                    estadoMaxRepublicano = estados[i];
                }
            }
        }

        System.out.println("Presidente electo: " + (electoresDemocrata > electoresRepublicano ? "Demócrata" : "Republicano"));
        System.out.println("Electores Demócrata: " + electoresDemocrata);
        System.out.println("Electores Republicano: " + electoresRepublicano);
        System.out.println("Partido más votado: " + (votosTotalesDemocrata > votosTotalesRepublicano ? "Demócrata" : "Republicano"));
        System.out.println("Estados Demócrata: " + estadosDemocrata);
        System.out.println("Estados Republicano: " + estadosRepublicano);
        System.out.println("Estado con más electores Demócrata: " + estadoMaxDemocrata + " con " + maxElectoresDemocrata + " electores");
        System.out.println("Estado con más electores Republicano: " + estadoMaxRepublicano + " con " + maxElectoresRepublicano + " electores");
    }
}