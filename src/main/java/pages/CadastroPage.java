/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pages;

import core.AppSettings;
import core.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 *
 * @author Jeff
 */
public class CadastroPage extends BasePage{
     public CadastroPage(WebDriver driver) {
        super(driver);
    }
    
    @FindBy(id = "user_login")
    WebElement input_usuario;
    
    @FindBy(id = "user_password")
    WebElement input_senha;
    
    @FindBy(id = "user_password_confirmation")
    WebElement input_confirmacao;
    
    @FindBy(id = "user_firstname")
    WebElement input_nome;
    
    @FindBy(id = "user_lastname")
    WebElement input_sobrenome;
    
    @FindBy(id = "user_mail")
    WebElement input_email;
    
    @FindBy(xpath = "//*[@id=\'new_user\']/input[3]")
    WebElement btn_enviar;
    
    @FindBy(xpath = "//*[@id=\'flash_notice\']")
    WebElement label_msg_sucesso;
    
    @FindBy(xpath = "//*[@id=\'errorExplanation\']")
    WebElement label_msg_erro; 
    
    public CadastroPage setUsuario(String usuario) {
        input_usuario.clear();
        input_usuario.sendKeys(usuario);
        return this;
    }
    
    public CadastroPage setSenha(String senha) {
        input_senha.clear();
        input_senha.sendKeys(senha);
        return this;
    }
    
    public CadastroPage setConfirmacao(String confirmacao) {
        input_confirmacao.clear();
        input_confirmacao.sendKeys(confirmacao);
        return this;
    }
    
    public CadastroPage setNome(String nome) {
        input_nome.clear();
        input_nome.sendKeys(nome);
        return this;
    }
    
    public CadastroPage setSobrenome(String sobrenome) {
        input_sobrenome.clear();
        input_sobrenome.sendKeys(sobrenome);
        return this;
    }
    
    public CadastroPage setEmail(String email) {
        input_email.clear();
        input_email.sendKeys(email);
        return this;
    }
    
    public void clicaCadastrar(){
        btn_enviar.click();
    }
    
    public void vaiParaPaginaDeCadastro() {
        driver.get("http://demo.redmine.org/account/register");
    }
    
    public String retornaMsgDeSucesso(){
        return label_msg_sucesso.getText();
    }
    
    public String retornaMsgDeErro(){
        return label_msg_erro.getText();
    }
}
