package ud1.ejerciciosPracticos;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 * @author AmerCz.
 *         Crea una clase Persona con los atributos nombre y edad. Crea un
 *         programa que serialice y deserialice un objeto de tipo Persona.
 *         Debe tener un menú con las siguientes opciones:
 *         Añadir persona.
 *         Mostrar personas.
 *         Buscar persona (por número o por nombre, según consideres)
 *         Salir
 * 
 */
public class SerializandoPersonas {
    private static List<Persona> personas;
    public static void main(String[] args) {

        try (var out = new ObjectOutputStream(new FileOutputStream("DATOS\\Personas.txt"))) {
            
            


        } catch (Exception e) {
            System.out.println("Erro");
        }
    }
}
