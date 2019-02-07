package soundmusic.selenium.POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Clase POM de la pagina login donde vemos los metodos para ingresar usuario y
 * contraseña para así iniciar sesión. .
 *
 * @author Santiago Medina Pelaez
 */
public class Login {

    WebDriver driver;
    By nomUsuario = By.id("textUsuario");
    By password = By.id("textPassword");
    By btnIngresar = By.id("btnIngresar");

    public Login(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Asignar el nombre de usuario en el input
     *
     * @param strNomUsuario
     */
    public void setNomUsuario(String strNomUsuario) {
        driver.findElement(nomUsuario).sendKeys(strNomUsuario);
    }

    /**
     * Asignar la contraseña en el input
     *
     * @param strPassword
     */
    public void setPassword(String strPassword) {
        driver.findElement(password).sendKeys(strPassword);
    }

    /**
     * Click en el boton de ingresar la pagina
     */
    public void clickLogin() {
        driver.findElement(btnIngresar).click();
    }

    /**
     * Método para ingresar a la aplicación
     *
     * @param nomUsuario
     * @param password
     */
    public void ingresarAplicacion(String nomUsuario, String password) {
        this.setNomUsuario(nomUsuario);
        this.setPassword(password);
        this.clickLogin();
    }
}
