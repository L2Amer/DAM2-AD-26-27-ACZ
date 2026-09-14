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
                    crearDirectorio();
                    break;

                case 2:
                    listarDirectorioRecursivo();
                    break;

                case 3:
                    eliminarArchivoODirectorio();
                    break;

                case 4:
                    moverArchivoODirectorio();
                    break;

                default:
                    break;
            }

            opcion = opcionMenu();
        }

    }

    private static void moverArchivoODirectorio() {
        System.out.println("Selecciona el archivo o carpeta que quieres mover/renombrar");
        Scanner sc = new Scanner(System.in);
        JFileChooser chooser = new JFileChooser("E:\\DAM-2\\ADAT\\DAM2-AD-26-27-ACZ\\src\\ud1");

        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int returnVal = chooser.showOpenDialog(null);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File fOrigen = chooser.getSelectedFile();
            System.out.print("Introduce el nuevo nombre: ");
            String nuevoNombre = sc.nextLine();

            System.out.println("Carpeta destino s/n: ");
            File fDestino = new File(fOrigen.getParentFile(), nuevoNombre);

            if (fOrigen.renameTo(fDestino)) {
                System.out.println("Operacion realizada con exito");
            } else {
                System.out.println("Error al renombrar/mover");
            }
        }
    }

    private static void eliminarArchivoODirectorio() {
        JFileChooser chooser = new JFileChooser("E:\\DAM-2\\ADAT\\DAM2-AD-26-27-ACZ\\src\\ud1");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int returnVal = chooser.showOpenDialog(null);

        if (returnVal == JFileChooser.APPROVE_OPTION) {

            File f = chooser.getSelectedFile();

            if (eliminarRecursivo(f)) {
                System.out.println("Se ha borrado");
            } else {
                System.out.println("Error...");
            }

        }
    }

    private static void listarDirectorioRecursivo() {
        JFileChooser chooser = new JFileChooser("E:\\DAM-2\\ADAT\\DAM2-AD-26-27-ACZ\\src\\ud1");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

        int returnVal = chooser.showOpenDialog(null);

        if (returnVal == JFileChooser.APPROVE_OPTION) {

            File f = chooser.getSelectedFile();
            System.out.println("Contenido de: " + f.getAbsolutePath());

            listarRecursiva(f, "");
        }
    }

    private static void crearDirectorio() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce nombre del directorio: ");
        String nombreDirectorio = sc.nextLine();

        JFileChooser chooser = new JFileChooser("E:\\DAM-2\\ADAT\\DAM2-AD-26-27-ACZ\\src");
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
    }

    private static int opcionMenu() {
        Scanner sc = new Scanner(System.in);

        System.out.println();

        System.out.println("--- GESTOR DE ARCHIVOS Y DIRECTORIOS ---");
        System.out.println("1. Crear un directorio");
        System.out.println("2. Listar directorio");
        System.out.println("3. Eliminar un archivo o directorio");
        System.out.println("4. Mostrar");
        System.out.println("x. Cualquier otra opcion para salir");

        System.out.print("Opcion: ");
        return sc.nextInt();
    }

    private static void listarRecursiva(File directorio, String sangria) {

        if (directorio == null)
            return;

        for (File f : directorio.listFiles()) {
            System.out.println(sangria +
                    "- " + f.getName() + " (" + f.length() + ")" + (f.isDirectory() ? " DIRECTORIO" : " ARCHIVO"));

            if (f.isDirectory()) {
                listarRecursiva(f, sangria + "     ");
            }

        }

    }

    private static boolean eliminarRecursivo(File directorio) {

        if (directorio.isDirectory()) {
            if (directorio.listFiles() != null) {
                for (File f : directorio.listFiles()) {
                    eliminarRecursivo(f);
                }
            }
        }

        return directorio.delete();
    }
}
