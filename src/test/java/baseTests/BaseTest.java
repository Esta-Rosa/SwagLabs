package baseTests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class BaseTest {
    protected static WebDriver driver;

    //set Up
    @BeforeTest
    public void setDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    //Tear down
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
