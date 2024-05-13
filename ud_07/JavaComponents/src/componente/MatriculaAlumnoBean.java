package componente;

import java.beans.*;
import java.io.Serializable;
import java.util.Vector;
import java.sql.*;
import java.sql.Statement;

public class MatriculaAlumnoBean implements Serializable {

    //Propiedades del componente
    private String DNI;
    private String NombreModulo;
    private String Curso;
    private double Nota;
    private Vector<Matricula> Matriculas = new Vector();
    
    private PropertyChangeSupport propertySupport;

    public MatriculaAlumnoBean() {
        propertySupport = new PropertyChangeSupport(this);
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

    public Vector getMatriculas() {
        return Matriculas;
    }
    
    //Clase auxiliar de las Matriculas:
    private class Matricula {

        String DNI;
        String NombreModulo;
        String Curso;
        Double Nota;

        public Matricula() {
        }

        public Matricula(String DNI, String NombreModulo, String Curso, Double Nota) {
            this.DNI = DNI;
            this.NombreModulo = NombreModulo;
            this.Curso = Curso;
            this.Nota = Nota;
        }

    }

    

    //Función que se conecta a la BBDD y crea un vector de Matriculas con la información extraida de la tabla Matriculas
    private void recargarFilas() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/actividad_ad", "root", "");
            Statement stat = con.createStatement();
            ResultSet rs = stat.executeQuery("select * from matriculas");
            while (rs.next()) {
                Matricula matricula = new Matricula(rs.getString("DNI"), rs.getString("NombreModulo"), rs.getString("Curso"), rs.getDouble("Nota"));
                Matriculas.add(matricula);
            }
            Matricula matricula = new Matricula();
            matricula = (Matricula) Matriculas.elementAt(1);
            this.DNI = matricula.DNI;
            this.NombreModulo = matricula.NombreModulo;
            this.Curso = matricula.Curso;
            this.Nota = matricula.Nota;

            rs.close();
            con.close();

        } catch (ClassNotFoundException ex) {
            System.out.println("Error clase no encontrada: " + ex);
        } catch (SQLException ex) {
            System.out.println("Error excepción Base de datos: " + ex);
        }
    }

    /**
     * Selecciona un elemento del Vector de matriculas en la posicion i
     *
     * @param i
     */
    public void seleccionarFila(int i) {
        if (i <= Matriculas.size()) {
            Matricula matricula = new Matricula();
            matricula = (Matricula) Matriculas.elementAt(i);
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

    public void seleccionarDNI(String nDNI) {
        Matricula matricula = new Matricula();
        int i = 0;
        this.DNI = "";
        this.NombreModulo = "";
        this.Curso = "";
        this.Nota = 0;

        while (this.DNI.equals("") && i < Matriculas.size()) {
            matricula = (Matricula) Matriculas.elementAt(i);
            if (matricula.DNI.equals(nDNI)) {
                this.DNI = matricula.DNI;
                this.NombreModulo = matricula.NombreModulo;
                this.Curso = matricula.Curso;
                this.Nota = matricula.Nota;
            }
        }
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertySupport.removePropertyChangeListener(listener);
    }

}
