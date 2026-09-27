package ud1.ejerciciosPracticos.flujosdeObjetos;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

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

    private static List<Persona> lstPersonas = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        try (var out = new ObjectOutputStream(new FileOutputStream("DATOS\\Personas.dat"));) {

            menu();
            int opcion = sc.nextInt();

            while (opcion != 6) {

                switch (opcion) {
                    case 1:
                        insertarPersona();
                        out.writeObject(lstPersonas.get(lstPersonas.size() - 1));
                        break;

                    case 2:
                        mostrarPersonas("DATOS\\Personas.dat");
                        break;

                    case 3:
                        buscarPersona("DATOS\\Personas.dat");
                        break;

                    case 4:
                        exportarXML("DATOS\\Personas.xml");
                        break;

                    case 5:
                        importarXML("DATOS\\Personas.xml");
                        break;
                }

                menu();
                opcion = sc.nextInt();

                if (opcion == 6) {
                    System.out.println("Saliendo...");
                }
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void importarXML(String fichero) {
        System.out.println("\n======== IMPORTAR XML DE PERSONAS  ========");
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            // leemos XML
            Document documento = builder.parse(new File(fichero));

            // extraemos raiz
            Element raiz = documento.getDocumentElement();
            
            System.out.println("Elemento raíz: " + raiz.getNodeName());

            NodeList listaPersonas = raiz.getElementsByTagName("persona");

            for (int i = 0; i < listaPersonas.getLength(); i++) {
                Element persona = (Element) listaPersonas.item(i);

                String nombre = persona.getElementsByTagName("nombre").item(0).getTextContent();
                String edad = persona.getElementsByTagName("edad").item(0).getTextContent();

                System.out.println();
                System.out.println("Nombre: " + nombre);
                System.out.println("Edad: " + edad);
            }




        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void exportarXML(String fichero) {
        if (lstPersonas.size() == 0) {
            System.out.println("No se puede exportar una lista vacía...");
            return;
        }

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document documento = builder.newDocument();

            // raiz
            Element personas = documento.createElement("personas");
            documento.appendChild(personas);

            // creamos personas y dentro persona con sus subelementos
            for (Persona p : lstPersonas) {
                Element persona = documento.createElement("persona");
                personas.appendChild(persona);

                Element nombre = documento.createElement("nombre");
                nombre.setTextContent(p.getNombre());
                persona.appendChild(nombre);

                Element edad = documento.createElement("edad");
                edad.setTextContent(Integer.toString(p.getEdad()));
                persona.appendChild(edad);
            }

            // guardar
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty("indent", "yes");
            transformer.transform(new DOMSource(documento), new StreamResult(fichero));

            System.out.println("Se ha exportado correctamente en " + fichero);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void buscarPersona(String fichero) {
        sc.nextLine();
        System.out.println("\n======== BUSCAR PERSONA ========");
        System.out.print("Introduce el nombre de la persona: ");
        String nombre = sc.nextLine();

        try (var in = new ObjectInputStream(new FileInputStream(fichero))) {

            while (true) {
                Persona p = (Persona) in.readObject();

                if (nombre.equalsIgnoreCase(p.getNombre())) {
                    System.out.println("Se ha encontrado a la persona");
                    System.out.println(p);
                    break;
                }
            }

        } catch (EOFException e) {
            System.out.println("No se ha encontrado la persona");
        } catch (Exception e) {
        }
    }

    public static void mostrarPersonas(String fichero) {

        try (var in = new ObjectInputStream(new FileInputStream(fichero))) {
            System.out.println("\n======== MOSTRANDO PERSONAS ========");

            while (true) {
                Persona p = (Persona) in.readObject();
                System.out.println(p);
            }

        } catch (EOFException e) {
            System.out.println("Fin de la lista");
        } catch (Exception e) {
            System.out.println("Error I/O ");
        }
    }

    public static void insertarPersona() {
        sc.nextLine();
        System.out.println("\n======== AÑADIR PERSONA ========");
        System.out.print("Introduce el nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Introduce la edad: ");
        int edad = sc.nextInt();

        Persona p = new Persona(nombre, edad);

        if (lstPersonas.add(p)) {
            System.out.println("Se ha añadido a " + p.getNombre() + " correctamente !");
        } else {
            System.out.println("No se ha podido añadir");
        }

    }

    public static void menu() {
        System.out.println("\n======== DATOS DE PERSONAS ========");
        System.out.println("1 -> Añadir persona");
        System.out.println("2 -> Mostrar personas");
        System.out.println("3 -> Buscar persona");
        System.out.println("4 -> Exportar en XML");
        System.out.println("5 -> Importar en XML");
        System.out.println("6 -> Salir");
        System.out.print("Introduca una opción: ");
    }

}