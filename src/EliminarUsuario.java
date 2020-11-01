import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class EliminarUsuario {
    private static Scanner sc = new Scanner(System.in);

    public static void eliminarUsuario() throws IOException, ParseException {
        JSONObject  obj = (JSONObject) new JSONParser().parse(new FileReader("usuarios.json"));
        Iterator<Map.Entry> iteratorCampos = obj.entrySet().iterator();
        Map.Entry parCampo = iteratorCampos.next();
        JSONArray array = (JSONArray) parCampo.getValue();

        System.out.println("Introduce el ID del usuario que desees eliminar: ");
        long idElim = sc.nextLong();
        String nombreElim = "";
        int usuarioElim=0;
        JSONObject usuarios = new JSONObject();
        for(int i=0;i<array.size();i++){
            long id = (long) ((JSONObject) array.get(i)).get("Id");
            if (id == idElim){
                usuarioElim = i;
                nombreElim = (String) ((JSONObject) array.get(i)).get("Nombre");
                try{
                    array.remove(usuarioElim);

                    BufferedWriter bw = new BufferedWriter(new FileWriter("usuarios.json"));

                    usuarios.put("usuarios",array);

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
