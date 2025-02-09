import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.example.ui.MainPage;
import org.example.ui.FirstOrderPage;
import org.example.ui.SecondOrderPage;
import static org.junit.Assert.assertTrue;

public class OrderTest {
    private WebDriver driver;

    @Before
    public void setup() {
        driver = new ChromeDriver();
    }

    @Test
    public void topOrderButtonTest() {
        driver.get("https://qa-scooter.praktikum-services.ru/");

        MainPage mainPage = new MainPage(driver);
        mainPage.clickTopOrderButton();

        FirstOrderPage firstOrderPage = new FirstOrderPage(driver);
        firstOrderPage.fillInTheFirstPageOfData("Эльмира", "Сегедина", "ул. Промышленная, д. 23",
                "//*[@class='select-search__select']//div[text()='Красносельская']",
                "+79803285666");

        SecondOrderPage secondOrderPage = new SecondOrderPage(driver);
        secondOrderPage.fillInTheSecondPageOfData("14.02.2025",
                ".//*[@class='Dropdown-menu']//div[text()='сутки']",
                ".//*[@class='Checkbox_Input__14A2w']", "Не звонить.");
        assertTrue(secondOrderPage.isOrderSubmittedScreenVisible());
    }

    @Test
    public void bottomOrderButtonTest() {
        driver.get("https://qa-scooter.praktikum-services.ru/");

        MainPage mainPage = new MainPage(driver);
        mainPage.scrollToBottomOrderButton();
        mainPage.clickBottomOrderButton();

        FirstOrderPage firstOrderPage = new FirstOrderPage(driver);
        firstOrderPage.fillInTheFirstPageOfData("Иван", "Свиридов", "ул. Садовая, д. 25, кв. 27",
                "//*[@class='select-search__select']//div[text()='Сокольники']",
                "89990099009");

        SecondOrderPage secondOrderPage = new SecondOrderPage(driver);
        secondOrderPage.fillInTheSecondPageOfData("20.02.2025",
                ".//*[@class='Dropdown-menu']//div[text()='двое суток']",
                ".//*[@class='Checkbox_Input__14A2w']", "Доставьте как можно быстрее.");
        assertTrue(secondOrderPage.isOrderSubmittedScreenVisible());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}


