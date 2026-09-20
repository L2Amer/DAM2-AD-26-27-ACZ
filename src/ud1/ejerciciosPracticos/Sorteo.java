package ud1.ejerciciosPracticos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * @author AmerCz.
 * 
 */

public class Sorteo {
    public static void main(String[] args) {

        File f = new File(".\\DATOS\\alumnos.txt");
        
        try (var in = new BufferedReader(new FileReader(f));
                var out = new BufferedWriter(new FileWriter(".\\DATOS\\sorteo.txt"));) {

            List<String> lista = new ArrayList<>(in.readAllLines());
            Collections.shuffle(lista);
          
            for (String s : lista) {
                out.write(s);
                out.newLine();
            }

        } catch (Exception e) {
            System.out.println("ERROR I/O");
        }

    }

}
