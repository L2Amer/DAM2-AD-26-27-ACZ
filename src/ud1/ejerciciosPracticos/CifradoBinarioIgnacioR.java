package ud1.ejerciciosPracticos;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author Ignacio Rodríguez
 */

public class CifradoBinarioIgnacioR {
    public static void main(String[] args) {
        try {
            cifradoBinario("alumnos.txt", "alumnos-cifrado.txt");
        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el archivo.");
        } catch (IOException e) {
            System.out.println("Error al leer/escribir el archivo.");
        }
    }

    public static void cifradoBinario(String rutaOrigen, String rutaDestino) throws FileNotFoundException, IOException {

        try (var origen = new FileInputStream(rutaOrigen);
                var destino = new FileOutputStream(rutaDestino);) {

            Path p = Path.of(rutaDestino);

            if (Files.exists(p, null)) {
                System.out.println();
            }

            if (origen.read() == -1) {
                System.out.println("El archivo no existe");
            }

            int cifrado;

            while ((cifrado = origen.read()) != -1) {
                destino.write(~cifrado);
            }

            System.out.println("Archivo cifrado correctamente");

        }

    }
}
