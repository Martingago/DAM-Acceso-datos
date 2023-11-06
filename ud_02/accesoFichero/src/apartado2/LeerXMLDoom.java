package apartado2;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class LeerXMLDoom {

        public void  leerDocumentoXMLconDOM(){

            try {
                File inputFile = new File("build\\classes\\apartado2\\lectura\\libros.xml");
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(inputFile);
                doc.getDocumentElement().normalize();
                System.out.println("Elemento raíz: " + doc.getDocumentElement().getNodeName());
                NodeList nList = doc.getElementsByTagName("libro");
                System.out.println("----------------------------");

                for (int temp = 0; temp < nList.getLength(); temp++) {
                    Node nNode = nList.item(temp);
                    System.out.println("\nElemento actual: " + nNode.getNodeName());
                    if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                        Element eElement = (Element) nNode;
                        System.out.println("Año: " + eElement.getAttribute("año"));
                        System.out.println("Título: " + eElement.getElementsByTagName("titulo").item(0).getTextContent());
                        System.out.println("Autor: " + eElement.getElementsByTagName("autor").item(0).getTextContent());
                        System.out.println("Editorial: " + eElement.getElementsByTagName("editorial").item(0).getTextContent());
                        System.out.println("Precio: " + eElement.getElementsByTagName("precio").item(0).getTextContent());
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
