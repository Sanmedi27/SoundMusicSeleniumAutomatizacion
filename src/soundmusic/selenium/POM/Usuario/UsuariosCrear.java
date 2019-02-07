package soundmusic.selenium.POM.Usuario;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import soundmusic.selenium.Modelo.Usuario.Usuario;

/**
 *
 * @author Santiago Medina Pelaez
 */
public class UsuariosCrear {

    WebDriver driver;
    By nom1 = By.id("nom1");
    By nom2 = By.id("nom2");
    By apellido1 = By.id("apellido1");
    By apellido2 = By.id("apellido2");
    By generoMasculino = By.xpath("/html/body/div/div[1]/div[2]/form/div[3]/label[1]");
    By generoFemenino = By.xpath("/html/body/div/div[1]/div[2]/form/div[3]/label[2]");
    By nomUsuario = By.id("nomUsuario");
    By pass1 = By.id("pass1");
    By pass2 = By.id("pass2");
    By perfil = By.id("perfil");
    By check = By.xpath("/html/body/div/div[1]/div[2]/form/div[7]/label");
    By btnRegresar = By.id("btn-regresar");
    By btnGuardar = By.id("btnGuardar");

    public UsuariosCrear(WebDriver driver) {
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

    public void setNomUsuario(String strNomUsuario) {
        driver.findElement(nomUsuario).sendKeys(strNomUsuario);
    }

    public void setPass1(String strPass1) {
        driver.findElement(pass1).sendKeys(strPass1);
    }

    public void setPass2(String strPass2) {
        driver.findElement(pass2).sendKeys(strPass2);
    }

    public void selectedPerfil(String nombrePerfil) {
        try {
            WebElement perfil_select = driver.findElement(perfil);
            Select perfil_dd = new Select(perfil_select);
            perfil_dd.selectByVisibleText(nombrePerfil.toUpperCase());
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public void checkConfirmacion() {
        driver.findElement(check).click();
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

    public void crearUsuario(Usuario usuarioACrear) {
        this.setNom1(usuarioACrear.getPrimerNombre());
        this.setNom2(usuarioACrear.getSegundoNombre());
        this.setApellido1(usuarioACrear.getPrimerApellido());
        this.setApellido2(usuarioACrear.getSegundoApellido());
        this.selectSex(usuarioACrear.getGenero());
        this.setNomUsuario(usuarioACrear.getUsuarioLogin().getNombreUsuario());
        this.setPass1(usuarioACrear.getUsuarioLogin().getContrasena());
        this.setPass2(usuarioACrear.getUsuarioLogin().getContrasena());
        this.selectedPerfil(usuarioACrear.getPerfil().getNombrePerfil());
        this.checkConfirmacion();
        this.clickGuardar();
    }
}
