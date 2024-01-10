package connection;

import java.sql.*;

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
            System.out.println("El número total de tablas es: " + count);
        } catch (SQLException ex) {
            System.out.println("Error proceso de SQL: " + ex);
        }

    }

    public void mostrarInformacionTabla(Connection connection, String nombreTabla) {
        try {
            Statement statement = connection.createStatement();
            String consulta = "SELECT * FROM " + nombreTabla;

            //Se establece la consulta y se muestra el resultado por pantalla:
            ResultSet resultado = statement.executeQuery(consulta);
            //Obtener el numero de columnas para poder imprimir el valor de cada columna:
            ResultSetMetaData metaData = resultado.getMetaData();
            int columnas = metaData.getColumnCount();
            System.out.println("Mostrando datos de la tabla: " + nombreTabla + "\n");
            // Imprimir los nombres de las columnas
            for (int i = 1; i <= columnas; i++) {
                System.out.print(metaData.getColumnName(i) + " | ");
            }
            System.out.println("\n"); //salto de linea
            //imprime datos de cada columna
            while (resultado.next()) {
                for (int i = 1; i < columnas; i++) {
                    System.out.print(resultado.getString(i) + " | ");
                }
                System.out.println(""); //salto de linea
            }

        } catch (SQLException ex) {
            System.out.println("Error proceso de SQL: " + ex);
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
