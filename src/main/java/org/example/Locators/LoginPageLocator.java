package org.example.Locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageLocator {
    @FindBy(xpath = "//input[@id='user-name']")
    public WebElement txtUsername;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement txtPassword;

    @FindBy(xpath = "//input[@id='login-button']")
    public WebElement btnLogin;
}
