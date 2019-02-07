package soundmusic.selenium.EmpresasDifusoras;

import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import soundmusic.selenium.Modelo.EmpresaDifusora.EmpresaDifusora;
import soundmusic.selenium.POM.Home;
import soundmusic.selenium.POM.Login;
import soundmusic.selenium.POM.EmpresaDifusora.*;

/**
 *
 * @author Santiago Medina Pelaez
 */
public class ListarTest {
    private static WebDriver driver = null;
    Login loginPOM;
    Home homePOM;
    EmpresasDifusoraListar empresaListarPOM;

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
        empresaListarPOM = new EmpresasDifusoraListar(driver);

        nomUsuario = "admin";
        password = "admin";
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void EmpresasListarTest() {
        loginPOM.ingresarAplicacion(nomUsuario, password);
        homePOM.ClicMenuEmpresasDifusoras();
        assertEquals("Validar titulo de la pagina Empresas",
                "Modulo de Empresa Difusora",
                empresaListarPOM.getTituloPagina());
    }
}
