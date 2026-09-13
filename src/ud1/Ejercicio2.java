package ud1;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.FileChooserUI;

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
public class Ejercicio2 {
    public static void main(String[] args) {
        
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int returnVal = chooser.showOpenDialog(null);

        if (returnVal == JFileChooser.APPROVE_OPTION) {

            File dir = chooser.getSelectedFile();

            System.out.println("Listado del directorio " + dir.getAbsolutePath());

            int totalLen = 0;

            for (File f : dir.listFiles()) {
                System.out.println("- " + f.getName() + " (" + f.length() + ")" + (f.isDirectory() ? " DIR" : ""));
                totalLen += f.length();
            }

            System.out.println("Tamaño total: " + totalLen);
        }

    }
}
