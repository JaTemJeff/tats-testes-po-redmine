package pages;

import core.BasePage;
import core.AppSettings;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@id=\"account\"]/ul/li[1]/a")
    WebElement link_entrar;

    @FindBy(xpath = "//*[@id=\"login-form\"]/form/table/tbody/tr[4]/td[2]/input")
    WebElement btn_entrar;

    @FindBy(xpath = "//*[@id=\'username\']")
    WebElement input_email;

    @FindBy(xpath = "//*[@id=\'password\']")
    WebElement input_senha;

    @FindBy(xpath = "//*[@id=\'loggedas\']")
    WebElement label_acesso;

    @FindBy(xpath = "//*[@id=\'flash_error\']")
    WebElement label_msg_login_errado;

    public void vaiParaPaginaDeLogin() {
        driver.get(AppSettings.URL_SITE);
        link_entrar.click();
    }

    public LoginPage setLogin(String login) {
        input_email.clear();
        input_email.sendKeys(login);
        return this;
    }

    public LoginPage setSenha(String senha) {
        input_senha.clear();
        input_senha.sendKeys(senha);
        return this;
    }

    public String getLogin() {
        return input_email.getAttribute("value");
    }

    public String getSenha() {
        return input_senha.getAttribute("value");
    }

    public void clicaLogar() {
        btn_entrar.click();
    }

    public String retornaTextoLabelDeAcesso() {
        return label_acesso.getText();
    }

    public String retornaTextoDaMensagemDeErro() {
        return label_msg_login_errado.getText();
    }
}
