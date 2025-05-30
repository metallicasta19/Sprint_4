package org.example.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FirstOrderPage extends BasePage {
    // Поле ввода "Имя"
    private final By nameInput = By.xpath(".//*[@placeholder='* Имя']");
    // Поле ввода "Фамилия"
    private final By surnameInput = By.xpath(".//*[@placeholder='* Фамилия']");
    // Поле ввода "Адрес: куда привезти заказ"
    private final By addressInput = By.xpath(".//*[@placeholder='* Адрес: куда привезти заказ']");
    // Поле ввода "Станция метро"
    private final By metroStationInput = By.xpath(".//*[@placeholder='* Станция метро']");
    // Поле ввода "Телефон: на него позвонит курьер"
    private final By phoneNumberInput = By.xpath(".//*[@placeholder='* Телефон: на него позвонит курьер']");
    // Кнопка "Далее"
    private final By nextStepButton = By.xpath(".//*[text()='Далее']");

    public FirstOrderPage(WebDriver driver) {
        super(driver);
    }

    public void setName(String name) {
        driver.findElement(nameInput).sendKeys(name);
    }

    public void setSurname(String surname) {
        driver.findElement(surnameInput).sendKeys(surname);
    }

    public void setAddress(String address) {
        driver.findElement(addressInput).sendKeys(address);
    }

    public void selectMetroStation(String metroStation) {
        driver.findElement(metroStationInput).click();
        String formatted = String.format("//*[@class='select-search__select']//div[text()='%s']", metroStation);
        driver.findElement(By.xpath(formatted)).click();
    }

    public void setPhoneNumber(String phoneNumber) {
        driver.findElement(phoneNumberInput).sendKeys(phoneNumber);
    }

    public void clickNextStepButton() {
        driver.findElement(nextStepButton).click();
    }

    public void fillInTheFirstPageOfData(String name, String surname, String address, String metroStation, String phoneNumber) {
        setName(name);
        setSurname(surname);
        setAddress(address);
        selectMetroStation(metroStation);
        setPhoneNumber(phoneNumber);
        clickNextStepButton();
    }

}
