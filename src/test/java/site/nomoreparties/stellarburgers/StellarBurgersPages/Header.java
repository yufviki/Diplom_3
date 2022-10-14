package site.nomoreparties.stellarburgers.StellarBurgersPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header {
    private WebDriver driver;
    //локатор логотипа "Stellar Burgers"
    private By logoStellarBurgers = By.cssSelector(".AppHeader_header__logo__2D0X2");
    //локатор кнопки "Конструктор"
    private By buttonConstructor = By.xpath(".//ul[@class='AppHeader_header__list__3oKJj']//p[text()='Конструктор']");
    //локатор кнопки "Личный кабинет"
    private By buttonAccountProfile = By.xpath(".//a[@class='AppHeader_header__link__3D_hX']//p[text()='Личный Кабинет']");

    public Header(WebDriver driver) {
        this.driver = driver;
    }

    //метод кликает по логотипу "Stellar Burgers"
    public void clickLogoStellarBurgers() {
        driver.findElement(logoStellarBurgers).click();
    }

    //метод кликает по кнопке "Конструктор"
    public void clickButtonConstructor() {
        driver.findElement(buttonConstructor).click();
    }

    //метод кликает по кнопке "Личный кабинет"
    public void clickButtonAccountProfile() {
        driver.findElement(buttonAccountProfile).click();
    }
}
