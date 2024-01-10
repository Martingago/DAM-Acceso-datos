package apartado1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class CrearArchivoXML {
  
    /**
     * Funcion que crea un elemento hijo con un nombre definido y un valor (String) determinado
     * @param doc documento en que se va a generar el elemento hijo
     * @param name nombre de la etiqueta
     * @param value valor que tendrá la etiqueta
     * @return Element que se añadirá al DOC
     */
    public Element addStringChildElement(Document doc, String name, String value){
        Element child = doc.createElement(name);
        child.appendChild(doc.createTextNode(value));
        return child;
    }

    /**
     * Funcion que genera un documento llamado empleados.xml
     * Esta funcion buscará el archivo llamado "empleados.dat" en caso de no existir previamente devolverá error
     * Sobre éste archivo generará un xml con cada uno de los datos del archivo principal
     */
    public void generateXML() {
        try {
            //Se crea un randomAccesFile de lectura del fichero sobre el cual se quiere hacer el nuevo fichero
            RandomAccessFile rFile = new RandomAccessFile("empleados.dat", "r");

            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

            //Se crea un objeto Document el cual contendrá la raiz del XML: rootElement
            Document doc = docBuilder.newDocument(); //documento sobre el que se creará la base del XML
            Element rootElement = doc.createElement("empleados"); //elemento padre principal que englobará el XML
            doc.appendChild(rootElement); //Sobre la raiz se le añade el padre del documento
            
            //Se realiza un bucle while: Mientras existan datos en el fichero, se añadirán elementos en el XML
            while (rFile.getFilePointer() < rFile.length()) {
                //Se lee la información del fichero atendiendo al tipo de dato que se está
                //leyendo y en base al orden en el que se encuentran en el documento
                int codigo = rFile.readInt();
                String nombre = rFile.readUTF();
                String direccion = rFile.readUTF();
                float salario = rFile.readFloat();
                float comision = rFile.readFloat();
                //Tras leer los datos se crea dentro del elemento "empleados" un elemento hijo "empleado".
                //Sobre el elemento "empleado" utilizaremos la función creada anteriormente que nos permite añadir
                // un elemento hijo con un valor String en su interior
                Element empleado = doc.createElement("empleado");
                rootElement.appendChild(empleado);

                empleado.appendChild(addStringChildElement(doc, "codigo", Integer.toString(codigo)));
                empleado.appendChild(addStringChildElement(doc, "nombre", nombre));
                empleado.appendChild(addStringChildElement(doc, "direccion", direccion));
                empleado.appendChild(addStringChildElement(doc, "salario", Float.toString(salario)));
                empleado.appendChild(addStringChildElement(doc, "comision", Float.toString(comision)));
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes"); //Formatea la salida del XML
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("empleados.xml"));

            transformer.transform(source, result);
            System.out.println("Archivo XML creado");
        } catch (FileNotFoundException e) {
            System.out.println("Error, el fichero no existe" + e);
        } catch (ParserConfigurationException | IOException | TransformerException ex) {
            Logger.getLogger(CrearArchivoXML.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
