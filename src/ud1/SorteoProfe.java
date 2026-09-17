package ud1;

import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

public class SorteoProfe {
    public static void main(String[] args) {

        System.out.println("PARTICIPACIÓN DE CLASE");
        System.out.println("======================");
        System.out.println("Leyendo fichero DATOS/alumnos.txt");

        try (var in = new FileReader(".\\DATOS\\alumnos.txt");
                var out = new FileWriter(".\\DATOS\\participaciones.txt", true);) {

            List<String> alumnos = in.readAllLines();
            Random rnd = new Random();
            String elegido = alumnos.get(rnd.nextInt(alumnos.size()));
            System.out.println("El elegido es... " + elegido);

            System.out.println("Añadiendo alumno a DATOS/participaciones.txt");
            out.write(LocalDateTime.now() + " - " + elegido + "\n");

        } catch (Exception e) {
            System.out.println("ERROR I/O");
        }
    }
}
