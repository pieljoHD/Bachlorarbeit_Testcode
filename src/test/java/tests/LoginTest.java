package tests;

import io.appium.java_client.AppiumDriver;
import org.example.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.SessionManager;

import static utils.SessionManager.getInstance;

public class LoginTest  {
    AppiumDriver driver = null;
    SessionManager sessionManager = null;

    @Parameters("platform")
    @BeforeMethod
    public void setUpDriver(String platform) {
        sessionManager = getInstance(platform);
        driver = sessionManager.driver;
        sessionManager.openApp();
    }

    @Test
    public void testIDLogin()  {
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

        sessionManager.closeApp();
    }
}
