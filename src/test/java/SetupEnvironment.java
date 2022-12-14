import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

@Test
public class SetupEnvironment {
    static WebDriver driver;

    //set Up
    @BeforeTest
    public void setDriver() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    //Go To SwagLabs
    public void goToBrowser() throws InterruptedException {
        driver.get("https://www.saucedemo.com");
        Thread.sleep(2000);
    }

    //Tear down
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}