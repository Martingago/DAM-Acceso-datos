package main;

import com.db4o.*;
import com.db4o.config.Configuration;
import com.db4o.query.Query;
import java.io.File;

public class MainActividad {

    public static void main(String[] args) {

        File fichero = new File("BDJefeHijo");

        /*Este código anterior lo ponemos por si la base de datos ya existiera y quisiéramos empezar desde el principio.*/
        fichero.delete();
        Configuration config = Db4o.newConfiguration();
        ObjectContainer baseDatos = Db4o.openFile(config, "BDJefeHijo");
        // Aquí iría el código para almacenar los objetos Jefe y Hijo...
        baseDatos.store(new Jefe("Ángel", 5, 53, new Hijo("Gustavo", 7)));
        baseDatos.store(new Jefe("Nieves", 3, 45, new Hijo("Iván", 3)));
        baseDatos.store(new Jefe("Jesús", 3, 5, new Hijo("Noelia", 3)));
        baseDatos.store(new Jefe("Dolores", 5, 63, new Hijo("Sergio", 7)));
        baseDatos.store(new Jefe("Vicki", 3, 5, null));
        baseDatos.store(new Jefe("Fátima", 5, 63, new Hijo("Lidia", 27)));
        baseDatos.store(new Jefe("Juan Luís", 3, 5, null));
        baseDatos.store(new Jefe("Elena", 1, 42, new Hijo("David", 19)));
        baseDatos.store(new Jefe("Miguel", 20, 45, new Hijo("Paula", 3)));
        baseDatos.store(new Jefe("Jesús", 19, 44, new Hijo("Rubén", 12)));


        buscarMayoresQue(baseDatos, 55);
        incrementarEdadJefe(baseDatos, "Miguel");
        mostrarDatosJefe(baseDatos, "Miguel");
        eliminarJefeAntiguedad(baseDatos, 6);
        visualizarJefes(baseDatos);
        baseDatos.close();
        
    }

    /**
     * Muestra información sobre un jefe cuyo nombre ha sido pasado por
     * parámetro
     *
     * @param db
     * @param nombre
     */
    public static void mostrarDatosJefe(ObjectContainer db, String nombre) {
        Query query = db.query();
        query.constrain(Jefe.class);
        query.descend("nombre").constrain(nombre);
        ObjectSet result = query.execute();
        //Si el resultado está vacio se informa al usuario
        if (result.hasNext()) {
            Jefe jefe = (Jefe) result.next();
            System.out.println(jefe.toString());
        } else {
            System.out.println("No se ha encontrado ningún resultado para el nombre de: " + nombre);
        }
    }

    /**
     * Muestra los resultados en la base de datos del ObjectSet proporcionado
     *
     * @param objeto
     */
    public static void mostrarConsulta(ObjectSet objeto) {
        while (objeto.hasNext()) {
            System.out.println(objeto.next());
        }

    }

    /**
     * Funcion que realiza una comprobacion en la BBDD de aquellos Jefes con
     * edad mayor a la especificada
     *
     * @param db
     * @param edad
     */
    public static void buscarMayoresQue(ObjectContainer db, int edad) {
        Query query = db.query();
        query.constrain(Jefe.class);
        query.descend("edad").constrain(edad).greater();
        ObjectSet result = query.execute();
        mostrarConsulta(result);
    }

    /**
     * Incrementa la edad de un Jefe cuyo nombre es pasado como argumento
     *
     * @param db
     * @param nombre
     */
    public static void incrementarEdadJefe(ObjectContainer db, String nombre) {
        Query query = db.query();
        query.constrain(Jefe.class);
        query.descend("nombre").constrain(nombre);
        ObjectSet result = query.execute();
        //Si el resultado está vacio se informa al usuario
        if (result.hasNext()) {
            Jefe jefe = (Jefe) result.next();
            jefe.setEdad(jefe.getEdad() + 1);
            db.store(jefe);
            System.out.println("La edad de " + nombre + " ha sido incrementada en 1.");

        } else {
            System.out.println("No se ha encontrado ningún resultado para el nombre de: " + nombre);
        }

    }

    public static void eliminarJefeAntiguedad(ObjectContainer db, int anosTrabajados) {
        Query query = db.query();
        query.constrain(Jefe.class);
        query.descend("antiguedad").constrain(anosTrabajados).greater();
        ObjectSet result = query.execute();
        if(!result.hasNext()) System.out.println("No se han encontrado Jefes con antiguedad igual o superior a: " + anosTrabajados);
        while (result.hasNext()) {
            Jefe jefe = (Jefe) result.next();
            db.delete(jefe);
            System.out.println("Eliminado de la empresa: " + jefe);
        }
    }
    
    /**
     * Función que visualiza TODOS los jefes de la BBDD y sus hijos
     * @param db 
     */
    public static void visualizarJefes(ObjectContainer db){
         Query query = db.query();
        query.constrain(Jefe.class);
        ObjectSet result = query.execute();
        if(!result.hasNext()) System.out.println("No hay Jefes en la empresa");
        while(result.hasNext()){
            Jefe jefe = (Jefe) result.next();
            Hijo hijo = (Hijo) jefe.getHijo();
            System.out.println(jefe.toString() + " " + (hijo != null ? hijo.toString() : "No tiene hijos"));
        
        }
        
    }
}
