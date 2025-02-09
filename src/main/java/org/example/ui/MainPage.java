package org.example.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class MainPage {
    // Кнопка "Заказать" вверху страницы
    private final By topOrderButton = By.xpath(".//*[@class='Button_Button__ra12g']");
    // Кнопка "Заказать" внизу страницы
    private final By bottomOrderButton = By.xpath("//*[@id='root']/div/div/div[4]/div[2]/div[5]/button");
    // Выпадающий список "Сколько это стоит? И как оплатить?"

    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickTopOrderButton() {
        driver.findElement(topOrderButton).click();
    }

    public void clickBottomOrderButton() {
        driver.findElement(bottomOrderButton).click();
    }

    public void scrollToBottomOrderButton() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
                driver.findElement(bottomOrderButton));
    }
}
