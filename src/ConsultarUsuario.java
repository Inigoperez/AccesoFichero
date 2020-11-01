import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import java.io.IOException;
import java.util.Scanner;

public class ConsultarUsuario {

    private static Scanner sc = new Scanner(System.in);

    public static void consultarUsuario() throws IOException, ParseException {

        //Recogemos todos los usuarios del JSON y los metemos en un array//
        JSONArray array = Lectura.vueltadatos();

        //Pedimos al usuario que inserte el ID del usuario a mostrar y lo recogemos en una variable//
        System.out.println("Introduce el ID del usuario que deseas mostrar: ");
        long idMos = sc.nextLong();

        //Hacemos un bucle al array de los usuarios, y cuando coincida el ID con el elegido por el usuario lo muestra//
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
