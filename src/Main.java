import java.awt.*;
import java.io.IOException;
import java.util.Scanner;


public class Main extends Component {

    public static void main(String[] args) throws IOException {
        int seleccion = 0;
        Scanner sc = new Scanner(System.in);

        while(seleccion != 5) {
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

                        break;
                    case 4:

                        break;
                    case 5:
                        System.out.println("Adios!");
                        break;
                    default:
                        System.out.println("Número no reconocido");break;
                }
            }catch(Exception e){
                System.out.println("Uoop! Error!");
            }
        }
    }

    public void CargarUsuarios(){

    }
}
