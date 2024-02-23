
package main;

public class Jefe {
    private String nombre;
    private int edad;
    private int antiguedad;
    private Hijo hijo;
    public Jefe() {
        this.nombre = null;
        this.hijo = null;
    }

    public Jefe(String nombre,int anosEmpresa, int edad, Hijo hijo) {
        this.nombre = nombre;
        this.edad = edad;
        this.antiguedad = anosEmpresa;
        this.hijo = hijo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public Hijo getHijo() {
        return hijo;
    }

    public void setHijo(Hijo hijo) {
        this.hijo = hijo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Jefe{");
        sb.append("nombre=").append(nombre);
        sb.append(", edad=").append(edad);
        sb.append(", anosEmpresa=").append(antiguedad);
        sb.append('}');
        return sb.toString();
    }
    
    
    

}
