package site.nomoreparties.stellarburgers.StellarBurgersTests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.StellarBurgersPages.AccountProfilePage;
import site.nomoreparties.stellarburgers.StellarBurgersPages.Header;
import site.nomoreparties.stellarburgers.StellarBurgersPages.LoginPage;
import site.nomoreparties.stellarburgers.StellarBurgersTests.utils.UserAuthorizationData;

public class AccountProfileTests extends TestBase {
    Header header;
    LoginPage loginPage;
    AccountProfilePage accountProfilePage;

    @Before
    public void setUpHomePageTests() {
        header = new Header(driver);
        loginPage = new LoginPage(driver);
        accountProfilePage = new AccountProfilePage(driver);
    }

    @Test
    @DisplayName("Выход по кнопке \"Выйти\" в личном кабинете")
    @Description("Авторизовывается пользователь, переходит в личный кабинет и кликает по кнопке выйти. После выхода проверяется заголовок страницы авторизации \"Вход\"")
    public void LogoutInAccountProfilePageTest() {
        header.clickButtonAccountProfile();
        loginPage.login(UserAuthorizationData.EMAIL,UserAuthorizationData.PASSWORD);
        header.clickButtonAccountProfile();
        accountProfilePage.clickButtonLogout();

        String actualHeader = loginPage.getTextHeaderLogin();
        String expectedHeader = "Вход";
        String errorMessage = "Ошибка выхода из аккаунта: не верный заголовок страницы авторизации";
        Assert.assertEquals(errorMessage, expectedHeader, actualHeader);
    }
}
