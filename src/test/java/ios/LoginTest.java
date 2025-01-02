package ios;

import io.appium.java_client.ios.IOSDriver;
import org.example.ios.BaseTestIOS;
import org.example.ios.LoginPageIOS;
import org.testng.annotations.Test;

public class LoginTest extends BaseTestIOS {

    @Test
    public void loginTest() {
        IOSDriver driver = getDriver();
        LoginPageIOS loginPageIOS = new LoginPageIOS(driver);
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