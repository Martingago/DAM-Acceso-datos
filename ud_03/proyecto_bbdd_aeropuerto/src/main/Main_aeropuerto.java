package main;

import connection.ConnectionDB;
import java.sql.*;

public class Main_aeropuerto {

    public static void main(String[] args) {
        // TODO code application logic here
        ConnectionDB connection = new ConnectionDB();

        Connection conexion = connection.testConnection();

        if (conexion != null) {
         connection.mostrarTablasBbdd(conexion);
         
         String tabla = "pasajeros";
         connection.mostrarInformacionTabla(conexion, tabla);

        } else {
            System.out.println("No te has contectado");
        }
    }

}
