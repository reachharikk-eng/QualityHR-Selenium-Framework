package tests;

import base.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test

    public void verifyLoginPageTitle() {

        String title = driver.getTitle();

        System.out.println("Page Title: " + title);
    }
}
