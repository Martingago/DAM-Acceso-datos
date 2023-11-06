package apartado1;

import java.io.*;

public class MainApartado1 {

    public static void main(String[] args) {
        var createDAT = new CrearArchivoDAT();
        var createXML = new CrearArchivoXML();

        String FILE_NAME = "empleados.dat";
        File f = new File(FILE_NAME);
        //Generamos el fichero dat:
        createDAT.generateFichero(FILE_NAME);
        //generamos el fichero xml:
        createXML.generateXML();

    }
}
