package soundmusic.selenium.Modelo.Artista.Album;

import soundmusic.selenium.Modelo.Artista.Artista;
import soundmusic.selenium.Modelo.Contacto.Ciudad.Ciudad;
import java.sql.Date;

/**
 *
 * @author Santiago Medina Pelaez
 */
public class Album {

    private int idAlbum;
    private String nombre;
    private int numeroCanciones;
    private Date fechaFinalizacion;
    private String rutaImagen;
    //private int idCiudad;
    //private int idArtista;
    private Artista artista;
    private Ciudad ciudad;

    public Album() {
        this.artista = new Artista();
        this.ciudad = new Ciudad();
    }

    public Album(int idAlbum, String nombre, int numeroCanciones, Date fechaFinalizacion,
            String rutaImagen, int idCiudad, int idArtista) {
        this.idAlbum = idAlbum;
        this.nombre = nombre;
        this.numeroCanciones = numeroCanciones;
        this.fechaFinalizacion = fechaFinalizacion;
        this.rutaImagen = rutaImagen;
        this.artista = new Artista();
        this.ciudad = new Ciudad();
        this.ciudad.setIdCiudad(idCiudad);
        this.artista.setIdArtista(idArtista);
    }

    public int getIdAlbum() {
        return idAlbum;
    }

    public void setIdAlbum(int idAlbum) {
        this.idAlbum = idAlbum;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumeroCanciones() {
        return numeroCanciones;
    }

    public void setNumeroCanciones(int numeroCanciones) {
        this.numeroCanciones = numeroCanciones;
    }

    public Date getFechaFinalizacion() {
        return fechaFinalizacion;
    }

    public void setFechaFinalizacion(Date fechaFinalizacion) {
        this.fechaFinalizacion = fechaFinalizacion;
    }

    public String getRutaImagen() {
        return this.rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
}
