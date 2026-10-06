package test.youtrack.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By dashboardLink = By.xpath("//a[@data-test='ring-link' and @href='dashboard']");

    private final By dashboardTitle = By.xpath("//a[@href='dashboard' and text()='Dashboards']");

    private final By newDashboardButton = By.xpath("//*[@data-test='new-dashboard-button']");

    private final By addWidgetButton = By.xpath("//*[@data-test='add-widget-button']");

    private final By dashboardWidget = By.xpath("//*[@data-test='dashboard-compatible-widget']");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openDashboard() {
        wait.until(ExpectedConditions.elementToBeClickable(dashboardLink)).click();
    }

    public boolean isDashboardDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardTitle)).isDisplayed();
    }

    public String getDashboardTitle() {
        return wait.until( ExpectedConditions.visibilityOfElementLocated(dashboardTitle) ).getText();
    }

    public boolean isNewDashboardButtonDisplayed() {
        return wait.until( ExpectedConditions.visibilityOfElementLocated(newDashboardButton) ).isDisplayed();
    }

    public boolean isAddWidgetButtonDisplayed() {
        return wait.until( ExpectedConditions.visibilityOfElementLocated(addWidgetButton) ).isDisplayed();
    }

    public boolean isWidgetDisplayed() {
        return wait.until( ExpectedConditions.visibilityOfElementLocated(dashboardWidget) ).isDisplayed();
    }
}

