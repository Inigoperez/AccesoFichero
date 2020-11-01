import java.awt.*;
import java.io.IOException;
import java.util.Scanner;

public class Main extends Component {

    public static void main(String[] args) throws IOException {
        int seleccion = 0;
        Scanner sc = new Scanner(System.in);

        while(seleccion != 7) {
            try{
                System.out.println("Elige opción:\n1.- Cargar usuarios" + "\n2.- Mostrar usuarios\n" + "3.- Añadir usuario nuevo\n" + "4.- Eliminar usuario (mediante ID)\n" + "5.- Detalles de usuario (Mediante ID)\n"+"6.- Modificar Nombre de usuario (mediante ID)\n"+"7.- Salir");
                seleccion = sc.nextInt();

                //Ejemplo de switch case en Java
                switch(seleccion){
                    case 1:
                        Lectura.leer();
                        break;
                    case 2:
                        MostrarUsuarios.listarUsuarios();
                        break;
                    case 3:
                        CrearUsuario.crearUsuario();
                        break;
                    case 4:
                        EliminarUsuario.eliminarUsuario();
                        break;
                    case 5:
                        ConsultarUsuario.consultarUsuario();
                        break;
                    case 6:
                        EditarUsuario.editarUsuario();
                        break;
                    case 7:
                        System.out.println("Adios!");
                        break;
                    default:
                        System.out.println("Número no reconocido");
                        break;
                }
            }catch(Exception e){
                System.out.println("Uoop! Error!");
            }
        }
    }

    public void CargarUsuarios(){

    }
}
