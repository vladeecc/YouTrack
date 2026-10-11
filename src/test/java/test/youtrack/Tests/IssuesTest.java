package test.youtrack.Tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import test.youtrack.Pages.IssuesPage;
import test.youtrack.Pages.LoginPage;


public class IssuesTest extends BaseTest {

    @ParameterizedTest
    @CsvFileSource(
            resources = "/login.csv",
            numLinesToSkip = 1 )
    void userShouldBeAbleToOpenIssues(String username, String password) {

        LoginPage loginPage = new LoginPage(driver);
        IssuesPage issuesPage = new IssuesPage(driver);

        loginPage.login(username, password);

        issuesPage.openIssues();

        assertTrue(
                issuesPage.isIssuesDisplayed(),
                "Страница Issues должна отображаться после перехода"
        );
    }
}
