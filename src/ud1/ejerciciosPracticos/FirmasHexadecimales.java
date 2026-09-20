package ud1.ejerciciosPracticos;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * @author AmerCz.
 *         Más allá de su extensión (.pdf, .jpg, .png, .doc, etc.), algunos
 *         formatos de archivo pueden
 *         reconocerse por los valores de sus primeros y últimos bytes, en lo
 *         que se conoce como
 *         firmas hexadecimales o "números mágicos". En la siguiente página
 *         puedes consultar
 *         algunos de estas firmas:
 *         https://garykessler.net/library/file_sigs.html
 *         Elabora un programa que permita seleccionar archivos de al menos 3
 *         extensiones
 *         distintas y que comprueba si la firma coincide con su extensión.
 * 
 */
public class FirmasHexadecimales {
    public static void main(String[] args) {

        File f = new File(".\\DATOS\\imagen.jpg");

        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(f))) {

            String firma = "";

            for (int i = 0; i < 4; i++) {

                int byteFichero = in.read();
                firma += String.format("%02X ", byteFichero);

            }

            firma = firma.trim();

            System.out.println("-> Archivo: " + f.getName());
            System.out.println("-> Firma: " + firma);

            if (firma.startsWith("FF D8 FF")) {
                System.out.println("***Es un JPG***");
            } else if (firma.startsWith("89 50 4E 47")) {
                System.out.println("***Es un PNG***");
            } else if (firma.startsWith("25 50 44 46")) {
                System.out.println("***Es un PDF***");
            } else {
                System.out.println("Formato distinto a JPG/PNG/PDF.");
            }

        } catch (Exception e) {
        }

    }
}
