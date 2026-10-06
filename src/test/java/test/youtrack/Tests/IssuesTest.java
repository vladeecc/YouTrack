package test.youtrack.Tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import test.youtrack.Pages.IssuesPage;
import test.youtrack.Pages.LoginPage;
import static test.youtrack.Data.DataLogPass.VALID_USERNAME;
import static test.youtrack.Data.DataLogPass.VALID_PASSWORD;

public class IssuesTest extends BaseTest {

    @Test
    void userShouldBeAbleToOpenIssues() {

        LoginPage loginPage = new LoginPage(driver);
        IssuesPage issuesPage = new IssuesPage(driver);

        loginPage.login(VALID_USERNAME, VALID_PASSWORD);

        issuesPage.openIssues();

        assertTrue(
                issuesPage.isIssuesDisplayed(),
                "Страница Issues должна отображаться после перехода"
        );
    }
}
