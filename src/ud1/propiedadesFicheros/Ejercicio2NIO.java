package ud1.propiedadesFicheros;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.stream.Stream;

import javax.swing.JFileChooser;

/**
 * @author AmerCz.
 *         Ejercicio 2. Mostrar el contenido de un directorio
 *         El programa abre una ventana para la selección de un directorio
 *         (hazlo también desde teclado si recoge un parámetro) y usando el
 *         método listFiles() de la clase File, muestra el contenido de ese
 *         directorio, indicando el tamaño de los archivos que contiene y si es
 *         un directorio o no. Además, muestra el tamaño total de los archivos y
 *         directorios.
 * 
 */
public class Ejercicio2NIO {

    static long totalSize = 0;


    public static void imprime(Path p) {
        System.out.print("Nombre: " + p.getFileName());

        try {
            long size = Files.size(p);
            totalSize += size;
            System.out.print(" (" + size + ") ");
            System.out.println(Files.isDirectory(p) ? "[DIRECTORIO]" : "[FICHERO]");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {


        JFileChooser chooser = new JFileChooser("F:\\DAM-2\\ADAT\\DAM2-AD-26-27-ACZ\\src\\ud1");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

            File f = chooser.getSelectedFile();
            Path path = f.toPath();

            // Try cath con recursos (cierra automáticamente el flujo)
            try (Stream<Path> stream = Files.list(path)) {

                // Iterar con Consumer
                System.out.println("\n IMPRIMIR CON CONSUMER");
                stream.forEach(Ejercicio2NIO::imprime);

                System.out.println("Tamaño total: " + totalSize);

                System.out.println("\n IMPRIMIR CON ITERATOR");
                Stream<Path> stream2 = Files.list(path);
                Iterator<Path> it = stream2.iterator();

                while (it.hasNext()) {
                    Path pi = it.next();
                    System.out.println(pi);
                }

            } catch (Exception e) {
            }

        }

    }
}
