package ios;

import io.appium.java_client.ios.IOSDriver;
import org.example.ios.BaseTestIOS;
import org.example.ios.LoginPageIOS;
import org.testng.annotations.Test;

public class Login extends BaseTestIOS {
    IOSDriver driver;

    @Test
    public void testIDLogin() throws InterruptedException {
        driver = getDriver();
        LoginPageIOS loginPageIOS = new LoginPageIOS(driver);
        loginPageIOS.loginWithCredentials("test123","falsch");
        loginPageIOS.checkErrorTextVisible();
        loginPageIOS.clearField();
        loginPageIOS.loginWithCredentials("falsch","1234");
        loginPageIOS.checkErrorTextVisible();
        loginPageIOS.clearField();
        loginPageIOS.loginWithCredentials("test123","1234");
        loginPageIOS.checkNotOnLoginPage();
    }
}