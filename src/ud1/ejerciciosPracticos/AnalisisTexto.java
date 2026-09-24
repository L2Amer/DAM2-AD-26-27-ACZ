package ud1.ejerciciosPracticos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

import javax.swing.JFileChooser;

/**
 * @author AmerCz.
 *         Crea un programa que solicite un fichero de texto y cuente el número
 *         de caracteres, de
 *         vocales, de consonantes, de dígitos y de espacios en blanco.
 * 
 */
public class AnalisisTexto {
    public static void main(String[] args) {
        System.out.println("Selecciona el fichero de texto a analizar: ");
        File f = fichero();

        System.out.println("Fichero -> " + f.getAbsolutePath());
        
        try (var in = new BufferedReader(new FileReader(f))) {

            int caracteres = 0;
            int vocales = 0;
            int consonantes = 0;
            int digitos = 0;
            int espacios = 0;

            List<String> lista = in.readAllLines();
            String vocalesStr = "aeiouAEIOU";

            for (String l : lista) {

                for (int i = 0; i < l.length(); i++) {

                    caracteres += 1;

                    if (Character.isSpaceChar(l.charAt(i))) {
                        espacios += 1;
                    } else {
                        if (Character.isDigit(l.charAt(i))) {
                            digitos += 1;
                        }

                        if (vocalesStr.indexOf(l.charAt(i)) != -1) {
                            vocales += 1;
                        } else {
                            consonantes += 1;
                        }
                    }
                }
            }

            System.out.println("====== TOTAL ======");
            System.out.println("Caracteres: " + caracteres);
            System.out.println("Vocales: " + vocales);
            System.out.println("Consonantes: " + consonantes);
            System.out.println("Digitos: " + digitos);
            System.out.println("Espacios: " + espacios);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    public static File fichero() {
        JFileChooser chooser = new JFileChooser("E:\\DAM-2\\ADAT\\DAM2-AD-26-27-ACZ\\DATOS");
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

        chooser.setDialogTitle("SELECCIONA UN ARCHIVO");

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile();
        }

        return null;
    }
}
