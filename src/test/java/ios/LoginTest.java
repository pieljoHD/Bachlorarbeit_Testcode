package ios;

import io.appium.java_client.ios.IOSDriver;
import org.example.ios.BaseTestIOS;
import org.example.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTestIOS {
    IOSDriver driver;

    @Test
    public void testIDLogin() throws InterruptedException {
        driver = getDriver();
        LoginPage loginPageIOS = new LoginPage(driver);
        loginPageIOS.loginWithCredentials("test123","falsch");
        loginPageIOS.checkErrorTextVisible();

        loginPageIOS.clearFieldUsername();
        loginPageIOS.clearFieldPassword();

        loginPageIOS.loginWithCredentials("falsch","1234");
        loginPageIOS.checkErrorTextVisible();

        loginPageIOS.clearFieldUsername();
        loginPageIOS.clearFieldPassword();

        loginPageIOS.loginWithCredentials("test123","1234");
        loginPageIOS.checkNotOnLoginPage();
    }
}