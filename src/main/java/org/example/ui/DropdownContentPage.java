package org.example.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DropdownContentPage extends BasePage {

    public DropdownContentPage(WebDriver driver) {
        super(driver);
    }

    public void clickDropdownTitle(String dropdownTitle) {
        String dropdownTitleXPath = String.format(".//*[text()='%s']", dropdownTitle);
        WebElement dropdownTitleElement = driver.findElement(By.xpath(dropdownTitleXPath));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdownTitleElement);
        dropdownTitleElement.click();
    }

    public String getActualText(String dropdownTitle) {
        String dropdownTitleXPath = String.format(".//*[text()='%s']", dropdownTitle);
        String dropdownDescriptionXPath = dropdownTitleXPath + "/parent::div/parent::div//p";
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dropdownDescriptionXPath)));
        return driver.findElement(By.xpath(dropdownDescriptionXPath)).getText();
    }
}
