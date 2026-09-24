package ud1.ejerciciosPracticos;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOError;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * @author AmerCz.
 *         Lee un fichero de texto con BufferedReader.readLine() y muestra por
 *         pantalla solo las líneas que contengan una palabra clave introducida
 *         por el usuario.
 * 
 */

public class LecturaPorLineas {

    public static void main(String[] args) {

        try (var in = new BufferedReader(new FileReader("DATOS\\porLineas.txt"));
                Scanner sc = new Scanner(System.in);) {


            System.out.print("Introduce la palabra clave: ");
            String palabra = sc.nextLine();

            String linea;

            while ((linea = in.readLine()) != null) {
                if (linea.contains(palabra)) {
                    System.out.println(linea);
                }
            }

        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el fichero.");
        } catch (IOException e) {
            System.out.println("Error de Entrada/Salida.");
        }

    }
}
