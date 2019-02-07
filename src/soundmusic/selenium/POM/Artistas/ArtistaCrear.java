package soundmusic.selenium.POM.Artistas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import soundmusic.selenium.Modelo.Artista.Artista;

/**
 *
 * @author Santiago Medina Pelaez
 */
public class ArtistaCrear {

    WebDriver driver;
    By nom1 = By.id("nom1");
    By nom2 = By.id("nom2");
    By apellido1 = By.id("apellido1");
    By apellido2 = By.id("apellido2");
    By generoMasculino = By.xpath("/html/body/div/div/div/form/div[3]/label[1]");
    By generoFemenino = By.xpath("/html/body/div/div/div/form/div[3]/label[2]");
    By nomArtista = By.id("nomArtista");
    By btnRegresar = By.id("btn-regresar");
    By btnGuardar = By.id("btnGuardar");

    public ArtistaCrear(WebDriver driver) {
        this.driver = driver;
    }

    public void setNom1(String strNom1) {
        driver.findElement(nom1).sendKeys(strNom1);
    }

    public void setNom2(String strNom2) {
        driver.findElement(nom2).sendKeys(strNom2);
    }

    public void setApellido1(String strApellido1) {
        driver.findElement(apellido1).sendKeys(strApellido1);
    }

    public void setApellido2(String strApellido2) {
        driver.findElement(apellido2).sendKeys(strApellido2);
    }

    public void selectSex(String genero) {
        if (genero.equalsIgnoreCase("masculino") | genero.equalsIgnoreCase("m")) {
            driver.findElement(generoMasculino).click();
        } else if (genero.equalsIgnoreCase("femenino") | genero.equalsIgnoreCase("f")) {
            driver.findElement(generoFemenino).click();
        }
    }

    public void setNomArtista(String strNomUsuario) {
        driver.findElement(nomArtista).sendKeys(strNomUsuario);
    }

    public void clickRegresar() {
        driver.findElement(btnRegresar).click();
    }

    public void clickGuardar() {
        try {
            Thread.sleep(5000);
            driver.findElement(btnGuardar).click();
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
    
    public void crearArtista(Artista artistaACrear){
        this.setNom1(artistaACrear.getPrimerNombre());
        this.setNom2(artistaACrear.getSegundoNombre());
        this.setApellido1(artistaACrear.getPrimerApellido());
        this.setApellido2(artistaACrear.getSegundoApellido());
        this.selectSex(artistaACrear.getGenero());
        this.setNomArtista(artistaACrear.getNombreArtistico());
        this.clickGuardar();
    }
}
