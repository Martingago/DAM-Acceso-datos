package main;

import connection.ConnectionDB;
import exceptions.SQLCustomExceptions;
import exceptions.SQLHelper;
import java.sql.Connection;
import java.sql.SQLException;

public class Main_apartado_Extra {

    //Este apartado es extra puesto es lo que en un inicio habia pensado que era de lo que se trataba el apartado 6.
    //A los pocos días con tu aclaración de la actividad vi que me había confundido, pero igual manera he mantenido el código
    // y lo guardo como un apartado EXTRA :)
    public static void main(String[] args) throws SQLCustomExceptions {
        //Se crea la conexion con la BBDD
        //Si esta no funciona la aplicacion termina y no se ejecuta codigo. 
        //Comprueba que los usuarios y contraseñas coinciden con la BBDD (En principio debería)

        ConnectionDB connection = new ConnectionDB();
        Connection conexion = connection.testConnection();

        if (conexion != null) {
            try {
                //reemplazar valores FUMADOR pasajero
                System.out.println("EXTRA: buscar un parámetro y sustituirlo por otro en una columna y tabla especificada");
                connection.reemplaceAllValuesFromTable(conexion, "pasajeros", "FUMADOR", "SI", "NO");

                //cerrar la conexion
                conexion.close();
                System.out.println("Conexión cerrada");
            } catch (SQLException ex) {
                System.out.println("\033[31m" + SQLHelper.handleSQLException(ex) + "\033[0m");
                ex.printStackTrace();
            }
        } else {
            System.out.println("No te has contectado. \nFIN DEL PROGRAMA");
            System.out.println("Comprueba que las credenciales que se encuentran en connection.ConnectionDB.java están correctas!");
        }
    }

}
