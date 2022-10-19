package site.nomoreparties.stellarburgers.pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {
    private WebDriver driver;
    //локатор ссылки "Войти"
    private By buttonLogin = By.cssSelector(".Auth_link__1fOlj");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Переход по клику на ссылку \"Войти\"")
    public void clickButtonLogin() {
        driver.findElement(buttonLogin).click();
    }
}
