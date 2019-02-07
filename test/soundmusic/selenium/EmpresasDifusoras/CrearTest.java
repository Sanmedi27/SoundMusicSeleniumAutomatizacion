package soundmusic.selenium.EmpresasDifusoras;

import java.sql.Date;
import java.time.LocalDate;
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
public class CrearTest {
     private static WebDriver driver = null;
    Login loginPOM;
    Home homePOM;
    EmpresasDifusoraListar empresaListarPOM;
    EmpresasDifusoraCrear empresaCrearPOM;
    EmpresasDifusoraModificar empresaModificarPOM;

    String nomUsuario;
    String password;

    EmpresaDifusora empresaEsperado, empresaActual;

    public CrearTest() {
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
        empresaCrearPOM = new EmpresasDifusoraCrear(driver);
        empresaModificarPOM = new EmpresasDifusoraModificar(driver);

        nomUsuario = "admin";
        password = "admin";

        empresaEsperado = new EmpresaDifusora();
        empresaEsperado.setNombre("MusicTunes");       

        empresaActual = new EmpresaDifusora();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void EmpresasCrearTest() {
        loginPOM.ingresarAplicacion(nomUsuario, password);
        homePOM.ClicMenuEmpresasDifusoras();
        empresaListarPOM.clickRegistrarEmpresa();
        empresaCrearPOM.crearEmpresa(empresaEsperado);
        
        empresaEsperado.setFechaCreacion(Date.valueOf(LocalDate.now()));
        
        empresaActual=empresaListarPOM.obtenerNuevaEmpresa();
        
        assertEquals("Comparar nombre de la empresa",
                empresaEsperado.getNombre(),
                empresaActual.getNombre());
        
        assertEquals("Comparar fecha de cracion de la empresa",
                empresaEsperado.getFechaCreacion(),
                empresaActual.getFechaCreacion());
    }
}
