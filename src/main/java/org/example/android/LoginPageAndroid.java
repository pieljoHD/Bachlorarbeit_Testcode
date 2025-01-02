package org.example.android;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPageAndroid extends BasePageAndroid {
    private final By UserNameInput = By.xpath("//*[@resource-id='UserNameInput']");
    private final By PasswortInput = By.xpath("//*[@resource-id='PasswortInput']");
    private final By ErrorText = By.xpath("//*[@resource-id='ErrorText']");
    private final By LoginButton = By.xpath("//*[@resource-id='LoginButton']");
    private final By InputTodoField = By.xpath("//*[@resource-id='TodoInput']");
    private final By ClearButtonUserName = By.xpath("//*[@resource-id='clearButtonUserName']");
    private final By ClearButtonPassword = By.xpath("//*[@resource-id='clearButtonPassword']");

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
