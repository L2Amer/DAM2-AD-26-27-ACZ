package ud1.ejerciciosPracticos;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * @author AmerCz.
 *         Crea un programa que escriba un número de bytes introducido por el
 *         usuario (por defecto
 *         1.000.000) de dos formas:
 *         a) con FileOutputStream directo,
 *         b) con BufferedOutputStream.
 *         Mide el tiempo empleado por cada método, por ejemplo con
 *         System.nanoTime() y
 *         muestra el resultado de la comparación.
 *         Amplía el experimento permitiendo al usuario elegir el tamaño del
 *         buffer y guardando en
 *         un fichero de texto (PruebasRendimiento.txt) las condiciones y los
 *         resultados de cada
 *         prueba.
 * 
 */
public class ComparaRendimiento {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Escribe un numero (1.000.000 por ejemplo): ");
        int bytesEscritos = sc.nextInt();   

        if (bytesEscritos < 1000000) {
            bytesEscritos = 1000000;
        }

        System.out.print("Escribe el tamaño del buffer: ");
        int tamanoBuffer = sc.nextInt();
        sc.close();

        long inicioFile = System.nanoTime();
        escribirFile(bytesEscritos);
        long finFile = System.nanoTime();

        double totalFile = (finFile - inicioFile ) / 1000000000.0;
        System.out.println("Tiempo con FileOutputStream: " + totalFile + " segundos");

        long inicioBuffer = System.nanoTime();
        escribirBuffered(bytesEscritos, tamanoBuffer);
        long finBuffer = System.nanoTime();

        double totalBuffered = (finBuffer - inicioBuffer) / 1000000000.0;
        System.out.println("Tiempo con BufferedOutputStream: " + totalBuffered + " segundos");

        try (var out = new FileWriter("DATOS\\PruebasRendimiento.txt", true)) {
            out.write("\nNUEVA PRUEBA DE RENDIMIENTO: \n");
            out.write("** CONDICIONES **: \n");
            out.write("     - Bytes escritos: " + bytesEscritos + "\n");
            out.write("     - Tamaño del buffer: " + tamanoBuffer + "\n");

            out.write("** RESULTADOS ** \n");

            out.write("     - Tiempo con FileOutputStream: " + totalFile + " segundos \n");
            out.write("     - Tiempo con BufferedOutpurStream: " + totalFile + " segundos \n");
            out.write("----------------------------------------------------------------------");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    private static void escribirBuffered(int n, int b) {
        try (var out = new BufferedOutputStream(new FileOutputStream("DATOS\\RendimientoBuffered.dat"), b)) {
            for (int i = 0; i < n; i++) {
                out.write(i); 
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void escribirFile(int n) {
        try (var out = new FileOutputStream("DATOS\\RendimientoFile.dat")) {
            for (int i = 0; i < n; i++) {
                out.write(i); 
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
