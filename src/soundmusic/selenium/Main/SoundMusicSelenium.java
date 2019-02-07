package soundmusic.selenium.Main;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import soundmusic.selenium.Modelo.Usuario.Usuario;
import soundmusic.selenium.POM.Home;
import soundmusic.selenium.POM.Login;
import soundmusic.selenium.POM.Usuario.UsuariosCrear;
import soundmusic.selenium.POM.Usuario.UsuariosListar;
import soundmusic.selenium.POM.Usuario.UsuariosModificar;

/**
 *
 * @author Santiago Medina Pelaez
 */
public class SoundMusicSelenium {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //inicializarcomponentes();
    }

    private static void inicializarcomponentes() {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost:8081/SoundMusic/login.jsp");
        Login loginPOM = new Login(driver);
        Home homePOM = new Home(driver);
        UsuariosListar usuarioListarPOM = new UsuariosListar(driver);
        UsuariosCrear usuarioCrearPOM = new UsuariosCrear(driver);
        UsuariosModificar usuarioModificarPOM = new UsuariosModificar(driver);

        String nomUsuario = "admin";
        String password = "admin";

        loginPOM.ingresarAplicacion(nomUsuario, password);
        homePOM.ClicMenuUsuarios();
        Usuario obtenerNuevoUsuario = usuarioListarPOM.obtenerNuevoUsuario();
    }

}
