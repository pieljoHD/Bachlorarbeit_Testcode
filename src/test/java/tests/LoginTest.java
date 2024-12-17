package tests;

import org.example.pages.LoginPage;
import org.example.utils.BaseTest;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
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
    }
}
