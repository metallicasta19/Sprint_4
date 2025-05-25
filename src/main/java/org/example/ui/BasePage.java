package org.example.ui;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
