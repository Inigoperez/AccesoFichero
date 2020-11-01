import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class ConsultarUsuario {

    private static Scanner sc = new Scanner(System.in);

    public static void consultarUsuario() throws IOException, ParseException {
        JSONArray array = Lectura.vueltadatos();

        System.out.println("Introduce el ID del usuario que deseas mostrar: ");
        long idMos = sc.nextLong();

        for(int i=0;i<array.size();i++){
            long id = (long) ((JSONObject) array.get(i)).get("Id");
            if (id == idMos){
                System.out.println("USUARIO :");
                System.out.println("-------------");
                System.out.println("Nombre: "+((JSONObject) array.get(i)).get("Nombre"));
                System.out.println("Edad: "+((JSONObject) array.get(i)).get("Edad"));
                System.out.println("Localidad: "+((JSONObject) array.get(i)).get("Localidad"));
                System.out.println("-------------");
            }
        }
    }
}
