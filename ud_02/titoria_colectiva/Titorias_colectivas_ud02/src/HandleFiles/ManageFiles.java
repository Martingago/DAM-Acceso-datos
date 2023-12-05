package HandleFiles;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ManageFiles {

    Scanner sc = new Scanner(System.in);

    /**
     * Listar archivos y directorios:
     *
     * @param path
     */
    public void listFiles(String path) {

        try {
            File file = new File(path);
            File[] listFiles = file.listFiles();

            for (File fichero : listFiles) {
                if (fichero.isDirectory()) {
                    System.out.println("Carpeta: " + fichero.getName());
                } else if (fichero.isFile()) {
                    System.out.println("Fichero: " + fichero.getName());
                }

            }
        } catch (NullPointerException e) {
            System.out.println("Asegúrate de que la dirección path existe");
        }
    }

    /**
     * Ver permisos de un fichero
     *
     * @param f
     */
    public void filePermissions(String f) {
        File file = new File(f);
        if (file.exists()) {
            System.out.println("Los permisos del fichero: " + file + " son:");
            System.out.println("Lectura: " + file.canRead());
            System.out.println("Escritura: " + file.canWrite());
            System.out.println("Ejecución: " + file.canExecute());
            System.out.println("Dirección: " + file.getPath());
        } else {
            System.out.println("Comprueba que el fichero existe");
        }
    }

    /**
     * Crear un fichero
     * @param path dirección en la que se creará el archivo
     */
    public void createFile(String path) {
        try {
          
            System.out.println("Introduce el nombre del fichero:");
            String filename = sc.nextLine();
            File file = new File(path + filename);
            if (file.createNewFile()) {
                System.out.println("El archivo se ha creado correctamente");
            } else {
                System.out.println("No se ha podido crear el archivo");
            }
        } catch (IOException ex) {
            System.out.println("Error al crear el archivo específicado");
        }

    }

    /**
     * Crear un directorio
     * @param path
     */
    public void createDirectory(String path) {
        System.out.println("Introduce el nombre del directorio:");
        String directorioName = sc.nextLine();
        boolean exito = (new File(path + directorioName).mkdir());
        if (exito) {
            System.out.println("Directorio creado con éxito");
        } else {
            System.out.println("Se ha producido un error al crear el directorio");
        }
    }

    /**
     * Eliminar un fichero
     *
     * @param pathFichero
     */
    public void deleteFile(File fichero) {
        if (fichero.exists()) {
            fichero.delete();
            System.out.println("El fichero: " + fichero + " ha sido eliminado.");
        } else {
            System.out.println("No se ha podido eliminaar el fichero específicado ya que no se encuentra o no existe");
        }
    }

    /**
     * Eliminar un directorio
     *
     * @param directorio
     */
    public void deleteDirectorio(File directorio) {
        File[] list = directorio.listFiles();
        for (File dato : list) {
            System.out.println(dato);
            if (dato.isFile()) {
                dato.delete();
                System.out.println("Se han eliminado ficheros");
            } else if (dato.isDirectory()) {
                //Si se trata de un directorio se llama de foma recursiva a la funcion para que éste a su vez elimine los subdirectorios
                deleteDirectorio(dato);
                System.out.println("Se ha eliminado un directorio: " + dato.getName());
            }
        }
        directorio.delete();
    }

    /**
     * Renombrar un fichero o file
     * @param path direccion en la que se encuentra el fichero
     */
    public void renameFileOrDirectory(String path) {
        System.out.println("Indica el nombre del fichero/carpeta que quieres renombrar:");
        String doc = sc.nextLine(); //nombre del fichero a modificar
        
        File toRename = new File(path + doc); //documento a modificar
        String oldName = toRename.getName(); //antiguo nombre a modificar
        if (toRename.exists()) {
            String typeData = toRename.isDirectory() ? "directorio" : "fichero";
            
            System.out.println("Indica el nuevo nombre del " + typeData + ":");
            String newName = sc.nextLine();
            boolean result = toRename.renameTo(new File(path + newName));
            if (result) {
                System.out.print(
                        "===========================================================\n"
                        + oldName + " ha sido renombrado a " + newName
                        + "\n===========================================================\n");
            } else {
                System.out.println("No se ha podido renombrar el "+ typeData + " con el nombre indicado");
            }
        } else {
            System.out.println("No se ha encontrado ningún documento ni fichero con ese nombre");
        }
    }

    /**
     * Leer datos de un ficheros
     * @param path 
     */
    public void readDataFromFile(String path) {
        File file = new File(path);
        try {
            if (file.isFile()) {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            System.out.println("================================================= \n\n");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            }else{
                System.out.println("El arhivo no puede ser leido");
            }

        } catch (FileNotFoundException ex) {
            System.out.println("Error, el fichero no existe");
        } catch (IOException ex) {
            System.out.println("Error en la lectura de datos");
        }
    }
    
    
    /**
     * Recibe por parámetro un string de un fichero, y un texto para añadir en el documento
     * @param path
     * @param datos 
     */
    public void writeDataOnFile(String path, String datos){
        File f = new File(path);
        FileWriter fw = null;
        if(f.exists()){
           try{
               fw = new FileWriter(f);
               fw.write(datos);
               fw.flush();
           }catch(IOException e){
               System.out.println("Error al escribir los datos");
           } finally{
               try {
                   System.out.println("Documento escrito con éxito!");
                   fw.close();
               } catch (IOException ex) {
                   System.out.println("Error de excepcion de datos");
               }
               
           }
        }else{
            System.out.println("El documento que has proporcionado no se ha encontrado o no existe");
        }
    }

}
