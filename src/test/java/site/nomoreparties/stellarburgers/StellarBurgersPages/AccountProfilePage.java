package site.nomoreparties.stellarburgers.StellarBurgersPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountProfilePage {
    private WebDriver driver;
    //локатор ссылки "Профиль"
    private By linkProfile = By.xpath(".//a[text()='Профиль']");
    //локатор кнопки "Выйти"
    private By buttonLogout = By.xpath(".//Button[text()='Выход']");

    public AccountProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    //метод ожидает текст ссылки "Профиль"
    public void waitLinkProfile() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(linkProfile));
    }

    //метод получает текст ссылки "Профиль"
    public String getLinkProfile() {
        waitLinkProfile();
        return driver.findElement(linkProfile).getText();
    }

    //метод кликает по кнопке "Выйти"
    public void clickButtonLogout() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(buttonLogout));
        driver.findElement(buttonLogout).click();
    }
}
