package soundmusic.selenium.POM.EmpresaDifusora;

import org.openqa.selenium.By;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import soundmusic.selenium.Modelo.EmpresaDifusora.EmpresaDifusora;

/**
 *
 * @author Santiago Medina Pelaez
 */
public class EmpresasDifusoraCrear {

    WebDriver driver;
    By nomEmpresa = By.id("nomEmpresaTxt");
    By tipoEmpresa = By.id("tipoEmpresa");
    By valorOperacion = By.id("valorOp");
    By check = By.xpath("/html/body/div/div[1]/div[2]/form/div[4]/div/label");
    By btnRegresar = By.id("btn-regresar");
    By btnGuardar = By.id("btnGuardar");

    public EmpresasDifusoraCrear(WebDriver driver) {
        this.driver = driver;
    }

    public void setNomEmpresa(String strNomEmpresa) {
        driver.findElement(nomEmpresa).sendKeys(strNomEmpresa);
    }

    public void selectTipoEmpresa(String nombreTipoEmpresa) {
        try {
            WebElement tipoEmpresa_select = driver.findElement(tipoEmpresa);
            Select tipoEmpresa_dd = new Select(tipoEmpresa_select);
            tipoEmpresa_dd.selectByVisibleText(nombreTipoEmpresa.toUpperCase());
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }

    public void setValorOPeracion(String strValorOPeracion) {
        driver.findElement(valorOperacion).sendKeys(strValorOPeracion);
    }
    
    public void checkConfirmacion() {
        driver.findElement(check).click();
    }

    public void clickRegresar() {
        driver.findElement(btnRegresar).click();
    }

    public void clickGuardar() {
        try {
            Thread.sleep(5000);
            driver.findElement(btnGuardar).click();
            Thread.sleep(9000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
    
    public void crearEmpresa(EmpresaDifusora empresaACrear){
        this.setNomEmpresa(empresaACrear.getNombre());
        this.selectTipoEmpresa(empresaACrear.getTipoActividad().getTipoActividad());
        this.setValorOPeracion(String.valueOf(empresaACrear.getCostoOperacion().
                getCostoPorOperacion()));
        this.checkConfirmacion();
        this.clickGuardar();
    }
}
