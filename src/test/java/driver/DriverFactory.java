package driver;

import config.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverFactory {

    public static WebDriver createDriver() {

        String browser = ConfigReader.get("browser");

        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();

            ChromeOptions options = new ChromeOptions();
            if (ConfigReader.get("headless").equals("true")) {
                options.addArguments("--headless");
            }

            return new ChromeDriver(options);
        }

        throw new RuntimeException("Unsupported browser");
    }
}
