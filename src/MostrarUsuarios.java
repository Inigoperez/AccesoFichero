import org.json.JSONArray;
import org.json.JSONException;
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
        JSONParser parser = new JSONParser();
        try{
            System.out.println("ERROR_0");
            Object obj = parser.parse(new FileReader("usuarios.json"));
            System.out.println("ERROR_1");
            JSONObject jsonObject = (JSONObject) obj;
            System.out.println("ERROR_2");
            System.out.println("Json leido"+jsonObject);
            System.out.println("ERROR_3");
            JSONArray array = (JSONArray) jsonObject.get("usuarios"); //No recoge datos, recoge null//
            System.out.println("ERROR_4");

            for(int i=0 ; i<array.length() ; i++){
                System.out.println("ERROR_5");
                JSONObject jsonObject1 = (JSONObject) array.get(i);
                System.out.println("Datos de usuario: "+i);
                System.out.println("ID: "+jsonObject1.get("id"));
                System.out.println("Nombre :"+jsonObject1.get("Nombre"));
                System.out.println("Edad :"+jsonObject1.get("Edad"));
                System.out.println("Localidad :"+jsonObject1.get("Localidad"));
            }
        }
        catch (FileNotFoundException e){}
        catch (IOException e){}
        catch (ParseException e){}
        catch (JSONException e) {
            e.printStackTrace();
        }
    }
}

