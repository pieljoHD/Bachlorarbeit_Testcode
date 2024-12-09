package org.example.android;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPageAndroid extends BasePageAndroid<LoginPageAndroid>{
    private final By UserNameInput = By.id("UserNameInput");
    private final By PasswortInput = By.id("PasswortInput");
    private final By ErrorText = By.id("ErrorText");
    private final By LoginButton = By.id("LoginButton");
    private final By InputTodoField = By.id("todoInput");
    private final By ClearButtonUserName = By.id("clearButtonUserName");
    private final By ClearButtonPassword = By.id("clearButtonPassword");

    public LoginPageAndroid(AndroidDriver driver) {
        super(driver);
    }

    public void loginWithRightCredentials() {
        sendKeys(UserNameInput, "test123");
        sendKeys(PasswortInput, "1234");
        click(LoginButton);
        Assert.assertTrue(isElementDisplayed(InputTodoField));
    }

    public void clearUserName() {
        click(ClearButtonUserName);
    }

    public void clearPassword() {
        click(ClearButtonPassword);
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
