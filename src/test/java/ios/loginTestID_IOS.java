package ios;

import io.appium.java_client.ios.IOSDriver;
import org.example.ios.BaseTestIOS;
import org.example.ios.LoginPageID_IOS;
import org.testng.annotations.Test;

public class loginTestID_IOS extends BaseTestIOS {
    IOSDriver driver;

    @Test
    public void testIDLogin(){
        driver = getDriver();
        new LoginPageID_IOS(driver)
                .logIn();
    }
}
