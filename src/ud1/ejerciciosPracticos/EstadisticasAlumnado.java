package ud1.ejerciciosPracticos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author AmerCz.
 *         Lee alumnos.txt (del ejercicio anterior) con BufferedReader, parsea
 *         cada línea, y calcula: nota media, máxima, mínima y cuántos aprobados
 *         hay. Muestra también el nombre del mejor alumno.
 */
public class EstadisticasAlumnado {

    public static void main(String[] args) {

        try (var in = new BufferedReader(new FileReader("DATOS\\alumnos.txt"))) {

            String linea;

            int suma = 0;
            int maxima = 0;
            int minima = 11;
            int aprobados = 0;
            String mejoresAlumnos = "";
            int contador = 0;

            while ((linea = in.readLine()) != null) {

                contador++;

                String partes[] = linea.split("_");

                int nota = Integer.parseInt(partes[partes.length - 1]);

                suma += nota;

                if (nota >= 5)
                    aprobados++;
                if (nota < minima)
                    minima = nota;

                if (nota > maxima) {
                    maxima = nota;
                    mejoresAlumnos = linea.substring(0, linea.indexOf(";"));
                } else if (nota == maxima) {
                    mejoresAlumnos += ", " + linea.substring(0, linea.indexOf(";"));
                }

            }

            System.out.println("media: " + (double) suma / contador);
            System.out.println("maxima:" + maxima);
            System.out.println("minima:" + minima);
            System.out.println("aprobados: " + aprobados);
            System.out.print("Mejores alumnos: ");
            System.out.println(mejoresAlumnos);

        } catch (IOException e) {
            System.out.println("Error de Entrada/Salida.");
        }
    }
}
