import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
public class InputData {
    @DataProvider(name = "loginData")
    public Object[][] LData(){
        return new Object[][]{
                {"standard_user", "secret_sauce"}
        };
    }

}
