package test.youtrack.Tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SmokeTest {

    @Test
    void openYouTrack() {
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("http://localhost:8080");
            String title = driver.getTitle();
            System.out.println("Page title: " + title);
            assertTrue(driver.getCurrentUrl().contains("localhost:8080"), "Youtrack должен быть открыт");
        } finally {
            driver.quit();
        }
    }
}
