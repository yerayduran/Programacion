package Boletin1.Ejercicio1;

import java.util.Scanner;

public class Rectangulo {

    private int ancho;
    private int longitud;

    public Rectangulo (){
        Scanner scanner = new Scanner(System.in);
        longitud= 1;
        ancho = 1;

    }

    public int getLongitud() {
        return longitud;
    }

    public void setLongitud(int longitud) {
        if(longitud > 0 && longitud <= 20){
            this.longitud = longitud;
        }
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        if(ancho > 0 && ancho <= 20){
            this.ancho = ancho;
        }
    }

    public int perimetroRectangulo(){
        return (this.longitud * 2) + (this.ancho * 2);
    }

    public int areaRectangulo(){
        return (longitud * ancho);
    }
}