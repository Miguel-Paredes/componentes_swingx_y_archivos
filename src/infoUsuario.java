import java.io.Serializable;

public class infoUsuario implements Serializable {
    private String usuario;
    private String contrasenia;

    public infoUsuario(){}
    public infoUsuario(String nombre, String contrasenia) {
        this.usuario = nombre;
        this.contrasenia = contrasenia;}

    public String getUsuario() {
        return usuario;}

    public void setUsuario(String usuario) {
        this.usuario = usuario;}

    public String getContrasenia() {
        return contrasenia;}

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;}
}
