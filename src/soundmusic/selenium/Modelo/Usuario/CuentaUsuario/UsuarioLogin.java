package soundmusic.selenium.Modelo.Usuario.CuentaUsuario;

import java.util.Objects;


/**
 *
 * @author Santiago Medina Pelaez
 */
public class UsuarioLogin {

    private int idUsuarioLogin;
    private String nombreUsuario;
    private String contrasena;

    public UsuarioLogin() {
    }

    public UsuarioLogin(int idUsuarioLogin, String nombreUsuario, String contrasena) {
        this.idUsuarioLogin = idUsuarioLogin;
        this.nombreUsuario = nombreUsuario;
        this.contrasena = contrasena;        
    }

    public int getIdUsuarioLogin() {
        return idUsuarioLogin;
    }

    public void setIdUsuarioLogin(int idUsuarioLogin) {
        this.idUsuarioLogin = idUsuarioLogin;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UsuarioLogin other = (UsuarioLogin) obj;
        if (!Objects.equals(this.nombreUsuario, other.nombreUsuario)) {
            return false;
        }
        if (!Objects.equals(this.contrasena, other.contrasena)) {
            return false;
        }
        return true;
    }
    
    
}
