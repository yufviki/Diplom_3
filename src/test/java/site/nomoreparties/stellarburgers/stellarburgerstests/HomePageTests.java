package site.nomoreparties.stellarburgers.stellarburgerstests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pageobjects.HomePage;
import site.nomoreparties.stellarburgers.pageobjects.LoginPage;
import site.nomoreparties.stellarburgers.stellarburgerstests.utils.UserAuthorizationData;

public class HomePageTests extends TestBase {
    HomePage homePage;
    LoginPage loginPage;

    @Before
    public void setUpHomePageTests() {
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
    }

    @DisplayName("Вход на главной по кнопке \"Войти в аккаунт\"")
    @Description("На главной пользователь кликает по кнопке \"Войти в аккаунт\", авторизовывается. Его редиректит на главную, где проверяется текст кнопки \"Оформить заказ\", она появляется только для авторизованного пользователя")
    @Test
    public void LoginFromHomePageTest() {
        homePage.clickButtonLogin();
        loginPage.login(UserAuthorizationData.EMAIL, UserAuthorizationData.PASSWORD);

        String actualButton = homePage.getTextButtonOrder();
        String expectedButton = "Оформить заказ";
        String errorMessage = "Ошибка входа в аккаунт";
        Assert.assertEquals(errorMessage, expectedButton, actualButton);
    }

    @DisplayName("Проверяется переход в конструкторе к разделу \"Булки\"")
    @Description("Пользователь кликает по вкадке \"Соусы\", затем возвращается на вкладку \"Булки\". Переход проверяется по классу активной вкладки \"Булки\"")
    @Test
    public void GoToTabBunTest() {
        homePage.clickTabSauce();
        homePage.clickTabBun();

        String actualClassTabBun = homePage.getClassTabBun();
        String expectedClassTabBun = "tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect";
        String errorMessage = "Неверная вкладка конструктора: атрибут class для активной вкладки не обновился";
        Assert.assertEquals(errorMessage, expectedClassTabBun, actualClassTabBun);
    }

    @DisplayName("Проверяется переход в конструкторе к разделу \"Соусы\"")
    @Description("Пользователь кликает по вкадке \"Соусы\". Переход проверяется по классу активной вкладки \"Соусы\"")
    @Test
    public void GoToTabSauceTest() {
        homePage.clickTabSauce();

        String actualClassTabSauce = homePage.getClassTabSauce();
        String expectedClassTabSauce = "tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect";
        String errorMessage = "Неверная вкладка конструктора: атрибут class для активной вкладки не обновился";
        Assert.assertEquals(errorMessage, expectedClassTabSauce, actualClassTabSauce);
    }

    @DisplayName("Проверяется переход в конструкторе к разделу \"Начинки\"")
    @Description("Пользователь кликает по вкадке \"Начинки\". Переход проверяется по классу активной вкладки \"Начинки\"")
    @Test
    public void GoToTabToppingTest() {
        homePage.clickTabTopping();

        String actualClassTabTopping = homePage.getClassTabTopping();
        String expectedClassTabTopping = "tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect";
        String errorMessage = "Неверная вкладка конструктора: атрибут class для активной вкладки не обновился";
        Assert.assertEquals(errorMessage, expectedClassTabTopping, actualClassTabTopping);
    }
}
