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
public class UsuariosModificar {

    WebDriver driver;
    By nom1 = By.id("nom1 texto");
    By nom2 = By.id("nombre2 texto");
    By apellido1 = By.id("apellido1 texto");
    By apellido2 = By.id("apellido2 texto");
    By generoMasculino = By.xpath("/html/body/div/div[1]/div[2]/form/div[3]/label[1]");
    By generoFemenino = By.xpath("/html/body/div/div[1]/div[2]/form/div[3]/label[2]");
    By sex1 = By.id("textSex1");
    By sex2 = By.id("textSex2");
    By email = By.id("email");
    By nomUsuario = By.id("textNameUser");
    By pass1 = By.id("textPass");
    By pass2 = By.id("textRepeatPass");
    By perfil = By.id("perfil");
    By numCel = By.id("numCel");
    By numTel = By.id("numTel");
    By pais = By.id("pais");
    By ciudad = By.id("ciudad");
    By direccion = By.id("direccion");
    By barrio = By.id("barrio");
    By check = By.xpath("/html/body/div/div[1]/div[2]/form/div[7]/label");
    By btnRegresar = By.id("btn-regresar");
    By btnGuardar = By.id("btnGuardar");

    public UsuariosModificar(WebDriver driver) {
        this.driver = driver;
    }

    public void setNom1(String strNom1) {
        driver.findElement(nom1).clear();
        driver.findElement(nom1).sendKeys(strNom1);
    }

    public void setNom2(String strNom2) {
        driver.findElement(nom2).clear();
        driver.findElement(nom2).sendKeys(strNom2);
    }

    public void setApellido1(String strApellido1) {
        driver.findElement(apellido1).clear();
        driver.findElement(apellido1).sendKeys(strApellido1);
    }

    public void setApellido2(String strApellido2) {
        driver.findElement(apellido2).clear();
        driver.findElement(apellido2).sendKeys(strApellido2);
    }

    public void selectSex(String genero) {
        if (genero.equalsIgnoreCase("masculino") | genero.equalsIgnoreCase("m")) {
            driver.findElement(generoMasculino).click();
        } else if (genero.equalsIgnoreCase("femenino") | genero.equalsIgnoreCase("f")) {
            driver.findElement(generoFemenino).click();
        }
    }

    public void setEmail(String strEmail) {
        driver.findElement(email).clear();
        driver.findElement(email).sendKeys(strEmail);
    }

    public void setNomUsuario(String strNomUsuario) {
        driver.findElement(nomUsuario).clear();
        driver.findElement(nomUsuario).sendKeys(strNomUsuario);
    }

    public void setPass1(String strPass1) {
        driver.findElement(pass1).clear();
        driver.findElement(pass1).sendKeys(strPass1);
    }

    public void setPass2(String strPass2) {
        driver.findElement(pass2).clear();
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

    public void setNumCel(String strNumCel) {
        driver.findElement(numCel).clear();
        driver.findElement(numCel).sendKeys(strNumCel);
    }

    public void setNumTel(String strNumTel) {
        driver.findElement(numTel).clear();
        driver.findElement(numTel).sendKeys(strNumTel);
    }

    public void selectedPais(String nombrePais) {
        try {
            WebElement pais_select = driver.findElement(pais);
            Select pais_dd = new Select(pais_select);
            pais_dd.selectByVisibleText(nombrePais.toUpperCase());
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public void selectedCity(String nomCiudad) {
        try {
            WebElement city_select = driver.findElement(ciudad);
            Select city_dd = new Select(city_select);
            city_dd.selectByVisibleText(nomCiudad.toUpperCase());
            Thread.sleep(2000);
            //city_dd.selectByValue("3");

        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public void setDireccion(String strDireccion) {
        driver.findElement(direccion).clear();
        driver.findElement(direccion).sendKeys(strDireccion);
    }

    public void setBarrio(String strBarrio) {
        driver.findElement(barrio).clear();
        driver.findElement(barrio).sendKeys(strBarrio);
    }

    public void checkConfirmacion() {
        driver.findElement(check).click();
    }

    public void clickRegresar() {
        driver.findElement(btnRegresar).click();
    }

    public void clickGuardar() {
        driver.findElement(btnGuardar).click();
    }
    
    public void modificarUsuario(Usuario usuarioACrear) {
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
