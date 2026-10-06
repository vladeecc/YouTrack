package test.youtrack.Tests;

import org.junit.jupiter.api.Test;
import test.youtrack.Pages.AgileBoardsPage;
import test.youtrack.Pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static test.youtrack.Data.DataLogPass.VALID_PASSWORD;
import static test.youtrack.Data.DataLogPass.VALID_USERNAME;

public class AgileBoardsTest extends BaseTest {

    @Test
    void userShouldBeAbleToOpenAgileBoards() {

        LoginPage loginPage = new LoginPage(driver);
        AgileBoardsPage agileBoardsPage = new AgileBoardsPage(driver);

        loginPage.login(VALID_USERNAME, VALID_PASSWORD);

        agileBoardsPage.openAgileBoards();

        assertTrue(
                agileBoardsPage.isAgileBoardsDisplayed(),
                "Страница AgileBoards должна отображаться после перехода"
        );
    }
}

