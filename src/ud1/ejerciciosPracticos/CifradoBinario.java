package ud1.ejerciciosPracticos;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * @author AmerCz,
 *         Crea un programa que cifre un fichero binario invirtiendo los valores
 *         de sus bits para
 *         hacerlo ilegible.
 *         Comprueba que aplicando proceso de nuevo el fichero vuelve a ser
 *         legible.
 * 
 */
public class CifradoBinario {
    public static void main(String[] args) {

        File f = new File(".\\DATOS\\im-nocifrado.jpg");
        File fCifrado = new File(".\\DATOS\\im-cifrado.jpg");

        try (var in = new BufferedInputStream(new FileInputStream(f));
            var out = new BufferedOutputStream(new FileOutputStream(fCifrado))) {
            
            int b;

            while ((b = in.read()) != -1) {
                out.write(~b);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
