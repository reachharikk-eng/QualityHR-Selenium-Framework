package tests;
import pages.DashboardPage;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test(priority = 1)

    public void verifyValidLogin() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("Admin", "admin123");

        String currentUrl = driver.getCurrentUrl();

        Assert.assertTrue(currentUrl.contains("dashboard"));

        System.out.println("Valid Login Test Passed");
    }

    @Test(priority = 2)

    public void verifyInvalidLogin() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("Admin", "wrongpassword");

        String actualError = loginPage.getErrorMessage();

        String expectedError = "Invalid credentials";

        Assert.assertEquals(actualError, expectedError);

        System.out.println("Invalid Login Test Passed");
    }

    @Test(priority = 3)

    public void verifyEmptyFieldValidation() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.clickLogin();

        String currentUrl = driver.getCurrentUrl();

        Assert.assertTrue(currentUrl.contains("login"));

        System.out.println("Empty Validation Test Passed");
    }

    @Test(priority = 4)

    public void verifyLogout() {

        LoginPage loginPage = new LoginPage(driver);

        DashboardPage dashboardPage =
                new DashboardPage(driver);

        loginPage.login("Admin", "admin123");

        dashboardPage.logout();

        String currentUrl = driver.getCurrentUrl();

        Assert.assertTrue(currentUrl.contains("login"));

        System.out.println("Logout Test Passed");
    }

}