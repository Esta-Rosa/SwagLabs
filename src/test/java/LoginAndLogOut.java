import baseTests.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static org.testng.Assert.*;


public class LoginAndLogOut extends BaseTest {
    //Login with provided credentials
    @Test(dependsOnMethods = "SetupEnvironment.goToBrowser")
    public void login() throws InterruptedException {
        SetupEnvironment.driver.findElement(By.id("user-name")).sendKeys("standard_user");
        Thread.sleep(4000);
        SetupEnvironment.driver.findElement(By.id("password")).sendKeys("secret_sauce");
        Thread.sleep(4000);
        SetupEnvironment.driver.findElement(By.id("login-button")).click();
        Thread.sleep(4000);
    }

    //Verify login
    @Test(dependsOnMethods = "login")
    public void verifyLogin() throws InterruptedException {
        String title = "Swag Labs";
        assertEquals(title, SetupEnvironment.driver.getTitle());
    }

    //Log out
    @Test(dependsOnMethods = "AddToCartCheckOut.enterCredentials")
    public void logOut() throws InterruptedException {
        SetupEnvironment.driver.findElement(By.id("finish")).click();//go back home page
        Thread.sleep(4000);
        SetupEnvironment.driver.findElement(By.id("back-to-products")).click();//log out
        Thread.sleep(4000);
        SetupEnvironment.driver.findElement(By.id("react-burger-menu-btn")).click();
        Thread.sleep(4000);
        SetupEnvironment.driver.findElement(By.id("logout_sidebar_link")).click();
        Thread.sleep(4000);
    }
}