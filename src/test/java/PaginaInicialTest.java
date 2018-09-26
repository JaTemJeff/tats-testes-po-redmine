import core.BaseTest;
import core.WebDriverFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.PaginaInicialPage;


public class PaginaInicialTest extends BaseTest{
    WebDriver driver; 
    PaginaInicialPage inicialPage;
    
    @Before
    public void inicializa(){
        driver = WebDriverFactory.getDriver();
        inicialPage = new PaginaInicialPage(driver);
    }
    
    @Test
    public void buscarPorUTFPRTest(){
        inicialPage.vaiParaPaginaInicial();
        inicialPage.setBuscar("UTFPR");
        Assert.assertTrue(inicialPage.retornaSeLabelResultadoExiste());
        Assert.assertEquals("http://demo.redmine.org/search?utf8=%E2%9C%93&q=UTFPR", inicialPage.retornaURL());
    }
    
    @Test
    public void navegaEntreAsPaginasTest(){
        
        inicialPage.vaiParaPaginaInicial();
        Assert.assertEquals("http://demo.redmine.org/", inicialPage.retornaURL());
        
        inicialPage.clicaLinkPaginaProjetos();
        Assert.assertEquals("http://demo.redmine.org/projects", inicialPage.retornaURL());
        
        inicialPage.clicaLinkAjuda();
        Assert.assertEquals("http://www.redmine.org/guide", inicialPage.retornaURL());
    }
    
    @Test
    public void Test(){
    
    }
    
}
