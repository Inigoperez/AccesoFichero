import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CrearUsuario {

    private static Scanner sc = new Scanner(System.in);

    public static void crearUsuario() throws IOException, ParseException {

        //Recogemos todos los usuarios del JSON y los metemos en un array//
        JSONArray array = Lectura.vueltadatos();

        //Sacamos el ID mas alto de la lista de usuarios y lo metemos en una variable//
        JSONObject ultimoID = (JSONObject) array.get(array.size()-1);
        long id = (long) ultimoID.get("Id");

        //Creamos un nuevo JSONObject donde insertaremos los datos del nuevo usuario//
        JSONObject nuevoUsuario = new JSONObject();

        //Inicializamos las variables que tendrá el usuario//
        String nombre = "";
        String localiad = "";
        int edad = 0;

        //Pedimos la información al usuario y no le dejamos dejar vacio los campos//
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

        //Insertamos dentro del JSONObject el nuevo usuario con sus datos//
        nuevoUsuario.put("Nombre", nombre);
        nuevoUsuario.put("Edad", edad);
        nuevoUsuario.put("Id", Math.toIntExact(id)+1);
        nuevoUsuario.put("Localidad", localiad);

        //Añadimos el nuevo usuario a la lista de usuarios//
        array.add(nuevoUsuario);

        //Creamos un JSONObject Users donde insertaremos la lista de usuarios//
        JSONObject Users = new JSONObject();

        //Insertamos en el objeto Usuarios la lista de usuarios//
        Users.put("usuarios",array);

        BufferedWriter bw = new BufferedWriter(new FileWriter("usuarios.json"));

        //Insertamos en el documento JSON el objeto Usuarios//
        bw.write(Users.toJSONString());

        bw.close();

        System.out.println("Nuevo usuario añadido con exito");
    }
}
