package site.nomoreparties.stellarburgers.StellarBurgersPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    private WebDriver driver;
    //локатор ссылки "Войти"
    private By buttonLogin = By.cssSelector(".Auth_link__1fOlj");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    //метод кликает по ссылке "Войти"
    public void clickButtonLogin() {
        driver.findElement(buttonLogin).click();
    }
}
