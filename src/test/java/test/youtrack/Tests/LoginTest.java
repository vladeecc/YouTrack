package test.youtrack.Tests;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import test.youtrack.Pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static test.youtrack.Data.DataLogPass.VALID_USERNAME;
import static test.youtrack.Data.DataLogPass.VALID_PASSWORD;

public class LoginTest extends BaseTest {
    @Test
    void succesfulLogin() {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.login(VALID_USERNAME, VALID_PASSWORD);
            String currentUrl = driver.getCurrentUrl();
            System.out.println("URL после авторизации: " + currentUrl);
            assertTrue(currentUrl.startsWith("http://localhost:8080/oauth"),
                    "После успешной авторизации должен быть выполнен переход на OAuth");
        }
    @Test
    void invalidPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(VALID_USERNAME, "admin12");
        String errorMessage = loginPage.geterrorMessage();
        System.out.println("Сообщение об ошибке: " + errorMessage);
        assertTrue(errorMessage.length() > 0, "При неверном пароле должна отображаться ошибка");
    }
    @Test
    void invalidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin1", VALID_PASSWORD);
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
    @Test
    void emptyUsername() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("", VALID_PASSWORD);
        String errorMessage = loginPage.geterrorMessage();
        System.out.println("URL после отправки формы: " + driver.getCurrentUrl());
        assertFalse(driver.getCurrentUrl().contains("/oauth"), "Пользователь не должен быть авторизован без username");
    }
    @Test
    void emptyPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(VALID_USERNAME, "");
        String errormessage = loginPage.geterrorMessage();
        System.out.println("URL после отправки формы: " + driver.getCurrentUrl());
        assertFalse(driver.getCurrentUrl().contains("/oauth"), "Пользователь не должен быть авторизован без password");

    }


}

