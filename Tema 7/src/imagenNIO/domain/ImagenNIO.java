package imagenNIO.domain;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class ImagenNIO {

    public static void main(String[] args) {
        Path entrada = Path.of("./imagenNIO/imagen/pradera.bmp");
        Path salida = Path.of("./imagenNIO/imagen/pradera_invertida.bmp");

        try (FileChannel canalEntrada = FileChannel.open(entrada, StandardOpenOption.READ);
             FileChannel canalSalida = FileChannel.open(salida, StandardOpenOption.CREATE, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING)) {

            ByteBuffer cabecera = ByteBuffer.allocate(54);
            canalEntrada.read(cabecera);
            cabecera.flip();
            canalSalida.write(cabecera);

            ByteBuffer buffer = ByteBuffer.allocate(4096);

            while (canalEntrada.read(buffer) > 0) {
                buffer.flip();

                for (int i = 0; i < buffer.limit(); i++) {
                    int valor = buffer.get(i) & 0xFF;
                    buffer.put(i, (byte) (255 - valor));
                }

                canalSalida.write(buffer);
                buffer.clear();
            }

            System.out.println("Imagen invertida.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}