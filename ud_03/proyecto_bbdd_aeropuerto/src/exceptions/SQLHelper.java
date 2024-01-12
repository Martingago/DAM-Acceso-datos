package exceptions;

import java.sql.*;

public class SQLHelper {

    /**
     * Funcion que devuelve los errores producidos en consultas SQL de forma personalizada
     * Los errores que aun no hayan sido descubiertos se mostrarán el default
     * @param ex
     * @return
     * @throws SQLCustomExceptions 
     */
    public static String handleSQLException(SQLException ex) throws SQLCustomExceptions {
        int errorCode = ex.getErrorCode();
        String mensajeError = "";
        
        switch (errorCode) {
            case 1045:
                mensajeError = "Los datos de inicio de sesión no son correctos \n" + ex.getMessage();
                break;
            case 1146:
                mensajeError = "Error en la consulta, la tabla seleccionada no existe \n" + ex.getMessage();
                break;
            case 1054:
                mensajeError = "Error, la columna seleccionada no existe \n" + ex.getMessage();
                break;
            case  1451 : 
                mensajeError = "Ya existe una fila con esa clave principal \n" + ex.getMessage();
                break;
            default:
                mensajeError = "codigo de error: " + ex.getErrorCode() + "\n" + ex.getMessage();
                break;
        }
        return mensajeError;
    }

}
