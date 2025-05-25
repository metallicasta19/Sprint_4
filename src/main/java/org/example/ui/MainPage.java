package org.example.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {
    // Кнопка "Заказать" вверху страницы
    private final By topOrderButton = By.xpath(".//*[@class='Button_Button__ra12g']");
    // Кнопка "Заказать" внизу страницы
    private final By bottomOrderButton = By.xpath(".//*[@class='Home_FinishButton__1_cWm']/button");

    public MainPage(WebDriver driver) {
        super(driver);
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
