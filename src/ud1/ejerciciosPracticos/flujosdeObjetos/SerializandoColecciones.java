package ud1.ejerciciosPracticos.flujosdeObjetos;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author AmerCz.
 *         Crea una clase ColeccionPersonas que contenga una colección de
 *         objetos de tipo
 *         Persona. Implementa la interface Serializable y crea un programa que
 *         serialice y
 *         deserialice un objeto de tipo ColeccionPersonas.
 */
public class SerializandoColecciones {
    public static void main(String[] args) {

        Persona p1 = new Persona("Alberto", 10);
        Persona p2 = new Persona("Marta", 20);
        Persona p3 = new Persona("Carlos", 45);

        ColeccionPersonas coleccionPersonas = new ColeccionPersonas();
        coleccionPersonas.añadirPersonas(p1);
        coleccionPersonas.añadirPersonas(p2);
        coleccionPersonas.añadirPersonas(p3);

        try (var out = new ObjectOutputStream(new FileOutputStream("DATOS\\Personas.dat"))) {
            out.writeObject(coleccionPersonas);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        // BLOQUE 2: LECTURA
        try (var in = new ObjectInputStream(new FileInputStream("DATOS\\Personas.dat"))) {
            ColeccionPersonas miColeccion = (ColeccionPersonas) in.readObject();
            System.out.println(miColeccion);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
