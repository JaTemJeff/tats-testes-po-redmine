/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import core.BasePage;
import core.AppSettings;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author Jeff
 */
public class PaginaInicialPage extends BasePage {

    public PaginaInicialPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\'top-menu\']/ul/li[1]/a")
    WebElement link_paginaInicial;

    @FindBy(xpath = "//*[@id=\'top-menu\']/ul/li[2]/a")
    WebElement link_projetos;

    @FindBy(xpath = "//*[@id=\'top-menu\']/ul/li[3]/a")
    WebElement link_ajuda;

    @FindBy(id = "q")
    WebElement input_buscar;

    @FindBy(xpath = "//*[@id=\'content\']/h3")
    WebElement label_resultados;

    public PaginaInicialPage setBuscar(String texto) {
        input_buscar.clear();
        input_buscar.sendKeys(texto);
        input_buscar.submit();
        return this;
    }

    public String getBuscar() {
        return input_buscar.getAttribute("value");
    }

    public void vaiParaPaginaInicial() {
        driver.get(AppSettings.URL_SITE);
    }

    public PaginaInicialPage clicaLinkPaginaInicial() {
        link_paginaInicial.click();
        return this;
    }

    public PaginaInicialPage clicaLinkPaginaProjetos() {
        link_projetos.click();
        return this;
    }

    public PaginaInicialPage clicaLinkAjuda() {
        link_ajuda.click();
        return this;
    }

    public String retornaURL() {
        return driver.getCurrentUrl();
    }

    public boolean retornaSeLabelResultadoExiste() {
        if (label_resultados.isDisplayed()) {
            return true;
        } else {
            return false;
        }
    }
}
