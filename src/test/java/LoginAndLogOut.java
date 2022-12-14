import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class LoginAndLogOut {
    //Login with provided credentials
    @Test(dependsOnMethods = "SetupEnvironment.goToBrowser")
    public void login() {
        try {
            SetupEnvironment.driver.findElement(By.id("user-name")).sendKeys("standard_user");
            Thread.sleep(3000);
            SetupEnvironment.driver.findElement(By.id("password")).sendKeys("secret_sauce");
            Thread.sleep(3000);
            SetupEnvironment.driver.findElement(By.id("login-button")).click();
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    //Verify login
    @Test(dependsOnMethods = "login")
    public void verifyLogin() {
        String title = "Swag Labs";
        assertEquals(title, SetupEnvironment.driver.getTitle());
    }

    //Log out
    @Test(dependsOnMethods = "AddToCartCheckOut.enterCredentials")
    public void logOut() {
        try {
            SetupEnvironment.driver.findElement(By.id("finish")).click();
            Thread.sleep(2000);

            //go back home page
            SetupEnvironment.driver.findElement(By.id("back-to-products")).click();
            Thread.sleep(2000);

            //log out
            SetupEnvironment.driver.findElement(By.id("react-burger-menu-btn")).click();
            Thread.sleep(2000);
            SetupEnvironment.driver.findElement(By.id("logout_sidebar_link")).click();
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}