package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {
        LoginPage login = new LoginPage(driver);

        login.load();
        login.login("standard_user", "secret_sauce");
        //here username is admin and password

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("inventory"));
        
        Assert.assertTrue(driver.findElement(By.className("title")).isDisplayed());

    }
}
