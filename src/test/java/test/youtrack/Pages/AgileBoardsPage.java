package test.youtrack.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AgileBoardsPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By agileBoardsLink =
            By.xpath("//a[@href='agiles']");

    private final By agileBoardsTitle =
            By.xpath("//*[@data-test='agile-boards-title']");

    public AgileBoardsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openAgileBoards() {
        wait.until(ExpectedConditions.elementToBeClickable(agileBoardsLink))
                .click();
    }

    public boolean isAgileBoardsDisplayed() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(agileBoardsTitle)
        ).isDisplayed();
    }
}
