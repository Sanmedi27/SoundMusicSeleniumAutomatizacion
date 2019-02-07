package soundmusic.selenium.POM.Artistas;

import java.sql.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import soundmusic.selenium.Modelo.Artista.Artista;

/**
 *
 * @author Santiago Medina Pelaez
 */
public class ArtistasListar {

    WebDriver driver;
    By tituloPagina = By.xpath("//h3[contains(text(),'Modulo de Artistas')]");
    By navBarArtista = By.id("artista");
    By tablaDeArtistas = By.id("listaArtistas");
    By btnRegistrar = By.id("btnRegistrar");
    By btnRegresar = By.id("btn-regresar");
    By listarSoloActivos = By.id("modoListar");

    public ArtistasListar(WebDriver driver) {
        this.driver = driver;
    }

    public String getTituloPagina() {
        return driver.findElement(tituloPagina).getText();
    }

    public void clickMainArtista() {
        driver.findElement(navBarArtista);
    }

    public void clickRegistrarArtista() {
        driver.findElement(btnRegistrar);
    }

    public void clickRegresar() {
        driver.findElement(btnRegistrar);
    }

    public void clickSoloListarActivosCheckbox() {
        driver.findElement(listarSoloActivos).click();
    }
    
    public Artista obtenerNuevoArtista() {
        Artista nuevoArtista = new Artista();
        List<WebElement> ultimaFilaTablaUsuarios = UltimaFila();

        nuevoArtista.setNombreArtistico(ultimaFilaTablaUsuarios.get(0).getText());
        nuevoArtista.setFechaCreacion(Date.valueOf(ultimaFilaTablaUsuarios.get(3).getText()));

        return nuevoArtista;
    }

    public int numeroArtistasListados() {
        return FilasTablaUsuarios().size() - 1;
    }

    public int numeroArtistasActivos() {
        int numeroArtistasActivos = 0;

        for (int i = 0; i < FilasTablaUsuarios().size(); i++) {
            if (i >= 1) {
                if (FilasTablaUsuarios().get(i).getText().contains("Activado")) {
                    numeroArtistasActivos++;
                }
            }
        }

        return numeroArtistasActivos;
    }

    public int numeroArtistasInactivos() {
        int numeroArtistasInactivos = 0;

        for (int i = 0; i < FilasTablaUsuarios().size(); i++) {
            if (i >= 1) {
                if (FilasTablaUsuarios().get(i).getText().contains("Inactivo")) {
                    numeroArtistasInactivos++;
                }
            }
        }

        return numeroArtistasInactivos;
    }

    private List<WebElement> FilasTablaUsuarios() {
        WebElement tablaUsuarios = driver.findElement(tablaDeArtistas);
        List<WebElement> filasTabla = tablaUsuarios.findElements(By.tagName("tr"));

        return filasTabla;
    }

    private List<WebElement> UltimaFila() {
        List<WebElement> ultimaFila = FilasTablaUsuarios().
                get(FilasTablaUsuarios().size() - 1).
                findElements(By.tagName("td"));

        return ultimaFila;
    }

    public void artistaApp() {
        this.clickMainArtista();
        this.clickRegistrarArtista();
        this.clickRegresar();
    }
}
