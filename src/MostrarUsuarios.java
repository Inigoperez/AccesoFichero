import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class MostrarUsuarios {

    public static void listarUsuarios(){
        Object obj = null;
        try {
            obj = new JSONParser().parse(new FileReader("usuarios.json"));
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        // typecasting obj to JSONObject
        JSONObject jo = (JSONObject) obj;

        // getting firstName and lastName
        String firstName = (String) jo.get("Nombre");
        String id = (String) jo.get("Id");
        String localidad = (String) jo.get("Localidad");
        String edad = (String) jo.get("Edad");

        System.out.println(firstName);
        System.out.println(id);
        System.out.println(localidad);
        System.out.println(edad);

        }
    }

