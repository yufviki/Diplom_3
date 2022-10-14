package site.nomoreparties.stellarburgers.StellarBurgersPages;

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

    //метод заполняет поле ввода "Имя"
    public void setName(String name) {
        driver.findElement(inputName).sendKeys(name);
    }

    //метод заполняет поле ввода "Email"
    public void setEmail(String email) {
        driver.findElement(inputEmail).sendKeys(email);
    }

    //метод заполняет поле ввода "Пароль"
    public void setPassword(String password) {
        driver.findElement(inputPassword).sendKeys(password);
    }

    //метод кликает по кнопке "Зарегистрироваться"
    public void clickButtonRegister() {
        driver.findElement(buttonRegister).click();
    }

    //метод кликает по ссылке "Войти"
    public void clickLinkLogin() {
        driver.findElement(linkLogin).click();
    }

    //метод регистрирует пользователя
    public void registration(String name, String email, String password) {
        setName(name);
        setEmail(email);
        setPassword(password);
        clickButtonRegister();
    }

    //метод отдает текст ошибки поля "Пароль"
    public String getTextErrorInputPassword() {
        return driver.findElement(errorInputPassword).getText();
    }
}
