package soundmusic.selenium.Usuarios;

import java.sql.Date;
import java.time.LocalDate;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import soundmusic.selenium.Modelo.Usuario.Usuario;
import soundmusic.selenium.POM.Home;
import soundmusic.selenium.POM.Login;
import soundmusic.selenium.POM.Usuario.*;

/**
 *
 * @author Santiago Medina Pelaez
 */
public class CrearTest {

    private static WebDriver driver = null;
    Login loginPOM;
    Home homePOM;
    UsuariosListar usuarioListarPOM;
    UsuariosCrear usuarioCrearPOM;

    String nomUsuario;
    String password;

    Usuario usuarioEsperado, usuarioActual;

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
        usuarioListarPOM = new UsuariosListar(driver);
        usuarioCrearPOM = new UsuariosCrear(driver);        

        nomUsuario = "admin";
        password = "admin";

        usuarioEsperado = new Usuario();
        usuarioEsperado.setPrimerNombre("Juan");
        usuarioEsperado.setSegundoNombre("Roman");
        usuarioEsperado.setPrimerApellido("Riquelme");
        usuarioEsperado.setSegundoApellido("Ricaurte");
        usuarioEsperado.setGenero("M");
        usuarioEsperado.getUsuarioLogin().setNombreUsuario("romanJ");
        usuarioEsperado.getUsuarioLogin().setContrasena("romanJ");
        usuarioEsperado.getPerfil().setNombrePerfil("Operario");

        usuarioActual = new Usuario();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void UsuariosCrearTest() {
        loginPOM.ingresarAplicacion(nomUsuario, password);
        homePOM.ClicMenuUsuarios();
        usuarioListarPOM.clickRegistrarUsuario();
        usuarioCrearPOM.crearUsuario(usuarioEsperado);

        usuarioEsperado.setFechaCreacion(Date.valueOf(LocalDate.now()));
        usuarioActual = usuarioListarPOM.obtenerNuevoUsuario();

        assertEquals("Comparar primer nombre y apellido de usuario",
                usuarioEsperado.getPrimerNombre() + " " + usuarioEsperado.getPrimerApellido(),
                usuarioActual.getPrimerNombre() + " " + usuarioActual.getPrimerApellido());
        assertEquals("Comparar genero de usuario",
                usuarioEsperado.getGenero(),
                usuarioActual.getGenero());        
        assertEquals("Comparar nombre Peril de usuario",
                usuarioEsperado.getPerfil().getNombrePerfil(),
                usuarioActual.getPerfil().getNombrePerfil());
        assertEquals("Comparar nombre de usuario de usuario",
                usuarioEsperado.getUsuarioLogin().getNombreUsuario(),
                usuarioActual.getUsuarioLogin().getNombreUsuario());
        assertEquals("Comparar fecha de cracion de usuario",
                usuarioEsperado.getFechaCreacion(),
                usuarioActual.getFechaCreacion());
    }
}
