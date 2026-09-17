package ud1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFileChooser;
/**
 * @author AmerCz.
 * 
 */
public class Flujos {

    public static void main(String[] args) {

        System.out.println("Selecciona el archivo de ORIGEN.");
        File ficheroOrigen = fichero();

        if (ficheroOrigen != null) {

            System.out.println("Selecciona el archivo de DESTINO.");
            File ficheroDestino = fichero();

            if (ficheroDestino != null) {

                try (var in = new BufferedInputStream(new FileInputStream(ficheroOrigen));
                        var out = new BufferedOutputStream(new FileOutputStream(ficheroDestino))) {

                    int c;

                    while ((c = in.read()) != -1) {
                        out.write(c);
                    }

                    System.out.println("Archivo copiado en: " + ficheroDestino.getAbsolutePath());

                } catch (IOException e) {
                    System.out.println("ERROR I/O");
                }

            } else {
                System.out.println("Error en el DESTINO.");
            }

        } else {
            System.out.println("ERROR en el ORIGEN.");
        }

    }

    public static File fichero() {
        JFileChooser chooser = new JFileChooser("E:\\DAM-2\\ADAT\\DAM2-AD-26-27-ACZ\\src\\ud1");
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        chooser.setDialogTitle("SELECCIONA UN ARCHIVO");

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile();
        }

        return null;
    }

}
