package android;

import io.appium.java_client.android.AndroidDriver;
import org.example.android.BaseTestAndroid;
import org.example.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTestAndroid {

    @Test
    public void addAndDeleteTodos() {
        AndroidDriver driver = getDriver();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginWithCredentials("test123","falsch");
        loginPage.checkErrorTextVisible();

        loginPage.clearFieldUsername();
        loginPage.clearFieldPassword();

        loginPage.loginWithCredentials("falsch","1234");
        loginPage.checkErrorTextVisible();

        loginPage.clearFieldUsername();
        loginPage.clearFieldPassword();

        loginPage.loginWithCredentials("test123","1234");
        loginPage.checkNotOnLoginPage();
    }
}
