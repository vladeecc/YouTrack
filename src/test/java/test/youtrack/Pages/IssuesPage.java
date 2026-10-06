package test.youtrack.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IssuesPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By issuesLink =
            By.xpath("//a[@href='issues']");

    private final By issuesTitle =
            By.xpath("//*[@data-test='issues-title']");

    public IssuesPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openIssues() {
        wait.until(ExpectedConditions.elementToBeClickable(issuesLink))
                .click();
    }

    public boolean isIssuesDisplayed() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(issuesTitle)
        ).isDisplayed();
    }
}
