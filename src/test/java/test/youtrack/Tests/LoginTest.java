package test.youtrack.Tests;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import test.youtrack.Pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class LoginTest extends BaseTest {
    @ParameterizedTest
    @CsvFileSource(
            resources = "/login.csv",
            numLinesToSkip = 1 )
    void succesfulLogin(String username, String password) {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.login(username, password);
            String currentUrl = driver.getCurrentUrl();
            System.out.println("URL после авторизации: " + currentUrl);
            assertTrue(currentUrl.startsWith("http://localhost:8080/oauth"),
                    "После успешной авторизации должен быть выполнен переход на OAuth");
        }
    @ParameterizedTest
    @CsvFileSource(
            resources = "/login.csv",
            numLinesToSkip = 1 )
    void invalidPassword(String username) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, "admin12");
        String errorMessage = loginPage.geterrorMessage();
        System.out.println("Сообщение об ошибке: " + errorMessage);
        assertTrue(errorMessage.length() > 0, "При неверном пароле должна отображаться ошибка");
    }
    @ParameterizedTest
    @CsvFileSource(
            resources = "/login.csv",
            numLinesToSkip = 1 )
    void invalidLogin(String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin1", password);
        String errorMessage = loginPage.geterrorMessage();
        System.out.println("Сообщение об ошибке: " + errorMessage);
        assertTrue(errorMessage.length() > 0, "При неверном логине должна отображаться ошибка");
    }
    @ParameterizedTest
    @CsvSource({"admin, admin12", "wrongadmin, wrongpass", "admin, 8656789"})
    void loginWithInvalidData(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
        String errorMessage = loginPage.geterrorMessage();
        System.out.println("Username: " + username + ", Password" + password);
        System.out.println("Ошибка: " + errorMessage);
        assertTrue(errorMessage.length() > 0, "При неверных данных должна появиться ошибка");
    }
    @ParameterizedTest
    @CsvFileSource(
            resources = "/login.csv",
            numLinesToSkip = 1 )
    void emptyUsername(String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("", password);
        String errorMessage = loginPage.geterrorMessage();
        System.out.println("URL после отправки формы: " + driver.getCurrentUrl());
        assertFalse(driver.getCurrentUrl().contains("/oauth"), "Пользователь не должен быть авторизован без username");
    }
    @ParameterizedTest
    @CsvFileSource(
            resources = "/login.csv",
            numLinesToSkip = 1 )
    void emptyPassword(String username) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, "");
        String errormessage = loginPage.geterrorMessage();
        System.out.println("URL после отправки формы: " + driver.getCurrentUrl());
        assertFalse(driver.getCurrentUrl().contains("/oauth"), "Пользователь не должен быть авторизован без password");

    }


}

