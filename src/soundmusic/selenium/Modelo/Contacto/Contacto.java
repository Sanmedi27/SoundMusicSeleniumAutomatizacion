package soundmusic.selenium.Modelo.Contacto;

import java.util.Objects;
import soundmusic.selenium.Modelo.Contacto.Ciudad.Ciudad;

/**
 *
 * @author Santiago Medina Pelaez
 */
public class Contacto {

    private int idContacto;
    private String celular;
    private String telefono;
    private String direccion;
    private String barrio;
    private String email;
    private Ciudad ciudad;

    public Contacto() {
        this.ciudad = new Ciudad();
    }

    public Contacto(int idContacto, String celular, String email, int idCiudad) {
        this.idContacto = idContacto;
        this.celular = celular;
        this.email = email;
        this.ciudad = new Ciudad();
        this.ciudad.setIdCiudad(idCiudad);
    }

    public Contacto(int idContacto, String[] datosContacto, int idCiudad) {
        this.idContacto = idContacto;
        this.celular = datosContacto[0];
        this.telefono = datosContacto[1];
        this.direccion = datosContacto[2];
        this.barrio = datosContacto[3];
        this.email = datosContacto[4];
        this.ciudad = new Ciudad();
        this.ciudad.setIdCiudad(idCiudad);
    }

    public Contacto(int idContacto, String celular, String telefono,
            String direccion, String barrio, String email) {
        this.idContacto = idContacto;
        this.celular = celular;
        this.telefono = telefono;
        this.direccion = direccion;
        this.barrio = barrio;
        this.email = email;
    }

    public int getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(int idContacto) {
        this.idContacto = idContacto;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
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
        final Contacto other = (Contacto) obj;
        if (!Objects.equals(this.celular, other.celular)) {
            return false;
        }
        if (!Objects.equals(this.direccion, other.direccion)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }
    
    
}
