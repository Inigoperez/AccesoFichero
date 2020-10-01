import java.awt.*;
import java.io.IOException;
import java.util.Scanner;


public class Main extends Component {

    public static void main(String[] args) throws IOException {
        Lectura.leer();
        int seleccion = 0;
        Scanner sc = new Scanner(System.in);

        while(seleccion != 5) {
            try{
                System.out.println("Elige opción:\n1.- Mostrar usuarios" + "\n2.- Añadir usuario\n" + "3.- Eliminar usuario (mediante ID)\n" + "4.- Informacion de usuario (mediante ID)\n" + "5.- Cambiar nombre usuario (Mediante ID)\n"+"5.- Salir");
                seleccion = sc.nextInt();

                //Ejemplo de switch case en Java
                switch(seleccion){
                    case 1:

                        break;
                    case 2:

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
