import java.io.Serializable;

public class Usuario implements Serializable{


    private static final long serialVersionUID = 1L;
    private int id;
    private String nombre;
    private int edad;
    private String localidad;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
    public void setNombre(String nom) {nombre=nom;}
    public void setEdad(int ed) {edad=ed;}

    public String getNombre() {return nombre;}
    public int getEdad() {return edad;}
    public Usuario() {

    }
    public Usuario (int id, String nombre, int edad, String localidad) {
        this.id = id;
        this.nombre=nombre;
        this.edad=edad;
        this.localidad = localidad;
    }


}
