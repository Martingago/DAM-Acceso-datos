package connection;

import exceptions.SQLCustomExceptions;
import java.sql.*;
import objetcs.VueloData;
import exceptions.SQLHelper;

public class ConnectionDB {

    private String bbdd_name = "bbdd_aeropuerto";
    private String url = "jdbc:mysql://localhost:3306/" + bbdd_name;
    private String user = "root";
    private String password = "martin1997";

    /**
     * Realiza una conexion con una BBDD y devuelve un objeto tipo Connection
     * con la informacion correspondiente En caso de producirse un error
     * devuelve null.
     *
     * @return objeto Connection
     */
    public Connection testConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println(e);

        }
        return connection;
    }

    /**
     * Funcion que recibe como parametro un objeto Connection, y obtiene
     * informacion especifica de la base de datos a la que se ha conectado:
     * listado de tablas, y numero de tablas totales
     *
     * @param connection
     */
    public void mostrarTablasBbdd(Connection connection) {
        DatabaseMetaData dt;
        try {
            dt = connection.getMetaData();
            ResultSet rs = dt.getTables(this.getBbdd_name(), null, "%", null);
            int count = 0;
            System.out.println("Listado de tablas:");
            while (rs.next()) {
                System.out.println("  - " + rs.getString(3));
                count++;
            }
            System.out.println("--------------------------------");
            System.out.println("El número total de tablas es: " + count + "\n");
        } catch (SQLException ex) {
            System.out.println("Error proceso de SQL: " + ex);
        }

    }

    /**
     * Funcion que muestra TODA la informacion de una tabla de una BBDD
     * específicada
     *
     * @param connection conexion a la BBDD
     * @param nombreTabla nombre de la tabla en la que se quieren ver los
     * resultados
     * @throws exceptions.SQLCustomExceptions
     */
    public void mostrarInformacionTabla(Connection connection, String nombreTabla) throws SQLCustomExceptions {
        try {
            Statement statement = connection.createStatement();
            String consulta = "SELECT * FROM " + nombreTabla;

            //Se establece la consulta y se muestra el resultado por pantalla:
            ResultSet resultado = statement.executeQuery(consulta);
            ResultSetMetaData metaData = resultado.getMetaData();

            //Obtener el numero de columnas para poder imprimir el valor de cada columna:
            int columnas = metaData.getColumnCount();

            System.out.println("Mostrando datos de la tabla: " + nombreTabla);
            printCabeceraTabla(metaData);

            //imprime datos de cada columna
            while (resultado.next()) {
                for (int i = 1; i <= columnas; i++) {
                    System.out.print(resultado.getString(i) + " | ");
                }
                System.out.println(""); //salto de linea
            }
            System.out.println(""); //salto de linea

        } catch (SQLException ex) {
            System.out.println("\033[31m" + SQLHelper.handleSQLException(ex) + "\033[0m");
            ex.printStackTrace();
        }
    }

    /**
     * Muestra la informacion de los pasajeros (tabla pasajeros) pasando como
     * parametro el codigo de vuelo
     *
     * @param connection
     * @param codigoVuelo
     */
    public void mostrarInformacionPasajerosVuelo(Connection connection, String codigoVuelo) throws SQLCustomExceptions {
        try {
            Statement statement = connection.createStatement();
            String consulta = "SELECT * FROM pasajeros WHERE COD_VUELO = '" + codigoVuelo + "'";

            //Se establece la consulta y se muestra el resultado por pantalla:
            ResultSet resultado = statement.executeQuery(consulta);
            ResultSetMetaData metaData = resultado.getMetaData();
            int columnas = metaData.getColumnCount();
            //Se imprime cabecera
            if (!resultado.next()) {
                System.out.println("\033[33mNo se han encontrado resultados para el vuelo: " + codigoVuelo + "\033[33m");
            } else {
                System.out.println("Mostrando resultados de pasajeros para el vuelo: " + codigoVuelo);
                printCabeceraTabla(metaData);

                while (resultado.next()) {
                    for (int i = 1; i <= columnas; i++) {
                        System.out.print(resultado.getString(i) + " | ");
                    }
                    System.out.println(""); //salto de linea
                }
            }

        } catch (SQLException ex) {
            System.out.println("\033[31m" + SQLHelper.handleSQLException(ex) + "\033[0m");
            ex.printStackTrace();
        }
    }

    /**
     * Realiza una inserción en la tabal de vuelos
     * @param connection objeto con la informacion de la conexion realizada
     * @param datosVuelo objeto que contiene los datos a introducir.
     */
    public void insertVuelo(Connection connection, VueloData datosVuelo) throws SQLCustomExceptions {
        try {
            Statement statement = connection.createStatement();
            String consulta = "INSERT INTO VUELOS(COD_VUELO, HORA_SALIDA, DESTINO, PROCEDENCIA, PLAZAS_FUMADOR, PLAZAS_NO_FUMADOR, PLAZAS_TURISTA, PLAZAS_PRIMERA) "
                    + "VALUES('" + datosVuelo.getCOD_VUELO() + "', '" + datosVuelo.getHORA_SALIDA() + "', '" + datosVuelo.getDESTINO() + "', '"
                    + datosVuelo.getPROCEDENCIA() + "', '" + datosVuelo.getPLAZAS_FUMADOR()
                    + "', '" + datosVuelo.getPLAZAS_NO_FUMADOR() + "', '" + datosVuelo.getPLAZAS_TURISTA() + "', '" + datosVuelo.getPLAZAS_PRIMERA() + "');";

            //Se ejecuta insercion de datos:
            int resultado = statement.executeUpdate(consulta);
            
            System.out.println("\033[32mNúmero de filas afectadas: " + resultado + "\033[0m");
        } catch (SQLException ex) {
            System.out.println("\033[31m" + SQLHelper.handleSQLException(ex) + "\033[0m");
            ex.printStackTrace();
        }

    }
    
    /**
     * funcion que elimina de la BBDD un vuelo que se ha pasado como parámetro
     * @param connection objeto de la conexion
     * @param identificador identificador del vuelo a eliminar
     * @throws exceptions.SQLCustomExceptions
     */
    
    public void deteleVuelo(Connection connection, String identificador) throws SQLCustomExceptions {
        try {
            Statement statement = connection.createStatement();
            String consulta = "DELETE FROM vuelos WHERE COD_VUELO = '" + identificador + "'";
            int resultado = statement.executeUpdate(consulta);
            
            if(resultado == 0){
                System.out.println("\033[33mNo se ha encontrado ningún elemento a eliminar\033[0m");
            }else{
                System.out.println("\033[32mNúmero de filas afectadas: " + resultado + "\033[0m");
            }
            
        } catch (SQLException ex) {
            System.out.println("\033[31m" + SQLHelper.handleSQLException(ex) + "\033[0m");
            ex.printStackTrace();
        }
    }
    
    /**
     * Funcion que busca en una tabla seleccionada => Columna seleccionada, un valor y lo sustituye por otro
     * @param connection
     * @param nombreTabla
     * @param columna
     * @param valorBuscar
     * @param valorReemplazar 
     * @throws exceptions.SQLCustomExceptions 
     */
    public void reemplaceAllValuesFromTable(Connection connection, String nombreTabla, 
            String columna, String valorBuscar, String valorReemplazar) throws SQLCustomExceptions{

        try{
        Statement statement = connection.createStatement();
        
        String consulta = "UPDATE " + nombreTabla + " SET " + columna
                + " = '" + valorReemplazar + "' WHERE " + columna + " = '" + valorBuscar + "';";
        
        int resultado = statement.executeUpdate(consulta);
            System.out.println("Número de columnas afectadas: "+ resultado);
        }catch(SQLException ex){
            System.out.println("\033[31m" + SQLHelper.handleSQLException(ex) + "\033[0m");
            ex.printStackTrace();
        }
    }
    
    

    //HOOKS PARA FUNCIONES GLOBALES
    /**
     * imprime la cabecera de una tabla
     *
     * @param tabla : ResultSetMetaData
     */
    public void printCabeceraTabla(ResultSetMetaData tabla) throws SQLCustomExceptions {
        try {
            int columnas = tabla.getColumnCount();
            // Imprimir los nombres de las columnas
            for (int i = 1; i <= columnas; i++) {
                System.out.print(tabla.getColumnName(i) + " | ");
            }
            System.out.println(""); //salto de linea
        } catch (SQLException ex) {
            System.out.println("\033[31m" + SQLHelper.handleSQLException(ex) + "\033[0m");
            ex.printStackTrace();
        }
    }

    //Getters de elementos informativos para el usuario
    public String getBbdd_name() {
        return bbdd_name;
    }

    public String getUser() {
        return user;
    }

}
