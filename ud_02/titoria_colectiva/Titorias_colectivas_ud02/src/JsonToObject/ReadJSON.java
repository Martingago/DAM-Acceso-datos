package JsonToObject;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import java.io.BufferedReader;
import java.io.*;

public class ReadJSON {

    public ObjectJSON functionReadJSON(String path) {
        JsonReader reader = null;
        ObjectJSON datos = null;
        //Crear un file y verificar que dicho file existe
        try {
            FileInputStream stream = new FileInputStream(path);
            InputStreamReader r = new InputStreamReader(stream);
            //leer datos del file
            BufferedReader br = new BufferedReader(r);

            //Obtener datos, atribuirlo a variables y crear un objeto: "ObjectJSON".
            reader = new JsonReader(br);
            datos = new Gson().fromJson(reader, ObjectJSON.class);        
        } catch (FileNotFoundException ex) {
            System.out.println("Error, fichero no encontrado");
        }
        return datos;
    }

}
