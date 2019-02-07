package soundmusic.selenium.Usuarios;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import soundmusic.selenium.POM.Home;
import soundmusic.selenium.POM.Login;
import soundmusic.selenium.POM.Usuario.*;

/**
 *
 * @author Santiago Medina Pelaez
 */
public class DesactivarTest {

    private static WebDriver driver = null;
    Login loginPOM;
    Home homePOM;
    UsuariosListar usuarioListarPOM;

    String nomUsuario;
    String password;

    public DesactivarTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        driver.get("http://localhost:8081/SoundMusic/login.jsp");

        loginPOM = new Login(driver);
        homePOM = new Home(driver);
        usuarioListarPOM = new UsuariosListar(driver);

        nomUsuario = "admin";
        password = "admin";
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void usuariosDesactivarTest() {
        loginPOM.ingresarAplicacion(nomUsuario, password);
        homePOM.ClicMenuUsuarios();

        int numeroUsuariosListados = usuarioListarPOM.numeroUsuariosListados();
        int numeroUsuariosActivos = usuarioListarPOM.numeroUsuariosActivos();        
        int numeroUsuariosInactivos= usuarioListarPOM.numeroUsuariosInactivos();
        usuarioListarPOM.clickSoloListarActivosCheckbox();
        

        assertEquals("Validar todos los activos con los que quedan al dar click al chekbox",
                numeroUsuariosActivos,
                numeroUsuariosListados-numeroUsuariosInactivos);

        try {
            Thread.sleep(300);
        } catch (InterruptedException ex) {
            Logger.getLogger(ListarTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
