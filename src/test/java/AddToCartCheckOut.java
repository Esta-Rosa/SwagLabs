import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class AddToCartCheckOut {
    //Add item to cart
    @Test(dependsOnMethods = "LoginAndLogOut.verifyLogin")
    public void addToCart() {
        try {
            SetupEnvironment.driver.findElement(By.linkText("Sauce Labs Bike Light")).click();
            Thread.sleep(3000);
            SetupEnvironment.driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Go to cart
    @Test(dependsOnMethods = "addToCart")
    public void goToCart() {
        try {
            SetupEnvironment.driver.findElement(By.id("shopping_cart_container")).click();
            Thread.sleep(2000);

            //check out
            SetupEnvironment.driver.findElement(By.id("checkout")).click();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Enter personal details
    @Test(dependsOnMethods = "goToCart")
    public void enterCredentials() {
        try {
            SetupEnvironment.driver.findElement(By.id("first-name")).sendKeys("Esta");
            Thread.sleep(3000);
            SetupEnvironment.driver.findElement(By.id("last-name")).sendKeys("Msimango");
            Thread.sleep(3000);
            SetupEnvironment.driver.findElement(By.id("postal-code")).sendKeys("1632");
            Thread.sleep(3000);
            SetupEnvironment.driver.findElement(By.id("continue")).click();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}