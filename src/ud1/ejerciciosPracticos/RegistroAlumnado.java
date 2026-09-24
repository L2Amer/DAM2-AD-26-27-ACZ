package ud1.ejerciciosPracticos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
 * @author AmerCz.
 *         Genera un fichero alumnos.txt con 1000 líneas del tipo
 *         Alumno_i;nota_i donde la nota es aleatoria entre 0 y 10. Usa
 *         BufferedWriter y newLine() para los saltos de línea.
 */
public class RegistroAlumnado {

    private static int lineas  = 1000;

    public static void main(String[] args) {

        Random rnd = new Random();

        try (var out = new BufferedWriter(new FileWriter("DATOS\\alumnos.txt")) ) {
            
            for (int i = 0; i < lineas; i++) {
                out.write("Alumno_" + (i + 1) + "; " + "nota_" + rnd.nextInt(0, 11));
                if (i < 999) {
                    out.newLine();
                }
            }

        } catch (IOException e) {
            System.out.println("Error de Entrada/Salida.");
        }
    }
}
