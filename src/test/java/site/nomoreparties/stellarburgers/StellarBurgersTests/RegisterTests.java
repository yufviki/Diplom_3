package site.nomoreparties.stellarburgers.StellarBurgersTests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.StellarBurgersPages.*;
import site.nomoreparties.stellarburgers.StellarBurgersTests.utils.UserAuthorizationData;
import site.nomoreparties.stellarburgers.StellarBurgersTests.utils.UserGenerateRegisterData;

public class RegisterTests extends TestBase {
    Header header;
    HomePage homePage;
    LoginPage loginPage;
    RegisterPage registerPage;

    @Before
    public void setUpRegisterTests() {
        header = new Header(driver);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
    }

    @DisplayName("Вход через кнопку в форме регистрации")
    @Description("Пользователь со страницы логина переходит в форму регистрации, кликает по ссылке \"Войти\" и авторизовывается. Его редиректит на главную, где проверяется текст кнопки \"Оформить заказ\", она появляется только для авторизованного пользователя")
    @Test
    public void LoginOnRegisterPageTest() {
        header.clickButtonAccountProfile();
        loginPage.clickLinkRegister();
        registerPage.clickLinkLogin();
        loginPage.login(UserAuthorizationData.EMAIL, UserAuthorizationData.PASSWORD);

        String actualButton = homePage.getTextButtonOrder();
        String expectedButton = "Оформить заказ";
        String errorMessage = "Ошибка входа в аккаунт";
        Assert.assertEquals(errorMessage, expectedButton, actualButton);
    }

    @DisplayName("Успешная регистрация пользователя")
    @Description("Пользователь со страницы логина переходит в форму регистрации, регистрируется. Его редиректит на страницу авторизации, где проверяется текст заголовка \"Вход\"")
    @Test
    public void SuccessRegisterUserTest() {
        header.clickButtonAccountProfile();
        loginPage.clickLinkRegister();
        registerPage.registration(UserGenerateRegisterData.getValidNameData(),
                UserGenerateRegisterData.getValidEmailData(), UserGenerateRegisterData.getValidPasswordData());

        String actualHeader = loginPage.getTextHeaderLogin();
        String expectedHeader = "Вход";
        String errorMessage = "Ошибка регистрации пользователя";
        Assert.assertEquals(errorMessage, expectedHeader, actualHeader);
    }

    @DisplayName("В форме регистрации проверяется ошибка валидации \"Некорректный пароль\"")
    @Description("Пользователь со страницы логина переходит в форму регистрации, регистрируется и вводит некорректный пароль. Проверяется текст ошибки валидации пароля \"Некорректный пароль\"")
    @Test
    public void ErrorForInvalidPasswordWhenRegisterUserTest() {
        header.clickButtonAccountProfile();
        loginPage.clickLinkRegister();
        registerPage.registration(UserGenerateRegisterData.getValidNameData(),
                UserGenerateRegisterData.getValidEmailData(), UserGenerateRegisterData.getInvalidPasswordData());

        String actualPasswordMessage = registerPage.getTextErrorInputPassword();
        String expectedPasswordMessage = "Некорректный пароль";
        String errorMessage = "Не верное сообщение ошибки валидации пароля";
        Assert.assertEquals(errorMessage, expectedPasswordMessage, actualPasswordMessage);
    }
}
