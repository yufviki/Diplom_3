package site.nomoreparties.stellarburgers.stellarburgerstests;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import site.nomoreparties.stellarburgers.pageobjects.AccountProfilePage;
import site.nomoreparties.stellarburgers.pageobjects.Header;
import site.nomoreparties.stellarburgers.pageobjects.HomePage;
import site.nomoreparties.stellarburgers.pageobjects.LoginPage;
import site.nomoreparties.stellarburgers.stellarburgerstests.utils.UserAuthorizationData;

public class HeaderTests extends TestBase {
    Header header;
    HomePage homePage;
    LoginPage loginPage;
    AccountProfilePage accountProfilePage;

    @Before
    public void setUpHomePageTests() {
        header = new Header(driver);
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        accountProfilePage = new AccountProfilePage(driver);
    }

    @DisplayName("Вход через кнопку \"Личный кабинет\" в шапке сайта")
    @Description("Пользователь авторизовывается и переходит в личный кабинет. В личном кабинете проверяется текст заголовка \"Профиль\"")
    @Test
    public void LoginOnAccountProfileInHeaderTest() {
        header.clickButtonAccountProfile();
        loginPage.login(UserAuthorizationData.EMAIL, UserAuthorizationData.PASSWORD);
        header.clickButtonAccountProfile();

        String actualHeader = accountProfilePage.getLinkProfile();
        String expectedHeader = "Профиль";
        String errorMessage = "Ошибка перехода в личный кабинет пользователя";
        Assert.assertEquals(errorMessage, expectedHeader, actualHeader);
    }

    @DisplayName("Переход по клику на \"Личный кабинет\" в шапке сайта")
    @Description("Не авторизованный пользователь кликает на \"Личный кабинет\" в шапке сайта. На странице авторизации проверяется текст заголовка \"Вход\"")
    @Test
    public void GoToAccountProfileTest() {
        header.clickButtonAccountProfile();

        String actualHeader = loginPage.getTextHeaderLogin();
        String expectedHeader = "Вход";
        String errorMessage = "Ошибка перехода на страницу авторизации: не верный заголовок страницы";
        Assert.assertEquals(errorMessage, expectedHeader, actualHeader);
    }

    @DisplayName("Переход из личного кабинета по клику на \"Конструктор\" в шапке сайта")
    @Description("Пользователь авторизовывается, переходит в личный кабинет и кликает на \"Конструктор\" в шапке сайта. На главной проверяется текст заголовка \"Соберите бургер\"")
    @Test
    public void GoToConstructorFromAccountProfileTest() {
        header.clickButtonAccountProfile();
        loginPage.login(UserAuthorizationData.EMAIL, UserAuthorizationData.PASSWORD);
        header.clickButtonAccountProfile();
        accountProfilePage.waitLinkProfile();
        header.clickButtonConstructor();

        String actualHeader = homePage.getTextHeaderConstructor();
        String expectedHeader = "Соберите бургер";
        String errorMessage = "Ошибка перехода на страницу конструктора: не верный заголовок страницы";
        Assert.assertEquals(errorMessage, expectedHeader, actualHeader);
    }

    @DisplayName("Переход из личного кабинета по клику на логотип \"Stellar Burgers\" в шапке сайта")
    @Description("Пользователь авторизовывается, переходит в личный кабинет и кликает на логотип \"Stellar Burgers\" в шапке сайта. На главной проверяется текст заголовка \"Соберите бургер\"")
    @Test
    public void GoToLogoStellarBurgersFromAccountProfileTest() {
        header.clickButtonAccountProfile();
        loginPage.login(UserAuthorizationData.EMAIL, UserAuthorizationData.PASSWORD);
        header.clickButtonAccountProfile();
        accountProfilePage.waitLinkProfile();
        header.clickLogoStellarBurgers();

        String actualHeader = homePage.getTextHeaderConstructor();
        String expectedHeader = "Соберите бургер";
        String errorMessage = "Ошибка перехода на страницу конструктора: не верный заголовок страницы";
        Assert.assertEquals(errorMessage, expectedHeader, actualHeader);
    }
}
