package test.youtrack.Tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import test.youtrack.Extensions.ScreenshotExtension;

import static test.youtrack.Data.DataLogPass.BASE_URL;

public class BaseTest {
    protected WebDriver driver;

    @RegisterExtension
    ScreenshotExtension screenshotExtension = new ScreenshotExtension(() -> driver);

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(BASE_URL);
    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


