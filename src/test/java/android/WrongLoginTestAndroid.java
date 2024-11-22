package android;

import io.appium.java_client.android.AndroidDriver;
import org.example.android.BaseTestAndroid;
import org.example.android.LoginPageAndroid;
import org.testng.annotations.Test;

public class WrongLoginTestAndroid extends BaseTestAndroid {

    @Test
    public void wrongLoginTests() {
        AndroidDriver driver = getDriver();
        new LoginPageAndroid(driver)
                .loginWithWrongCredentials();
    }
}
