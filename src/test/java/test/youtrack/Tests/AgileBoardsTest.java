package test.youtrack.Tests;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import test.youtrack.Pages.AgileBoardsPage;
import test.youtrack.Pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static test.youtrack.Data.DataLogPass.VALID_PASSWORD;
import static test.youtrack.Data.DataLogPass.VALID_USERNAME;

public class AgileBoardsTest extends BaseTest {

    @ParameterizedTest
    @CsvFileSource(
            resources = "/login.csv",
            numLinesToSkip = 1 )
    void userShouldBeAbleToOpenAgileBoards(String username, String password) {

        LoginPage loginPage = new LoginPage(driver);
        AgileBoardsPage agileBoardsPage = new AgileBoardsPage(driver);

        loginPage.login(username, password);

        agileBoardsPage.openAgileBoards();

        assertTrue(
                agileBoardsPage.isAgileBoardsDisplayed(),
                "Страница AgileBoards должна отображаться после перехода"
        );
    }
}

