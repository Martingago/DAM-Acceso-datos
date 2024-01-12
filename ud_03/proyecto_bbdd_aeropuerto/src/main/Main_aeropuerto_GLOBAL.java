package main;

import connection.ConnectionDB;
import exceptions.SQLCustomExceptions;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetcs.AeropuertoEnum;
import objetcs.VueloData;

public class Main_aeropuerto_GLOBAL {

    public static void main(String[] args) throws SQLCustomExceptions {
        
        //Ejecuta todos los apartados de la actividad en un único main
        ConnectionDB connection = new ConnectionDB();
        Connection conexion = connection.testConnection();

        if (conexion != null) {
            
            //Mostrar datos generales de la tabla
            System.out.println("Apartado 1: Mostrar datos generales de la BBDD [Nombre de las tablas y total de tablas]");
            connection.mostrarTablasBbdd(conexion);

            
            //mostrar datos tabla pasajeros
            System.out.println("Apartado 2: Mostrar datos de la tabla pasajeros");
            String tabla = "pasajeros";
            connection.mostrarInformacionTabla(conexion, tabla);

            //Ver informacion pasajeros a través de un codigo_vuelo
            System.out.println("Apartado 3: Ver la información de los pasajeros de un vuelo");
            String buscar_vuelo = "IB-BA-46DC";
            connection.mostrarInformacionPasajerosVuelo(conexion, buscar_vuelo);

            String codigo_vuelo = "AI-1289-99"; //codigo de vuelo para insertar y eliminar posteriormente
            
            //Aqui se crea un objeto tipo VueloData que contiene la informacion que se añadirá a la BBDD.
            //Se emplea el string de codigo_vuelo definido anteriormente en la creación del objeto VueloData
            LocalDateTime fechaHora = LocalDateTime.of(2024, 1, 14, 20, 0);
            VueloData vuelo = new VueloData(codigo_vuelo, fechaHora,
                    AeropuertoEnum.BARCELONA, AeropuertoEnum.BRUSELAS, 0, 240, 220, 20);

            //Inserta un vuelo:
            System.out.println("\nApartado 4: Insertar un vuelo cuyos valores se pasan como parámetros. [Objeto vuelo]");
            connection.insertVuelo(conexion, vuelo);

            //Elimina un vuelo
            System.out.println("\nApartado 5: Eliminar vuelo que se metió anteriormente");
            connection.deteleVuelo(conexion, codigo_vuelo);

            //cambiar asientos fumadores
            System.out.println("\nApartado: 6: Modificar los vuelos de fumadores a no fumadores");
            connection.ajustarPlazasFumadores(conexion);

            //reemplazar valores FUMADOR pasajero
            System.out.println("EXTRA: buscar un parámetro y sustituirlo por otro en una columna y tabla especificada");
            connection.reemplaceAllValuesFromTable(conexion, "pasajeros", "FUMADOR", "SI", "NO");

            
            try {
                conexion.close();
                System.out.println("Conexion cerrada!");
            } catch (SQLException ex) {
                System.out.println("Error: " + ex);
            }
            System.out.println("");
        } else {
            System.out.println("No te has contectado. \nFIN DEL PROGRAMA");
            System.out.println("Comprueba que las credenciales que se encuentran en connection.ConnectionDB.java están correctas!");
        }
    }

}
