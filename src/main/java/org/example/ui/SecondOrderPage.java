package org.example.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecondOrderPage extends BasePage {
    // Поле ввода "Когда привезти самокат"
    private final By deliveryDateInput = By.xpath(".//*[@placeholder='* Когда привезти самокат']");
    // Поле ввода "Срок аренды"
    private final By rentalPeriodInput = By.xpath(".//*[@class='Dropdown-arrow']");
    // Поле ввода "Комментарий для курьера"
    private final By commentForCourierInput = By.xpath(".//*[@placeholder='Комментарий для курьера']");
    // Кнопка "Заказать"
    private final By orderButton = By.xpath(".//*[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    // Кнопка подтверждения заказа "Да"
    private final By confirmationOrderButton = By.xpath("//button[contains(text(), 'Да')]");
    // Всплывающее окно "Заказ оформлен"
    private final By orderSubmittedScreen = By.xpath("//button[contains(text(), 'Посмотреть статус')]");

    public SecondOrderPage(WebDriver driver) {
        super(driver);
    }

    public void setDeliveryDate(String deliveryDate) {
        driver.findElement(deliveryDateInput).sendKeys(deliveryDate);
    }

    public void setRentalPeriod(String rentalPeriodXPath) {
        driver.findElement(rentalPeriodInput).click();
        driver.findElement(By.xpath(rentalPeriodXPath)).click();
    }

    public void setScooterColor(String scooterColorXPath) {
        driver.findElement(By.xpath(scooterColorXPath)).click();
    }

    public void setCommentForCourier(String commentForCourier) {
        driver.findElement(commentForCourierInput).sendKeys(commentForCourier);
    }

    public void clickOrderButton() {
        driver.findElement(orderButton).click();
    }

    public void clickConfirmationOrderButton() {
        driver.findElement(confirmationOrderButton).click();
    }

    public void fillInTheSecondPageOfData(String deliveryDate, String rentalPeriodXPath, String scooterColorXPath, String commentForCourier) {
        setDeliveryDate(deliveryDate);
        setRentalPeriod(rentalPeriodXPath);
        setScooterColor(scooterColorXPath);
        setCommentForCourier(commentForCourier);
        clickOrderButton();
        clickConfirmationOrderButton();
    }

    public boolean isOrderSubmittedScreenVisible() {
        return driver.findElement(orderSubmittedScreen).isDisplayed();
    }

}
