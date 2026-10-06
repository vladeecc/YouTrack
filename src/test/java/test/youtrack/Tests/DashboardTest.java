package test.youtrack.Tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import test.youtrack.Pages.LoginPage;
import test.youtrack.Pages.DashboardPage;
import static test.youtrack.Data.DataLogPass.VALID_USERNAME;
import static test.youtrack.Data.DataLogPass.VALID_PASSWORD;

public class DashboardTest extends BaseTest {

    @Test
    void dashboardShouldBeDisplayedAfterLogin() {
        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = new DashboardPage(driver);

        loginPage.login(VALID_USERNAME, VALID_PASSWORD);

        String currentUrl = driver.getCurrentUrl();
        System.out.println("URL после авторизации: " + currentUrl);
        assertTrue(currentUrl.startsWith("http://localhost:8080/dashboard"),
                "После успешной авторизации должен быть выполнен переход на dashboard");
    }
}
