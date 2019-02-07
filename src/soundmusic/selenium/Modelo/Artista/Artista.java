package soundmusic.selenium.Modelo.Artista;

import soundmusic.selenium.Modelo.Contacto.Contacto;
import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author Santiago Medina Pelaez
 */
public class Artista {

    private Integer idArtista;
    private String primerNombre;
    private String segundoNombre;
    private String primerApellido;
    private String segundoApellido;
    private String nombreArtistico;
    private String genero;
    private Date fechaNacimiento;
    private Date fechaCreacion;
    private String status;
    private String rutaImagen;
    private Contacto contacto;

    public Artista(Integer idArtista, String[] datosArtista, Date[] fechasArtista, Integer idContacto) {
        this.idArtista = idArtista;
        this.primerNombre = datosArtista[0];
        this.segundoNombre = datosArtista[1];
        this.primerApellido = datosArtista[2];
        this.segundoApellido = datosArtista[3];
        this.nombreArtistico = datosArtista[4];
        this.genero = datosArtista[5];
        this.fechaNacimiento = fechasArtista[0];
        this.fechaCreacion = fechasArtista[1];
        this.status = datosArtista[6];
        this.rutaImagen = datosArtista[7];
        this.contacto = new Contacto();
        this.contacto.setIdContacto(idContacto);
    }

    public Artista() {
        this.contacto = new Contacto();
    }

    public Integer getIdArtista() {
        return idArtista;
    }

    public void setIdArtista(Integer idArtista) {
        this.idArtista = idArtista;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getNombreArtistico() {
        return nombreArtistico;
    }

    public void setNombreArtistico(String nombreArtistico) {
        this.nombreArtistico = nombreArtistico;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.idArtista;
        hash = 47 * hash + Objects.hashCode(this.nombreArtistico);
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
        final Artista other = (Artista) obj;
        if (this.idArtista != other.idArtista) {
            return false;
        }
        if (!Objects.equals(this.nombreArtistico, other.nombreArtistico)) {
            return false;
        }
        return true;
    }
}
