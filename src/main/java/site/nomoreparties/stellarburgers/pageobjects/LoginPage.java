package site.nomoreparties.stellarburgers.pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;
    //локатор заголовка "Вход"
    private By headerLogin = By.xpath(".//h2[text()='Вход']");
    //локатор поля ввода "Email"
    private By inputEmail = By.name("name");
    //локатор поля ввода "Пароль"
    private By inputPassword = By.name("Пароль");
    //локатор кнопки "Войти"
    private By buttonLogin = By.xpath(".//button[text()='Войти']");
    //локатор ссылки "Зарегистрироваться"
    private By linkRegister = By.xpath(".//a[text()='Зарегистрироваться']");
    //локатор ссылки "Восстановить пароль"
    private By linkForgotPassword = By.xpath(".//a[text()='Восстановить пароль']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Получение текста заголовка страницы логина \"Вход\"")
    public String getTextHeaderLogin() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(headerLogin));
        return driver.findElement(headerLogin).getText();
    }

    @Step("Заполнение поля ввода \"Email\" для страницы логина")
    public void setEmail(String email) {
        driver.findElement(inputEmail).sendKeys(email);
    }

    @Step("Заполнение поля ввода \"Пароль\" для страницы логина")
    public void setPassword(String password) {
        driver.findElement(inputPassword).sendKeys(password);
    }

    @Step("Переход по клику на кнопку \"Войти\" для страницы логина")
    public void clickButtonLogin() {
        driver.findElement(buttonLogin).click();
    }

    @Step("Авторизация пользователя")
    public void login(String email, String password) {
        setEmail(email);
        setPassword(password);
        clickButtonLogin();
    }

    @Step("Переход по клику на ссылку \"Зарегистрироваться\" для страницы логина")
    public void clickLinkRegister() {
        driver.findElement(linkRegister).click();
    }

    @Step("Переход по клику на ссылку \"Восстановить пароль\" для страницы логина")
    public void clickLinkForgotPassword() {
        driver.findElement(linkForgotPassword).click();
    }
}
