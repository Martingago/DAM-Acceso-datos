package apartado2;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class LeerXMLDoom {

    public void leerDocumentoXMLconDOM() {

        try {
            File inputFile = new File("build\\classes\\apartado2\\lectura\\libros.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Elemento raíz: " + doc.getDocumentElement().getNodeName());
            NodeList nodeListLibros = doc.getElementsByTagName("libro");
            System.out.println("----------------------------");

            for (int temp = 0; temp < nodeListLibros.getLength(); temp++) {
                Node nodeLibro = nodeListLibros.item(temp);
                System.out.println("\nElemento actual: " + nodeLibro.getNodeName());
                if (nodeLibro.getNodeType() == Node.ELEMENT_NODE) {
                    //Extraemos cada atributo (Element) de cada node de libro:
                    Element atributo = (Element) nodeLibro;
                    System.out.println("Año: " + atributo.getAttribute("año"));
                    System.out.println("Título: " + atributo.getElementsByTagName("titulo").item(0).getTextContent());
                    System.out.println("Autor: ");
                    //Hacemos un listado (nodeList) con todos los "autor" que puede tener un libro
                    NodeList nodeListAutores = atributo.getElementsByTagName("autor");
                    for (int i = 0; i < nodeListAutores.getLength(); i++) {
                        Node nodeAutor = nodeListAutores.item(i);
                        if (nodeAutor.getNodeType() == Node.ELEMENT_NODE) {
                            Element atributoAutor = (Element) nodeAutor;
                            System.out.println("    Apellido: " + atributoAutor.getElementsByTagName("apellido").item(0).getTextContent()
                                    + ", nombre: "
                                    + atributoAutor.getElementsByTagName("apellido").item(0).getTextContent());
                        }
                    }

                    System.out.println("Editorial: " + atributo.getElementsByTagName("editorial").item(0).getTextContent());
                    System.out.println("Precio: " + atributo.getElementsByTagName("precio").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
