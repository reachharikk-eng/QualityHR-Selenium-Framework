package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

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
            By.cssSelector(".oxd-alert-content-text");

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

        WaitUtils waitUtils = new WaitUtils(driver);

        return waitUtils
                .waitForElementVisible(errorMessage)
                .getText();
    }
}
