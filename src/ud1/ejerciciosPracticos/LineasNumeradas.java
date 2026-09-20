package ud1.ejerciciosPracticos;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.List;

/**
 * @author AmerCz.
 *         Crea un programa que lea un fichero de texto y genere una copia en la
 *         que cada línea
 *         vaya precedida por el número de línea (“1: “, “2: “, 3: “, etc.)
 */
public class LineasNumeradas {

    public static void main(String[] args) {
        File f = new File("DATOS\\lineas.txt");

        try (var in = new BufferedReader(new FileReader(f));
                var out = new BufferedWriter(new FileWriter("DATOS\\lineas-copia.txt"))) {

            List<String> lista = in.readAllLines();

            int indice = 1;

            for (String l : lista) {
                
                out.write(indice + ": ");
                out.write(l);                    
                out.newLine();
                
                indice +=1;
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
