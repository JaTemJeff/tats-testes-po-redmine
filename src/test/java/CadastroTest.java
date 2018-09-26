
import core.BaseTest;
import core.GeneratorUtils;
import core.WebDriverFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.CadastroPage;

public class CadastroTest extends BaseTest {

    WebDriver driver;
    CadastroPage cadastroPage;
    GeneratorUtils gerador;

    @Before
    public void inicializa() {
        driver = WebDriverFactory.getDriver();
        cadastroPage = new CadastroPage(driver);
        gerador = new GeneratorUtils();
    }

    @Test
    public void cadastraCorretamenteTest() {
        String usuario = gerador.stringAleatoria(20);
        String senha = "123456";
        String confirmacao = "123456";
        String nome = gerador.stringAleatoria(15);
        String sobrenome = gerador.stringAleatoria(5);
        String email = gerador.stringAleatoria(10) + "@email.com";

        cadastroPage.vaiParaPaginaDeCadastro();
        cadastroPage.setUsuario(usuario);
        cadastroPage.setSenha(senha);
        cadastroPage.setConfirmacao(confirmacao);
        cadastroPage.setNome(nome);
        cadastroPage.setSobrenome(sobrenome);
        cadastroPage.setEmail(email);

        cadastroPage.clicaCadastrar();

        Assert.assertEquals("Sua conta foi ativada. Você pode acessá-la agora.", cadastroPage.retornaMsgDeSucesso());
    }

    @Test
    public void cadastroContendoCamposEmBrancoTest() {
        String usuario = " ";
        String senha = " ";
        String confirmacao = " ";
        String nome = " ";
        String sobrenome = " ";
        String email = " ";

        cadastroPage.vaiParaPaginaDeCadastro();
        cadastroPage.setUsuario(usuario);
        cadastroPage.setSenha(senha);
        cadastroPage.setConfirmacao(confirmacao);
        cadastroPage.setNome(nome);
        cadastroPage.setSobrenome(sobrenome);
        cadastroPage.setEmail(email);

        cadastroPage.clicaCadastrar();

        Assert.assertEquals(
                "E-mail não pode ficar vazio\n"
                + "Usuário não pode ficar vazio\n"
                + "Usuário não é válido\n"
                + "Nome não pode ficar vazio\n"
                + "Sobrenome não pode ficar vazio\n"
                + "Senha é muito curto (mínimo: 4 caracteres)",
                cadastroPage.retornaMsgDeErro());
    }
}
