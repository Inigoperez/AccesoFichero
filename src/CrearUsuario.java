import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class CrearUsuario {

    private static Scanner sc = new Scanner(System.in);

    public static void crearUsuario() throws IOException, ParseException {
        System.out.println("error1");
        JSONObject obj = (JSONObject) new JSONParser().parse(new FileReader("usuarios.json"));
        System.out.println("error2");
        Iterator<Map.Entry> iteratorCampos = obj.entrySet().iterator();
        System.out.println("error3");
        Map.Entry parCampo = iteratorCampos.next();
        System.out.println("error4");
        JSONArray array = (JSONArray) parCampo.getValue();
        System.out.println("error5");
        JSONObject ultimoID = (JSONObject) array.get(array.size()-1);
        System.out.println(ultimoID.get("Id"));
        long id = (long) ultimoID.get("Id");


        JSONObject nuevoUsuario = new JSONObject();

        // putting data to JSONObject
        String nombre = "";
        String localiad = "";
        int edad = 0;
        do{
            System.out.println("Introduce el nombre de usuario: ");
            nombre = sc.next();
        }while ((nombre == null)||(nombre.equals("")));

        do{
            System.out.println("Introduce la localidad donde reside el usuario: ");
            localiad = sc.next();
        }while ((localiad == null)||(localiad.equals("")));

        do{
            System.out.println("Introduce la edad del usuario: ");
            edad = sc.nextInt();
        }while (edad <= 0 && edad >= 100);

        nuevoUsuario.put("Nombre", nombre);
        nuevoUsuario.put("Edad", edad);
        nuevoUsuario.put("Id", Math.toIntExact(id)+1);
        nuevoUsuario.put("Localidad", localiad);

        array.add(nuevoUsuario);

        JSONObject Users = new JSONObject();

        Users.put("usuarios",array);

        BufferedWriter bw = new BufferedWriter(new FileWriter("usuarios.json"));

        bw.write(Users.toJSONString());

        bw.close();

        System.out.println("Nuevo usuario añadido con exito");
    }
}
