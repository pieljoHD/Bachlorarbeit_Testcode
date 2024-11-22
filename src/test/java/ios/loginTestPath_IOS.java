package ios;

import io.appium.java_client.ios.IOSDriver;
import org.example.ios.BaseTestIOS;
import org.example.ios.LoginPageID_IOS;
import org.example.ios.LoginPageXPath_IOS;
import org.testng.annotations.Test;

public class loginTestPath_IOS extends BaseTestIOS {
    IOSDriver driver;

    @Test
    public void testPathLogin(){
        driver = getDriver();
        new LoginPageXPath_IOS(driver)
                .logIn();
    }
}
