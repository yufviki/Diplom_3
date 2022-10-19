package site.nomoreparties.stellarburgers.stellarburgerstests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.stellarburgerstests.utils.UserAuthorizationData;
import site.nomoreparties.stellarburgers.pageobjects.ForgotPasswordPage;
import site.nomoreparties.stellarburgers.pageobjects.Header;
import site.nomoreparties.stellarburgers.pageobjects.HomePage;
import site.nomoreparties.stellarburgers.pageobjects.LoginPage;

public class ForgotPasswordTests extends TestBase {
    Header header;
    HomePage homePage;
    LoginPage loginPage;
    ForgotPasswordPage forgotPasswordPage;

    @Before
    public void setUpForgotPasswordTests() {
        header = new Header(driver);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        forgotPasswordPage = new ForgotPasswordPage(driver);
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    @Description("Через форму восстановления пароля, авторизовывается пользователь. Его редиректит на главную, где проверяется текст кнопки \"Оформить заказ\", она появляется только для авторизованного пользователя")
    public void LoginOnForgotPasswordPageTest() {
        header.clickButtonAccountProfile();
        loginPage.clickLinkForgotPassword();
        forgotPasswordPage.clickButtonLogin();
        loginPage.login(UserAuthorizationData.EMAIL, UserAuthorizationData.PASSWORD);

        String actualButton = homePage.getTextButtonOrder();
        String expectedButton = "Оформить заказ";
        String errorMessage = "Ошибка входа в аккаунт";
        Assert.assertEquals(errorMessage, expectedButton, actualButton);
    }
}
