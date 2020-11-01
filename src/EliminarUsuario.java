import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import java.io.*;
import java.util.Scanner;

public class EliminarUsuario {

    private static Scanner sc = new Scanner(System.in);
    private  static JSONObject usuarios = new JSONObject();

    public static void eliminarUsuario() throws IOException, ParseException {

        //Traemos el array de usuarios //
        JSONArray array = Lectura.vueltadatos();

        //Pedimos el ID del usuario que queremos borrar//
        System.out.println("Introduce el ID del usuario que desees eliminar: ");
        long idElim = sc.nextLong();

        //Inicializamos la variable nombreElim para mostrar el  nombre del usuario eliminado al final//
        String nombreElim = "";
        int usuarioElim=0;

        //Creamos un bucle donde seleccionamos el usuario a eliminar y se elimina//
        for(int i=0;i<array.size();i++){
            long id = (long) ((JSONObject) array.get(i)).get("Id");
            if (id == idElim){
                usuarioElim = i;
                nombreElim = (String) ((JSONObject) array.get(i)).get("Nombre");
                try{
                    array.remove(usuarioElim);

                    BufferedWriter bw = new BufferedWriter(new FileWriter("usuarios.json"));

                    //Insertamos en el JSONObject el array de usuarios//
                    usuarios.put("usuarios",array);

                    //Insertamos el JSONObject usuarios al archivo JSON//
                    bw.write(usuarios.toJSONString());

                    bw.close();
                }catch (IOException e) {
                    System.out.println(e);
                }
                System.out.println("El usuario "+nombreElim+" ha sido eliminado");
            }
        }
    }

}
