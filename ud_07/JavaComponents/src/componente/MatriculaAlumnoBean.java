package componente;

import java.beans.*;
import java.io.Serializable;
import java.util.Vector;
import java.sql.*;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MatriculaAlumnoBean implements Serializable {

    //Propiedades del componente
    private String DNI;
    private String NombreModulo;
    private String Curso;
    private double Nota;

    private Vector<Matricula> matriculas = new Vector();
    private GestorEventosMatricula eventos;

    private PropertyChangeSupport propertySupport;

    public MatriculaAlumnoBean() {
        propertySupport = new PropertyChangeSupport(this);
        eventos = new GestorEventosMatricula();
        eventos.inicializarListeners();
        recargarFilas();

    }

    //Getters y setters
    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombreModulo() {
        return NombreModulo;
    }

    public void setNombreModulo(String NombreModulo) {
        this.NombreModulo = NombreModulo;
    }

    public String getCurso() {
        return Curso;
    }

    public void setCurso(String Curso) {
        this.Curso = Curso;
    }

    public double getNota() {
        return Nota;
    }

    public void setNota(double Nota) {
        this.Nota = Nota;
    }




    /**
     * Función que se conecta a la BBDD y crea un vector de Matriculas con la
     * información extraida de la tabla Matriculas Es decir, esta función va a
     * cargar TODAS las matriculas existentes en el sistema.
     */
    public void recargarFilas() {
        try {
            matriculas.clear(); //Se limpian las matriculas
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/actividad_ad", "root", "");
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery("select * from matriculas");
            while (rs.next()) {
                Matricula matricula = new Matricula(rs.getString("DNI"), rs.getString("NombreModulo"), rs.getString("Curso"), rs.getDouble("Nota"));
                matriculas.add(matricula);
            }
            if (!matriculas.isEmpty()) {
                Matricula matricula = matriculas.firstElement();
                this.DNI = matricula.DNI;
                this.Nota = matricula.Nota;
                this.Curso = matricula.Curso;
                this.NombreModulo = matricula.NombreModulo;
            }

            rs.close();
            con.close();
            eventos.lanzarMatriculaEvent("matriculasRecargadaSistema");

        } catch (ClassNotFoundException ex) {
            System.out.println("Error clase no encontrada: " + ex);
        } catch (SQLException ex) {
            System.out.println("Error excepción Base de datos: " + ex);
        }
    }

    /**
     * Selecciona un elemento del Vector de matriculas en la posicion i y lo
     * establece como valores determinados del componente
     *
     * @param i
     */
    public void seleccionarFila(int i) {

        if (i <= matriculas.size()) {
            Matricula matricula = matriculas.elementAt(i);
            this.DNI = matricula.DNI;
            this.NombreModulo = matricula.NombreModulo;
            this.Curso = matricula.Curso;
            this.Nota = matricula.Nota;
        } else {
            this.DNI = "";
            this.NombreModulo = "";
            this.Curso = "";
            this.Nota = 0;
        }
    }

    /**
     * Función que recarga el valor del Vector de Matriculas con los datos de un
     * DNI específicado en el componente.
     */
    public void recargarDNI() {
        matriculas.clear(); //Se limpian las matriculas
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/actividad_ad", "root", "");
            Statement stat = con.createStatement();
            String query = "SELECT * FROM matriculas WHERE DNI = ?";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, this.DNI);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Matricula matricula = new Matricula(rs.getString("DNI"),
                        rs.getString("NombreModulo"),
                        rs.getString("Curso"),
                        rs.getDouble("Nota"));
                matriculas.add(matricula);
            }
            rs.close();
            con.close();
            //Se actualiza el modo a "matriculasRecargadaEspecifica" para que se muestre una notificación de que estamos cargando matriculas de un usuario específico.
            eventos.lanzarMatriculaEvent("matriculasRecargadaEspecifica");
        } catch (ClassNotFoundException ex) {
            System.out.println("Clase no encontrada: " + ex);
        } catch (SQLException ex) {
            System.out.println("Excepción en la solicitud SQL: " + ex);
        }

    }

    /**
     * Funcion que agrega una matricula a la BBDD y emite un evento de
     * actualización.
     */
    public void addMatricula() {
        Matricula newMatricula = new Matricula(this.DNI, this.NombreModulo, this.Curso, this.Nota);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/actividad_ad", "root", "");
            Statement stat = con.createStatement();
            String query = "INSERT INTO matriculas (DNI, NombreModulo, Curso, Nota) VALUES ('" + this.DNI + "', '" + this.NombreModulo + "', '" + this.Curso + "', " + this.Nota + ")";
            stat.executeUpdate(query); //Se ejecuta la sentencia de datos en la BBDD
            matriculas.add(newMatricula); // Se añade la matricula al vector solo si la inserción en la base de datos es exitosa
            // Se crea un evento con la nueva matricula añadida:
            eventos.lanzarMatriculaEvent("matriculaAgregada");
            con.close(); // Se cierra la conexion
        } catch (ClassNotFoundException ex) {
            System.out.println("Clase no encontrada: " + ex);
        } catch (SQLException ex) {
            System.out.println("Excepción en el código SQL: " + ex);
        }

    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }

    /**
     * Funcion que muestra por pantalla y devuelve una lista de Matriculas
     *
     * @return Vector de matriculas
     */
    public Vector<Matricula> listarMatriculas() {
        for (Matricula matricula : matriculas) {
            System.out.println(matricula.getDNI() + ", " + matricula.getNombreModulo() + ", " + matricula.getCurso() + ", " + matricula.getNota());
        }
        return matriculas;
    }

}
