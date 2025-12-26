package pages;

import config.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

    By username = By.id("username");
    By password = By.id("password");
    By loginBtn = By.id("login");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void load() {
        driver.get(ConfigReader.get("base.url") + "/login");
    }

    public void login(String user, String pwd) {
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(loginBtn).click();
    }
}
