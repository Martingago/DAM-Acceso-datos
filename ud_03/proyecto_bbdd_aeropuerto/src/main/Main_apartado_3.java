package main;

import connection.ConnectionDB;
import exceptions.SQLCustomExceptions;
import exceptions.SQLHelper;
import java.sql.Connection;
import java.sql.SQLException;

public class Main_apartado_3 {

    public static void main(String[] args) throws SQLCustomExceptions {
        //Se crea la conexion con la BBDD
        //Si esta no funciona la aplicacion termina y no se ejecuta codigo. 
        //Comprueba que los usuarios y contraseñas coinciden con la BBDD (En principio debería)

        ConnectionDB connection = new ConnectionDB();
        Connection conexion = connection.testConnection();

        if (conexion != null) {
            try {
                //Ver informacion pasajeros a través de un codigo_vuelo
                System.out.println("Apartado 3: Ver la información de los pasajeros de un vuelo");
                String buscar_vuelo = "IB-BA-46DC";
                connection.mostrarInformacionPasajerosVuelo(conexion, buscar_vuelo);

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
