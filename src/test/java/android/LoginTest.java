package android;

import io.appium.java_client.android.AndroidDriver;
import org.example.android.BaseTestAndroid;
import org.example.android.LoginPageAndroid;
import org.testng.annotations.Test;

public class LoginTest extends BaseTestAndroid {

    @Test
    public void addAndDeleteTodos() {
        AndroidDriver driver = getDriver();
        LoginPageAndroid loginPage = new LoginPageAndroid(driver);
        loginPage.loginWithCredentials("test123","falsch");
        loginPage.checkErrorTextVisible();
        loginPage.clearField();
        loginPage.loginWithCredentials("falsch","1234");
        loginPage.checkErrorTextVisible();
        loginPage.clearField();
        loginPage.loginWithCredentials("test123","1234");
        loginPage.checkNotOnLoginPage();
    }
}
