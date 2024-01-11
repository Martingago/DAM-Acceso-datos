package main;

import connection.ConnectionDB;
import exceptions.SQLCustomExceptions;
import java.sql.*;
import java.time.LocalDateTime;
import objetcs.AeropuertoEnum;
import objetcs.VueloData;

public class Main_aeropuerto {

    public static void main(String[] args) throws SQLCustomExceptions {
        // TODO code application logic here
        ConnectionDB connection = new ConnectionDB();

        Connection conexion = connection.testConnection();

        if (conexion != null) {
            connection.mostrarTablasBbdd(conexion);

            //mostrar datos tabla pasajeros
            String tabla = "pasajeros";
            connection.mostrarInformacionTabla(conexion, tabla);

            //buscar vuelo
            String codigo_vuelo = "AI-1289-99";
            //connection.mostrarInformacionPasajerosVuelo(conexion, codigo_vuelo);

            //añadir vuelo
            LocalDateTime fechaHora = LocalDateTime.of(2024, 1, 14, 20, 0);
            VueloData vuelo = new VueloData(codigo_vuelo, fechaHora,
                    AeropuertoEnum.BARCELONA, AeropuertoEnum.BRUSELAS, 0, 240, 220, 20);
            //Inserta un vuelo:
            connection.insertVuelo(conexion, vuelo);

            
            //Elimina un vuelo
            connection.deteleVuelo(conexion, codigo_vuelo);
            
            //connection.reemplaceAllValuesFromTable(conexion, "pasajeros", "FUMADOR", "SI", "NO");
            
        } else {
            System.out.println("No te has contectado");
        }
    }

}
