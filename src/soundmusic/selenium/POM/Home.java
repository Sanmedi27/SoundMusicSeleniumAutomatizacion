package soundmusic.selenium.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Clase POM de la pagina home.
 *
 * @author Santiago Medina Pelaez
 */
public class Home {

    WebDriver driver;
    By mensajeHome = By.xpath("//h3[contains(text(),'Artistas Mas Destacados')]");
    By menuUsuario = By.id("usuarios");
    By menuArtistas = By.id("artista");
    By menuEmpresasDifusoras = By.id("empresas");

    public Home(WebDriver driver) {
        this.driver = driver;
    }

    public String getMensajeHome() {
        return driver.findElement(mensajeHome).getText();
    }

    public void ClicMenuUsuarios() {
        driver.findElement(menuUsuario).click();
    }

    public void ClicMenuArtistas() {
        driver.findElement(menuArtistas).click();
    }

    public void ClicMenuEmpresasDifusoras() {
        driver.findElement(menuEmpresasDifusoras).click();
    }
}
