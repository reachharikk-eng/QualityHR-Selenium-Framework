package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    // Constructor

    public LoginPage(WebDriver driver) {

        this.driver = driver;
    }

    // Locators

    By usernameField = By.name("username");

    By passwordField = By.name("password");

    By loginButton = By.xpath("//button[@type='submit']");

    By errorMessage =
            By.xpath("//p[contains(text(),'Invalid credentials')]");

    // Actions

    public void enterUsername(String username) {

        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {

        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {

        driver.findElement(loginButton).click();
    }

    public void login(String username, String password) {

        enterUsername(username);

        enterPassword(password);

        clickLogin();
    }

    public String getErrorMessage() {

        return driver.findElement(errorMessage).getText();
    }
}
