import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class EditarUsuario {

    private static Scanner sc = new Scanner(System.in);
    private static JSONObject usuarios = new JSONObject();

    public static void editarUsuario() throws IOException, ParseException {
        JSONArray array = Lectura.vueltadatos();

        System.out.println("Introduce el ID del usuario que deseas modificar: ");
        long idMod = sc.nextLong();

        for (int i = 0; i < array.size(); i++) {
            long id = (long) ((JSONObject) array.get(i)).get("Id");
            if (id == idMod) {
                String nombre = "";
                do {
                    System.out.println("Introduce el nombre de usuario: ");
                    nombre = sc.next();
                } while ((nombre == null) || (nombre.equals("")));

                ((JSONObject) array.get(i)).put("Nombre", nombre);

            }
        }

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("usuarios.json"));

            usuarios.put("usuarios",array);
            bw.write(usuarios.toJSONString());

            bw.close();
        } catch (IOException e) {
            System.out.println(e);
        }
        System.out.println("El usuario con el ID: " + idMod + " ha sido modificado");
    }
}
