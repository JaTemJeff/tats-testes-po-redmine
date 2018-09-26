/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

/**
 *
 * @author Jeff
 */
public class AppSettings {

    public static String URL_SITE = "http://demo.redmine.org";

    public static String LOGIN = "jff_94@hotmail.com";
    public static String SENHA = "123456";

    //Propriedades = true, não fecha os browsers ao fim de cada teste
    public static boolean FECHAR_BROWSER = true;

    //Escolhe em qual browser rodar
    public static Browsers browser = Browsers.CHROME_HEADLESS;

    public enum Browsers {
        CHROME,
        PHATOMJS,
        CHROME_HEADLESS
    }
}
