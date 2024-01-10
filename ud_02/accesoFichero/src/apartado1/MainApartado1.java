package apartado1;

public class MainApartado1 {

    public static void main(String[] args) {
        var createDAT = new CrearArchivoDAT();
        var createXML = new CrearArchivoXML();

        final String FILE_NAME = "empleados.dat";
        //Generamos el fichero dat:
        createDAT.generateFichero(FILE_NAME);
        //generamos el fichero xml:
        createXML.generateXML();

    }
}
