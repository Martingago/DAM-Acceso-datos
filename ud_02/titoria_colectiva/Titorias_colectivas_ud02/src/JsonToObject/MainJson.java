package JsonToObject;

public class MainJson {


    public static void main(String[] args) {
        ReadJSON lectura = new ReadJSON();
        ObjectJSON dato = lectura.functionReadJSON("./ficheros/exampleJSON.json");
        System.out.println(dato.toString());
    }
}
