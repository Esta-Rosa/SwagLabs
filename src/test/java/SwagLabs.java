import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Test
public class SwagLabs {
    WebDriver driver;

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

    //Login with provided credentials
    @Test(dependsOnMethods = "goToBrowser")
    public void login() {
        try {
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            Thread.sleep(3000);
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            Thread.sleep(3000);
            driver.findElement(By.id("login-button")).click();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Verify login    @Test(dependsOnMethods = "login")
    public void verifyLogin() {
        String title = "Swag Labs";
        assertEquals(title, driver.getTitle());
    }

    //Add item to cart
    @Test(dependsOnMethods = "verifyLogin")
    public void addToCart() {
        try {
            driver.findElement(By.linkText("Sauce Labs Bike Light")).click();
            Thread.sleep(3000);
            driver.findElement(By.id("add-to-cart-sauce-labs-bike-light")).click();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Go to cart
    @Test(dependsOnMethods = "addToCart")
    public void goToCart() {
        try {
            driver.findElement(By.id("shopping_cart_container")).click();
            Thread.sleep(2000);

            //check out
            driver.findElement(By.id("checkout")).click();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Enter personal details
    @Test(dependsOnMethods = "goToCart")
    public void enterCredentials() {
        try {
            driver.findElement(By.id("first-name")).sendKeys("Esta");
            Thread.sleep(3000);
            driver.findElement(By.id("last-name")).sendKeys("Msimango");
            Thread.sleep(3000);
            driver.findElement(By.id("postal-code")).sendKeys("1632");
            Thread.sleep(3000);
            driver.findElement(By.id("continue")).click();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Log out
    @Test(dependsOnMethods = "enterCredentials")
    public void logOut() {
        try {
            driver.findElement(By.id("finish")).click();
            Thread.sleep(2000);

            //go back home page
            driver.findElement(By.id("back-to-products")).click();
            Thread.sleep(2000);

            //log out
            driver.findElement(By.id("react-burger-menu-btn")).click();
            Thread.sleep(2000);
            driver.findElement(By.id("logout_sidebar_link")).click();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Tear down
    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}