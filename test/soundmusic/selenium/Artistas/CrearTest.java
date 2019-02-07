package soundmusic.selenium.Artistas;

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
import soundmusic.selenium.Modelo.Artista.Artista;
import soundmusic.selenium.POM.Home;
import soundmusic.selenium.POM.Login;
import soundmusic.selenium.POM.Artistas.*;

/**
 *
 * @author Santiago Medina Pelaez
 */
public class CrearTest {
    private static WebDriver driver = null;
    Login loginPOM;
    Home homePOM;
    ArtistasListar artistaListarPOM;
    ArtistaCrear artistaCrearPOM;
    ArtistaModificar artistaModificarPOM;

    String nomUsuario;
    String password;

    Artista artistaEsperado, artistaActual;

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
        artistaListarPOM = new ArtistasListar(driver);
        artistaCrearPOM = new ArtistaCrear(driver);
        artistaModificarPOM = new ArtistaModificar(driver);

        nomUsuario = "admin";
        password = "admin";

        artistaEsperado = new Artista();
        artistaEsperado.setPrimerNombre("Juan");
        artistaEsperado.setSegundoNombre("Roman");
        artistaEsperado.setPrimerApellido("Riquelme");
        artistaEsperado.setSegundoApellido("Ricaurte");
        artistaEsperado.setGenero("M");
        artistaEsperado.setNombreArtistico("DJ Roman");
        artistaEsperado.getContacto().setEmail("email@example.com");
        artistaEsperado.getContacto().setCelular("3164948754");
        artistaEsperado.getContacto().setDireccion("Cll 35 # 85 -78");
        artistaEsperado.getContacto().getCiudad().getPais().setNombre("Colombia");
        artistaEsperado.getContacto().getCiudad().setNombre("Medellin");

        artistaActual = new Artista();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
    
    @Test
    public void ArtistasCrearTest() {
        loginPOM.ingresarAplicacion(nomUsuario, password);
        homePOM.ClicMenuArtistas();
        artistaListarPOM.clickRegistrarArtista();
        artistaCrearPOM.crearArtista(artistaEsperado);
        
        artistaEsperado.setFechaCreacion(Date.valueOf(LocalDate.now()));
        artistaActual=artistaListarPOM.obtenerNuevoArtista();
        
        assertEquals("Comparar nombre artistico de artista",
                artistaEsperado.getNombreArtistico(),
                artistaActual.getNombreArtistico());
        assertEquals("Comparar fecha de cracion de artista",
                artistaEsperado.getFechaCreacion(),
                artistaActual.getFechaCreacion());
    }
}
