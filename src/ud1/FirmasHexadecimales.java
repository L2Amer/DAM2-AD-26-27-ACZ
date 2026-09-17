package ud1;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

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
