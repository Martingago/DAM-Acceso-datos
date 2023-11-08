
package apartado2;

public class MainApartado2 {

    public static void main(String[] args) {
        // TODO code application logic here
        
        var leerDOM = new LeerXMLDoom();
        var leerSAX = new LeerXMLSAX();
        
        //Ejecuta la salida de codigo mediante DOM
        System.out.println("Lectura con DOM: ");
        leerDOM.leerDocumentoXMLconDOM();
        //Ejecuta la salida de codigo mediante SAX:
        System.out.println("Lectura con SAX:");
        leerSAX.readXMLwithSAX();
        
    }

}
