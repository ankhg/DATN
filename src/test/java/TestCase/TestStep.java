package TestCase;

import org.example.Helper.ExcelReader;
import org.example.Helper.HelperClass;
import org.example.Helper.Log;
import org.example.Locators.LoginPageLocator;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.example.Helper.HelperClass.driver;

public class TestStep {

    LoginPageLocator loginPageLocator;

    public TestStep() {
        HelperClass.setup();
        this.loginPageLocator = new LoginPageLocator();
        PageFactory.initElements(HelperClass.getDriver(),loginPageLocator);
    }

    @BeforeTest
    public void BeforeRunTest() {
        //  ghi log
        Log.info("Run step: ");
    }

    @Test
    public void runTests() throws IOException, InterruptedException {
        Object[][] testData = ExcelReader.readExcel("Book1.xlsx", "Sheet1");
        for (Object[] row : testData) {
            String action = row[0].toString();
            String value = row[1].toString();

                switch (action) {
                    case "Navigate":
                        driver.get(value);
                        break;
                    case "Username":
                        loginPageLocator.txtUsername.sendKeys(value);
                        Thread.sleep(3000);
                        break;
                    case "Password":
                        loginPageLocator.txtPassword.sendKeys(value);
                        Thread.sleep(3000);
                        break;
                    case "Click":
                        loginPageLocator.btnLogin.click();
                        Thread.sleep(3000);
                        break;
                    case "Check title page":
                        Assert.assertEquals(driver.getTitle(), value);
                        Thread.sleep(3000);
                        break;
                }
            }
        }

    @AfterTest
    public void AfterRunTest() {
        Log.info("Tear Down");
        HelperClass.teardown();
    }
}

