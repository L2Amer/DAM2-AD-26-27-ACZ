package ud1;

import java.io.File;
import java.util.Scanner;

import javax.swing.JFileChooser;

/**
 * @author AmerCz
 *         Ejercicio3
 *         Escribe un programa en Java que funcione como un gestor básico de
 *         archivos y directorios. El programa debe permitir al usuario realizar
 *         las siguientes operaciones:
 *         Crear un directorio, empleando la clase JFileChooser para seleccionar
 *         la ruta donde se creará.
 *         Listar todos los archivos y subdirectorios de un directorio de forma
 *         recursiva.
 *         Eliminar un archivo o directorio. Si es un directorio, eliminar todo
 *         su contenido de forma recursiva.
 *         Mover o renombrar archivos y directorios.
 *         El programa debe ofrecer un menú para que el usuario elija la
 *         operación que desea realizar. La selección de directorios o archivos
 *         puede realizarse con la clase JFileChooser.
 * 
 */
public class Ejercicio3 {

    public static void main(String[] args) {

        int opcion = opcionMenu();

        while (opcion >= 1 && opcion <= 4) {

            switch (opcion) {
                case 1:

                    Scanner sc = new Scanner(System.in);
                    System.out.print("Introduce nombre del directorio: ");
                    String nombreDirectorio = sc.nextLine();
                    
                    JFileChooser chooser = new JFileChooser();
                    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

                    int returnVal = chooser.showOpenDialog(null);

                    if (returnVal == JFileChooser.APPROVE_OPTION) {

                        File f = chooser.getSelectedFile();

                        File nuevoDirectorio = new File(f, nombreDirectorio);

                        if (nuevoDirectorio.mkdir()) {
                            System.out.println("Creado correctamente en " + nuevoDirectorio.getAbsolutePath());
                        } else {
                            System.out.println("No se ha podido crear");
                        }
                    }

                    break;

                case 2:
                    
                    JFileChooser chooser2 = new JFileChooser();
                    chooser2.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

                    int returnVal2 = chooser2.showOpenDialog(null);
                    
                    if (returnVal2 == JFileChooser.APPROVE_OPTION) {

                        File f2 = chooser2.getSelectedFile();

                        for (File f : f2.listFiles()) {
                            
                            if (f.isDirectory()) {
                                for (File j : f.listFiles()) {
                                    System.out.println("- " + j.getName() + " (" + j.length() + ")" + (j.isDirectory() ? " DIRECTORIO" : " ARCHIVO"));
                                }
                            }

                            System.out.println("- " + f.getName() + " (" + f.length() + ")" + (f.isDirectory() ? " DIRECTORIO" : " ARCHIVO"));
                        }

                    }

                    break;

                case 3:

                    break;

                case 4:

                    break;

                default:
                    break;
            }

            opcion = opcionMenu();
        }

    }

    private static int opcionMenu() {
        Scanner sc = new Scanner(System.in);

        System.out.println();

        System.out.println("--- GESTOR DE ARCHIVOS Y DIRECTORIOS ---");
        System.out.println("1. Crear un directorio");
        System.out.println("2. Listar directorio");
        System.out.println("3. Eliminar un archivo o directorio");
        System.out.println("4. Mostrar");

        System.out.print("Opcion: ");
        return sc.nextInt();

    }
}
