package site.nomoreparties.stellarburgers.pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    private WebDriver driver;
    //локатор поля ввода "Имя"
    private By inputName = By.xpath(".//label[text()='Имя']/parent::div/input");
    //локатор поля ввода "Email"
    private By inputEmail = By.xpath(".//label[text()='Email']/parent::div/input");
    //локатор поля ввода "Пароль"
    private By inputPassword = By.name("Пароль");
    //локатор кнопки "Зарегистрироваться"
    private By buttonRegister = By.cssSelector(".button_button__33qZ0");
    //локатор ссылки "Войти"
    private By linkLogin = By.xpath(".//a[text()='Войти']");
    //локатор ошибки валидации поля "Пароль"
    private By errorInputPassword = By.cssSelector(".input__error");

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Заполнение поля ввода \"Имя\" для страницы регистрации")
    public void setName(String name) {
        driver.findElement(inputName).sendKeys(name);
    }

    @Step("Заполнение поля ввода \"Email\" для страницы регистрации")
    public void setEmail(String email) {
        driver.findElement(inputEmail).sendKeys(email);
    }

    @Step("Заполнение поля ввода \"Пароль\" для страницы регистрации")
    public void setPassword(String password) {
        driver.findElement(inputPassword).sendKeys(password);
    }

    @Step("Переход по клику на кнопку \"Зарегистрироваться\" для страницы регистрации")
    public void clickButtonRegister() {
        driver.findElement(buttonRegister).click();
    }

    @Step("Переход по клику на ссылку \"Войти\" для страницы регистрации")
    public void clickLinkLogin() {
        driver.findElement(linkLogin).click();
    }

    @Step("Регистрация пользователя")
    public void registration(String name, String email, String password) {
        setName(name);
        setEmail(email);
        setPassword(password);
        clickButtonRegister();
    }

    @Step("Получение текста ошибки валидации поля \"Пароль\"")
    public String getTextErrorInputPassword() {
        return driver.findElement(errorInputPassword).getText();
    }
}
