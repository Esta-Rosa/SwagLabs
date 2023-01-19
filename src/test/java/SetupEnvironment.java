import baseTests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.*;

import java.time.Duration;

public class SetupEnvironment  extends BaseTest {
    //Go To SwagLabs
    @Test
    public void goToBrowser() throws InterruptedException {
        driver.get("https://www.google.com/"); //go to google
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("Swag Labs"); //search for Swag Labs
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@title='Search']")).sendKeys(Keys.ENTER); //search for Swag Labs
        Thread.sleep(2000);
        driver.findElement(By.xpath("//h3[normalize-space()='Swag Labs']")).click(); //go to Swag Labs
        Thread.sleep(2000);
    }


}