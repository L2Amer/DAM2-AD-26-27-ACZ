package ud1.propiedadesFicheros;

import java.nio.file.Files;
import java.nio.file.Path;

/**
 * @author AmerCz.
 * Ejercicio1
 */
/**
 * Debes trabajar únicamente con métodos de la clase File.
 * Realiza los siguientes pasos:
 * Crea un archivo de texto llamado prueba.txt en el directorio actual de tu
 * proyecto, sólo si no existe.
 * Escribe un programa que cree un objeto File para el archivo prueba.txt y
 * compruebe si el archivo existe.
 * Si el archivo existe, muestra la ruta absoluta, nombre del archivo, tamaño,
 * última modificación y si es un directorio.
 * Si el archivo no existe, muestra un mensaje que lo indique y crea uno
 * temporal.
 * 
 */

public class Ejercicio1NIO {

    public static void main(String[] args) {

        Path p = Path.of("src\\ud1\\prueba.txt");

        try {
            if (Files.exists(p)) {
                System.out.println("----- El archivo ya existe -----");

                System.out.println("Ruta absoluta: " + p.toAbsolutePath());
                System.out.println("Nombre: " + p.getFileName());

                System.out.println("Ultima modificacion: " + Files.getLastModifiedTime(p));

                System.out.println("Tamaño: " + Files.size(p) + " bytes");

            } else {
                System.out.println("No existe");
                System.out.println("Creando fichero: " + p);

                Files.createFile(p);
            }
        } catch (Exception e) {
            System.out.println("ERROR DE E/S");
        }

    }
}
