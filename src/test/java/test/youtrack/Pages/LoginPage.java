package test.youtrack.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;

    private final WebDriverWait wait;

    private final By usernameInput = By.id("username");

    private final By passwordInput = By.id("password");

    private final By loginButton = By.cssSelector("[data-test='login-button']");

    private final By errorMessage = By.cssSelector("[data-test='error-message']");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput)).sendKeys(username);
    }
    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput)).sendKeys(password);
    }
    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();

    }
    public void clearUsername() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameInput)).clear();
    }
    public void clearPassword() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordInput)).clear();
    }

    public String geterrorMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).getText();
    }
}
