package site.nomoreparties.stellarburgers.pageobjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;
    //локатор кнопки "Войти в аккаунт"
    private By buttonLogin = By.xpath(".//button[text()='Войти в аккаунт']");
    //локатор кнопки "Оформить заказ"
    private By buttonOrder = By.xpath(".//button[text()='Оформить заказ']");
    //локатор заголовка "Соберите бургер"
    private By headerConstructor = By.xpath(".//h1[text()='Соберите бургер']");
    //локатор вкладки конструктора "Булки"
    private By tabBun = By.xpath(".//span[text()='Булки']");
    //локатор  акивной вкладки конструктора "Булки"
    private By activeTabBun = By.xpath(".//span[text()='Булки']/parent::div");
    //локатор вкладки конструктора "Соусы"
    private By tabSauce = By.xpath(".//span[text()='Соусы']");
    //локатор  акивной вкладки конструктора "Соусы"
    private By activeTabSauce = By.xpath(".//span[text()='Соусы']/parent::div");
    //локатор вкладки конструктора "Начинки"
    private By tabTopping = By.xpath(".//span[text()='Начинки']");
    //локатор  акивной вкладки конструктора "Начинки"
    private By activeTabTopping = By.xpath(".//span[text()='Начинки']/parent::div");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Переход по клику на \"Войти в аккаунт\"")
    public void clickButtonLogin() {
        driver.findElement(buttonLogin).click();
    }

    @Step("Получение текста кнопки \"Оформить заказ\"")
    public String getTextButtonOrder() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(buttonOrder));
        return driver.findElement(buttonOrder).getText();
    }

    @Step("Получение текста заголовка страницы конструктора \"Соберите бургер\"")
    public String getTextHeaderConstructor() {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.elementToBeClickable(headerConstructor));
        return driver.findElement(headerConstructor).getText();
    }

    @Step("Переход по клику на вкладку конструктора \"Булки\"")
    public void clickTabBun() {
        new WebDriverWait(driver, 3);
        driver.findElement(tabBun).click();
    }

    @Step("Получение класса активной вкладки конструктора \"Булки\"")
    public String getClassTabBun() {
        return driver.findElement(activeTabBun).getAttribute("class");
    }

    @Step("Переход по клику на вкладку конструктора \"Соусы\"")
    public void clickTabSauce() {
        new WebDriverWait(driver, 3);
        driver.findElement(tabSauce).click();
    }

    @Step("Получение класса активной вкладки конструктора \"Соусы\"")
    public String getClassTabSauce() {
        return driver.findElement(activeTabSauce).getAttribute("class");
    }

    @Step("Переход по клику на вкладку конструктора \"Начинки\"")
    public void clickTabTopping() {
        new WebDriverWait(driver, 3);
        driver.findElement(tabTopping).click();
    }

    @Step("Получение класса активной вкладки конструктора \"Начинки\"")
    public String getClassTabTopping() {
        return driver.findElement(activeTabTopping).getAttribute("class");
    }
}
