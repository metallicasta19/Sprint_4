import org.junit.Test;
import org.example.ui.MainPage;
import org.example.ui.FirstOrderPage;
import org.example.ui.SecondOrderPage;
import static org.junit.Assert.assertTrue;

public class OrderTest extends BaseTest {

    @Test
    public void topOrderButtonTest() {

        MainPage mainPage = new MainPage(BaseTest.driver);
        mainPage.clickTopOrderButton();

        FirstOrderPage firstOrderPage = new FirstOrderPage(BaseTest.driver);
        firstOrderPage.fillInTheFirstPageOfData("Эльмира", "Сегедина", "ул. Промышленная, д. 23", "Черкизовская",
                "+79803285666");

        SecondOrderPage secondOrderPage = new SecondOrderPage(BaseTest.driver);
        secondOrderPage.fillInTheSecondPageOfData("14.02.2025",
                ".//*[@class='Dropdown-menu']//div[text()='сутки']",
                ".//*[@class='Checkbox_Input__14A2w']", "Не звонить.");
        assertTrue(secondOrderPage.isOrderSubmittedScreenVisible());
    }

    @Test
    public void bottomOrderButtonTest() {

        MainPage mainPage = new MainPage(BaseTest.driver);
        mainPage.scrollToBottomOrderButton();
        mainPage.clickBottomOrderButton();

        FirstOrderPage firstOrderPage = new FirstOrderPage(BaseTest.driver);
        firstOrderPage.fillInTheFirstPageOfData("Иван", "Свиридов", "ул. Садовая, д. 25, кв. 27", "Красносельская",
                "89990099009");

        SecondOrderPage secondOrderPage = new SecondOrderPage(BaseTest.driver);
        secondOrderPage.fillInTheSecondPageOfData("20.02.2025",
                ".//*[@class='Dropdown-menu']//div[text()='двое суток']",
                ".//*[@class='Checkbox_Input__14A2w']", "Доставьте как можно быстрее.");
        assertTrue(secondOrderPage.isOrderSubmittedScreenVisible());
    }
}


