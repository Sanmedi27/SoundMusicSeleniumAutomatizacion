package soundmusic.selenium.POM.EmpresaDifusora;

import java.sql.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import soundmusic.selenium.Modelo.EmpresaDifusora.EmpresaDifusora;

/**
 *
 * @author Santiago Medina Pelaez
 */
public class EmpresasDifusoraListar {

    WebDriver driver;
    By tituloPagina = By.xpath("//h3[contains(text(),'Modulo de Empresa Difusora')]");
    By btnRegistrar = By.id("btnRegistrar");
    By btnRegresar = By.id("btn-regresar");
    By tablaEmpresas=By.id("listaEmpresas");

    public EmpresasDifusoraListar(WebDriver driver) {
        this.driver = driver;
    }

    public String getTituloPagina() {
        return driver.findElement(tituloPagina).getText();
    }

    public void clickRegistrarEmpresa() {
        driver.findElement(btnRegistrar).click();
    }

    public void clickRegresar() {
        driver.findElement(btnRegresar);
    }
    
     public EmpresaDifusora obtenerNuevaEmpresa() {
        EmpresaDifusora nuevaEmpresa = new EmpresaDifusora();
        List<WebElement> ultimaFilaTablaEmpresas = UltimaFila();

        nuevaEmpresa.setNombre(ultimaFilaTablaEmpresas.get(0).getText());
         nuevaEmpresa.setFechaCreacion(Date.valueOf(ultimaFilaTablaEmpresas.get(2).getText()));
        return nuevaEmpresa;
    }

     private List<WebElement> FilasTablaEmpresas() {
        WebElement tablaEmpresasDifusoras = driver.findElement(tablaEmpresas);
        List<WebElement> filasTabla = tablaEmpresasDifusoras.findElements(By.tagName("tr"));

        return filasTabla;
    }

    private List<WebElement> UltimaFila() {
        List<WebElement> ultimaFila = FilasTablaEmpresas().
                get(FilasTablaEmpresas().size() - 1).
                findElements(By.tagName("td"));

        return ultimaFila;
    }
}
