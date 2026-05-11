package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class DashboardPage {

    WebDriver driver;

    public DashboardPage(WebDriver driver) {

        this.driver = driver;
    }

    // Locators

    By profileDropdown =
            By.className("oxd-userdropdown-tab");

    By logoutButton =
            By.linkText("Logout");

    // Actions

    public void clickProfileDropdown() {

        WaitUtils waitUtils = new WaitUtils(driver);

        waitUtils
                .waitForElementVisible(profileDropdown)
                .click();
    }

    public void clickLogout() {

        WaitUtils waitUtils = new WaitUtils(driver);

        waitUtils
                .waitForElementVisible(logoutButton)
                .click();
    }

    public void logout() {

        clickProfileDropdown();

        clickLogout();
    }
}
