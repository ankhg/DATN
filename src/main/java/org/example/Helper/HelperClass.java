package org.example.Helper;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.ByteArrayInputStream;

public class HelperClass {
    public static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void setup() {
        String webdriver = System.getProperty("webdriver", "Chrome");
        switch (webdriver) {
            case "Chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "Firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                throw new RuntimeException("Unsupported webdriver" + webdriver);
        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    public static void teardown() {
        byte[] screenshot = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES);
        Allure.addAttachment("Screenshot", new ByteArrayInputStream(screenshot));

        driver.quit();
    }
}
