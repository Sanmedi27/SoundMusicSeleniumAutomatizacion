package soundmusic.selenium;

import java.util.concurrent.TimeUnit;
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

/**
 *
 * @author Santiago Medina Pelaez
 */
public class LoginTest {

    private static WebDriver driver = null;
    Login loginPOM;
    Home homePOM;

    String nomUsuario;
    String password;

    public LoginTest() {
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

        nomUsuario = "admin";
        password = "admin";
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void LoginIngresarTest() {
        loginPOM.ingresarAplicacion(nomUsuario, password);

        assertEquals("Validar titulo en la pagina home",
                "Artistas Mas Destacados Del 2019",
                homePOM.getMensajeHome());
    }
}
