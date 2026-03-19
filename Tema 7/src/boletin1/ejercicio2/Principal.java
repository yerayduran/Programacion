package boletin1.ejercicio2;

import java.io.*;

public class Principal {
    public static void main(String[] args) {
        File f = new File("./boletin1/ejercicio1/leeme.txt");

        try (FileReader fr = new FileReader(f); BufferedReader br = new BufferedReader(fr)) {
            String linea;
            StringBuilder sb = new StringBuilder();

            while ((linea = br.readLine()) != null) {
                sb.append(linea);
            }
            System.out.println(sb);


        } catch (IOException e) {
            System.out.println("Error al abrir archivo");
        }
    }
}
