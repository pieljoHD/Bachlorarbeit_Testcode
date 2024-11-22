package org.example.android;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPageAndroid extends BasePageAndroid<LoginPageAndroid>{
    private final By UserNameInput = By.xpath("//*[@resource-id='UserNameInput']");
    private final By PasswortInput = By.xpath("//*[@resource-id='PasswortInput']");
    private final By ErrorText = By.xpath("//*[@resource-id='ErrorText']");
    private final By LoginButton = By.xpath("//*[@resource-id='LoginButton']");

    public LoginPageAndroid(AndroidDriver driver) {
        super(driver);
    }

    public void loginWithRightCredentials() {
        sendKeys(UserNameInput, "test123");
        sendKeys(PasswortInput, "1234");
        click(LoginButton);
        Assert.assertFalse(isElementDisplayed(UserNameInput));
    }

    public void loginWithWrongCredentials() {
        sendKeys(UserNameInput, "admin");
        sendKeys(PasswortInput, "admin");
        click(LoginButton);
        Assert.assertTrue(isElementDisplayed(ErrorText));
    }
}
