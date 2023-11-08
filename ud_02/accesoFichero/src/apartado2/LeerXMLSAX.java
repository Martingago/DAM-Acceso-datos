package apartado2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;

public class LeerXMLSAX {
    
    /**
     * Función que lee un archivo XML empleado SAX.
     * La funcion lee por defecto el arhivo de libros que se encuentra en la ruta especificada
     * y muestra por consola el resultado de la operación
     */
    public void readXMLwithSAX() {
        try {
            FileReader fr = new FileReader("build\\classes\\apartado2\\lectura\\libros.xml");
            XMLInputFactory xmlif = XMLInputFactory.newInstance();
            XMLStreamReader xmlsr = xmlif.createXMLStreamReader(fr);
            String tag = null;
            int eventType;
            System.out.println("Listado de libros:");
            while (xmlsr.hasNext()) {
                eventType = xmlsr.next();
                switch (eventType) {
                    case XMLEvent.START_ELEMENT -> {
                        tag = xmlsr.getLocalName();
                        if (tag.equals("libro")) {
                            System.out.println("año: " + xmlsr.getAttributeValue(0));
                        }else if(tag.equals("editorial") || tag.equals("titulo") || tag.equals("precio")){
                            System.out.println(xmlsr.getElementText());
                        }else if (tag.equals("nombre") || tag.equals("apellido")) {
                            System.out.println("Autor " + tag + ": " + xmlsr.getElementText());
                        }
                    }
                    case XMLEvent.END_DOCUMENT -> System.out.println("Fin del documento");
                }
            }

        }catch (FileNotFoundException e){
            System.out.println("Error el archivo no se ha encontrado \n" + e);
        } catch (XMLStreamException ex) {
            System.out.println("Error de salida: " + ex);
        }

    }

}
