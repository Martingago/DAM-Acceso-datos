package main;

import connection.ConnectionDB;
import exceptions.SQLCustomExceptions;
import exceptions.SQLHelper;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import objetcs.AeropuertoEnum;
import objetcs.VueloData;

public class Main_apartado_4 {

    public static void main(String[] args) throws SQLCustomExceptions {
        //Se crea la conexion con la BBDD
        //Si esta no funciona la aplicacion termina y no se ejecuta codigo. 
        //Comprueba que los usuarios y contraseñas coinciden con la BBDD (En principio debería)

        ConnectionDB connection = new ConnectionDB();
        Connection conexion = connection.testConnection();

        if (conexion != null) {
            try {
                String codigo_vuelo = "AI-1289-00"; //codigo de vuelo para insertar y eliminar posteriormente

                //Aqui se crea un objeto tipo VueloData que contiene la informacion que se añadirá a la BBDD.
                //Se emplea el string de codigo_vuelo definido anteriormente en la creación del objeto VueloData
                LocalDateTime fechaHora = LocalDateTime.of(2024, 1, 14, 20, 0);
                VueloData vuelo = new VueloData(codigo_vuelo, fechaHora,
                        AeropuertoEnum.BARCELONA, AeropuertoEnum.BRUSELAS, 0, 240, 220, 20);

                //Inserta un vuelo:
                System.out.println("\nApartado 4: Insertar un vuelo cuyos valores se pasan como parámetros. [Objeto vuelo]");
                connection.insertVuelo(conexion, vuelo);

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
