package boletin1.ejercicio1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Principal {

    public static void main(String[] args) {
        File f = new File("./boletin1/ejercicio1/leeme.txt");

        try(FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr)) {
            int contador = 0;
            while(br.readLine() != null) {
                contador++;
            }

            System.out.println("Las lineas totales son: " + contador);

        }catch(IOException e){
            System.out.println(e. getMessage());
        }

    }
}
