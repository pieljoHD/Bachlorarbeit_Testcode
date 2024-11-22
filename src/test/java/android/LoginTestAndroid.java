package android;

import io.appium.java_client.android.AndroidDriver;
import org.example.android.BaseTestAndroid;
import org.example.android.LoginPageAndroid;
import org.testng.annotations.Test;

public class LoginTestAndroid extends BaseTestAndroid {

    @Test
    public void loginTests() {
        AndroidDriver driver = getDriver();
        LoginPageAndroid loginPage = new LoginPageAndroid(driver);
        loginPage.loginWithRightCredentials();
    }
}
