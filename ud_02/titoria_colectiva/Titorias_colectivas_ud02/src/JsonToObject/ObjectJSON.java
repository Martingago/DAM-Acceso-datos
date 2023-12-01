package JsonToObject;

public class ObjectJSON {

    private String nombre;
    private int edad;
    private String[] descendencia;
    
    
    public ObjectJSON(){}
    
    /**
     * Convierte los parámetros recibidos en un objeto
     * @param nombre
     * @param edad
     * @param descendientes 
     */
    public ObjectJSON(String nombre, int edad, String[] descendientes){
        this.nombre = nombre;
        this.edad = edad;
        this.descendencia = descendientes;
    }

    public String[] getDescendientes() {
        return descendencia;
    }

    public void setDescendientes(String[] descendientes) {
        this.descendencia = descendientes;
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
        return "ObjectJSON{" + "nombre=" + nombre + ", edad=" + edad + ", descencia=" + descendencia + '}';
    }
    
}
