import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    public static WebDriver driver;
    private static final String SCOOTER_URL = "https://qa-scooter.praktikum-services.ru/";

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.get(SCOOTER_URL);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
