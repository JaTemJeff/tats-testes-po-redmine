/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

/**
 *
 * @author Jeff
 */
public class WebDriverFactory {

    private static WebDriver driver;

    private WebDriverFactory() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            switch (AppSettings.browser) {
                case CHROME:
                    driver = new ChromeDriver();
                    break;

                case PHATOMJS:
                    driver = new PhantomJSDriver();
                    break;

                case CHROME_HEADLESS:
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("headless");
                    options.addArguments("window-size=1366x768");
                    driver = new ChromeDriver(options);
                    break;

            }
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void killDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
