package soundmusic.selenium.Artistas;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import soundmusic.selenium.POM.Home;
import soundmusic.selenium.POM.Login;
import soundmusic.selenium.POM.Artistas.*;

/**
 *
 * @author Santiago Medina Pelaez
 */
public class ListarTest {

    private static WebDriver driver = null;
    Login loginPOM;
    Home homePOM;
    ArtistasListar artistaListarPOM;

    String nomUsuario;
    String password;

    public ListarTest() {
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
        artistaListarPOM = new ArtistasListar(driver);

        nomUsuario = "admin";
        password = "admin";
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void ArtistasListarTest() {
        loginPOM.ingresarAplicacion(nomUsuario, password);
        homePOM.ClicMenuArtistas();
        
        int numeroUsuariosListados = artistaListarPOM.numeroArtistasListados();
        int numeroUsuariosActivos = artistaListarPOM.numeroArtistasActivos();
        int numeroUsuariosInactivos = artistaListarPOM.numeroArtistasInactivos();
        artistaListarPOM.clickSoloListarActivosCheckbox();

        assertEquals("Validar todos los activos con los que quedan al dar click al chekbox",
                numeroUsuariosActivos,
                numeroUsuariosListados - numeroUsuariosInactivos);

        try {
            Thread.sleep(300);
        } catch (InterruptedException ex) {
            Logger.getLogger(ListarTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
