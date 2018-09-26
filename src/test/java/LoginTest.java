import core.AppSettings;
import core.BaseTest;
import core.WebDriverFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    WebDriver driver; 
    LoginPage loginPage;
    
    @Before
    public void inicializa(){
        driver = WebDriverFactory.getDriver();
        loginPage = new LoginPage(driver);
    }
    
    @Test
    public void logaCorretamenteTest(){
        loginPage.vaiParaPaginaDeLogin();
        loginPage.setLogin(AppSettings.LOGIN);
        loginPage.setSenha(AppSettings.SENHA);
        loginPage.clicaLogar();
        
        Assert.assertEquals("Acessando como: jff_94@hotmail.com", loginPage.retornaTextoLabelDeAcesso());
    }
    
    @Test
    public void loginErradoTest(){
        loginPage.vaiParaPaginaDeLogin();
        loginPage.setLogin("login_errado@gmail.com");
        loginPage.setSenha(AppSettings.SENHA);
        loginPage.clicaLogar();
        
         Assert.assertEquals("Usuário ou senha inválido.", loginPage.retornaTextoDaMensagemDeErro());
    }
    
    @Test
    public void senhaErradaTest(){
        loginPage.vaiParaPaginaDeLogin();
        loginPage.setLogin(AppSettings.LOGIN);
        loginPage.setSenha("senha_errada");
        loginPage.clicaLogar();
        
         Assert.assertEquals("Usuário ou senha inválido.", loginPage.retornaTextoDaMensagemDeErro());
    }
    
}
