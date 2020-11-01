import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class MostrarUsuarios {

    public static void listarUsuarios() throws IOException, ParseException {
        JSONArray array = Lectura.vueltadatos();
        for(int i=0;i<array.size();i++){
            JSONObject persona = (JSONObject) array.get(i);
            System.out.println("----------------------------------");
            System.out.println("ID: "+persona.get("Id"));
            System.out.println("Nombre: "+persona.get("Nombre"));
            System.out.println("Edad: "+persona.get("Edad"));
            System.out.println("Localidad: "+persona.get("Localidad"));
            System.out.println("----------------------------------");
        }
    }
}

