package test.youtrack.Tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import test.youtrack.Pages.LoginPage;
import test.youtrack.Pages.DashboardPage;

public class DashboardTest extends BaseTest {

    @ParameterizedTest
    @CsvFileSource(
            resources = "/login.csv",
            numLinesToSkip = 1 )
    void dashboardShouldBeDisplayedAfterLogin(String username, String password) {

        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = new DashboardPage(driver);

        loginPage.login(username, password);

        assertTrue(
                dashboardPage.isNewDashboardButtonDisplayed(),
                "Dashboard должен отображаться после успешной авторизации"
        );
    }

    @ParameterizedTest
    @CsvFileSource(
            resources = "/login.csv",
            numLinesToSkip = 1 )
    void newDashboardTest(String username, String password) {

        LoginPage loginPage = new LoginPage(driver);
        DashboardPage dashboardPage = new DashboardPage(driver);

        loginPage.login(username, password);

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
