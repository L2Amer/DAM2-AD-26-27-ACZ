package ud1.propiedadesFicheros;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

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

public class Ejercicio1 {

    public static void main(String[] args) {

        File f = new File("F:\\DAM-2\\ADAT\\DAM2-AD-26-27-ACZ\\src\\ud1\\prueba.txt");
        SimpleDateFormat formateador = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy", Locale.of("es", "ES"));

        if (f.exists()) {

            System.out.println("----- El archivo ya existe -----");

            System.out.println("Ruta absoluta: " + f.getAbsolutePath());
            System.out.println("Nombre: " + f.getName());
            System.out.println("Tamaño: " + f.length() + " bytes");
            System.out.println("Ultima modificacion: " + formateador.format(new Date(f.lastModified())));

        } else {
            System.out.println("No existe");
            System.out.println("Creando fichero: " + f);

            try {
                f.createNewFile();
            } catch (Exception e) {
                System.out.println("Error... " + e.getMessage());
            }

        }

    }
}
