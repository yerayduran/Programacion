package boletin1.ejercicio3;

import java.io.*;

public class Principal {

    static void main(String[] args) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter pw = new PrintWriter(new FileWriter("./boletin1/ejercicio3/salidaEjercicio3.txt"))) {

            String linea;
            while ((linea = br.readLine()) != null && !linea.equalsIgnoreCase("fin")) {
                pw.println(linea);
            }

            pw.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}