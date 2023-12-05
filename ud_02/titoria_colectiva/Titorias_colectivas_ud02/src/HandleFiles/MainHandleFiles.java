package HandleFiles;

import java.io.File;
import java.util.*;

public class MainHandleFiles {

    public static void main(String[] args) {
        // TODO code application logic here
        ManageFiles action = new ManageFiles();
        Hooks hooks = new Hooks();
        Scanner sc = new Scanner(System.in);

        String PATH = "./";

        do {
            hooks.optionText();
            System.out.println("Indica una opción:");
            int option = sc.nextInt();
            sc.nextLine();  // consume the newline

            switch (option) {

                case 1:
                    //Listar archivos y carpetas
                    System.out.println("================================================");
                    System.out.println("El listado de ficheros para el path: \"" + PATH + "\" es:");
                    action.listFiles(PATH);

                    break;
                case 2:
                    //Ver permisos de un fichero
                    System.out.println("Introduce el nombre del fichero para ver sus permisos");
                    String fichero = sc.nextLine();
                    System.out.println("================================================");
                    action.filePermissions(fichero);
                    break;
                case 3:
                    //crear fichero
                    System.out.println("Indica dónde quieres crear el fichero - Partiendo de la raiz del proyecto");
                    String extraPath = sc.nextLine();
                    action.createFile(PATH + extraPath);
                    break;
                case 4:
                    //crear carpeta
                    System.out.println("Indica dónde quieres crear la carpeta - Partiendo de la raiz del proyecto");
                    String extraPathCarpeta = sc.nextLine();
                    action.createDirectory(PATH + extraPathCarpeta);
                    break;
                case 5:
                    //borrar fichero
                    System.out.println("Indica la dirección del fichero a eliminar:");
                    String extraPathDelete = sc.nextLine();

                    File deleteElement = new File(PATH + extraPathDelete);
                    if (deleteElement.exists()) {
                        //Si es directorio se emplea funcion eliminar directorios
                        if (deleteElement.isDirectory()) {
                            action.deleteDirectorio(deleteElement);
                        } else if (deleteElement.isFile()) {
                            action.deleteFile(deleteElement);
                        }
                    } else {
                        System.out.println("El fichero o carpeta seleccionado no existe");
                    }
                    break;
                case 6:
                    //renombrar fichero
                    System.out.println("Indica la ruta del fichero/documento que quieres renombrar: ");
                    String oldFile = sc.nextLine();
                    action.renameFileOrDirectory(PATH + oldFile);

                    break;
                case 7:
                    //Leer fichero

                    break;
                case 8:
                    //Escribir fichero

                    break;
                case 9:
                    //salir de la app
                    System.out.println("Saliendo de la aplicación");
                    System.exit(0);
                default:
                    System.out.println("Error, introduce un número válido!");
                    break;
            }

        } while (true);

    }
}
