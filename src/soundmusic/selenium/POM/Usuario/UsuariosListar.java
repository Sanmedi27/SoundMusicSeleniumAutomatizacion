package soundmusic.selenium.POM.Usuario;

import java.sql.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import soundmusic.selenium.Modelo.Usuario.Usuario;

/**
 *
 * @author Santiago Medina Pelaez
 */
public class UsuariosListar {

    WebDriver driver;
    By tituloPagina = By.xpath("//h3[contains(text(),'Modulo de Usuarios')]");
    By btnRegistrarUsuario = By.id("registrarUsuario");
    By tablaDeUsuarios = By.id("listaUsuarios");
    By listarSoloActivos = By.id("modoListar");

    public UsuariosListar(WebDriver driver) {
        this.driver = driver;
    }

    public String getTituloPagina() {
        return driver.findElement(tituloPagina).getText();
    }

    /**
     * Click en el boton para registrar un nuevo usuario.
     */
    public void clickRegistrarUsuario() {
        driver.findElement(btnRegistrarUsuario).click();
    }

    /**
     * Click en el boton de actualizar para modificar el ultimo usuario de la
     * tabla.
     */
    public void clickActualizarUltimoUsuario() {
        List<WebElement> ultimaFilaTablaUsuarios = UltimaFila();
        ultimaFilaTablaUsuarios.get(ultimaFilaTablaUsuarios.size() - 1).click();
    }

    public void clickSoloListarActivosCheckbox() {
        driver.findElement(listarSoloActivos).click();
    }

    public Usuario obtenerNuevoUsuario() {
        Usuario nuevoUsuario = new Usuario();
        List<WebElement> ultimaFilaTablaUsuarios = UltimaFila();

        String[] nombreCompleto = ultimaFilaTablaUsuarios.get(0).getText().split(" ", 2);

        nuevoUsuario.setPrimerNombre(nombreCompleto[0]);
        nuevoUsuario.setPrimerApellido(nombreCompleto[1]);
        nuevoUsuario.setGenero(ultimaFilaTablaUsuarios.get(1).getText());
        nuevoUsuario.getPerfil().setNombrePerfil(procesareNombre(ultimaFilaTablaUsuarios.get(2).getText()));
        nuevoUsuario.getUsuarioLogin().setNombreUsuario(ultimaFilaTablaUsuarios.get(3).getText());
        nuevoUsuario.setFechaCreacion(Date.valueOf(ultimaFilaTablaUsuarios.get(4).getText()));

        return nuevoUsuario;
    }

    public int numeroUsuariosListados() {
        return FilasTablaUsuarios().size() - 1;
    }

    public int numeroUsuariosActivos() {
        int numeroUsuariosActivos = 0;

        for (int i = 0; i < FilasTablaUsuarios().size(); i++) {
            if (i >= 1) {
                if (FilasTablaUsuarios().get(i).getText().contains("Activado")) {
                    numeroUsuariosActivos++;
                }
            }
        }

        return numeroUsuariosActivos;
    }

    public int numeroUsuariosInactivos() {
        int numeroUsuariosInactivos = 0;

        for (int i = 0; i < FilasTablaUsuarios().size(); i++) {
            if (i >= 1) {
                if (FilasTablaUsuarios().get(i).getText().contains("Inactivo")) {
                    numeroUsuariosInactivos++;
                }
            }
        }

        return numeroUsuariosInactivos;
    }

    private List<WebElement> FilasTablaUsuarios() {
        WebElement tablaUsuarios = driver.findElement(tablaDeUsuarios);
        List<WebElement> filasTabla = tablaUsuarios.findElements(By.tagName("tr"));

        return filasTabla;
    }

    private List<WebElement> UltimaFila() {
        List<WebElement> ultimaFila = FilasTablaUsuarios().
                get(FilasTablaUsuarios().size() - 1).
                findElements(By.tagName("td"));

        return ultimaFila;
    }

    private String procesareNombre(String nombrePerfil) {
        String aux = nombrePerfil.substring(0, 1).toUpperCase()
                + nombrePerfil.substring(1).toLowerCase();

        return aux;
    }
}
