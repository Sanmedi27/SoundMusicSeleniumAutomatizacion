package soundmusic.selenium.Usuarios;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author Santiago Medina Pelaez
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({soundmusic.selenium.Usuarios.ListarTest.class,
    soundmusic.selenium.Usuarios.ModificarTest.class,
    soundmusic.selenium.Usuarios.CrearTest.class,
    soundmusic.selenium.Usuarios.DesactivarTest.class})
public class UsuariosTestSuite {

}
