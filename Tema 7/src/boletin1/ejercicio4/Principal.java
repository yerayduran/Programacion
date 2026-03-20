package boletin1.ejercicio4;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Principal {

    static void main(String[] args) {

        Path fichero = Path.of("./boletin1/ejercicio3/salidaEjercicio3.txt");
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            String linea;
            while((linea = br.readLine()) != null && !linea.equalsIgnoreCase("fin")) {
                Files.writeString(fichero, linea, StandardOpenOption.APPEND);

            }
            }catch(IOException e){
                System.out.println(e.getMessage());
            }
        }
    }
