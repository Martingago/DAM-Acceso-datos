
package main.basedatosxml;

import javax.xml.transform.OutputKeys;
import org.xmldb.api.base.Collection;
import org.xmldb.api.base.XMLDBException;
import org.xmldb.api.modules.XMLResource;
import org.xmldb.api.DatabaseManager;
import org.xmldb.api.base.Database;
public class BaseDatosXML {

    private static String URI = "xmldb:exist://localhost:8080/exist/xmlrpc";
    private static String driver = "org.exist.xmldb.DatabaseImpl";

    public static void main(String args[]) throws XMLDBException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        // initialize database driver
        Class cl = Class.forName(driver); 
        Database database = (Database)cl.newInstance();
        DatabaseManager.registerDatabase(database);

        // get the collection
        Collection col = DatabaseManager.getCollection(URI + "/db/actividad");
        col.setProperty(OutputKeys.INDENT, "no");
        // get the XMLResource
        XMLResource res = (XMLResource)col.getResource("libros.xml");

        if(res == null) {
            System.out.println("El documento no se encontró!");
        } else {
            System.out.println((String) res.getContent());
        }

        // close the collection
        col.close();
    }
}
