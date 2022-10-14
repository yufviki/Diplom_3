package site.nomoreparties.stellarburgers.StellarBurgersPages;

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

    //метод получает текст заголовка "Вход"
    public String getTextHeaderLogin() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(headerLogin));
        return driver.findElement(headerLogin).getText();
    }

    //метод заполняет поле ввода "Email"
    public void setEmail(String email) {
        driver.findElement(inputEmail).sendKeys(email);
    }

    //метод заполняет поле ввода "Пароль"
    public void setPassword(String password) {
        driver.findElement(inputPassword).sendKeys(password);
    }

    //метод кликает по кнопке "Войти"
    public void clickButtonLogin() {
        driver.findElement(buttonLogin).click();
    }

    //метод авторизовывает пользователя
    public void login(String email, String password) {
        setEmail(email);
        setPassword(password);
        clickButtonLogin();
    }

    //метод кликает по ссылке "Зарегистрироваться"
    public void clickLinkRegister() {
        driver.findElement(linkRegister).click();
    }

    //метод кликает по ссылке "Восстановить пароль"
    public void clickLinkForgotPassword() {
        driver.findElement(linkForgotPassword).click();
    }
}
