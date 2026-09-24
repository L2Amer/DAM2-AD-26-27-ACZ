package ud1.ejerciciosPracticos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

/**
 * @author AmerCz
 *         Crea un programa que compare dos ficheros de texto e indique si son
 *         idénticos y, en caso
 *         de no serlo, en que línea y columna tienen el primer caracter
 *         distinto.
 */
public class ComparadorFicheros {
    public static void main(String[] args) {

        File f1 = new File("DATOS\\comparador1.txt");
        File f2 = new File("DATOS\\comparador2.txt");

        try (var in1 = new BufferedReader(new FileReader(f1));
                var in2 = new BufferedReader(new FileReader(f2))) {

            List<String> lista1 = in1.readAllLines();
            List<String> lista2 = in2.readAllLines();

            if (lista1.equals(lista2)) {
                System.out.println("Los ficheros son IDÉNTICOS");
            } else {
                System.out.println("Los ficheros son DISTINTOS");

                int linea = 0;
                int columna = 0;
                boolean esMismoCaracter = true;

                for (int i = 0; i < lista1.size() && esMismoCaracter; i++) {

                    linea = i + 1;

                    for (int j = 0; j < lista1.get(i).length() && esMismoCaracter; j++) {
                        if (lista1.get(i).charAt(j) != lista2.get(i).charAt(j)) {
                            columna = j + 1;
                            esMismoCaracter = false;
                        }
                    }
                }

                System.out.println("==== PRIMER CARACTER DISTINO ====");
                System.out.println("Linea: " + linea);
                System.out.println("Columna: " + columna);

            }
            

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
