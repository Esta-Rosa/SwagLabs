import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

@Test
public class SwagLabs {
    WebDriver driver;

    //set Up
    @Test(priority = 1)
    public void setDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    //Go To SwagLabs
    @Test(priority = 2)
    public void goToBrowser() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(2000);
    }

    //Login with provided credentials
    @Test(priority = 3)
    public void login(){
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

    //Add item to cart
    @Test(priority = 4)
    public void addToCart(){
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
    @Test(priority = 5)
    public void goToCart(){
        try {
            driver.findElement(By.id("shopping_cart_container")).click();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //checkout
    @Test(priority = 6)
    public  void checkOut(){
        try {
            driver.findElement(By.id("checkout")).click();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Enter personal details
    @Test(priority = 7)
    public void enterCredentials(){
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

    //Finish
    @Test(priority = 8)
    public  void finish(){
        try {
            driver.findElement(By.id("finish")).click();
            Thread.sleep(2000);
            //go back home page
            driver.findElement(By.id("back-to-products")).click();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //log out
    @Test(priority = 9)
    public void logOut() throws InterruptedException {
        driver.findElement(By.id("react-burger-menu-btn")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("logout_sidebar_link")).click();
        Thread.sleep(2000);
    }

    //Tear down
    @Test(priority = 10)
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
