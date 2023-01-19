import baseTests.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.time.Duration;

public class AddToCartCheckOut extends BaseTest {
    //Add item to cart
    @Test(dependsOnMethods = "LoginAndLogOut.verifyLogin")
    public void addToCart() throws InterruptedException {
        SetupEnvironment.driver.findElement(By.linkText("Sauce Labs Bike Light")).click();
        Thread.sleep(2000);
        SetupEnvironment.driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
        Thread.sleep(2000);
    }

    //Go to cart
    @Test(dependsOnMethods = "addToCart")
    public void goToCart() throws InterruptedException {
        SetupEnvironment.driver.findElement(By.id("shopping_cart_container")).click();
        Thread.sleep(2000);
        SetupEnvironment.driver.findElement(By.id("checkout")).click();//check out
        Thread.sleep(2000);
    }

    //Enter personal details
    @Test(dependsOnMethods = "goToCart")
    public void enterCredentials() throws InterruptedException {
        SetupEnvironment.driver.findElement(By.id("first-name")).sendKeys("Esta");
        Thread.sleep(2000);
        SetupEnvironment.driver.findElement(By.id("last-name")).sendKeys("Msimango");
        Thread.sleep(2000);
        SetupEnvironment.driver.findElement(By.id("postal-code")).sendKeys("1632");
        Thread.sleep(2000);
        SetupEnvironment.driver.findElement(By.id("continue")).click();
        Thread.sleep(2000);
    }
}