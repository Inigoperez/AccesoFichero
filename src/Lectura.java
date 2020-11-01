import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.*;

public class Lectura {
    public static void leer() throws IOException {
        JSONObject jo = new JSONObject();
        Usuario persona;
        File fichero = new File("FichUsuarios.dat");
        FileInputStream filein = new FileInputStream(fichero);
        ObjectInputStream datIS = new ObjectInputStream(filein);
        JSONArray Lista = new JSONArray();


        try {
            while (true) {
                JSONObject object = new JSONObject();
                persona = (Usuario) datIS.readObject();
                object.put("Id",persona.getId());
                object.put("Nombre",persona.getNombre());
                object.put("Edad",persona.getEdad());
                object.put("Localidad",persona.getLocalidad());
                Lista.add(object);

                //System.out.println("ID:" + persona.getId() + ", Nombre:" + persona.getNombre() + ", Edad:" + persona.getEdad() + ", Localidad:" + persona.getLocalidad());

            }
        } catch (EOFException | ClassNotFoundException eo) {
            datIS.close();
        }
        jo.put("usuarios", Lista);
        // writing JSON to file:"JSONExample.json" in cwd
        PrintWriter pw = new PrintWriter("usuarios.json");
        pw.write(jo.toJSONString());

        pw.flush();
        pw.close();

    }
}