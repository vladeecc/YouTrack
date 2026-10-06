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

        assertTrue(
                dashboardPage.isNewDashboardButtonDisplayed(),
                "Dashboard должен отображаться после успешной авторизации"
        );
    }

    @Test
    void newDashboardTest() {

        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = new DashboardPage(driver);

        loginPage.login(VALID_USERNAME, VALID_PASSWORD);

        assertTrue(
                dashboardPage.isAddWidgetButtonDisplayed(),
                "Кнопка добавления виджета должна отображаться"
        );

        dashboardPage.clickNewDashboard();

        assertTrue(
                dashboardPage.isWidgetDisplayed(),
                "После нажатия Add Widget должен открыться интерфейс добавления виджета"
        );

    }

}
