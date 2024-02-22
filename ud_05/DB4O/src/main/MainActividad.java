package main;

import com.db4o.*;
import com.db4o.config.Configuration;
import com.db4o.query.Query;
import java.io.File;

public class MainActividad {

    public static void main(String[] args) {

        File fichero = new File("baseDatos");
        fichero.delete();
        /*Este código anterior lo ponemos por si la base de datos ya existiera y quisiéramos empezar desde el principio.*/
        fichero.delete();
        Configuration config = Db4o.newConfiguration();
        ObjectContainer baseDatos = Db4o.openFile(config, "BDJefeHijo");
                // Aquí iría el código para almacenar los objetos Jefe y Hijo...

        // Visualiza los jefes que tengan más de 55 años.
        Query query = baseDatos.query();
        query.constrain(Jefe.class);
        query.descend("edad").constrain(55).greater();
        ObjectSet<Jefe> result = query.execute();
        System.out.println("Jefes con más de 55 años:");
        for (Jefe jefe : result) {
            System.out.println(jefe);
        }

        // Modifica la edad de Miguel incrementando su edad un año más.
        Query queryMiguel = baseDatos.query();
        queryMiguel.constrain(Jefe.class);
        queryMiguel.descend("nombre").constrain("Miguel");
        ObjectSet<Jefe> resultMiguel = queryMiguel.execute();
        if (!resultMiguel.isEmpty()) {
            Jefe miguel = resultMiguel.next();
            miguel.setEdad(miguel.getEdad() + 1);
            baseDatos.store(miguel);
            System.out.println("La edad de Miguel ha sido incrementada.");
        }

        // Borra los jefes que llevan más de 6 años en la empresa.
        Query queryAntiguos = baseDatos.query();
        queryAntiguos.constrain(Jefe.class);
        queryAntiguos.descend("antiguedad").constrain(6).greater();
        ObjectSet<Jefe> resultAntiguos = queryAntiguos.execute();
        for (Jefe jefe : resultAntiguos) {
            baseDatos.delete(jefe);
        }
        System.out.println("Los jefes que llevan más de 6 años en la empresa han sido borrados.");

        // Visualiza todos los jefes que quedan, incluidos sus hijos, que no han sido borrados anteriormente.
        Query queryTodos = baseDatos.query();
        queryTodos.constrain(Jefe.class);
        ObjectSet<Jefe> resultTodos = queryTodos.execute();
        System.out.println("Jefes restantes:");
        for (Jefe jefe : resultTodos) {
            System.out.println(jefe);
        }

        baseDatos.close();
    }

}
