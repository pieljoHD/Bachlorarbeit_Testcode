package org.example.ios;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPageIOS extends BasePageIOS{
    private final By UserNameInput = By.xpath("//*[@name='UserNameInput']");
    private final By PasswortInput = By.xpath("//*[@name='PasswortInput']");
    private final By ErrorText = By.xpath("//*[@name='ErrorText']");
    private final By LoginButton = By.xpath("//*[@name='LoginButton']");
    private final By InputTodoField = By.xpath("//*[@name='TodoInput']");
    private final By ClearButtonUsername = By.xpath("//*[@name='clearButtonUserName']");
    private final By ClearButtonPassword = By.xpath("//*[@name='clearButtonPassword']");

    public LoginPageIOS(IOSDriver driver) {
        super(driver);
    }

    public void clearFieldUsername() {
        click(ClearButtonUsername);
    }

    public void clearFieldPassword() {
        click(ClearButtonPassword);
    }

    public void loginWithRightCredentials() {
        sendKeys(UserNameInput, "test123");
        sendKeys(PasswortInput, "1234");
        click(LoginButton);
        Assert.assertTrue(isElementDisplayed(InputTodoField));
    }

    public void loginWithCredentials(String username, String password) {
        sendKeys(UserNameInput, username);
        sendKeys(PasswortInput, password);
        click(LoginButton);
    }

    public void checkNotOnLoginPage() {
        waitElementToBeClickable(InputTodoField);
        Assert.assertTrue(isElementDisplayed(InputTodoField));
    }

    public void checkErrorTextVisible() {
        Assert.assertTrue(isElementDisplayed(ErrorText));
    }
}
