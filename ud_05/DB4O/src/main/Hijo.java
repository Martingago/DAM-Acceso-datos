package main;

public class Hijo {
    private String nombre;
    private int edad;

    public Hijo() {
    }

    public Hijo(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hijo{");
        sb.append("nombre=").append(nombre);
        sb.append(", edad=").append(edad);
        sb.append('}');
        return sb.toString();
    }
    
    
    
    
}
