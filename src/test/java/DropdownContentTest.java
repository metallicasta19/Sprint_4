import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class DropdownContentTest {

    private WebDriver driver;
    private static String dropdownXPath;
    private static String dropdownContent;
    private static String expectedText;

    public DropdownContentTest(String dropdownXPath, String dropdownContent, String expectedText) {
        this.dropdownXPath = dropdownXPath;
        this.dropdownContent = dropdownContent;
        this.expectedText = expectedText;
    }

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {"//*[@id='accordion__heading-0']", "//*[@id='accordion__panel-0']/p", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {"//*[@id='accordion__heading-1']", "//*[@id='accordion__panel-1']/p", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {"//*[@id='accordion__heading-2']", "//*[@id='accordion__panel-2']/p", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {"//*[@id='accordion__heading-3']", "//*[@id='accordion__panel-3']/p", "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {"//*[@id='accordion__heading-4']", "//*[@id='accordion__panel-4']/p", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {"//*[@id='accordion__heading-5']", "//*[@id='accordion__panel-5']/p", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {"//*[@id='accordion__heading-6']", "//*[@id='accordion__panel-6']/p", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {"//*[@id='accordion__heading-7']", "//*[@id='accordion__panel-7']/p", "Да, обязательно. Всем самокатов! И Москве, и Московской области."},
        };
    }

    @Test
    public void dropdownContentTest() {
        WebElement element = driver.findElement(By.xpath(dropdownXPath));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        driver.findElement(By.xpath(dropdownXPath)).click();

        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dropdownContent)));
        String actualText = driver.findElement(By.xpath(dropdownContent)).getText();

        assertEquals("Текст не соответствует ожидаемому.", expectedText, actualText);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}


