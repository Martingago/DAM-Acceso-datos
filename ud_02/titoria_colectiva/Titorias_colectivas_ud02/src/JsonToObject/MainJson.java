package JsonToObject;

public class MainJson {


    public static void main(String[] args) {
        ReadJSON lec = new ReadJSON();
        ObjectJSON dato = lec.functionReadJSON("./ficheros/exampleJSON.json");
        System.out.println(dato.toString());
    }
}
