
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.manager.SeleniumManagerOutput;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;



public class SeleniumUITest {
    private static WebDriver driver;
    @BeforeEach
    public void setup() {

        //Driver path not required with Selenium > v4.6 as selenium manager takes acre of the driver
        //System.setProperty("webdriver.chrome.driver", "chromedriver-mac-arm64-latest/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--verbose");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @Test
    public void testLaunchGoogle() throws InterruptedException {

        driver.get("https://google.com");

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        Thread.sleep(5000);

    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }

}
