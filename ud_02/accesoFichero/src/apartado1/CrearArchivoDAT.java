package apartado1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class CrearArchivoDAT {

    /**
     * Funcion que crea un fichero y le introduce datos sobre empleados
     * @param nombreFichero
     * @throws IOException 
     */
    public void generateFichero(String nombreFichero){
        try {
            File f = new File(nombreFichero);
            RandomAccessFile raf = new RandomAccessFile(f, "rw");

            Empleado[] empleados = {
                new Empleado(1, "Martin", "Calle 1", 1400f, 0.2f),
                new Empleado(2, "Pedro", "Calle 2", 1500f, 0.15f),
                new Empleado(3, "María", "Calle 3", 1500f, 0.15f),
                new Empleado(4, "Carlos", "Calle 4", 1250f, 0.25f),
                new Empleado(5, "Sara", "calle 5", 1400f, 0.2f),
                new Empleado(6, "Daniel", "Calle 6", 1900f, 0f)
            };
            //Recorremos el array de empleados y lo añadimos al fichero:
            for (Empleado empleado : empleados) {
                raf.writeInt(empleado.identificador);
                raf.writeUTF(empleado.nombre);
                raf.writeUTF(empleado.direccion);
                raf.writeFloat(empleado.salario);
                raf.writeFloat(empleado.comision + '\n');
            }
            raf.close();
            System.out.println("archivo .dat creado");
        } catch (FileNotFoundException e) {
            System.out.println("Error al crear fichero:" + e);
        }catch(IOException e){
            System.out.println("Error en el proceso de crear fichero" + e);
        }
    }

}
